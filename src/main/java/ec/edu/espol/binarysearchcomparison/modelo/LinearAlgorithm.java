package ec.edu.espol.binarysearchcomparison.modelo;

/**
 * 
 * @author Group #13
 */
public class LinearAlgorithm implements SearchAlgorithm {

    @Override
    public int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        
        // Si no lo encuentra retorna -1
        return -1;
    }
}
