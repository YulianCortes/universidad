package VersionUno;

import java.util.Scanner;

public class menuHelado {
    // se delcaron las varibles globales y publicas para poder usar en todo el
    // programa
    public static int opcionPrincipal = 0;
    public static int opcionDos = 0;
    public static int opcionTres = 0;
    public static int opcionCuatro = 0;

    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        while (true) {// el while se usa para que se repita el menu infinitamente
            menusUnidos(1);// aqui, en vez de nombrar nada mas la funcion, ponemos la opcion en parentesis,
                           // que indica qeu case debe salir ahi
            System.out.println("Elja una opción: ");
            opcionPrincipal = entrada.nextInt();

            switch (opcionPrincipal) {
                case 1:// se dejan los espacios en blanco para juqe siga de largo, pues sin importar la
                       // opcion que escogan siempre los llevara al mismo menu
                case 2:
                case 3:
                case 4:
                case 5:
                    while (true) {
                        menusUnidos(2);
                        System.out.println("Elija una opción: ");
                        opcionDos = entrada.nextInt();
                        switch (opcionDos) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                while (true) {
                                    menusUnidos(3);
                                    System.out.println("Elija una opción: ");
                                    opcionTres = entrada.nextInt();
                                    switch (opcionTres) {
                                        case 1:
                                        case 2:
                                        case 3:
                                            while (true) {
                                                menusUnidos(4);
                                                System.out.println("Elija una opción");
                                                opcionCuatro = entrada.nextInt();
                                                switch (opcionCuatro) {
                                                    case 1:
                                                    case 2:
                                                        System.out.println("Gracias por comprar😊");
                                                        mostrarPedidoCompleto();
                                                        break;
                                                    default:
                                                        System.out.println("Opción no valida❎");
                                                }
                                            }
                                        default:
                                            System.out.println("Opción no valida");
                                    }
                                    break;
                                }
                                break;
                            default:
                                System.out.println("❎Opción no valida❎");
                        }
                        break;
                    }
                    break;
                case 6:
                    System.out.println("Gracias por su compra😎");
                    mostrarPedidoCompleto();
                    break;
                default:
                    System.out.println("Opción no valida😔");
            }
        }
    }

    public static void menuPrincipal() {
        System.out.println("________________________________");
        System.out.println("|       POO-PY HELADERIA       |");
        System.out.println("|  Menú Heladería Poo-Py       |");
        System.out.println("|  OPCIONES:                   |");
        System.out.println("| 1. Conos                     |");
        System.out.println("| 2. Copas de Helado           |");
        System.out.println("| 3. Ensalada de frutas        |");
        System.out.println("| 4. Malteadas                 |");
        System.out.println("| 5. Litro de Helado           |");
        System.out.println("| 6. TERMINAR                  |");
        System.out.println("|______________________________|");
    }

    public static void menuDos() {
        System.out.println("________________________________");
        System.out.println("|       POO-PY HELADERIA       |");
        System.out.println("|  Sabores:                    |");
        System.out.println("| 1. Maracuyá                  |");
        System.out.println("| 2. Vainilla Chips            |");
        System.out.println("| 3. Chocolate                 |");
        System.out.println("| 4. Fresa                     |");
        System.out.println("| 5. TERMINAR                  |");
        System.out.println("|______________________________|");
    }

    public static void menuTres() {
        System.out.println("________________________________");
        System.out.println("|       POO-PY HELADERIA       |");
        System.out.println("|  Acompañantes:               |");
        System.out.println("| 1. Galleta                   |");
        System.out.println("| 2. Gomita                    |");
        System.out.println("| 3. Chips                     |");
        System.out.println("| 4. TERMINAR                  |");
        System.out.println("|______________________________|");
    }

    public static void menuCuatro() {
        System.out.println("________________________________");
        System.out.println("|       POO-PY HELADERIA       |");
        System.out.println("|  Pagos:                      |");
        System.out.println("| 1. Efectivo                  |");
        System.out.println("| 2. Pagos virtuales           |");
        System.out.println("| 3. TERMINAR                  |");
        System.out.println("|______________________________|");
    }

    public static void menusUnidos(int nivel) {// esta funcion fue la nueva que se agrego que esta es la genral y dentro
                                               // de ella estan las otras funciones que ya se habian realizado, cada una
                                               // sale conforme arriba se digite el la opcion del swtich
        switch (nivel) {
            case 1:
                menuPrincipal();
                break;
            case 2:
                menuDos();
                break;
            case 3:
                menuTres();
                break;
            case 4:
                menuCuatro();
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public static void mostrarPedidoCompleto() {// esta funcion imprime al final lo que la persona escogio

        System.out.println("Esto pediste:");

        switch (opcionPrincipal) {
            case 1:
                System.out.println("Producto:Cono");
                break;
            case 2:
                System.out.println("Producto:Copa de Helado");
                break;
            case 3:
                System.out.println("Producto:Ensalada de frutas");
                break;
            case 4:
                System.out.println("Producto:Malteada");
                break;
            case 5:
                System.out.println("Producto:Litro de Helado");
                break;
        }
        switch (opcionDos) {
            case 1:
                System.out.println("Sabor:Maracuyá");
                break;
            case 2:
                System.out.println("Sabor:Vainilla Chips");
                break;
            case 3:
                System.out.println("Sabor:Chocolate");
                break;
            case 4:
                System.out.println("Sabor:Fresa");
                break;
        }
        switch (opcionTres) {
            case 1:
                System.out.println("Acompañante:Galleta");
                break;
            case 2:
                System.out.println("Acompañante:Gomita");
                break;
            case 3:
                System.out.println("Acompañante: Chips");
        }
        switch (opcionCuatro) {
            case 1:
                System.out.println("Pago:Efectivo");

            case 2:
                System.out.println("Pago:Pagos virtuales");
        }
        System.out.println("Gracias por su compra 😘");
    }
}
