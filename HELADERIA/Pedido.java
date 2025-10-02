package HELADERIA;
import java.util.ArrayList;
 
public class Pedido {
    private ArrayList<Helado> listaHelados;
    private ArrayList<Malteada> listaMalteada;
    public int mesa;
    public float propina;

    // Constructor
    public Pedido(int mesa){
        this.mesa = mesa;
        this.listaHelados = new ArrayList<Helado>();
        this.listaMalteada = new ArrayList<Malteada>();
    }

    // Métodos
    public float calcularCuenta(){
        float total = 0;
        for(Helado helado : this.listaHelados){
            total += helado.calcularPrecio();
        }
        for(Malteada malteada : this.listaMalteada){
            total += malteada.calcularPrecio();
        }
        return total + this.propina;
    }

    // Setters
    public void addMalteada(Malteada producto){
        this.listaMalteada.add(producto);
    }

    // 🔹 Método que te faltaba para evitar el error
    public void addHelado(Helado producto){
        this.listaHelados.add(producto);
    }

    public void addToppingToHelado(Toppings topping){
        if(!this.listaHelados.isEmpty()){
            this.listaHelados.get(this.listaHelados.size()-1).addTopping(topping.getNombre());
            System.out.println("✅ Topping agregado al helado: " + topping.getNombre());
        } else {
            System.out.println("⚠ No hay helados en el pedido.");
        }
    }

    public void addToppingToMalteada(Toppings topping){
        if(!this.listaMalteada.isEmpty()){
            this.listaMalteada.get(this.listaMalteada.size()-1).addTopping(topping.getNombre());
            System.out.println("✅ Topping agregado a la malteada: " + topping.getNombre());
        } else {
            System.out.println("⚠ No hay malteadas en el pedido.");
        }
    }

    // Método para editar un pedido existente
    public void editarPedido() {
        @SuppressWarnings("resource")
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- EDITAR PEDIDO ---");
            System.out.println("1. Editar helados");
            System.out.println("2. Editar malteadas");
            System.out.println("3. Cambiar propina");
            System.out.println("4. Volver");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (listaHelados.isEmpty()) {
                        System.out.println("No hay helados en el pedido.");
                    } else {
                        System.out.println("Tienes " + listaHelados.size() + " helados en el pedido.");
                        System.out.print("¿Cuál quieres editar? (1-" + listaHelados.size() + "): ");
                        int index = sc.nextInt() - 1;
                        if (index >= 0 && index < listaHelados.size()) {
                            Helado helado = listaHelados.get(index);
                            System.out.println("Editando helado con sabores: " + helado.getSabores());
                            System.out.println("1. Cambiar sabores");
                            System.out.println("2. Agregar topping");
                            System.out.println("3. Volver");
                            int sub = sc.nextInt();
                            sc.nextLine(); // limpiar buffer
                            if (sub == 1) {
                                System.out.println("Escribe un nuevo sabor:");
                                String sabor = sc.nextLine();
                                java.util.ArrayList<String> nuevosSabores = new java.util.ArrayList<>();
                                nuevosSabores.add(sabor);
                                helado.setSabores(nuevosSabores);
                                System.out.println("✅ Sabores actualizados.");
                            } else if (sub == 2) {
                                System.out.println("Escribe el nombre del topping:");
                                String topping = sc.nextLine();
                                helado.addTopping(topping);
                                System.out.println("✅ Topping agregado.");
                            }
                        }
                    }
                    break;

                case 2:
                    if (listaMalteada.isEmpty()) {
                        System.out.println("No hay malteadas en el pedido.");
                    } else {
                        System.out.println("Tienes " + listaMalteada.size() + " malteadas en el pedido.");
                        System.out.print("¿Cuál quieres editar? (1-" + listaMalteada.size() + "): ");
                        int index = sc.nextInt() - 1;
                        if (index >= 0 && index < listaMalteada.size()) {
                            Malteada malteada = listaMalteada.get(index);
                            System.out.println("Editando malteada con sabores: " + malteada.getSabores());
                            System.out.println("1. Cambiar sabores");
                            System.out.println("2. Agregar topping");
                            System.out.println("3. Volver");
                            int sub = sc.nextInt();
                            sc.nextLine();
                            if (sub == 1) {
                                System.out.println("Escribe un nuevo sabor:");
                                String sabor = sc.nextLine();
                                java.util.ArrayList<String> nuevosSabores = new java.util.ArrayList<>();
                                nuevosSabores.add(sabor);
                                malteada.setSabores(nuevosSabores);
                                System.out.println("✅ Sabores actualizados.");
                            } else if (sub == 2) {
                                System.out.println("Escribe el nombre del topping:");
                                String topping = sc.nextLine();
                                malteada.addTopping(topping);
                                System.out.println("✅ Topping agregado.");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Propina actual: " + propina);
                    System.out.print("Escribe el nuevo valor de propina: ");
                    propina = sc.nextFloat();
                    System.out.println("✅ Propina actualizada.");
                    break;

                case 4:
                    System.out.println("Saliendo de edición...");
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 4);
    }
}
