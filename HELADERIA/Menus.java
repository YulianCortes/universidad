package HELADERIA;
import java.util.ArrayList;
import java.util.Scanner;

public class Menus{
    private int windowWidth = 30;
    private char borderChar = '*';
    private int firstOption = 1; // primero como número

    public Menus(int windowWidth, char borderChar, char firstOption){
        this.windowWidth = windowWidth;
        this.borderChar = borderChar;
        this.firstOption = Character.getNumericValue(firstOption);
    }

    public int createMenu(ArrayList<String> options, boolean CENTERED){
        boolean DRAW_MENU = true;                       
        int option = -1;                                 
        Scanner input = new Scanner(System.in);

        while(DRAW_MENU){
            System.out.println(borderLine());
            int optionId = firstOption;                    
            for(String optionText : options){           
                if(CENTERED)
                    System.out.println(padding(optionId + ". " + optionText));
                else
                    System.out.println(optionId + ". " + optionText);
                optionId++;
            }
            System.out.println(borderLine());

            System.out.print("Seleccione una opcion: ");
            if(input.hasNextInt()){
                option = input.nextInt();
                input.nextLine(); // limpiar buffer
                if(option >= firstOption && option < (firstOption + options.size())){
                    DRAW_MENU = false; // opción válida
                } else {
                    System.out.println("Opción inválida, intente de nuevo.\n");
                }
            } else {
                System.out.println("Debe ingresar un número válido.\n");
                input.nextLine();
            }
        }
        return option;
    }

    public String borderLine(){
        String line = "";
        for(int i = 0; i < windowWidth; i++){
            line += borderChar;
        }
        return line;
    }

    public String padding(String message){
        int padding = (windowWidth - message.length()) / 2;
        String paddingString = "";
        for(int i = 0; i < padding; i++){
            paddingString += " ";
        }
        return paddingString + message;
    }
}
