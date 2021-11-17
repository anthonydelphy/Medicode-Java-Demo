package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WritePrescriptionControl {

    @FXML
    private Button backButton;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField medicineDosage;

    @FXML
    private TextField medicineName;

    @FXML
    private Button prescribeMedicineButton;

    @FXML
    void prescribe(ActionEvent event) {
        //Add medicine to the patient list


    }

    @FXML
    void previousScene(ActionEvent event) {
        //return to previous scene

    }

}
