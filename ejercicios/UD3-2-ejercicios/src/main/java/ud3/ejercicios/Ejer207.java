package ud3.ejercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * UD3Ejer207 - BDAPPS (función nomprograma).
 *
 * <p>Pide el código de un programa y muestra su nombre usando la función
 * {@code nomprograma} creada en la base de datos.</p>
 */
public class Ejer207 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Código del programa: ");
        int codigo = Integer.parseInt(sc.nextLine().trim());

        try {
            try (Connection con = Conexion.abrir("bdapps");
                 PreparedStatement ps = con.prepareStatement(
                         "SELECT nomprograma(?) AS nombre")) {
                ps.setInt(1, codigo);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String nombre = rs.getString("nombre");
                        if (nombre == null) {
                            System.out.println("No existe un programa con el código " + codigo);
                        } else {
                            System.out.println("El programa " + codigo + " se llama " + nombre);
                        }
                    }
                }
            } catch (SQLException se) {
                System.out.println(se.getErrorCode() + " " + se.getMessage());
            }
        } catch (ClassNotFoundException ce) {
            Conexion.errorMessage();
        }
    }
}
