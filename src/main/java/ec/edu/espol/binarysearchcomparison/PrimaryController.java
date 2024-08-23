package ec.edu.espol.binarysearchcomparison;

import ec.edu.espol.binarysearchcomparison.modelo.AlgorithmCreateArray;
import ec.edu.espol.binarysearchcomparison.modelo.BinarySearchAlgorithmIterative;
import ec.edu.espol.binarysearchcomparison.modelo.BinarySearchAlgorithmRecursive;
import ec.edu.espol.binarysearchcomparison.modelo.LinearAlgorithm;
import ec.edu.espol.binarysearchcomparison.util.AlgorithmTimeManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.util.StringConverter;

public class PrimaryController implements Initializable{

    @FXML
    private TextField elementToSearch;
    @FXML
    private Slider selectElementsSlider;
    @FXML
    private Text txtBusquedaLineal;
    @FXML
    private Text txtBusquedaBinIterada;
    @FXML
    private Text txtBusquedaBinRecursiva;
    @FXML
    private Button btnBuscar;
    @FXML
    private Text txtNElements;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Inicializa el valor del slider, por ejemplo, en 10 elementos.
        selectElementsSlider.setValue(10);
        selectElementsSlider.setMin(10.0);
        selectElementsSlider.setMax(3000000.0);
        selectElementsSlider.setMajorTickUnit(100000);  // Mostrar tick cada 100000 unidades
        selectElementsSlider.setMinorTickCount(0);       // No mostrar ticks menores
        selectElementsSlider.setShowTickLabels(true);    // Mostrar etiquetas
        selectElementsSlider.setShowTickMarks(true);     // Mostrar marcas
        selectElementsSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n == 1000000) return "1E6";  // Representación en notación científica
                if (n >= 100000) return String.format("%.0E", n);
                return n.intValue() + "";
            }

            @Override
            public Double fromString(String s) {
                return Double.valueOf(s);
            }
        });

        selectElementsSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            txtNElements.setText(String.valueOf(newVal.intValue()));
        });
    }

    @FXML
    private void search(ActionEvent event) {
        try{
            // Validar que el campo de texto no esté vacío
            if (elementToSearch.getText().isEmpty()) {
                showTooltip(elementToSearch, "Por favor, ingrese un número a buscar.");
                return;
            }

            // Validar que el valor ingresado es un número dentro del rango
            int target = Integer.parseInt(elementToSearch.getText());
            final int minRange = 1;
            int maxRange = (int) Math.floor(selectElementsSlider.getValue());

            if (target < minRange || target > maxRange) {
                showTooltip(elementToSearch, "El número debe estar entre " + minRange + " y " + maxRange + ".");
                return;
            }

            // Si todo es válido, restablecer el estilo del campo
            elementToSearch.setStyle(null);
            int arraySize = (int) selectElementsSlider.getValue(); // Obtener tamaño del array del slider.

            // Utilizar AlgorithmCreateArray para generar el arreglo.
            AlgorithmCreateArray arrayGenerator = new AlgorithmCreateArray();
            int[] array = arrayGenerator.generateSequentialArray(arraySize);

            // Instanciar los algoritmos de búsqueda.
            LinearAlgorithm linearSearch = new LinearAlgorithm();
            BinarySearchAlgorithmIterative binarySearchIterative = new BinarySearchAlgorithmIterative();
            BinarySearchAlgorithmRecursive binarySearchRecursive = new BinarySearchAlgorithmRecursive();

            // Medir el tiempo de búsqueda usando Linear Search.
            long linearTime = AlgorithmTimeManager.measureTime(linearSearch, array, target);
            txtBusquedaLineal.setText(String.format("%.5f ms", AlgorithmTimeManager.toMilliseconds(linearTime)));

            // Medir el tiempo de búsqueda usando Binary Search Iterativo.
            long binaryIterativeTime = AlgorithmTimeManager.measureTime(binarySearchIterative, array, target);
            txtBusquedaBinIterada.setText(String.format("%.5f ms", AlgorithmTimeManager.toMilliseconds(binaryIterativeTime)));

            // Medir el tiempo de búsqueda usando Binary Search Recursivo.
            long binaryRecursiveTime = AlgorithmTimeManager.measureTime(binarySearchRecursive, array, target);
            txtBusquedaBinRecursiva.setText(String.format("%.5f ms", AlgorithmTimeManager.toMilliseconds(binaryRecursiveTime)));
            changeColors(linearTime, binaryIterativeTime, binaryRecursiveTime);
        } catch (NumberFormatException e) {
             showTooltip(elementToSearch, "Por favor, ingrese un valor numérico válido.");
        }
    }
    
    private void showTooltip(TextField textField, String message) {
        Tooltip tooltip = new Tooltip(message);
        tooltip.setAutoHide(true);
        tooltip.setShowDelay(Duration.ONE); 
        tooltip.setHideDelay(Duration.seconds(4)); // Ocultar después de 4 segundos

        // Posiciona el Tooltip debajo del TextField
        Window window = textField.getScene().getWindow();
        Point2D pos = textField.localToScene(0.0, 0.0);
        double tooltipX = window.getX() + pos.getX() + textField.getScene().getX();
        double tooltipY = window.getY() + pos.getY() + textField.getScene().getY() + textField.getHeight();

        tooltip.show(textField, tooltipX, tooltipY);

        // Mantener el focus en el TextField
        textField.requestFocus();
    }
    
    private void changeColors(long linearTime, long binaryIterativeTime, long binaryRecursiveTime) {
        long maxTime = Math.max(Math.max(linearTime, binaryIterativeTime), binaryRecursiveTime);
        long minTime = Math.min(Math.min(linearTime, binaryIterativeTime), binaryRecursiveTime);

        // Cambia el color del tiempo más alto a rojo
        if (linearTime == maxTime) {
            txtBusquedaLineal.setStyle("-fx-fill: red;");
        } else if (linearTime == minTime) {
            txtBusquedaLineal.setStyle("-fx-fill: green;");
        } else {
            txtBusquedaLineal.setStyle("-fx-fill: #FFB200;");
        }

        if (binaryIterativeTime == maxTime) {
            txtBusquedaBinIterada.setStyle("-fx-fill: red;");
        } else if (binaryIterativeTime == minTime) {
            txtBusquedaBinIterada.setStyle("-fx-fill: green;");
        } else {
            txtBusquedaBinIterada.setStyle("-fx-fill: #FFB200;");
        }

        if (binaryRecursiveTime == maxTime) {
            txtBusquedaBinRecursiva.setStyle("-fx-fill: red;");
        } else if (binaryRecursiveTime == minTime) {
            txtBusquedaBinRecursiva.setStyle("-fx-fill: green;");
        } else {
            txtBusquedaBinRecursiva.setStyle("-fx-fill: #FFB200;");
        }
    }
}
