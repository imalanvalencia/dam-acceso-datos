package unidad0.ejercicios.ejercicio7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import unidad0.ejercicios.util.Utilidades;

public class ListaTextos {

    public static void ejecutar(Scanner scanner) {
        ArrayList<String> lista = new ArrayList<String>();

        System.out.println("--- Fase 1 ---");
        System.out.println("Introduce textos; \"fin\" (en cualquier mayúscula/minúscula) termina la fase.");
        while (true) {
            String texto = Utilidades.leerTexto(scanner, "Texto (\"fin\" para terminar): ");
            if (texto.equalsIgnoreCase("fin")) {
                // "fin" cierra la fase y no se guarda.
                break;
            }
            lista.add(texto);
        }

        System.out.println("--- Fase 2 ---");
        System.out.println("Introduce textos para comprobar si están en la lista; \"fin\" termina la fase.");
        while (true) {
            String texto = Utilidades.leerTexto(scanner, "Texto a buscar (\"fin\" para terminar): ");
            if (texto.equalsIgnoreCase("fin")) {
                break;
            }
            if (contiene(lista, texto)) {
                System.out.println("\"" + texto + "\" está en la lista.");
            } else {
                System.out.println("\"" + texto + "\" no está en la lista.");
            }
        }

        System.out.println("--- Fase 3 ---");
        Collections.sort(lista);
        System.out.println("Lista ordenada: " + lista);
    }

    /** Busca sin distinguir mayúsculas de minúsculas (la comparación ya viene recortada). */
    private static boolean contiene(ArrayList<String> lista, String texto) {
        for (String guardado : lista) {
            if (guardado.equalsIgnoreCase(texto)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }
}
