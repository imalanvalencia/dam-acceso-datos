package unidad0.ejercicios;

import java.util.Scanner;

import unidad0.ejercicios.ejercicio1.Saludo;
import unidad0.ejercicios.ejercicio2.Factorial;
import unidad0.ejercicios.ejercicio3.MesesSwitch;
import unidad0.ejercicios.ejercicio4.MesesArray;
import unidad0.ejercicios.ejercicio5.PrimoPalindromo;
import unidad0.ejercicios.ejercicio6.ListaNumeros;
import unidad0.ejercicios.ejercicio7.ListaTextos;
import unidad0.ejercicios.ejercicio8.Ejercicio8;
import unidad0.ejercicios.util.Utilidades;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        do {
            // Línea en blanco antes de redibujar para que la salida no se pegue.
            System.out.println();
            mostrarMenu();

            // Si la entrada se acaba (Ctrl+D o fin de la tubería) salimos limpios.
            if (!scanner.hasNextLine()) {
                System.out.println("Entrada finalizada. Hasta luego.");
                break;
            }

            opcion = Utilidades.leerTexto(scanner, "Elige una opción: ");

            try {
                ejecutarOpcion(opcion, scanner);
            } catch (java.util.NoSuchElementException e) {
                // Ctrl+D / fin de la tubería en mitad de un ejercicio: salimos limpios.
                System.out.println();
                System.out.println("Entrada finalizada. Hasta luego.");
                break;
            }
        } while (!"0".equals(opcion));

        scanner.close();
    }

    private static void ejecutarOpcion(String opcion, Scanner scanner) {
        switch (opcion) {
            case "1":
                Saludo.ejecutar(scanner);
                break;
            case "2":
                Factorial.ejecutar(scanner);
                break;
            case "3":
                MesesSwitch.ejecutar(scanner);
                break;
            case "4":
                MesesArray.ejecutar(scanner);
                break;
            case "5":
                PrimoPalindromo.ejecutar(scanner);
                break;
            case "6":
                ListaNumeros.ejecutar(scanner);
                break;
            case "7":
                ListaTextos.ejecutar(scanner);
                break;
            case "8":
                Ejercicio8.ejecutar(scanner);
                break;
            case "0":
                System.out.println("Hasta luego, gracias por pasar.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private static void mostrarMenu() {
        System.out.println("=====================================");
        System.out.println("  UD0 - Iniciación a Java: ejercicios");
        System.out.println("=====================================");
        System.out.println(" 1. Saludo con nombre");
        System.out.println(" 2. Factorial de un número");
        System.out.println(" 3. Meses con switch");
        System.out.println(" 4. Meses con array");
        System.out.println(" 5. ¿Número primo y palíndromo?");
        System.out.println(" 6. Lista de números (ArrayList)");
        System.out.println(" 7. Lista de textos (variante con \"fin\")");
        System.out.println(" 8. ListaDeDatos (clase propia)");
        System.out.println(" 0. Salir");
        System.out.println("=====================================");
    }
}
