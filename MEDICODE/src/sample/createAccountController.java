package sample;

import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class createAccountController {

    @FXML
    private Text completeFields;

    @FXML
    private Button createAccountButton;

    @FXML
    private Button createBack;

    @FXML
    private TextField createBirthday;

    @FXML
    private TextField createEmail;

    @FXML
    private TextField createFirstName;

    @FXML
    private TextField createLastName;

    @FXML
    private TextField createPassword;

    @FXML
    //When
    void createAccount(ActionEvent event) {

        //Notify user that fields aren't complete
        if(createBirthday.getText().isEmpty() || createEmail.getText().isEmpty() || createFirstName.getText().isEmpty() || createLastName.getText().isEmpty() || createPassword.getText().isEmpty())
        {
            completeFields.setVisible(true);
            return;
        }

        Patient newPatient = new Patient();
        newPatient.setFirstName(createFirstName.getText());
        newPatient.setLastName(createLastName.getText());
        newPatient.setBirthday(createBirthday.getText());
        newPatient.setPassword(createPassword.getText());
        String noDashBDay = createBirthday.getText().replace("/", "");
        newPatient.setUsername(createFirstName.getText() + createLastName.getText() + noDashBDay);

        //Grab the database from the event
        Database temp = new Database();
        try {
            temp = ChangeSceneClass.getDatabase(event);
        }catch(IOException e){e.printStackTrace();}


        //Add new patient to the database
        temp.addPatient(newPatient);


        //Save newly updated database
        try{
            ChangeSceneClass.setDatabase(event,temp);
        }catch (IOException e){e.printStackTrace();}

        temp.updateJSON();


    }

    @FXML
    void previousScene(ActionEvent event)  throws IOException {
        //Takes you to the account creation screen
        ChangeSceneClass.changeScene(event, "loginScreen.fxml");
    }

}
