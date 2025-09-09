import java.util.Scanner;

class Usuario {
    String nombre;
    char sexo;
    String cargo;
    int edad;
    float salario;

    public Usuario(String nombre, char sexo, String cargo, int edad, float salario) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.cargo = cargo;
        this.edad = edad;
        this.salario = salario;
    }

    public void mostrar(int index) {
        System.out.printf("%-3d %-15s %-5s %-15s %-3d %f\n",index, nombre, sexo, cargo, edad,salario);
    }
}

public class Arreglos {
    static Scanner input = new Scanner(System.in);
    static final int MAX_USUARIOS = 30;
    static Usuario[] usuarios = new Usuario[MAX_USUARIOS];
    static int numUsuarios = 0; 

    public static void main(String[] args) {
        boolean activo = true;

        while (activo) {
            int opcion = menu();
            switch (opcion) {
                case 1: agregarUsuario(); break;
                case 2: editarUsuario(); break;
                case 3: borrarUsuario(); break;
                case 4: mostrarUsuarios(); break;
                case 5: 
                    System.out.println("Saliendo del sistema...");
                    activo = false;
                    break;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    // Menú principal
    public static int menu() {
        System.out.println("\n===== REGISTRO DE USUARIOS =====");
        System.out.println("1 - Agregar usuario");
        System.out.println("2 - Editar usuario");
        System.out.println("3 - Borrar usuario");
        System.out.println("4 - Mostrar usuarios");
        System.out.println("5 - Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = input.nextInt();
        input.nextLine(); 
        return opcion;
    }

    public static void agregarUsuario() {
        if (numUsuarios >= MAX_USUARIOS) {
            System.out.println("Ya alcanzó el límite de " + MAX_USUARIOS + " usuarios.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = input.nextLine();
        System.out.print("Sexo (M/F): ");
        char sexo = input.next().charAt(0);
        input.nextLine();
        System.out.print("Cargo: ");
        String cargo = input.nextLine();
        System.out.print("Edad: ");
        int edad = input.nextInt();
        System.out.print("Salario: ");
        float salario = input.nextFloat();
        input.nextLine();

        usuarios[numUsuarios] = new Usuario(nombre, sexo, cargo, edad, salario);
        numUsuarios++;
        System.out.println("Usuario agregado exitosamente.");
    }

    public static void editarUsuario() {
        if (numUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        mostrarUsuarios();
        System.out.print("Ingrese el número de usuario a editar: ");
        int mostrar = input.nextInt() - 1;
        input.nextLine();

        if (mostrar >= 0 && mostrar < numUsuarios) {
            Usuario u = usuarios[mostrar];
            System.out.println("Editando al usuario #" + (mostrar+1) + " (" + u.nombre + ")");
            System.out.println("1 - Cambiar nombre");
            System.out.println("2 - Cambiar sexo");
            System.out.println("3 - Cambiar cargo");
            System.out.println("4 - Cambiar edad");
            System.out.println("5 - Cambiar salario");
            System.out.print("Seleccione opción: ");
            int opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    u.nombre = input.nextLine();
                    break;
                case 2:
                    System.out.print("Nuevo sexo (M/F): ");
                    u.sexo = input.next().charAt(0);
                    input.nextLine();
                    break;
                case 3:
                    System.out.print("Nuevo cargo: ");
                    u.cargo = input.nextLine();
                    break;
                case 4:
                    System.out.print("Nueva edad: ");
                    u.edad = input.nextInt();
                    input.nextLine();
                    break;
                case 5:
                    System.out.print("Nuevo salario: ");
                    u.salario = input.nextFloat();
                    input.nextLine();
                    break;    
                default:
                    System.out.println("Opción inválida.");
            }
            System.out.println("Usuario editado exitosamente.");
        } else {
            System.out.println("Número de usuario inválido.");
        }
    }

    // Borrar usuario
    public static void borrarUsuario() {
        if (numUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        mostrarUsuarios();
        System.out.print("Ingrese el número de usuario a borrar: ");
        int mostrar = input.nextInt() - 1;
        input.nextLine();

        if (mostrar >= 0 && mostrar < numUsuarios) {
            for (int i = mostrar; i < numUsuarios - 1; i++) {
                usuarios[i] = usuarios[i+1];
            }
            usuarios[numUsuarios - 1] = null; 
            numUsuarios--;
            System.out.println("Usuario borrado exitosamente.");
        } else {
            System.out.println("Número de usuario inválido.");
        }
    }

    // Mostrar usuarios
    public static void mostrarUsuarios() {
        if (numUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("\n#   Nombre                Sexo      Cargo                Edad       salario");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < numUsuarios; i++) {
            usuarios[i].mostrar(i + 1);
        }
    }
}
