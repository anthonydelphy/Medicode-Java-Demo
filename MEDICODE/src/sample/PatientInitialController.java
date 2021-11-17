package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class PatientInitialController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String userType;

    @FXML
    private BorderPane displayBorder;

    @FXML
    private Button doctorAppointmentsButton;

    @FXML
    private Button doctorCreatePatientButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TextField doctorNameField;

    @FXML
    private Button doctorPatientSearch;

    @FXML
    private Button doctorPrescribeButton;

    @FXML
    private Button doctorViewMessagesButton;

    @FXML
    private Button doctorViewNurses;

    @FXML
    private Button doctorViewPatients;

    @FXML
    private Button viewProfileButton;

    @FXML
    void loadPrescriptions(ActionEvent e ) throws IOException{

    }

    @FXML
    void changeDoctor(ActionEvent e) throws IOException{

    }


    @FXML
    void createPatient(ActionEvent event) throws IOException{
        //Takes you to the account creation screen
        Main m = new Main();
        m.changeScene("createAccount.fxml");
    }

    @FXML
    void loadAppointments(ActionEvent event) throws IOException {
        loadUI("ApointmentView");

    }

    @FXML
    void loadMessages(ActionEvent event)  throws IOException{
        loadUI("MessagePage");
    }

    @FXML
    void loadNurses(ActionEvent event)  throws IOException{
        loadUI("MyNurses");
    }

    @FXML
    void loadPatients(ActionEvent event) throws IOException {
        loadUI("MyPatients");
    }

    @FXML
    void loadPrescriptionForm(ActionEvent event) throws IOException{
        loadUI("WritePrescription");
    }

    @FXML
    void loadProfile(ActionEvent event) throws IOException {
        loadUI("Profile");

    }

    @FXML
    void searchPatients(ActionEvent event) throws IOException {
        loadUI("PatientSearch");

    }


    @FXML
    void makeAppointment(ActionEvent event) throws IOException{
        loadUI("professionalAppointmentForm");
    }


    @FXML
    void logVitals(ActionEvent event) throws IOException{
        loadUI("logVisitForm");

    }
    @FXML
    void logout(ActionEvent event) {

    }

    private void loadUI(String ui) throws IOException{
        root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        displayBorder.setRight(root);


    }




}

