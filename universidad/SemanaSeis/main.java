package SemanaSeis;
import java.util.Scanner;

import OrientaObjetos.MostrarUsuarios;

import java.util.ArrayList;
public class main
{   public static void menuPpal(){
    boolean salir = false;
    while (salir){
    
	   ArrayList <String> menu1 = new ArrayList<String>();
		menu1.add("Helado de crema");
		menu1.add("Helado naturales");
		menu1.add("Gourmets");
		menu1.add("con cremas calientes");
		menu1.add("Terminar");
		int opcion = Menu(menu1);
		switch (opcion){
		    case 1:
                    break;    
         default: System.out.println("Opción inválida.");
         salir = true;
		            break;
                
            
		}
	}
    }
	
	
}
 
