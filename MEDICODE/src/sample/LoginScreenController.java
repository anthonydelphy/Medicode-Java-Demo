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
import javafx.scene.text.Text;

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
    private Text loginFailText;

    @FXML
    void createAccountButtonAction(ActionEvent event) throws IOException{
        //Takes you to the account creation screen
        ChangeSceneClass.changeScene(event,"createAccount.fxml");

    }

    @FXML
    void loginButtonAction(ActionEvent event) throws IOException {
            Database temp = new Database();
        try {
            temp = ChangeSceneClass.getDatabase(event);
        }catch(IOException e){e.printStackTrace();}

        for(int i = 0; i < temp.getDoctorsList().size(); i++){
            if (loginUsername.getText().equals(temp.getDoctorsList().get(i).getUsername())){
                if(loginPassword.getText().equals(temp.getDoctorsList().get(i).getPassword())) {
                    ChangeSceneClass.changeScene(event, "DoctorInitial.fxml");
                    return;
                }
                else{
                    loginFailText.setText("Incorrect Username or Password");
                    return;
                }
            }
        }


        //If Nurse
        for(int i = 0; i < temp.getNursesList().size(); i++){
            if (loginUsername.getText().equals(temp.getNursesList().get(i).getUsername())){
                if (loginPassword.getText().equals(temp.getNursesList().get(i).getPassword())) {
                    ChangeSceneClass.changeScene(event, "NurseInitial.fxml");
                    return;
                }
                else{
                    loginFailText.setText("Incorrect Username or Password");
                    return;
                }
            }
        }


        //If Patient
        for(int i = 0; i < temp.getPatientList().size(); i++){
            if (loginUsername.getText().equals(temp.getPatientList().get(i).getUsername())){
                if (loginPassword.getText().equals(temp.getPatientList().get(i).getPassword())) {
                    ChangeSceneClass.changeScene(event, "PatientInitial.fxml");
                    return;
                }
                else{
                    loginFailText.setText("Incorrect Username or Password");
                    return;
                }
            }
        }
        
        loginFailText.setText("Incorrect Username or Password");
        return;

    }
}
