import DAO.*;
import com.mongodb.client.MongoDatabase;
import models.Publicacions;
import view.View;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        View view = new View();
        MongoDatabase database = new Connection("Activitat3").getDatabase();
        PublicacionsDAO publicacionsDAO = new PublicacionsDAO(database);
        boolean exitProgram = false;
        while (!exitProgram){
            view.showMenu();
            int option = checkInputInt(input, 1, 3, ">");
            switch (option){
                case 1:
                    List<Publicacions> publicacions = publicacionsDAO.obtenirTots();
                    for (Publicacions p : publicacions){
                        view.showPublicacio(p);
                    }
                    break;
                case 2:
                    String id = publicacionsDAO.getLastId();
                    List<String> hastags = new ArrayList<String>();
                    List<String> mencions = new ArrayList<String>();
                    List<String> paraules_clau = List.of("paraules_clau1");
                    String fechaActual = Instant.now()
                            .atOffset(ZoneOffset.UTC)
                            .truncatedTo(java.time.temporal.ChronoUnit.SECONDS) // Elimina los nanosegundos
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")); // Formato deseado
                    Publicacions p = new Publicacions(id, "label", hastags , mencions, paraules_clau, fechaActual, 0, 0, "ubicacio", "sentiment", "102");
                    view.showMenuAddPublicacio();
                    view.inputText();
                    String text = input.next();
                    p.setText(text);
                    while (true){
                        view.inputHastags();
                        String hastag = input.next();
                        if (hastag.equals("exit")){
                            break;
                        }
                        hastags.add(hastag);
                    }
                    p.setHastags(hastags);
                    while (true){
                        view.inputMencions();
                        String mencio = input.next();
                        if (mencio.equals("exit")){
                            break;
                        }
                        mencions.add(mencio);
                    }
                    p.setMencions(mencions);
                    boolean checkadd = publicacionsDAO.addPublicacio(p);
                    if (checkadd){
                        view.succesAddPublicacio();
                    } else {
                        view.failAddPublicacio();
                    }
                    break;
                case 3:
                    view.filterDates();
                    String date1 = input.next();
                    view.filterDates2();
                    String date2 = input.next();
                    List<Publicacions> publicacionsFiltrades = publicacionsDAO.filtrarData(date1, date2);
                    for (Publicacions pF : publicacionsFiltrades){
                        view.showPublicacio(pF);
                    }
                    break;
            }
        }

    }
    public static int checkInputInt(Scanner input, int min, int max, String prompt){
        int option = 0;
        boolean valid = false;
        while (!valid){
            System.out.println(prompt);
            if (input.hasNextInt()){
                option = input.nextInt();
                if (option >= min && option <= max){
                    valid = true;
                } else {
                    System.out.println("Numero incorrecte. Posa un numero entre " + min + " i " + max);
                }
            } else {
                System.out.println("No es un numero. Posa un numero entre " + min + " i " + max);
                input.next();
            }
        }
        return option;
    }
}
