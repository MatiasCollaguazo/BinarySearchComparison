package ec.edu.espol.binarysearchcomparison.modelo;

/**
 * 
 * @author Group #13
 */
public class BinarySearchAlgorithmIterative implements SearchAlgorithm {

    @Override
    public int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Comprueba y retorna el elemento en la mitad del array si es igual al target
            if (array[mid] == target) {
                return mid;
            }
            
            // Si el target es mayor al elemento, ignora la mitad izquierda del array
            if (array[mid] < target) {
                left = mid + 1;
            } 
            // Si el target es menor al elemento, ignora la mitad derecha del array
            else {
                right = mid - 1;
            }
        }
        
        // Si no lo encuentra retorna -1
        return -1;
    }
}
