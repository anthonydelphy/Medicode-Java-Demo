package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
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
        Database temp = new Database();
        try {
            temp = ChangeSceneClass.getDatabase(event);
        }catch(IOException e){e.printStackTrace();}

        for(int i = 0; i < temp.getDoctorsList().size(); i++){
            if (loginUsername.getText().equals(temp.getDoctorsList().get(i).getUsername()) && loginPassword.getText().equals(temp.getDoctorsList().get(i).getPassword())) {
                switchToDoctor(event);
            }
        }


        //If Nurse
        for(int i = 0; i < temp.getNursesList().size(); i++){
            if (loginUsername.getText().equals(temp.getNursesList().get(i).getUsername()) && loginPassword.getText().equals(temp.getNursesList().get(i).getPassword())) {
                switchToNurse(event);
            }
        }


        //If Patient
        for(int i = 0; i < temp.getPatientList().size(); i++){
            if (loginUsername.getText().equals(temp.getPatientList().get(i).getUsername()) && loginPassword.getText().equals(temp.getPatientList().get(i).getPassword())) {
                switchToPatient(event);
            }
        }

        return;

    }

    public void switchToDoctor(ActionEvent event) throws IOException {
        //Main m = new Main();
        //m.changeScene("DoctorInitial.fxml");
        ChangeSceneClass.changeScene(event, "DoctorInitial.fxml");
        /*Parent root = FXMLLoader.load(getClass().getResource("DoctorInitial.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

    }

    public void switchToNurse(ActionEvent event) throws IOException{
        ChangeSceneClass.changeScene(event, "NurseInitial.fxml");
       /* Parent root = FXMLLoader.load(getClass().getResource("2NurseSplash.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */

    }
    public void switchToPatient(ActionEvent event) throws IOException{
        ChangeSceneClass.changeScene(event, "PatientInitial.fxml");
        /*
        Parent root = FXMLLoader.load(getClass().getResource("2PatientSplash.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */


    }




}
