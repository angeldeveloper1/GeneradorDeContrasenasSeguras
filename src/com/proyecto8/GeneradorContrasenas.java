package com.proyecto8; // Define el paquete donde se encuentra la clase GeneradorContrasenas

import java.security.SecureRandom; // Importa la clase SecureRandom para generar números aleatorios seguros
import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class GeneradorContrasenas { // Define la clase GeneradorContrasenas

    // Define constantes que representan los conjuntos de caracteres permitidos para generar contraseñas
    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETRAS_MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS = "!@#$%^&*()_+-=[]{}|;':<>,.?/";

    // Crea una instancia de SecureRandom para generar números aleatorios seguros
    private static final SecureRandom secureRandom = new SecureRandom();

    // Define constantes que representan los niveles de complejidad de las contraseñas
    private static final int FACIL = 1;
    private static final int MEDIO = 2;
    private static final int DIFICIL = 3;

    // Método para generar una contraseña con la longitud y complejidad especificadas
    public static String generarContrasena(int longitud, int complejidad){
        StringBuilder contrasena = new StringBuilder(); // Crea un objeto StringBuilder para construir la contraseña
        String caracteresPermitidos; // Declara una variable para almacenar los caracteres permitidos según el nivel de complejidad

        // Utiliza un switch para determinar los caracteres permitidos según el nivel de complejidad
        switch (complejidad){
            case FACIL:
                caracteresPermitidos = LETRAS_MINUSCULAS + LETRAS_MAYUSCULAS; // Solo letras minúsculas y mayúsculas
                break;
            case MEDIO:
                caracteresPermitidos = LETRAS_MINUSCULAS + LETRAS_MAYUSCULAS + NUMEROS; // Letras minúsculas, mayúsculas y números
                break;
            case DIFICIL:
                caracteresPermitidos = LETRAS_MINUSCULAS + LETRAS_MAYUSCULAS + NUMEROS + SIMBOLOS; // Letras minúsculas, mayúsculas, números y símbolos
                break;
            default:
                throw new IllegalArgumentException ("Nivel de complejidad invalido"); // Lanza una excepción si el nivel de complejidad es inválido
        }

        // Genera la contraseña eligiendo caracteres aleatorios de los permitidos y los agrega al StringBuilder
        for (int i = 0; i < longitud; i++) {
            int randomNumero = secureRandom.nextInt(caracteresPermitidos.length());
            contrasena.append(caracteresPermitidos.charAt(randomNumero));
        }
        return contrasena.toString(); // Retorna la contraseña generada como una cadena de texto
    }

    // Método principal que interactúa con el usuario para obtener la longitud y complejidad de la contraseña
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

        // Solicita al usuario que ingrese la longitud de la contraseña
        System.out.println("Ingrese la longitud de la contrasena: ");
        int longitud = scanner.nextInt(); // Lee la longitud de la contraseña proporcionada por el usuario

        // Solicita al usuario que ingrese la complejidad de la contraseña
        System.out.println("Ingrese la complejidad de la contrasena");
        System.out.println("1. FACIL");
        System.out.println("2. MEDIO");
        System.out.println("3. DIFICIL");
        int complejidad = scanner.nextInt(); // Lee la complejidad de la contraseña proporcionada por el usuario

        // Genera la contraseña utilizando el método generarContrasena y la imprime en la consola
        System.out.println("La contrasena generado es: " +GeneradorContrasenas.generarContrasena(longitud,complejidad));
    }
}