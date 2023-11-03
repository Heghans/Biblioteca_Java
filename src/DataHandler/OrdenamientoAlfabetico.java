package DataHandler;
import Objetos.Usuario;
import java.util.ArrayList;

/**
 * La clase OrdenamientoAlfabetico proporciona una implementación simple del algoritmo de ordenamiento de burbuja para
 * ordenar una lista de objetos Usuario alfabéticamente por su nombre.
 */
public class OrdenamientoAlfabetico {

    /**
     * Ordena la lista de usuarios alfabéticamente por su nombre utilizando el algoritmo de ordenamiento de burbuja.
     *
     * @param listausuarios La lista de usuarios que se va a ordenar.
     */
    public static void bubbleSort(ArrayList<Usuario> listausuarios) {
        int n = listausuarios.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                // Compara los nombres de los usuarios en la lista
                if (listausuarios.get(i - 1).getNom().compareTo(listausuarios.get(i).getNom()) > 0) {
                    // Intercambia los usuarios si el nombre es mayor
                    Usuario temp = listausuarios.get(i - 1);
                    listausuarios.set(i - 1, listausuarios.get(i));
                    listausuarios.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }
}