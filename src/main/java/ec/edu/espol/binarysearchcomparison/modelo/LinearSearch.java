package ec.edu.espol.binarysearchcomparison.modelo;

/**
 * Clase que implementa el algoritmo de búsqueda lineal.
 * Este algoritmo busca un elemento en una lista desordenada o ordenada y 
 * retorna el índice del elemento si es encontrado, o -1 si no lo es.
 * 
 * @author Group #13
 */
public class LinearSearch {
    
    /**
     * Método estático que realiza la búsqueda lineal en un arreglo.
     * 
     * @param array El arreglo en el cual se busca el elemento.
     * @param target El elemento que se desea buscar.
     * @return El índice del elemento si se encuentra en el arreglo, de lo contrario -1.
     */
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Retorna el índice si el elemento es encontrado
            }
        }
        return -1; // Retorna -1 si el elemento no está presente en el arreglo
    }
}
