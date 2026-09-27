package unidad0.ejercicios.util;

import java.util.Scanner;

public class Utilidades {
    /** Pide un número entero repitiendo la pregunta mientras la entrada no sea válida. */
    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número entero válido, probamos otra vez.");
            }
        }
    }

    /** Pide una línea de texto y la devuelve sin espacios al principio ni al final. */
    public static String leerTexto(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
}
