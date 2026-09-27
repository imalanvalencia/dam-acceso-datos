package unidad0.ejercicios.ejercicio4;

import java.util.Scanner;
import unidad0.ejercicios.util.Utilidades;

public class MesesArray {

    public static void ejecutar(Scanner scanner) {
        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        int numero = Utilidades.leerEntero(scanner, "Dime un número del 1 al 12: ");

        if (numero < 1 || numero > 12) {
            System.out.println("Número fuera de rango (1-12).");
            return;
        }

        // El array empieza en 0: el mes 1 (Enero) está en la posición 0.
        System.out.println("Mes " + numero + ": " + meses[numero - 1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }
}
