package ud3.ejercicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * UD3Ejer202 - BDAPPS (CREATE TABLE).
 *
 * <p>Crea la tabla {@code ejecuciones} dentro de la base de datos
 * {@code bdapps}.</p>
 */
public class Ejer202 {

    public static void main(String[] args) {
        String sql = """
                CREATE TABLE ejecuciones (
                    id          INT AUTO_INCREMENT PRIMARY KEY,
                    codprograma INT NOT NULL,
                    fecha       DATE NOT NULL,
                    usuario     VARCHAR(50) NOT NULL,
                    CONSTRAINT fk_ejecuciones_programa
                        FOREIGN KEY (codprograma) REFERENCES programas(codigo)
                )
                """;

        try {
            try (Connection con = Conexion.abrir("bdapps");
                 Statement st = con.createStatement()) {

                st.executeUpdate(sql);
                System.out.println("Tabla ejecuciones creada correctamente.");
            } catch (SQLException se) {
                System.out.println(se.getErrorCode() + " " + se.getMessage());
            }
        } catch (ClassNotFoundException ce) {
            System.out.println("MySQL no accesible");
        }
    }
}
