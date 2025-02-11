package view;

import models.Publicacions;
import models.Usuaris;

public class View {
    private String separador = "-------------------------";
    public View(){}

    public void showMenu(){
        System.out.println(separador);
        System.out.println("MENU");
        System.out.println("1. Visualitzar Publicacions");
        System.out.println("2. Afegir Publicacio");
        System.out.println("3. Filtrar per dates");
        System.out.println(separador);
    }

    public void showPublicacio(Publicacions p) {
        System.out.println(separador);
        System.out.println("Text: " + p.getText());
        System.out.println("Hastags: ");
        for (String h : p.getHastags()){
            System.out.println(h);
        }
        System.out.println("Mencions: ");
        for (String m : p.getMencions()){
            System.out.println(m);
        }
        System.out.println("Paraules clau: ");
        for (String pc : p.getParaules_clau()){
            System.out.println(pc);
        }
        System.out.println("Data i hora: " + p.getData_hora());
        System.out.println("Likes: " + p.getLikes());
        System.out.println("Retuits: " + p.getRetuits());
        System.out.println("Ubicacio: " + p.getUbicacio());
        System.out.println("Sentiment: " + p.getSentiment());
        Usuaris u = p.getUsuari();
        System.out.println("Usuari: " + u.getNom_usuari());
    }

    public void showMenuAddPublicacio() {
        System.out.println(separador);
        System.out.println("Afegir Publicacio");
        System.out.println(separador);
    }

    public void inputText() {
        System.out.println("Text: ");
    }

    public void inputHastags() {
        System.out.println("Hastag (exit): ");
    }

    public void inputMencions() {
        System.out.println("Mencio (exit): ");
    }

    public void succesAddPublicacio() {
        System.out.println("Publicacio afegida correctament");
    }

    public void failAddPublicacio() {
        System.out.println("Error al afegir la publicacio");
    }

    public void filterDates() {
        System.out.println("Filtrar per dates (yyyy-MM-ddTHH:mm:ss): ");
        System.out.println("Desde: ");
    }

    public void filterDates2() {
        System.out.println("Fins: ");
    }
}
