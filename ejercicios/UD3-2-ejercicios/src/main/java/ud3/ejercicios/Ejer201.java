package ud3.ejercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**
 * UD3Ejer201 - BDTAREAS (SELECT).
 *
 * <p>Muestra la tabla {@code tareas} con formato de tabla usando printf.</p>
 */
public class Ejer201 {

    private static final String SEPARADOR =
            "+" + "-".repeat(8) + "+" + "-".repeat(42) + "+" + "-".repeat(16) + "+" + "-".repeat(11) + "+";

    public static void main(String[] args) {
        String sql = "SELECT codigo, descripcion, fecha_prevista, terminada "
                + "FROM tareas ORDER BY codigo";
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            try (Connection con = Conexion.abrir("bdtareas");
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println(SEPARADOR);
                System.out.printf("| %-6s | %-40s | %-14s | %-9s |%n",
                        "Código", "Descripción", "Fecha prevista", "Terminada");
                System.out.println(SEPARADOR);

                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    String descripcion = rs.getString("descripcion");
                    String fecha = rs.getDate("fecha_prevista").toLocalDate().format(formatoFecha);
                    String terminada = rs.getBoolean("terminada") ? "SI" : "NO";

                    System.out.printf("| %-6d | %-40s | %-14s | %-9s |%n",
                            codigo, descripcion, fecha, terminada);
                }

                System.out.println(SEPARADOR);
            } catch (SQLException se) {
                System.out.println(se.getErrorCode() + " " + se.getMessage());
            }
        } catch (ClassNotFoundException ce) {
            Conexion.errorMessage();
        }
    }
}
