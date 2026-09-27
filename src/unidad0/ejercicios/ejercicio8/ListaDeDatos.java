package unidad0.ejercicios.ejercicio8;

import java.util.ArrayList;
import java.util.Collections;


public class ListaDeDatos {

    private final ArrayList<String> datos = new ArrayList<String>();

    public void incluir(String texto) {
        datos.add(texto);
    }

    public boolean contiene(String texto) {
        for (String guardado : datos) {
            if (guardado.equalsIgnoreCase(texto)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarDatosOrdenados() {
        ArrayList<String> copia = new ArrayList<String>(datos);
        Collections.sort(copia);
        System.out.println("Datos ordenados: " + copia);
    }
}
