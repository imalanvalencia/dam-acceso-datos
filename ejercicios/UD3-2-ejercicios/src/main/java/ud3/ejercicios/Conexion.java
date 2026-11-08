package ud3.ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Punto único de conexión con MARIADB/MySQL.
 *
 * <p>Ajusta USUARIO y PASSWORD a los de tu instalación. El resto de programas
 * llaman a {@link #abrir(String)} y no se preocupan por los detalles.</p>
 */
public final class Conexion {

    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 3306;
    private static final String USUARIO = "acceso_datos";
    private static final String PASSWORD = "";

    static {
        // El driver mysql escribe sus propios avisos internos en la consola.
        // Los desactivamos para que la salida del programa sea la esperada.
        System.setProperty("mysql.logging.disable", "true");
    }

    private Conexion() {
        // Clase de utilidades: no se instancia.
    }

    /**
     * Carga el driver JDBC y abre una conexión con la base de datos indicada.
     *
     * @param baseDatos nombre de la base de datos (por ejemplo, "bdapps")
     * @throws ClassNotFoundException si el driver no está en el classpath
     * @throws SQLException           si el servidor rechaza la conexión
     */
    public static Connection abrir(String baseDatos) throws ClassNotFoundException, SQLException {
        // Si el driver no está en el classpath, aquí salta ClassNotFoundException.
        Class.forName("org.mysql.jdbc.Driver");

        String url = "jdbc:mysql://" + SERVIDOR + ":" + PUERTO + "/" + baseDatos;
        return DriverManager.getConnection(url, USUARIO, PASSWORD);
    }

    public static void errorMessage() {
        System.out.println("MySQL no accesible");
        System.out.println("Por favor revisar los parametros en Conexion.java");
        System.out.println("pueden tener una configuracion diferente");
    }
}
