package HELADERIA;
import java.util.ArrayList;
import java.util.Scanner;
 
 
public class Menus{
    private int windowWidth = 30;
    private char borderChar = '*';
    private char firstOption = '1';
 
    // Constructor de clase
    public Menus(int windowWidth, char borderChar, char firstOption){
        this.windowWidth = windowWidth;
        this.borderChar = borderChar;
        this.firstOption = firstOption;
    }
 
    // Crear el menu usando un arraylist con la lista de opciones del menu
    public int createMenu(ArrayList<String> options, boolean CENTERED){
        boolean DRAW_MENU = true;                       // permite controlar el escape del ciclo de dibujo
        char optionId = firstOption;
        int option = 0;                                 // variable que recibe la opcion del usuario
        Scanner input = new Scanner(System.in);
        System.out.println(options);
        while(DRAW_MENU){
            // primero dibujar el borde superior
            optionId = firstOption;                    // carga el identificador de la primera opcion
            System.out.println(borderLine());
            for(String optionText : options){           // Imprime el menu
                //System.out.println(optionText);s
                if(CENTERED)
                    System.out.println(padding(optionId + ". " + optionText));
                else
                    System.out.println(optionId + ". " + optionText);
                optionId++;
            }
            // dibujar el borde inferior    
            System.out.println(borderLine());
            System.out.print("Seleccione una opcion: ");
            option = input.nextInt();
            if((option >= firstOption) && (option < (firstOption + options.size()))){
                DRAW_MENU = false;
            }else{
                System.out.println("Opcion invalida");
            }
        }
        input.close();
        return option;
    }
 
    // Helpers
    // Crea una linea del ancho de la ventana usando el caracter definido
    public String borderLine(){
        String line = "";
        for(int i = 0; i < windowWidth; i++){
            line += borderChar;
        }
        return line;
    }
    // Crea un padding (relleno de espacios) para centrar un mensaje en la ventana
    public String padding(String message){
        int padding = (windowWidth - message.length()) / 2;
        String paddingString = "";
        for(int i = 0; i < padding; i++){
            paddingString += " ";
        }
        return paddingString;
    }
    
}
 