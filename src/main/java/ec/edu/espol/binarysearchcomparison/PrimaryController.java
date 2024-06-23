package ec.edu.espol.binarysearchcomparison;

import ec.edu.espol.binarysearchcomparison.modelo.IterativeBinarySearch;
import ec.edu.espol.binarysearchcomparison.modelo.RecursiveBinarySearch;
import ec.edu.espol.binarysearchcomparison.modelo.LinearSearch;
import ec.edu.espol.binarysearchcomparison.modelo.AlgorithmTimeManager;
import ec.edu.espol.binarysearchcomparison.modelo.GenerateSortedArray;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable {

    @FXML
    private Text nElements;
    @FXML
    private Slider nSlider;
    @FXML
    private Text txtLinearSearch;
    @FXML
    private Text txtBS_Iterative;
    @FXML
    private Text txtBS_Recursive;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField txtFieldN;

    private String nValue = "10";
    
    private int nInit = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nSlider.setValue(10);
        nElements.setText("10");
        Tooltip txtFieldTooltip = new Tooltip();
        txtFieldN.setTooltip(txtFieldTooltip);
    }

    @FXML
    private void updateNElements(MouseEvent event) {
        nValue = String.valueOf((int) Math.floor(nSlider.getValue()));
        nElements.setText(nValue);
        txtFieldN.getTooltip().setText("Ingresa un numero en el rango entre 1 y " + nValue + ".");
    }

    @FXML
    private void executeAlgorithms(ActionEvent event) {
        String targetString = txtFieldN.getText();
        int[] array = GenerateSortedArray.generate(Integer.parseInt(nValue));
        Tooltip tooltip = txtFieldN.getTooltip();

        int target=1;
        try {
            target = Integer.parseInt(targetString);
            if (target>=nInit||target<=Integer.parseInt(nValue)) {
                throw new NumberFormatException();
            }
            txtFieldN.setStyle(""); // Reset the style if the input is correct
            tooltip.hide(); // Hide the tooltip if the input is correct
        } catch (NumberFormatException e) {
            txtFieldN.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            tooltip.setText("Por favor, ingrese un número válido.");
            tooltip.show(txtFieldN, txtFieldN.getScene().getWindow().getX() + txtFieldN.getLayoutX(), txtFieldN.getScene().getWindow().getY() + txtFieldN.getLayoutY() + txtFieldN.getHeight());
            return;
        }
        IterativeBinarySearch iterativeBinarySearch = new IterativeBinarySearch();
        RecursiveBinarySearch recursiveBinarySearch = new RecursiveBinarySearch();
        LinearSearch linearSearch = new LinearSearch();
        long iterativeTime = AlgorithmTimeManager.measureTime(iterativeBinarySearch, array, target);
        long recursiveTime = AlgorithmTimeManager.measureTime(recursiveBinarySearch, array, target);
        long linearTime = AlgorithmTimeManager.measureTime(linearSearch, array, target);
        txtLinearSearch.setText(
            linearTime + " ns (" + 
            AlgorithmTimeManager.toMicroseconds(linearTime) + " µs, " + 
            AlgorithmTimeManager.toMilliseconds(linearTime) + " ms)"
        );
        txtBS_Iterative.setText(
            iterativeTime + " ns (" + 
            AlgorithmTimeManager.toMicroseconds(iterativeTime) + " µs, " + 
            AlgorithmTimeManager.toMilliseconds(iterativeTime) + " ms)"
        );
        txtBS_Recursive.setText(
            recursiveTime + " ns (" + 
            AlgorithmTimeManager.toMicroseconds(recursiveTime) + " µs, " + 
            AlgorithmTimeManager.toMilliseconds(recursiveTime) + " ms)"
        );
        
    }
}
