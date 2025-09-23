package OrientaObjetos;

public class MostrarUsuarios {
    public static void mostrar(Usuario[] usuarios, int numUsuarios) {
        if (numUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("+-----+------------------------------+--------+----------------------+-------+--------------+");

        System.out.printf("| %-3s | %-28s | %-6s | %-20s | %-5s | %-12s |%n",
                "N°", "Nombre", "Sexo", "Cargo", "Edad", "Salario");
        System.out.println("+-----+------------------------------+--------+----------------------+-------+--------------+");

        // Filas de usuar
        for (int i = 0; i < numUsuarios; i++) {
            Usuario u = usuarios[i];
            System.out.printf("| %-3d | %-28s | %-6s | %-20s | %-5d | %-12.2f |%n",
                    i + 1,
                    u.getNombre(),
                    String.valueOf(u.getSexo()),
                    u.getCargo(),
                    u.getEdad(),
                    u.getSalario());
        }

        // Línea inferior
        System.out.println("+-----+------------------------------+--------+----------------------+-------+--------------+");
    }
}
