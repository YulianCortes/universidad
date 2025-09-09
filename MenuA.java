// ejercisio uno 
import java.util.Scanner;
public class MenuA {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" _______________________________");
        System.out.println("|         MENÚ DE PRODUCTOS     |");
        System.out.println("|-------------------------------|");
        System.out.println("| 1. Hamburguesa    - $12,000   |");
        System.out.println("| 2. Perro caliente - $ 8,000   |");
        System.out.println("| 3. Pizza          - $15,000   |");
        System.out.println("| 4. Gaseosa        - $ 3,000   |");
        System.out.println("|_______________________________|");
        System.out.print("Elija una opción (1-4): ");
        int opcion = sc.nextInt();
        int total = 0;
        if (opcion == 1) {
            total = 12000;
            System.out.println("Has elegido: Hamburguesa");
        } else if (opcion == 2) {
            total = 8000;
            System.out.println("Has elegido: Perro caliente");
        } else if (opcion == 3) {
            total = 15000;
            System.out.println("Has elegido: Pizza");
        } else if (opcion == 4) {
            total = 3000;
            System.out.println("Has elegido: Gaseosa");
        } else {
            System.out.println("Opción inválida.");
        }
        if (total > 0) {
            System.out.println("Total a pagar: $" + total);
        }

        sc.close();
    }
}
