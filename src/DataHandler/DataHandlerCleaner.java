package DataHandler;

import java.io.File;

/**
 * La clase DataHandlerCleaner proporciona métodos para eliminar archivos de datos de usuarios y libros.
 */
public class DataHandlerCleaner {

    /**
     * Elimina el archivo de datos de usuarios.
     *
     * @param archivo El nombre del archivo que se va a eliminar.
     */
    public static void limpiarUsuarios(String archivo) {
        File file = new File(archivo);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("Archivo de usuarios eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el archivo de usuarios.");
            }
        } else {
            System.out.println("No se encontró el archivo de usuarios.");
        }
    }

    /**
     * Elimina el archivo de datos de libros.
     *
     * @param archivo El nombre del archivo que se va a eliminar.
     */
    public static void limpiarLibros(String archivo) {
        File file = new File(archivo);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("Archivo de libros eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el archivo de libros.");
            }
        } else {
            System.out.println("No se encontró el archivo de libros.");
        }
    }
}