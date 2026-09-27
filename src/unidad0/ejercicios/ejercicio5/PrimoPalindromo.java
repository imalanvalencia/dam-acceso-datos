package unidad0.ejercicios.ejercicio5;

import java.util.Scanner;
import unidad0.ejercicios.util.Utilidades;

public class PrimoPalindromo {

    public static void ejecutar(Scanner scanner) {
        int numero = Utilidades.leerEntero(scanner, "Dime un número entero: ");

        boolean primo = esPrimo(numero);
        boolean palindromo = esPalindromo(numero);

        System.out.println(numero + " es primo: " + (primo ? "sí" : "no"));
        System.out.println(numero + " es palíndromo: " + (palindromo ? "sí" : "no"));

        if (primo && palindromo) {
            System.out.println(numero + " es un palíndromo primo: sí");
        } else {
            System.out.println(numero + " es un palíndromo primo: no");
        }
    }

    // FUNCIÓN - esPrimo
    public static boolean esPrimo(int numero) {
        // Fuera de [2, ...] no hay primos; sin esto el bucle de abajo no termina
        // nunca para 1 ni para los negativos (contador crece y nunca alcanza a numero).
        if (numero < 2) {
            return false;
        }
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if ( (numero % contador) == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

    // FUNCIÓN - esPalindromo
    public static boolean esPalindromo(int numero) {
        String sPalabra=String.valueOf(numero);
        int inc = 0;
        int des = sPalabra.length()-1;
        boolean palindromo = true;
        while ((inc<des) && (palindromo)){
            if (sPalabra.charAt(inc)==sPalabra.charAt(des)){
                inc++;
                des--;
            } else {
                palindromo = false;
            }
        }
        return palindromo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }
}
