package HELADERIA;
import java.util.ArrayList;
import java.util.Scanner;

public class Helpers {

    public Heladeria crearHeladeria(){
        Scanner input = new Scanner(System.in);
        int id;
        while(true){
            System.out.println("Crear Heladeria");
            System.out.println("Escribir el ID de la heladeria: ");
            if(input.hasNextInt()){
                id = input.nextInt();
                input.nextLine();
                break;
            } else {
                System.out.println("Debe ingresar un número válido.");
                input.nextLine();
            }
        }
        System.out.println("Escribir la direccion de la Heladeria: ");
        String direccion = input.nextLine();
        return new Heladeria(id, direccion);        
    }

    public void editarHeladeria(Heladeria h){
        Scanner input = new Scanner(System.in);
        System.out.println("Editar Heladeria ID " + h.id);
        System.out.println("Dirección actual: " + h.getDireccion());
        System.out.print("Nueva dirección: ");
        String dir = input.nextLine();
        h.setDireccion(dir);
        System.out.println("Heladeria actualizada.");
    }

    public Helado crearHelado(){
        Scanner input = new Scanner(System.in);
        int id, tipo;
        float precio;

        while(true){
            System.out.println("Crear Helado");
            System.out.println("Escribir el ID del helado: ");
            if(input.hasNextInt()){ id = input.nextInt(); input.nextLine(); break;}
            else {System.out.println("Debe ingresar un número válido."); input.nextLine();}
        }

        System.out.println("Escriba el nombre del helado: ");
        String nombre = input.nextLine();

        while(true){
            System.out.println("Escriba el precio del Helado:");
            if(input.hasNextFloat()){ precio = input.nextFloat(); input.nextLine(); break;}
            else {System.out.println("Debe ingresar un número válido."); input.nextLine();}
        }

        while(true){
            System.out.println("Escriba el tipo del helado (1: Vaso, 2: Cono, 3: Paleta):");
            if(input.hasNextInt()){ tipo = input.nextInt(); input.nextLine(); break;}
            else {System.out.println("Debe ingresar un número válido."); input.nextLine();}
        }

        ArrayList<String> sabores = new ArrayList<>();
        String opcionSabor;
        do {
            System.out.println("Ingrese un sabor (o 'fin' para terminar): ");
            opcionSabor = input.nextLine();
            if(!opcionSabor.equalsIgnoreCase("fin")) sabores.add(opcionSabor);
        } while(!opcionSabor.equalsIgnoreCase("fin"));

        return new Helado(id, nombre, precio, sabores, tipo);        
    }

    public void editarHelado(Helado h){
        Scanner input = new Scanner(System.in);
        System.out.println("Editar Helado ID " + h.id);
        System.out.println("Nombre actual: " + h.nombre);
        System.out.print("Nuevo nombre: ");
        h.nombre = input.nextLine();

        System.out.println("Precio actual: " + h.getPrecio());
        System.out.print("Nuevo precio: ");
        if(input.hasNextFloat()) h.setPrecio(input.nextFloat());
        input.nextLine();
        System.out.println("Helado actualizado.");
    }

    public Malteada crearMalteada() {
        Scanner input = new Scanner(System.in);
        int id;
        float precio;

        while(true){
            System.out.println("Crear Malteada");
            System.out.println("Escribir el ID de la malteada: ");
            if(input.hasNextInt()){ id = input.nextInt(); input.nextLine(); break;}
            else {System.out.println("Debe ingresar un número válido."); input.nextLine();}
        }

        while(true){
            System.out.println("Escriba el precio de la malteada:");
            if(input.hasNextFloat()){ precio = input.nextFloat(); input.nextLine(); break;}
            else {System.out.println("Debe ingresar un número válido."); input.nextLine();}
        }

        ArrayList<String> sabores = new ArrayList<>();
        String opcionSabor;
        do {
            System.out.println("Ingrese un sabor (o 'fin' para terminar): ");
            opcionSabor = input.nextLine();
            if(!opcionSabor.equalsIgnoreCase("fin")) sabores.add(opcionSabor);
        } while(!opcionSabor.equalsIgnoreCase("fin"));

        return new Malteada(id, precio, sabores);
    }

    public void editarMalteada(Malteada m){
        Scanner input = new Scanner(System.in);
        System.out.println("Editar Malteada ID " + m.id);
        System.out.println("Precio actual: " + m.getPrecio());
        System.out.print("Nuevo precio: ");
        if(input.hasNextFloat()) m.setPrecio(input.nextFloat());
        input.nextLine();
        System.out.println("Malteada actualizada.");
    }

    public Toppings crearTopping() {
        Scanner input = new Scanner(System.in);
        int id;
        float precio;
        System.out.println("Crear Topping");

        while(true){
            System.out.println("Escribir ID del topping:");
            if(input.hasNextInt()){ id = input.nextInt(); input.nextLine(); break;}
            else {System.out.println("Debe ingresar un número válido."); input.nextLine();}
        }

        System.out.println("Nombre del topping:");
        String nombre = input.nextLine();

        while(true){
            System.out.println("Precio del topping:");
            if(input.hasNextFloat()){ precio = input.nextFloat(); input.nextLine(); break;}
            else {System.out.println(" Debe ingresar un número válido."); input.nextLine();}
        }

        Toppings topping = new Toppings();
        topping.id = id;
        topping.setNombre(nombre);
        topping.setPrecio(precio);

        return topping;
    }

    public void editarTopping(Toppings t){
        Scanner input = new Scanner(System.in);
        System.out.println("Editar Topping ID " + t.id);
        System.out.println("Nombre actual: " + t.getNombre());
        System.out.print("Nuevo nombre: ");
        t.setNombre(input.nextLine());
        System.out.println("Precio actual: " + t.getPrecio());
        System.out.print("Nuevo precio: ");
        if(input.hasNextFloat()) t.setPrecio(input.nextFloat());
        input.nextLine();
        System.out.println("Topping actualizado.");
    }

    public Pedido crearPedido(int mesa) {
        return new Pedido(mesa);
    }

    public Heladeria buscarHeladeria(ArrayList<Heladeria> lista, int id){
        for(Heladeria h : lista){
            if(h.id == id) return h;
        }
        System.out.println("Heladeria no encontrada.");
        return null;
    }

    public void mostrarProductosHeladeria(Heladeria h){
        System.out.println("Helados disponibles:");
        for(Helado hel : h.getListaHeladosDisponibles()) System.out.println("- " + hel.nombre);
        System.out.println("Malteadas disponibles:");
        for(Malteada mal : h.getListaMalteadasDisponibles()) System.out.println("- Precio: " + mal.calcularPrecio());
        System.out.println("Toppings disponibles:");
        for(Toppings top : h.getListaToppings()) System.out.println("- " + top.getNombre());
        System.out.println("Pedidos actuales:");
        for(Pedido ped : h.getListaPedidos()) System.out.println("- Mesa: " + ped.mesa + " Total: " + ped.calcularCuenta());
    }
}
