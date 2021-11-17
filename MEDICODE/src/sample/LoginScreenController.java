package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginScreenController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String userType;

    @FXML
    private Button createAccountButton;

    @FXML
    private VBox infoInputPanel;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginPassword;

    @FXML
    private TextField loginUsername;

    @FXML
    void createAccountButtonAction(ActionEvent event) throws IOException{
        //Takes you to the account creation screen
        ChangeSceneClass.changeScene(event,"createAccount.fxml");

    }

    @FXML
    void loginButtonAction(ActionEvent event) throws IOException {
        //Takes you into the account itself by calling the check account method
        //then populates the UI with the information relevant to the
        //user i.e. a doctor patient or nurse etc
        checkType(event);


    }



    public void checkType(ActionEvent event) throws IOException{
        //If Doctor
        switchToDoctor(event);

        /*If Nurse
        switchToNurse(event);

        //If Patient
        switchToPatient(event);*/

    }

    public void switchToDoctor(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("DoctorInitial.fxml");
        /*Parent root = FXMLLoader.load(getClass().getResource("DoctorInitial.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

    }
    /*
    public void switchToNurse(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("2NurseSplash.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPatient(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("2PatientSplash.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }*/




}
