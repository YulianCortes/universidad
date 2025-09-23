package SemanaSeis;
import java.util.Scanner;
import java.util.ArrayList;
public class Menu{
    private char caracterMarco ='*';
    private int ancho 
    public Menu(){

    }
    //metodo para mostrar el menu
    public static int menu(ArrayList<String> opciones){
	    int opcion;
	    char simboloOpcion = '1';
		boolean MOSTRAR = 0
	    Scanner input = new Scanner(System.in);
		 int nroOpciones = opciones.size();
		while(MOSTRAR){
	    System.out.println("-----------------------------------------");
	    System.out.println("|.               Menu.                  |");
	    for(String opcionVista : opciones){
	        System.out.println("| " + simboloOpcion + " - " + opcionVista);
			simboloOpcion++;
	    }
	    System.out.println("-----------------------------------------");
	    System.out.println("Digite su opcion");
	    opcion = input.nextInt();
	    if (opcion < nroOpciones)
		 MOSTRAR = false;
	} simboloOpcion = '1';
	    return opcion;
	}
    private String horizontal(int nroCaracteres){
        String borde ="";
        for (int i = 0; i < nroCaracteres; i++){
            borde += caracterMarco;
        }
    }
}