package CLASESANTES;
//ejercisio dos invocar menu () y cambiar void por int 
import java.util.Scanner;
public class MenuB {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion = 0;
        int total = 0;
        String pedido = "";
        do {
            opcion = menu(); 
            if (opcion == 1) { 
                System.out.println("\n--- Menú de Cafés ---");
                System.out.println("|_ 1. Café con leche - $3000");
                System.out.println("|_ 2. Tinto - $2000");
                System.out.println("|_ 3. Café simple - $2500");
                System.out.println("|_ 4. Regresar");
                System.out.print("👉 Elige una opción: ");
                int sub = sc.nextInt();
                if (sub == 1) {
                    pedido += "Café con leche - $3000\n";
                    total += 3000;
                } else if (sub == 2) {
                    pedido += "Tinto - $2000\n";
                    total += 2000;
                } else if (sub == 3) {
                    pedido += "Café simple - $2500\n";
                    total += 2500;
                } else if (sub == 4) {
                    System.out.println("↩ Regresando al menú principal...");
                } else {
                    System.out.println("❌ Opción inválida en menú de cafés");
                }
            } else if (opcion == 2) {
                System.out.println("\n--- Tamaños de Vasos ---");
                System.out.println("|_ 1. Pequeño - $0 (incluido)");
                System.out.println("|_ 2. Mediano - $1000");
                System.out.println("|_ 3. Grande - $2000");
                System.out.println("|_ 4. Regresar");
                System.out.print("Elige una opción: ");
                int sub = sc.nextInt();
                if (sub == 1) {
                    pedido += "Tamaño Pequeño - $0\n";
                } else if (sub == 2) {
                    pedido += "Tamaño Mediano - $1000\n";
                    total += 1000;
                } else if (sub == 3) {
                    pedido += "Tamaño Grande - $2000\n";
                    total += 2000;
                } else if (sub == 4) {
                    System.out.println("↩ Regresando al menú principal...");
                } else {
                    System.out.println("❌ Opción inválida en menú de tamaños");
                }
            } else if (opcion == 3) {
                System.out.println("\n🧾 TU PEDIDO FINAL:");
                System.out.println(pedido);
                System.out.println("TOTAL A PAGAR: $" + total);
                System.out.println("☕ Gracias por visitarnos ☕");
            } else {
                System.out.println("Opción inválida en menú principal");
            }

        } while (opcion != 3);
    }
    public static int menu() {
        System.out.println("\n ____________________________________");
        System.out.println("|       ☕ CAFETERÍA EL SABOR ☕     |");
        System.out.println("|____________________________________|");
        System.out.println("|_ 1. Menú de Café                   |");
        System.out.println("|_ 2. Tamaños de vasos               |");
        System.out.println("|_ 3. Finalizar pedido               |");
        System.out.print("👉 Elige una opción: ");
        return sc.nextInt();
    }
}
