import Objetos.Libros;
import Objetos.Usuario;
import DataHandler.DataHandler;
import java.util.ArrayList;
import java.util.Scanner;
import InputValidator.InputValidator;
import DataHandler.OrdenamientoAlfabetico;
import DataHandler.DataHandlerCleaner;
import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {

        // Se crea la biblioteca
        ArrayList<Libros> biblioteca = DataHandler.cargarLibros("libros.dat");
        ArrayList<Usuario> listausuarios = DataHandler.cargarUsuarios("usuarios.dat");

        // Validaciones y agregación de ejemplos predefinidos
        if (listausuarios.isEmpty()) {
            System.out.println("No se encontraron usuarios almacenados o el archivo de usuarios está vacío.");
            // Agregar ejemplos de usuarios
            Usuario usuario1 = new Usuario("Alfredo", "Cruz",209540853, 6015432, "Alajuela");
            listausuarios.add(usuario1);
            Usuario usuario3 = new Usuario("Carlos","Pérez", 407890123, 8234567, "Cartago");
            listausuarios.add(usuario3);
            Usuario usuario2 = new Usuario("María","Garcia", 308765432, 7123456, "San José");
            listausuarios.add(usuario2);
            Usuario usuario4 = new Usuario("Brenda", "Aguilar", 10760532, 8875345, "Guanacaste");
            listausuarios.add(usuario4);
        } else {
            System.out.println("Usuarios cargados con éxito.");
        }

        if (biblioteca.isEmpty()) {
            System.out.println("No se encontraron libros en la biblioteca o el archivo de libros está vacío.");
            // Agregar ejemplos de libros
            Libros libro1 = new Libros("El código Da Vinci", "Dan Brown", "Misterio", 2003, 123456789, false);
            Libros libro2 = new Libros("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía", 1997, 987654321, false);
            Libros libro3 = new Libros("1984", "George Orwell", "Ciencia ficción", 1949, 345678912, false);
            Libros libro4 = new Libros("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", 1967, 567891234, false);
            Libros libro5 = new Libros("Los juegos del hambre", "Suzanne Collins", "Ciencia ficción", 2008, 789123456, false);
            Libros libro6 = new Libros("Cronica de una muerte anunciada", "Gabriel García Márquez", "Realismo mágico", 1981, 987654321, false);
            Libros libro7 = new Libros("El amor en los tiempos del cólera", "Gabriel García Márquez", "Realismo mágico", 1985, 876543210, false);

            biblioteca.add(libro1);
            biblioteca.add(libro2);
            biblioteca.add(libro3);
            biblioteca.add(libro4);
            biblioteca.add(libro5);
            biblioteca.add(libro6);
            biblioteca.add(libro7);
        } else {
            System.out.println("Libros cargados con éxito.");
        }

        Scanner scanner = new Scanner(System.in);

        String nom = " ";
        String apellido = "";
        int cedula = 0;
        int numerotelefonico = 0;
        String domicilio = "";
        int buscarcedula = 0;
        int opcion;
        long clavemaster = 1310041310;

        do {

            System.out.println("\nMenú:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Ver biblioteca");
            System.out.println("3. Tomar libro prestado");
            System.out.println("4. Devolver libro");
            System.out.println("5. Listar usuarios registrados");
            System.out.println("6. Guardar y salir ");
            System.out.println("7. Borrar datos de biblioteca (Solo usuario master)");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();


            switch (opcion) {

                case 1:
                    // Solicitud de nombre
                    nom = InputValidator.validarNombre(scanner);

                    apellido = InputValidator.validarApellido(scanner);

                    // Solicitud de cedula
                    cedula = InputValidator.validarCedula(scanner);
                    if (cedulaRepetida(cedula, listausuarios)) {
                        System.out.println("\nEspere, esta cédula ya está registrada.");
                        System.out.println("Volviendo al menu principal");
                        break;
                    } else {

                        // Solicitud de telefono
                        numerotelefonico = InputValidator.validarNumeroTelefono(scanner);
                        if (telefonoRepetido(cedula, listausuarios)) {
                            System.out.println("\nEspere, esta telefono esta ya está registrado.");
                            System.out.println("Volviendo al menu principal");
                            break;
                        } else {

                            // Solicitud de domicilio
                            domicilio = InputValidator.validarDomicilio(scanner);

                            // Agregar usuario registrado
                            Usuario usuario = new Usuario(nom, apellido, cedula, numerotelefonico, domicilio);
                            listausuarios.add(usuario);

                            System.out.println("\nUsuario agregado con exito");

                            break;
                        }
                    }
                case 2:
                    System.out.println("\nLibros en la biblioteca:");
                    for (Libros libro : biblioteca) {
                        System.out.println("\n" + libro);
                    }

                    break;
                case 3:

                    System.out.println("Digite su numero de cedula: ");
                    buscarcedula = scanner.nextInt();
                    boolean encontrado = false;
                    int cedulaPrestamo = 0; // Declara la cédula de prestamo fuera del bucle

                    for (Usuario usuario0 : listausuarios) {
                        if (usuario0.getCedula() == buscarcedula) {
                            System.out.println("Bienvenido " + usuario0.getNom());
                            cedulaPrestamo = usuario0.getCedula(); // Almacena la cédula del usuario autenticado
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Cédula no encontrada. Volviendo al menú principal.");
                    } else {
                        System.out.print("Ingrese el ISBN del libro a tomar prestado: ");
                        int isbnPrestamo = scanner.nextInt();
                        boolean encontradoLibro = false;

                        for (Libros libro : biblioteca) {
                            if (libro.getIsbn() == isbnPrestamo && !libro.isPrestado()) {
                                libro.tomarPrestado(cedulaPrestamo); // Marca el libro como prestado y almacena la cédula del usuario
                                DataHandler.guardarLibros(biblioteca, "libros.dat");
                                System.out.println("\nLibro tomado prestado con éxito.");
                                encontradoLibro = true;
                                break;
                            }
                        }

                        if (!encontradoLibro) {
                            System.out.println("\nNo se encontró un libro con ese ISBN o ya está prestado.");
                        }
                    }
                     break;
                case 4:

                    int cedulaDevolucion = 0; // Variable para almacenar la cédula del usuario que devuelve el libro
                    System.out.println("Digite su numero de cedula: ");
                    buscarcedula = scanner.nextInt();
                    encontrado = false;

                    for (Usuario usuario0 : listausuarios) {
                        if (usuario0.getCedula() == buscarcedula) {
                            System.out.println("\nBienvenido " + usuario0.getNom());
                            cedulaDevolucion = usuario0.getCedula(); // Almacena la cédula del usuario autenticado
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Cédula no encontrada. Volviendo al menú principal.");
                        break;
                    }

                    System.out.print("Ingrese el ISBN del libro a devolver: ");
                    int isbnDevolver = scanner.nextInt();
                    encontrado = false;

                    for (Libros libro : biblioteca) {
                        if (libro.getIsbn() == isbnDevolver && libro.isPrestado() && libro.getCedulaUsuarioPrestado() == cedulaDevolucion) {
                            libro.devolver();
                            DataHandler.guardarLibros(biblioteca, "libros.dat");
                            System.out.println("\nLibro devuelto con éxito.");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("\nNo se encontró un libro con ese ISBN o no le pertenece.");
                    }
                     break;

                case 5:

                    if (listausuarios.isEmpty()) {
                        System.out.println("No se encuentran usuarios registrados");
                    } else {
                        System.out.println("\nUsuarios registrados (ordenados por nombre):");
                        // Ordenar la lista de usuarios por nombre antes de mostrarla
                        OrdenamientoAlfabetico.bubbleSort(listausuarios);
                        for (Usuario usuario0 : listausuarios) {
                            System.out.println(usuario0);
                        }
                    }
                    break;

                case 6:

                    System.out.println("\nSaliendo del programa.");
                    DataHandler.guardarUsuarios(listausuarios, "usuarios.dat");
                    DataHandler.guardarLibros(biblioteca, "libros.dat");
                    System.out.println("\nDatos guardados con éxito en 'usuarios.dat' y 'libros.dat'.");


                    System.exit(0);
                    break;

                case 7:

    
                    System.out.println("Digite la clave maestra para borrar los datos ");
                    int clave = scanner.nextInt();

                    if (clavemaster == clave) {
                        // Borrar datos
                        DataHandler.guardarUsuarios(listausuarios, "usuarios.dat");
                        DataHandler.guardarLibros(biblioteca, "libros.dat");
                        DataHandlerCleaner.limpiarUsuarios("usuarios.dat");
                        DataHandlerCleaner.limpiarLibros("libros.dat");
                        System.out.println("\nDatos eliminados con éxito.");

                        // Finaliza el programa solo si la clave es correcta
                        System.exit(0);
                    } else {
                        System.out.println("\nLa clave es incorrecta, volviendo al menú.");
                    }
                    break;
            }
        } while (opcion != 8);
    }

    // Método para verificar si una cédula ya existe en la lista de usuarios
    private static boolean cedulaRepetida(int cedula, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula() == cedula) {
                return true; // La cédula ya existe en la lista de usuarios
            }
        }
        return false; // La cédula no está repetida
    }
    private static boolean telefonoRepetido(int numerotelefonico, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNumerotelefonico() == numerotelefonico) {
                return true; // La cédula ya existe en la lista de usuarios
            }
        }
        return false; // La cédula no está repetida
    }
}
