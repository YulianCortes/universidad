package OrientaObjetos;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioManager {
    private ArrayList<Usuario> usuarios;
    private Scanner input;

    public UsuarioManager(int capacidad) {
        usuarios = new ArrayList<>(capacidad);
        input = new Scanner(System.in);
    }
    // Agregar usuario
    public void agregarUsuario() {
        System.out.print("Nombre: ");
        String nombre = input.nextLine();

        System.out.print("Sexo (M/F): ");
        char sexo = input.nextLine().charAt(0); // char en lugar de String

        System.out.print("Cargo: ");
        String cargo = input.nextLine();

        System.out.print("Edad: ");
        int edad = input.nextInt();

        System.out.print("Salario: ");
        double salario = input.nextDouble();
        input.nextLine(); // limpiar buffer

        usuarios.add(new Usuario(nombre, sexo, cargo, edad, salario));
        System.out.println("✅ Usuario agregado exitosamente.");
    }
    // Editar usuario
    public void editarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        MostrarUsuarios.mostrar(usuarios.toArray(new Usuario[0]), usuarios.size());
        System.out.print("Ingrese el número del usuario a editar: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index < 0 || index >= usuarios.size()) {
            System.out.println("Usuario no válido.");
            return;
        }
        Usuario u = usuarios.get(index);
        System.out.print("Nuevo nombre (" + u.getNombre() + "): ");
        String nombre = input.nextLine();
        if (!nombre.isEmpty()) u.setNombre(nombre);

        System.out.print("Nuevo cargo (" + u.getCargo() + "): ");
        String cargo = input.nextLine();
        if (!cargo.isEmpty()) u.setCargo(cargo);

        System.out.print("Nueva edad (" + u.getEdad() + "): ");
        String edadStr = input.nextLine();
        if (!edadStr.isEmpty()) u.setEdad(Integer.parseInt(edadStr));

        System.out.print("Nuevo salario (" + u.getSalario() + "): ");
        String salarioStr = input.nextLine();
        if (!salarioStr.isEmpty()) u.setSalario(Double.parseDouble(salarioStr));

        System.out.println("✅ Usuario actualizado.");
    }

    public void borrarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        MostrarUsuarios.mostrar(usuarios.toArray(new Usuario[0]), usuarios.size());
        System.out.print("Ingrese el número del usuario a eliminar: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index < 0 || index >= usuarios.size()) {
            System.out.println("Usuario no válido.");
            return;
        }

        usuarios.remove(index);
        System.out.println("✅ Usuario eliminado.");
    }
    public void mostrarUsuarios() {
        MostrarUsuarios.mostrar(usuarios.toArray(new Usuario[0]), usuarios.size());
    }
}