package ud3.ejercicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * UD3Ejer208 - BDAPPS (función numejecuciones).
 *
 * <p>Pide una fecha y muestra cuántas ejecuciones hay ese día usando la
 * función {@code numejecuciones} creada en la base de datos.</p>
 */
public class Ejer208 {

    private static final DateTimeFormatter FORMATO_SALIDA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fecha (yyyy-MM-dd): ");

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(sc.nextLine().trim());
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto. Usa yyyy-MM-dd.");
            return;
        }

        try {
            try (Connection con = Conexion.abrir("bdapps");
                 PreparedStatement ps = con.prepareStatement(
                         "SELECT numejecuciones(?) AS total")) {
                ps.setDate(1, Date.valueOf(fecha));

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int total = rs.getInt("total");
                        System.out.println("Ejecuciones del "
                                + fecha.format(FORMATO_SALIDA) + ": " + total);
                    }
                }
            } catch (SQLException se) {
                System.out.println(se.getErrorCode() + " " + se.getMessage());
            }
        } catch (ClassNotFoundException ce) {
            System.out.println("MySQL no accesible");
        }
    }
}
