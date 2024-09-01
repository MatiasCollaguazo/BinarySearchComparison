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
        if (left <= right) {
            int mid = (right + left) / 2;

            // Check if the target is at the mid index
            if (array[mid] == target) {
                return mid;
            }

            // If the target is smaller than the mid element, search in the left subarray
            if (array[mid] > target) {
                return binarySearchRecursive(array, target, left, mid - 1);
            }

            // If the target is larger than the mid element, search in the right subarray
            return binarySearchRecursive(array, target, mid + 1, right);
        }

        // Target not found
        return -1;
    }
}
