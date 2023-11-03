package InputValidator;

import java.util.Scanner;
import Objetos.Usuario;
import java.util.ArrayList;
/**
 * La clase InputValidator proporciona métodos para validar y obtener datos de entrada del usuario.
 * Estos métodos incluyen la validación de nombre, apellido, cédula, número telefónico y domicilio.
 */
public class InputValidator {

    /**
     *
     * Valida y obtiene el nombre del usuario.
     *
     * @param scanner El objeto Scanner utilizado para la entrada de datos.
     * @return El nombre validado del usuario.
     */
    public static String validarNombre(Scanner scanner) {
            String nombre;
            do {
                System.out.println("\nDigite su nombre (sin números):");
                nombre = scanner.next();
                if (nombre.matches(".*\\d.*")) {
                    System.out.println("El nombre no debe contener números. Intente de nuevo.");
                }
            } while (nombre.matches(".*\\d.*"));
            System.out.println("\nNombre registrado con éxito");
            return nombre;
        }

    /**
     * Valida y obtiene el apellido del usuario.
     *
     * @param scanner El objeto Scanner utilizado para la entrada de datos.
     * @return El apellido validado del usuario.
     */
    public static String validarApellido(Scanner scanner) {
        String apellido;
        do {
            System.out.println("\nDigite su apellido (sin números):");
            apellido = scanner.next();
            if (apellido.matches(".*\\d.*")) {
                System.out.println("El apellido no debe contener números. Intente de nuevo.");
            }
        } while (apellido.matches(".*\\d.*"));
        System.out.println("\nApellido registrado con éxito");
        return apellido;
    }


    /**
     * Valida y obtiene la cédula del usuario.
     *
     * @param scanner El objeto Scanner utilizado para la entrada de datos.
     * @return La cédula validada del usuario.
     */
        public static int validarCedula(Scanner scanner) {
            int cedula;
            do {
                System.out.println("\nDigite su cédula (número entero de 9 dígitos):");
                if (scanner.hasNextInt()) {
                    cedula = scanner.nextInt();
                    if (String.valueOf(cedula).length() == 9) {
                        break;
                    }
                }
                scanner.nextLine();
                System.out.println("Cédula inválida. Debe ser un número entero de 9 dígitos.");
            } while (true);
            System.out.println("\nCédula válida");
            return cedula;
        }

    /**
     * Valida y obtiene el número telefónico del usuario.
     *
     * @param scanner El objeto Scanner utilizado para la entrada de datos.
     * @return El número telefónico validado del usuario.
     */
        public static int validarNumeroTelefono(Scanner scanner) {
            int numerotelefonico;
            do {
                System.out.println("\nDigite su número telefónico (número entero de 8 dígitos):");
                if (scanner.hasNextInt()) {
                    numerotelefonico = scanner.nextInt();
                    if (String.valueOf(numerotelefonico).length() == 8) {
                        break;
                    }
                }
                scanner.nextLine();
                System.out.println("Número telefónico inválido. Debe ser un número entero de 8 dígitos.");
            } while (true);
            System.out.println("\n+506 " + numerotelefonico);
            return numerotelefonico;
        }

    /**
     * Valida y obtiene el domicilio del usuario.
     *
     * @param scanner El objeto Scanner utilizado para la entrada de datos.
     * @return El domicilio validado del usuario.
     */
        public static String validarDomicilio(Scanner scanner) {
            String domicilio;
            do {
                System.out.println("\nDigite su domicilio (sin números):");
                domicilio = scanner.next();
                if (domicilio.matches(".*\\d.*")) {
                    System.out.println("El domicilio no debe contener números. Intente de nuevo.");
                }
            } while (domicilio.matches(".*\\d.*"));
            System.out.println("\nDomicilio registrado con éxito");
            return domicilio;
        }

}

