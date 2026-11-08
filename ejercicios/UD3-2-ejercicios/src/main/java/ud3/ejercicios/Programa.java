package ud3.ejercicios;

/**
 * Representa una fila de la tabla {@code programas} de la base de datos
 * {@code bdapps}.
 */
public class Programa {

    private final int codigo;
    private final String nombre;
    private final String carpeta;

    public Programa(int codigo, String nombre, String carpeta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carpeta = carpeta;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarpeta() {
        return carpeta;
    }

    /**
     * Devuelve el programa en formato JSON, tal y como pide el ejercicio 205.
     */
    public String toJson() {
        return String.format(
                "{\"codigo\":%d, \"nombre\":\"%s\", \"carpeta\":\"%s\" }",
                codigo, nombre, carpeta);
    }
}
