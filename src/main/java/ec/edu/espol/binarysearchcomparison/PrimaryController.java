package ec.edu.espol.binarysearchcomparison;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nSlider.setValue(0);
        nElements.setText("10");
    }

    @FXML
    private void updateNElements(MouseEvent event) {
        int nValue = (int) Math.floor(nSlider.getValue());
        nElements.setText(String.valueOf(nValue));
    }
}
