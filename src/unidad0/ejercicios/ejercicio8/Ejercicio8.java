package unidad0.ejercicios.ejercicio8;

import java.util.Scanner;
import unidad0.ejercicios.util.Utilidades;

public class Ejercicio8 {

    public static void ejecutar(Scanner scanner) {
        ListaDeDatos lista = new ListaDeDatos();

        System.out.println("--- Fase 1 ---");
        System.out.println("Introduce textos; \"fin\" (en cualquier mayúscula/minúscula) termina la fase.");
        while (true) {
            String texto = Utilidades.leerTexto(scanner, "Texto (\"fin\" para terminar): ");
            if (texto.equalsIgnoreCase("fin")) {
                // "fin" cierra la fase y no se guarda.
                break;
            }
            lista.incluir(texto);
        }

        System.out.println("--- Fase 2 ---");
        System.out.println("Introduce textos para comprobar si están en la lista; \"fin\" termina la fase.");
        while (true) {
            String texto = Utilidades.leerTexto(scanner, "Texto a buscar (\"fin\" para terminar): ");
            if (texto.equalsIgnoreCase("fin")) {
                break;
            }
            if (lista.contiene(texto)) {
                System.out.println("\"" + texto + "\" está en la lista.");
            } else {
                System.out.println("\"" + texto + "\" no está en la lista.");
            }
        }

        System.out.println("--- Fase 3 ---");
        lista.mostrarDatosOrdenados();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }
}
