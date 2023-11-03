package DataHandler;

import Objetos.Libros;
import Objetos.Usuario;
import java.io.*;
import java.util.ArrayList;

/**
 * La clase DataHandler proporciona métodos para guardar y cargar listas de objetos Usuario y Libros en archivos
 * serializados, permitiendo almacenar y recuperar información de usuarios y libros.
 */
public class DataHandler {

    /**
     * Guarda la lista de usuarios en un archivo serializado.
     *
     * @param listausuarios La lista de usuarios que se va a guardar.
     * @param archivo        El nombre del archivo en el que se va a guardar la lista de usuarios.
     */
    public static void guardarUsuarios(ArrayList<Usuario> listausuarios, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(listausuarios);
            System.out.println("Usuarios guardados con éxito.");
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    /**
     * Carga la lista de usuarios desde un archivo serializado.
     *
     * @param archivo El nombre del archivo desde el que se va a cargar la lista de usuarios.
     * @return La lista de usuarios cargada desde el archivo. Si hay un error, se devuelve una lista vacía.
     */
    public static ArrayList<Usuario> cargarUsuarios(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
        return new ArrayList<>(); // En caso de error, devolvemos una lista vacía.
    }

    /**
     * Guarda la lista de libros en un archivo serializado.
     *
     * @param biblioteca La lista de libros que se va a guardar.
     * @param archivo    El nombre del archivo en el que se va a guardar la lista de libros.
     */
    public static void guardarLibros(ArrayList<Libros> biblioteca, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(biblioteca);
            System.out.println("Libros guardados con éxito.");
        } catch (IOException e) {
            System.err.println("Error al guardar libros: " + e.getMessage());
        }
    }

    /**
     * Carga la lista de libros desde un archivo serializado.
     *
     * @param archivo El nombre del archivo desde el que se va a cargar la lista de libros.
     * @return La lista de libros cargada desde el archivo. Si hay un error, se devuelve una lista vacía.
     */
    public static ArrayList<Libros> cargarLibros(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<Libros>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar libros: " + e.getMessage());
        }
        return new ArrayList<>(); // En caso de error, devolvemos una lista vacía.
    }
}