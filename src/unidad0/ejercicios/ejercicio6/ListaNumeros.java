package unidad0.ejercicios.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import unidad0.ejercicios.util.Utilidades;

public class ListaNumeros {

    public static void ejecutar(Scanner scanner) {
        ArrayList<Integer> lista = new ArrayList<Integer>();

        System.out.println("--- Fase 1 ---");
        System.out.println("Introduce números positivos; un número negativo termina la fase.");
        int numero;

        do {
            numero = Utilidades.leerEntero(scanner, "Número: ");
            if (numero >= 0) {
                lista.add(numero);
            }
        } while (numero >= 0);

        System.out.println("--- Fase 2 ---");
        System.out.println("Introduce números positivos para comprobar si están en la lista; un negativo termina la fase.");

        do {
            numero = Utilidades.leerEntero(scanner, "Número a buscar: ");
            if (numero >= 0) {
                if (lista.contains(numero)) {
                    System.out.println(numero + " está en la lista.");
                } else {
                    System.out.println(numero + " no está en la lista.");
                }
            }
        } while (numero >= 0);

        System.out.println("--- Fase 3 ---");
        Collections.sort(lista);
        System.out.println("Lista ordenada: " + lista);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }
}
