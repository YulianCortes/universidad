import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HeladoManager heladoManager = new HeladoManager();
        MalteadaManager malteadaManager = new MalteadaManager();
        ToppingManager toppingManager = new ToppingManager();
        PedidoManager pedidoManager = new PedidoManager();

        // Productos de ejemplo
        ArrayList<String> saboresHelado1 = new ArrayList<>();
        saboresHelado1.add("Fresa");
        heladoManager.agregarHelado(new Helado(1, 2000, saboresHelado1, 1));

        ArrayList<String> saboresHelado2 = new ArrayList<>();
        saboresHelado2.add("Chocolate");
        heladoManager.agregarHelado(new Helado(2, 2000, saboresHelado2, 2));

        ArrayList<String> saboresHelado3 = new ArrayList<>();
        saboresHelado3.add("Vainilla");
        heladoManager.agregarHelado(new Helado(3, 2000, saboresHelado3, 3));

        ArrayList<String> saboresMalteada1 = new ArrayList<>();
        saboresMalteada1.add("Fresa");
        malteadaManager.agregarMalteada(new Malteada(1, 3000, saboresMalteada1, 1));

        // Toppings
        toppingManager.agregarTopping(new Topping("Chips", 500));
        toppingManager.agregarTopping(new Topping("Galletas", 500));
        toppingManager.agregarTopping(new Topping("Gomitas", 500));

        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Hacer pedido");
            System.out.println("2. Ver estado de mesas");
            System.out.println("3. Cerrar cuenta de una mesa");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("⚠️ Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    ArrayList<Integer> mesasLibres = pedidoManager.getMesasLibres();
                    if (mesasLibres.isEmpty()) {
                        System.out.println("⚠️ No hay mesas libres.");
                        break;
                    }
                    System.out.println("Mesas libres: " + mesasLibres);
                    System.out.print("Número de mesa a usar: ");
                    int mesa = Integer.parseInt(sc.nextLine());

                    if (!mesasLibres.contains(mesa)) {
                        System.out.println("⚠️ Mesa ocupada o inválida.");
                        break;
                    }

                    Pedido pedido = pedidoManager.getPedidoPorMesa(mesa);

                    // Mostrar lo que ya se ha pedido en la mesa
                    if (!pedido.estaLibre()) {
                        System.out.println("\n--- Pedido actual de la mesa " + mesa + " ---");
                        for (Helado h : pedido.getListaHelados()) {
                            System.out.println("Helado: " + h.getSabores() + " | Tipo: " + h.getTipo() + " | Toppings: " + h.getToppings() + " | Precio: " + h.calcularPrecio());
                        }
                        for (Malteada m : pedido.getListaMalteadas()) {
                            System.out.println("Malteada: " + m.getSabores() + " | Tipo: " + m.getTipo() + " | Toppings: " + m.getToppings() + " | Precio: " + m.calcularPrecio());
                        }
                        System.out.println("Cuenta parcial: $" + pedido.calcularCuenta());
                    } else {
                        System.out.println("Mesa " + mesa + " está vacía.");
                    }

                    boolean seguirAgregando = true;
                    while (seguirAgregando) {
                        System.out.println("\n¿Qué desea agregar?");
                        System.out.println("1. Helado");
                        System.out.println("2. Malteada");
                        System.out.println("3. Terminar pedido");
                        int tipoProducto;
                        try {
                            tipoProducto = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("⚠️ Entrada inválida.");
                            continue;
                        }

                        if (tipoProducto == 3) break;

                        if (tipoProducto == 1) {
                            // Helado
                            System.out.println("Sabores de helado: 1.Fresa 2.Chocolate 3.Vainilla");
                            int sabor = Integer.parseInt(sc.nextLine());
                            System.out.println("Tipos de helado: 1.Cono 2.Canasta 3.Vaso");
                            int tipo = Integer.parseInt(sc.nextLine());
                            ArrayList<String> saborElegido = new ArrayList<>();
                            if (sabor == 1) saborElegido.add("Fresa");
                            else if (sabor == 2) saborElegido.add("Chocolate");
                            else saborElegido.add("Vainilla");

                            Helado helado = new Helado(0, 2000, saborElegido, tipo);

                            // Toppings helado
                            boolean agregarTopping = true;
                            while (agregarTopping) {
                                System.out.println("Toppings disponibles:");
                                System.out.println("0. Ninguno / Terminar");
                                System.out.println("1. Chips");
                                System.out.println("2. Galletas");
                                System.out.println("3. Gomitas");
                                System.out.print("Seleccione topping: ");

                                int t;
                                try {
                                    t = Integer.parseInt(sc.nextLine());
                                } catch (Exception e) {
                                    System.out.println("⚠️ Entrada inválida.");
                                    continue;
                                }

                                switch (t) {
                                    case 0 -> agregarTopping = false;
                                    case 1 -> helado.addTopping("Chips");
                                    case 2 -> helado.addTopping("Galletas");
                                    case 3 -> helado.addTopping("Gomitas");
                                    default -> System.out.println("⚠️ Topping inválido.");
                                }
                            }

                            pedido.addHelado(helado);

                        } else if (tipoProducto == 2) {
                            // Malteada
                            System.out.println("Sabores de malteada: 1.Fresa 2.Chocolate 3.Vainilla");
                            int sabor = Integer.parseInt(sc.nextLine());
                            System.out.println("Tipos de malteada: 1.Vaso mediano 2.Vaso grande");
                            int tipo = Integer.parseInt(sc.nextLine());
                            ArrayList<String> saborElegido = new ArrayList<>();
                            if (sabor == 1) saborElegido.add("Fresa");
                            else if (sabor == 2) saborElegido.add("Chocolate");
                            else saborElegido.add("Vainilla");

                            Malteada malteada = new Malteada(0, 3000, saborElegido, tipo);

                            // Toppings malteada
                            boolean agregarTopping = true;
                            while (agregarTopping) {
                                System.out.println("\nToppings disponibles:");
                                System.out.println("0. Ninguno / Terminar");
                                System.out.println("1. Chips");
                                System.out.println("2. Galletas");
                                System.out.println("3. Gomitas");
                                System.out.print("Seleccione topping: ");

                                int t;
                                try {
                                    t = Integer.parseInt(sc.nextLine());
                                } catch (Exception e) {
                                    System.out.println("⚠️ Entrada inválida.");
                                    continue;
                                }

                                switch (t) {
                                    case 0 -> agregarTopping = false;
                                    case 1 -> malteada.addTopping("Chips");
                                    case 2 -> malteada.addTopping("Galletas");
                                    case 3 -> malteada.addTopping("Gomitas");
                                    default -> System.out.println("⚠️ Topping inválido.");
                                }
                            }

                            pedido.addMalteada(malteada);
                        }

                        // Mostrar pedido actualizado después de cada adición
                        System.out.println("\n--- Pedido actualizado de la mesa " + mesa + " ---");
                        for (Helado h : pedido.getListaHelados()) {
                            System.out.println("Helado: " + h.getSabores() + " | Tipo: " + h.getTipo() + " | Toppings: " + h.getToppings() + " | Precio: " + h.calcularPrecio());
                        }
                        for (Malteada m : pedido.getListaMalteadas()) {
                            System.out.println("Malteada: " + m.getSabores() + " | Tipo: " + m.getTipo() + " | Toppings: " + m.getToppings() + " | Precio: " + m.calcularPrecio());
                        }
                        System.out.println("Cuenta parcial: $" + pedido.calcularCuenta());
                    }
                }
                case 2 -> pedidoManager.mostrarPedidos();
                case 3 -> {
                    System.out.print("Número de mesa a cerrar: ");
                    int mesaCerrar = Integer.parseInt(sc.nextLine());
                    pedidoManager.cerrarCuenta(mesaCerrar);
                }
                case 4 -> salir = true;
                default -> System.out.println("⚠️ Opción inválida.");
            }
        }

        sc.close();
    }
}
