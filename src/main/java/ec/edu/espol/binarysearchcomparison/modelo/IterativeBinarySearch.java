package ec.edu.espol.binarysearchcomparison.modelo;

/**
 * Clase que implementa el algoritmo de búsqueda binaria iterativa.
 * Este algoritmo busca un elemento en una lista ordenada y retorna el índice
 * del elemento si es encontrado, o -1 si no lo es.
 * 
 * @author
 */
public class IterativeBinarySearch implements ISearchAlgorithm {

    /**
     * Método que realiza la búsqueda binaria iterativa en un arreglo ordenado.
     * 
     * @param array El arreglo ordenado en el cual se busca el elemento.
     * @param target El elemento que se desea buscar.
     * @return El índice del elemento si se encuentra en el arreglo, de lo contrario -1.
     */
    @Override
    public int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
