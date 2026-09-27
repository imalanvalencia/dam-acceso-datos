package unidad0.ejercicios.ejercicio2;

import java.util.Scanner;
import unidad0.ejercicios.util.Utilidades;

public class Factorial {

    public static void ejecutar(Scanner scanner) {
        int numero = Utilidades.leerEntero(scanner, "Dime un número entero: ");

        if (numero < 0) {
            System.out.println("El factorial no está definido para números negativos.");
            return;
        }

        // 21! ya no cabe en un long, así no imprimir un número equivocado. (me lo dijo la IA)
        if (numero > 20) {
            System.out.println("Aviso: " + numero + " supera el rango de long (máximo 20), no se calcula el factorial.");
            return;
        }

        long resultado = 1;
        StringBuilder expansion = new StringBuilder();
        for (int i = 1; i <= numero; i++) {
            resultado = resultado * i;
            if (i > 1) {
                expansion.append(" * ");
            }
            expansion.append(i);
        }

        if (numero <= 1) {
            System.out.println("Factorial de " + numero + " = 1");
        } else {
            System.out.println("Factorial de " + numero + " = " + expansion + " = " + resultado);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }
}
