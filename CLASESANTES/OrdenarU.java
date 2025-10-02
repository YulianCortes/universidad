package CLASESANTES;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class OrdenarU{
    static class Persona {
        String nombre;
        double salario;

        Persona(String nombre, double salario) {
            this.nombre = nombre;
            this.salario = salario;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int TOTAL_PERSONAS = 20;
        Persona[] personas = new Persona[TOTAL_PERSONAS];

        for (int i = 0; i < TOTAL_PERSONAS; i++) {
            System.out.print("Ingrese el nombre de la persona #" + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el salario de " + nombre + ": ");
            double salario = Double.parseDouble(scanner.nextLine());

            personas[i] = new Persona(nombre, salario);
        }

        Arrays.sort(personas, new Comparator<Persona>() {
            public int compare(Persona p1, Persona p2) {
                return p1.nombre.compareToIgnoreCase(p2.nombre);
            }
        });

        System.out.println("\n=== Lista ordenada alfabéticamente ===");
        for (Persona p : personas) {
            System.out.println("Nombre: " + p.nombre + " | Salario: $" + p.salario);
        }

        scanner.close();
    }

}
