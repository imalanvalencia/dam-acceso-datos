package unidad0.ejercicios.ejercicio3;

import java.util.Scanner;
import unidad0.ejercicios.util.Utilidades;

public class MesesSwitch {

    public static void ejecutar(Scanner scanner) {
        int numero = Utilidades.leerEntero(scanner, "Dime un número del 1 al 12: ");
        String mes = switch (numero) {
            case 1 -> "Enero";
            case 2 -> "Febrero";
            case 3 -> "Marzo";
            case 4 -> "Abril";
            case 5 -> "Mayo";
            case 6 -> "Junio";
            case 7 -> "Julio";
            case 8 -> "Agosto";
            case 9 -> "Septiembre";
            case 10 -> "Octubre";
            case 11 -> "Noviembre";
            case 12 -> "Diciembre";
            default -> "";
        };

        if (mes.isEmpty()) {
            System.out.println("Número fuera de rango (1-12).");
        } else {
            System.out.println("Mes " + numero + ": " + mes);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }
}
