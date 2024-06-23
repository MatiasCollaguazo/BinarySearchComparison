package ec.edu.espol.binarysearchcomparison.modelo;

/**
 *
 * @author Grupo #13
 */
public class GenerateSortedArray {
    
    /**
     * Genera un arreglo ordenado de tamaño especificado.
     * El arreglo generado empezará en 1.
     *
     * @param size El tamaño del arreglo a generar.
     * @return Un arreglo ordenado del tamaño especificado.
     */
    public static int[] generate(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}
