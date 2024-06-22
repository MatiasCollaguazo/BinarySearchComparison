package ec.edu.espol.binarysearchcomparison.modelo;

/**
 * Clase que implementa el algoritmo de búsqueda binaria de manera iterativa.
 * Este algoritmo busca un elemento en una lista ordenada y retorna el índice
 * del elemento si es encontrado, o -1 si no lo es.
 * 
 * @author Group #13
 */
public class IterativeBinarySearch {
    
    /**
     * Método que realiza la búsqueda binaria iterativa en un arreglo ordenado.
     * 
     * @param array El arreglo ordenado en el cual se busca el elemento.
     * @param target El elemento que se desea buscar.
     * @return El índice del elemento si se encuentra en el arreglo, de lo contrario -1.
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Comprueba si el elemento objetivo está en la posición media
            if (array[mid] == target) {
                return mid;
            }
            
            // Si el elemento objetivo es mayor que el elemento en la posición media, ignora la mitad izquierda
            if (array[mid] < target) {
                left = mid + 1;
            }
            // Si el elemento objetivo es menor que el elemento en la posición media, ignora la mitad derecha
            else {
                right = mid - 1;
            }
        }
        
        // Si el elemento no está presente en el arreglo
        return -1;
    }
}
