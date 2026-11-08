package ud3.ejercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UD3Ejer205 - BDAPPS (SELECT y mapeo).
 *
 * <p>Lee todos los programas, los guarda en un {@code ArrayList<Programa>} y
 * muestra en JSON los que están instalados en la unidad C:.</p>
 */
public class Ejer205 {

    public static void main(String[] args) {
        String sql = "SELECT codigo, nombre, carpeta_instalacion "
                + "FROM programas ORDER BY codigo";
        List<Programa> programas = new ArrayList<>();

        try {
            try (Connection con = Conexion.abrir("bdapps");
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    programas.add(new Programa(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("carpeta_instalacion")));
                }
            } catch (SQLException se) {
                System.out.println(se.getErrorCode() + " " + se.getMessage());
            }

            for (Programa programa : programas) {
                if (programa.getCarpeta().startsWith("C:")) {
                    System.out.println(programa.toJson());
                }
            }
        } catch (ClassNotFoundException ce) {
            System.out.println("MySQL no accesible");
        }
    }
}
