package OrientaObjetos;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("¿Cuántos usuarios desea registrar como máximo?: ");
        int capacidad = input.nextInt();
        input.nextLine(); 
        UsuarioManager gestor = new UsuarioManager(capacidad);
        boolean activo = true;
        while (activo) {
            Menu.mostrarMenu();
            int opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1: gestor.agregarUsuario(); break;
                case 2: gestor.editarUsuario(); break;
                case 3: gestor.borrarUsuario(); break;
                case 4: gestor.mostrarUsuarios(); break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    activo = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}