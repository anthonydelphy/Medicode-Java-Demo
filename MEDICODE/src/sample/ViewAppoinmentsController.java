import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Appointments;
import sample.ChangeSceneClass;

public class ViewAppoinmentsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableView<?> upcomingAppoinments;

    @FXML
    private TableView<?> upcomingAppoinments1;

    @FXML
    private TableColumn<String, String> upcomingDate;


    @FXML
    void goBackHome(ActionEvent e) throws IOException {
        ChangeSceneClass.changeScene(e, "PatientInitial.fxml");
    }

    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'AppointmentTable.fxml'.";
        assert upcomingAppoinments != null : "fx:id=\"upcomingAppoinments\" was not injected: check your FXML file 'AppointmentTable.fxml'.";
        assert upcomingAppoinments1 != null : "fx:id=\"upcomingAppoinments1\" was not injected: check your FXML file 'AppointmentTable.fxml'.";

        TableColumn<Appointments, String> column1 = new TableColumn<>("Upcoming Date");
        column1.setCellValueFactory(new PropertyValueFactory<>("date"));


    }

    public ObservableList<Appointments> getAppointments(ActioEvent e){
        ObservableList<Appointments> appointments = new Ob

    }
}
