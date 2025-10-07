package HELADERIA;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Heladeria> listaHeladerias = new ArrayList<>();
    ArrayList<Helado> listaHelados = new ArrayList<>();
    ArrayList<Malteada> listaMalteadas = new ArrayList<>();
    ArrayList<Toppings> listaToppings = new ArrayList<>();

    public static void main(String[] args) {
        Main app = new Main();
        Menus menuPrincipal = new Menus(40, '-', '1');
        boolean running = true;

        ArrayList<String> opcionesMenu = new ArrayList<>();
        opcionesMenu.add("Administrar Heladerias");
        opcionesMenu.add("Administrar Helados");
        opcionesMenu.add("Administrar Malteadas");
        opcionesMenu.add("Administrar Toppings");
        opcionesMenu.add("Administrar Pedidos");
        opcionesMenu.add("Salir");

        while(running){
            int opcion = menuPrincipal.createMenu(opcionesMenu, false);
            switch(opcion){
                case 1: app.crud("CRUD Heladerias", 1); break;
                case 2: app.crud("CRUD Helados", 2); break;
                case 3: app.crud("CRUD Malteadas", 3); break;
                case 4: app.crud("CRUD Toppings", 4); break;
                case 5: app.crudPedidos(); break;
                case 6: running = false; break;
            }
        }
    }

    public void crud(String titulo, int idTipoRecurso){
        Helpers helpers = new Helpers();
        Menus menuCrud = new Menus(40, '-', '1');
        ArrayList<String> options = new ArrayList<>();
        options.add("Crear"); 
        options.add("Ver"); 
        options.add("Editar"); 
        options.add("Eliminar"); 
        options.add("Volver");

        int opcion = menuCrud.createMenu(options, false);
        Scanner sc = new Scanner(System.in);

        switch(opcion){
            case 1: // Crear
                if(idTipoRecurso == 1) listaHeladerias.add(helpers.crearHeladeria());
                else if(idTipoRecurso == 2) listaHelados.add(helpers.crearHelado());
                else if(idTipoRecurso == 3) listaMalteadas.add(helpers.crearMalteada());
                else if(idTipoRecurso == 4) listaToppings.add(helpers.crearTopping());
                break;

            case 2: // Ver
                if(idTipoRecurso == 1) for(Heladeria h : listaHeladerias) System.out.println("ID: " + h.id + " Direccion: " + h.getDireccion());
                else if(idTipoRecurso == 2) for(Helado h : listaHelados) System.out.println("ID: " + h.id + " Nombre: " + h.nombre);
                else if(idTipoRecurso == 3) for(Malteada m : listaMalteadas) System.out.println("ID: " + m.id + " Precio: " + m.calcularPrecio());
                else if(idTipoRecurso == 4) for(Toppings t : listaToppings) System.out.println("ID: " + t.id + " Nombre: " + t.getNombre());
                break;

            case 3: // Editar
                System.out.println("Ingrese ID a editar:");
                int idEdit = sc.nextInt();
                sc.nextLine();
                if(idTipoRecurso == 1){
                    for(Heladeria h : listaHeladerias) if(h.id == idEdit) helpers.editarHeladeria(h);
                } else if(idTipoRecurso == 2){
                    for(Helado h : listaHelados) if(h.id == idEdit) helpers.editarHelado(h);
                } else if(idTipoRecurso == 3){
                    for(Malteada m : listaMalteadas) if(m.id == idEdit) helpers.editarMalteada(m);
                } else if(idTipoRecurso == 4){
                    for(Toppings t : listaToppings) if(t.id == idEdit) helpers.editarTopping(t);
                }
                break;

            case 4: // Eliminar
                System.out.println("Ingrese ID a eliminar:");
                int idDel = sc.nextInt();
                sc.nextLine();
                if(idTipoRecurso == 1) listaHeladerias.removeIf(h -> h.id == idDel);
                else if(idTipoRecurso == 2) listaHelados.removeIf(h -> h.id == idDel);
                else if(idTipoRecurso == 3) listaMalteadas.removeIf(m -> m.id == idDel);
                else if(idTipoRecurso == 4) listaToppings.removeIf(t -> t.id == idDel);
                System.out.println("Eliminado correctamente.");
                break;

            case 5: return;
        }
    }

    public void crudPedidos(){
        Helpers helpers = new Helpers();
        Scanner sc = new Scanner(System.in);
        if(listaHeladerias.isEmpty()){ 
            System.out.println("No hay heladerías registradas."); 
            return; 
        }

        System.out.println("Seleccione la heladería por ID:");
        for(Heladeria h : listaHeladerias) System.out.println("ID: " + h.id + " Direccion: " + h.getDireccion());

        int idHeladeria = sc.nextInt();
        sc.nextLine();
        Heladeria heladeria = helpers.buscarHeladeria(listaHeladerias, idHeladeria);
        if(heladeria == null) return;

        boolean menuPedido = true;
        while(menuPedido){
            ArrayList<String> opciones = new ArrayList<>();
            opciones.add("Crear Pedido"); 
            opciones.add("Ver Pedidos"); 
            opciones.add("Agregar Helado a Pedido"); 
            opciones.add("Agregar Malteada a Pedido"); 
            opciones.add("Agregar Topping a Pedido"); 
            opciones.add("Editar Pedido"); 
            opciones.add("Volver");

            int opc = new Menus(40, '-', '1').createMenu(opciones, false);
            switch(opc){
                case 1: // Crear Pedido
                    System.out.println("Número de mesa:");
                    int mesa = sc.nextInt(); sc.nextLine();
                    Pedido p = helpers.crearPedido(mesa); 
                    heladeria.addListaPedidos(p); 
                    System.out.println("Pedido creado para la mesa " + mesa);
                    break;

                case 2: // Ver Pedidos
                    if(heladeria.getListaPedidos().isEmpty()) System.out.println("No hay pedidos.");
                    else helpers.mostrarProductosHeladeria(heladeria);
                    break;

                case 3: // Agregar Helado a Pedido
                    if(heladeria.getListaPedidos().isEmpty()){ System.out.println("No hay pedidos."); break; }
                    System.out.println("Seleccionar mesa para agregar helado:");
                    int mesaHel = sc.nextInt(); sc.nextLine();
                    Pedido pedidoHel = null;
                    for(Pedido ped : heladeria.getListaPedidos()) if(ped.mesa == mesaHel) pedidoHel = ped;
                    if(pedidoHel != null){
                        Helado h = helpers.crearHelado();
                        pedidoHel.addHelado(h);
                        System.out.println("Helado agregado al pedido.");
                    } else System.out.println("Mesa no encontrada.");
                    break;

                case 4: // Agregar Malteada a Pedido
                    if(heladeria.getListaPedidos().isEmpty()){ System.out.println("No hay pedidos."); break; }
                    System.out.println("Seleccionar mesa para agregar malteada:");
                    int mesaMal = sc.nextInt(); sc.nextLine();
                    Pedido pedidoMal = null;
                    for(Pedido ped : heladeria.getListaPedidos()) if(ped.mesa == mesaMal) pedidoMal = ped;
                    if(pedidoMal != null){
                        Malteada m = helpers.crearMalteada();
                        pedidoMal.addMalteada(m);
                        System.out.println("Malteada agregada al pedido.");
                    } else System.out.println("Mesa no encontrada.");
                    break;

                case 5: // Agregar Topping
                    if(heladeria.getListaPedidos().isEmpty()){ System.out.println("No hay pedidos."); break; }
                    System.out.println("Seleccionar mesa para agregar topping:");
                    int mesaTop = sc.nextInt(); sc.nextLine();
                    Pedido pedidoTop = null;
                    for(Pedido ped : heladeria.getListaPedidos()) if(ped.mesa == mesaTop) pedidoTop = ped;
                    if(pedidoTop != null){
                        Toppings top = helpers.crearTopping();
                        System.out.println("Agregar a (1) Helado o (2) Malteada?");
                        int tipo = sc.nextInt(); sc.nextLine();
                        if(tipo == 1) pedidoTop.addToppingToHelado(top);
                        else if(tipo == 2) pedidoTop.addToppingToMalteada(top);
                    } else System.out.println("Mesa no encontrada.");
                    break;

                case 6: // Editar Pedido
                    if(heladeria.getListaPedidos().isEmpty()){ System.out.println("No hay pedidos."); break; }
                    System.out.println("Seleccionar mesa a editar:");
                    int mesaEdit = sc.nextInt(); sc.nextLine();
                    Pedido pedidoEdit = null;
                    for(Pedido ped : heladeria.getListaPedidos()) if(ped.mesa == mesaEdit) pedidoEdit = ped;
                    if(pedidoEdit != null) pedidoEdit.editarPedido();
                    else System.out.println("Mesa no encontrada.");
                    break;

                case 7: menuPedido = false; break;
            }
        }
    }
}
