package ud3.ejercicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * UD3Ejer204 - BDAPPS (UPDATE + INSERT).
 *
 * <p>Ejecuta varios UPDATE sobre {@code programas} y varios INSERT sobre
 * {@code ejecuciones}. Comprueba el número de filas afectadas por cada
 * sentencia.</p>
 */
public class Ejer204 {

    public static void main(String[] args) {
        String[] actualizaciones = {
                "UPDATE programas SET ocupacion = 250000 WHERE codigo = 1",
                "UPDATE programas SET ocupacion = 180000 WHERE codigo = 2"
        };

        String[] inserciones = {
                "INSERT INTO ejecuciones (codprograma, fecha, usuario) "
                        + "VALUES (1, '2021-10-15', 'ana')",
                "INSERT INTO ejecuciones (codprograma, fecha, usuario) "
                        + "VALUES (1, '2021-10-16', 'ana')",
                "INSERT INTO ejecuciones (codprograma, fecha, usuario) "
                        + "VALUES (2, '2021-10-15', 'luis')"
        };

        try {
            try (Connection con = Conexion.abrir("bdapps");
                 Statement st = con.createStatement()) {

                boolean todoCorrecto = true;

                for (String sql : actualizaciones) {
                    int filas = st.executeUpdate(sql);
                    todoCorrecto &= comprobar("UPDATE", filas, 1);
                }

                for (String sql : inserciones) {
                    int filas = st.executeUpdate(sql);
                    todoCorrecto &= comprobar("INSERT", filas, 1);
                }

                System.out.println(todoCorrecto
                        ? "Todas las operaciones se ejecutaron correctamente."
                        : "Alguna operación no afectó al número de filas esperado.");
            } catch (SQLException se) {
                System.out.println(se.getErrorCode() + " " + se.getMessage());
            }
        } catch (ClassNotFoundException ce) {
            Conexion.errorMessage();
        }
    }

    private static boolean comprobar(String tipo, int filas, int esperadas) {
        boolean correcto = filas == esperadas;
        System.out.printf("%s -> %d fila(s) %s%n",
                tipo, filas, correcto ? "OK" : "AVISO: se esperaban " + esperadas);
        return correcto;
    }
}
