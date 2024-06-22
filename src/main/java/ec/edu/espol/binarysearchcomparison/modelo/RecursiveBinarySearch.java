package ec.edu.espol.binarysearchcomparison.modelo;

/**
 * Clase que implementa el algoritmo de búsqueda binaria de manera recursiva.
 * Este algoritmo busca un elemento en una lista ordenada y retorna el índice
 * del elemento si es encontrado, o -1 si no lo es.
 * 
 * @author Group #13
 */
public class RecursiveBinarySearch {

    /**
     * Método estático que realiza la búsqueda binaria recursiva en un arreglo ordenado.
     * 
     * @param array El arreglo ordenado en el cual se busca el elemento.
     * @param target El elemento que se desea buscar.
     * @return El índice del elemento si se encuentra en el arreglo, de lo contrario -1.
     */
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    /**
     * Método recursivo estático que realiza la búsqueda binaria recursiva en un arreglo ordenado.
     * 
     * @param array El arreglo ordenado en el cual se busca el elemento.
     * @param target El elemento que se desea buscar.
     * @param left El índice inicial del rango de búsqueda.
     * @param right El índice final del rango de búsqueda.
     * @return El índice del elemento si se encuentra en el arreglo, de lo contrario -1.
     */
    private static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // Caso base: El elemento no está presente en el arreglo
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid; // El elemento objetivo está en la posición media
        }

        if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, right); // Ignorar la mitad izquierda
        } else {
            return binarySearch(array, target, left, mid - 1); // Ignorar la mitad derecha
        }
    }
}
