// tarea menu tras otro menu utilizando switch 
import java.util.Scanner;
public class MenuC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion, sub;
        String pedido = "";
        int total = 0;
        do {
            System.out.println(" ____________________________________");
            System.out.println("|       🍦 HELADERÍA LA DULZURA 🍦  |");
            System.out.println("|____________________________________|");
            System.out.println("|_ 1. Sabores de helado              |");
            System.out.println("|_ 2. Tamaños                        |");
            System.out.println("|_ 3. Toppings                       |");
            System.out.println("|_ 4. Conos y Vasos                  |");
            System.out.println("|_ 5. Finalizar pedido               |");
            System.out.println("|____________________________________|");
            System.out.print("👉 Elige una opción: ");
            opcion = sc.nextInt();
            switch(opcion) {
                case 1: 
                    System.out.println("\n--- Sabores de helado ---");
                    System.out.println("1. Vainilla - $3000");
                    System.out.println("2. Chocolate - $3200");
                    System.out.println("3. Fresa - $3100");
                    System.out.println("4. Mango - $3300");
                    System.out.println("5. Regresar");
                    System.out.print("👉 Elige una opción: ");
                    sub = sc.nextInt();
                    switch(sub) {
                        case 1: pedido += "Vainilla - $3000\n"; total += 3000; break;
                        case 2: pedido += "Chocolate - $3200\n"; total += 3200; break;
                        case 3: pedido += "Fresa - $3100\n"; total += 3100; break;
                        case 4: pedido += "Mango - $3300\n"; total += 3300; break;
                        default: break;
                    }
                    break;
                case 2:
                    System.out.println("\n--- Tamaños ---");
                    System.out.println("1. Pequeño - $2000");
                    System.out.println("2. Mediano - $3500");
                    System.out.println("3. Grande - $5000");
                    System.out.println("4. Familiar - $8000");
                    System.out.println("5. Regresar");
                    System.out.print("👉 Elige una opción: ");
                    sub = sc.nextInt();
                    switch(sub) {
                        case 1: pedido += "Pequeño - $2000\n"; total += 2000; break;
                        case 2: pedido += "Mediano - $3500\n"; total += 3500; break;
                        case 3: pedido += "Grande - $5000\n"; total += 5000; break;
                        case 4: pedido += "Familiar - $8000\n"; total += 8000; break;
                        default: break;
                    }
                    break;
                case 3:
                    System.out.println("\n--- Toppings ---");
                    System.out.println("1. Chispas - $1000");
                    System.out.println("2. Oreo - $1500");
                    System.out.println("3. Frutas - $2000");
                    System.out.println("4. Sirope - $1200");
                    System.out.println("5. Regresar");
                    System.out.print("👉 Elige una opción: ");
                    sub = sc.nextInt();
                    switch(sub) {
                        case 1: pedido += "Chispas - $1000\n"; total += 1000; break;
                        case 2: pedido += "Oreo - $1500\n"; total += 1500; break;
                        case 3: pedido += "Frutas - $2000\n"; total += 2000; break;
                        case 4: pedido += "Sirope - $1200\n"; total += 1200; break;
                        default: break;
                    }
                    break;
                case 4:
                    System.out.println("\n--- Conos y Vasos ---");
                    System.out.println("1. Cono tradicional - $500");
                    System.out.println("2. Vaso plástico - $800");
                    System.out.println("3. Barquillo especial - $1500");
                    System.out.println("4. Regresar");
                    System.out.print("👉 Elige una opción: ");
                    sub = sc.nextInt();
                    switch(sub) {
                        case 1: pedido += "Cono tradicional - $500\n"; total += 500; break;
                        case 2: pedido += "Vaso plástico - $800\n"; total += 800; break;
                        case 3: pedido += "Barquillo especial - $1500\n"; total += 1500; break;
                        default: break;
                    }
                    break;
                case 5:
                    System.out.println("\n🧾 TU PEDIDO FINAL:");
                    System.out.println(pedido);
                    System.out.println("TOTAL A PAGAR: $" + total);
                    System.out.println("🍦 Gracias por visitarnos 🍦");
                    break;
                default:
                    System.out.println("❌ Opción inválida");
            }
        } while(opcion != 5);
        sc.close();
    }
}

