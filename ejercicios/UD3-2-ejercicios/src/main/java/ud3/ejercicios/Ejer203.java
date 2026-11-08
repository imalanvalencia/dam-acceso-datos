package ud3.ejercicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * UD3Ejer203 - BDAPPS (ALTER TABLE).
 *
 * <p>Añade la columna {@code ocupacion} (KB) a la tabla {@code programas}.</p>
 */
public class Ejer203 {

    public static void main(String[] args) {
        String sql = "ALTER TABLE programas "
                + "ADD COLUMN ocupacion INT NOT NULL DEFAULT 0";

        try {
            try (Connection con = Conexion.abrir("bdapps");
                 Statement st = con.createStatement()) {

                st.executeUpdate(sql);
                System.out.println("Columna ocupacion añadida correctamente.");
            } catch (SQLException se) {
                System.out.println(se.getErrorCode() + " " + se.getMessage());
            }
        } catch (ClassNotFoundException ce) {
            System.out.println("MySQL no accesible");
        }
    }
}
