package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class professionalAppointmentFormController {

    @FXML
    private TextArea concernField;

    @FXML
    private TextField dateField;

    @FXML
    private VBox firstName;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;
    @FXML
    private TextField doctorUs;

    @FXML
    private Button makeAppointmentButton;

    @FXML
    private TextField timeField;

    @FXML
    private Text completeFields;

    @FXML
    private TextField patientUsername;


    @FXML
    private Text created;

    @FXML
    void makeAppointment(ActionEvent event) {
        //Notify user that fields aren't complete
        if(patientUsername.getText().isEmpty() || doctorUs.getText().isEmpty()
                || timeField.getText().isEmpty() || dateField.getText().isEmpty()
                || concernField.getText().isEmpty())
        {
            completeFields.setVisible(true);
            return;
        }

        else{
            Appointments newAppointment = new Appointments();
            newAppointment.setPatientUsername(patientUsername.getText());
            newAppointment.setDate(dateField.getText());
            newAppointment.setDoctorUsername(doctorUs.getText());
            newAppointment.setConcerns(concernField.getText());
            newAppointment.setTime(timeField.getText());

            firstNameField.clear();
            lastNameField.clear();
            timeField.clear();
            dateField.clear();
            concernField.clear();
            created.setVisible(true);
        }




        //Grab the database from the event
        Database temp = new Database();
        try {
            temp = ChangeSceneClass.getDatabase(event);
        }catch(IOException e){e.printStackTrace();}


        //Add new patient to the database


        try{
            ChangeSceneClass.setDatabase(event,temp);
        }catch (IOException e){e.printStackTrace();}



        temp.updateJSON();




    }

}
