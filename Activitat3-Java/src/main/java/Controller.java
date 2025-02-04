import DAO.*;
import com.mongodb.client.MongoDatabase;
import view.View;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        View view = new View();
        MongoDatabase database = new Connection("Activitat3").getDatabase();
        PublicacionsDAO publicacionsDAO = new PublicacionsDAO(database);
        boolean exitProgram = false;
        while (!exitProgram){
            view.showMenu();
            int option = checkInputInt(input, 1, 3, ">");
            switch (option){
                case 1:
                    System.out.println("Visualitzar Publicacions");
                    break;
                case 2:
                    System.out.println("Afegir Publicacio");
                    break;
                case 3:
                    System.out.println("Filtrar per dates");
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
