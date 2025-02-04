package view;

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
}
