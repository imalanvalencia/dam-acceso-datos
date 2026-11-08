package ud3.ejercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * UD3Ejer206 - BDAPPS (INSERT).
 *
 * <p>Pide los datos de un programa y lo inserta. Si el código ya existe,
 * vuelve a pedir otro código sin interrumpir la ejecución.</p>
 */
public class Ejer206 {

    /** Código de error de MariaDB/MySQL para "Duplicate entry". */
    private static final int CODIGO_DUPLICADO = 1062;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int codigo = leerEntero(sc, "Código: ");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Carpeta de instalación: ");
        String carpeta = sc.nextLine().trim();

        String sql = "INSERT INTO programas (codigo, nombre, carpeta_instalacion) "
                + "VALUES (?, ?, ?)";

        try {
            try (Connection con = Conexion.abrir("bdapps")) {
                boolean insertado = false;

                while (!insertado) {
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setInt(1, codigo);
                        ps.setString(2, nombre);
                        ps.setString(3, carpeta);
                        ps.executeUpdate();

                        insertado = true;
                        System.out.println("Programa insertado correctamente.");
                    } catch (SQLException se) {
                        if (se.getErrorCode() == CODIGO_DUPLICADO) {
                            System.out.println("El código " + codigo + " ya existe.");
                            codigo = leerEntero(sc, "Introduce otro código: ");
                        } else {
                            throw se;
                        }
                    }
                }
            } catch (SQLException se) {
                System.out.println(se.getErrorCode() + " " + se.getMessage());
            }
        } catch (ClassNotFoundException ce) {
            System.out.println("MySQL no accesible");
        }
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido.");
            }
        }
    }
}
