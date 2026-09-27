package unidad0.ejercicios.ejercicio1;

import java.util.Scanner;

public class Saludo {
    public static void ejecutar(Scanner scanner) {
        System.out.print("Dime tu nombre: ");
        String nombre = scanner.nextLine().trim();
        for (int i = 0; i < 5; i++) {
            System.out.println("Hola, " + nombre);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }
}
