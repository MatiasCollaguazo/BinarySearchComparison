package ec.edu.espol.binarysearchcomparison.modelo;

/**
 * Interfaz para los algoritmos de búsqueda.
 * Define un método de búsqueda que debe ser implementado por diferentes algoritmos.
 * 
 * @author Group #13
 */
public interface ISearchAlgorithm {
    /**
     * Método para realizar la búsqueda en un arreglo.
     * 
     * @param array El arreglo en el cual se busca el elemento.
     * @param target El elemento que se desea buscar.
     * @return El índice del elemento si se encuentra en el arreglo, de lo contrario -1.
     */
    int search(int[] array, int target);
}
