package SemanaSeis;
import java.util.Scanner;

import OrientaObjetos.MostrarUsuarios;

import java.util.ArrayList;
 
public class Ejemplo
{   public static void menuPpal(){
    boolean salir = false;
    while (salir){
    
	   ArrayList <String> menu1 = new ArrayList<String>();
		menu1.add("Helado de crema");
		menu1.add("Helado naturales");
		menu1.add("Gourmets");
		menu1.add("con cremas calientes");
		menu1.add("Terminar");
		int opcion = menu(menu1);
		switch (opcion){
		    case 1:
                    break;    
         default: System.out.println("Opción inválida.");
         salir = true;
		            break;
                
            
		}
	}
    }
	
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
}
 
