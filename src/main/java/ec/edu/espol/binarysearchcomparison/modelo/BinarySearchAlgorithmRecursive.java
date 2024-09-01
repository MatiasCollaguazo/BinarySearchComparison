package ec.edu.espol.binarysearchcomparison.modelo;

/**
 * 
 * @author Grupo#13
 */
public class BinarySearchAlgorithmRecursive implements SearchAlgorithm {

    @Override
    public int search(int[] array, int target) {
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    /**
     * Método privado que realiza la búsqueda binaria de manera recursiva.
     * 
     * @param array El arreglo en el cual se realizará la búsqueda.
     * @param target El elemento que se desea buscar.
     * @param left El índice izquierdo del subarreglo actual.
     * @param right El índice derecho del subarreglo actual.
     * @return El índice del elemento si se encuentra, de lo contrario -1.
     */
    private int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // No encontrado
        }

          int mid = (int) Math.floor((left+right)/2); // Calcular el índice medio

        if (array[mid] == target) { // Comparar con el valor en el índice medio
            return mid; // Devolver el índice
        }

        if (target < array[mid]) { // Si el objetivo es menor que el valor en el medio
            right = mid - 1; // Buscar en la mitad izquierda del array, actualizando el límite superior
        } else { // Si no, buscar en la mitad derecha del array
            left = mid + 1; // Actualizando el límite inferior
        }
        return binarySearchRecursive(array, target, left, right);
    }
}
