import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;

public class main{

    public static void main(String[] args){
        Database db = new Database();
        String content = "";
        Scanner scan = new Scanner(System.in);
        try {
            content = readFile("database.json", StandardCharsets.UTF_8);
        }
        catch(IOException e){};
        Gson gson = new Gson();
        db = gson.fromJson(content, Database.class);

        //Example of getting information
        //System.out.println(db.getPatient(0).getPrescription(0).toString());

        logInMenu(db);
    }

    public static void logInMenu(Database db)
    {
        Scanner scan = new Scanner(System.in);
        //Choose what account to log into
        System.out.println("What type of account do you have?");
        System.out.println("1. Patient");
        System.out.println("2. Nurse");
        System.out.println("3. Doctor");

        int typeOfAccount = scan.nextInt();

        switch(typeOfAccount) {
            case 1: //PATIENT
                System.out.println("What would you like to do?\n1.Log in\n2.Create an Account");
                int logIn = scan.nextInt();

                if(logIn == 1){ //Log into account
                    logInPatient(db);
                }
                else if(logIn == 2){ //Create an Account
                    createPatientAccount(db);
                    updateJSON(db);

                }
                break;
            case 2: //NURSE
                logInNurse(db);

                break;
            case 3: //DOCTOR
                logInDoctor(db);
                break;
            default:
                System.out.println("Incorrect input. Please try again.");
        }
        scan.close();
    }

    public static void createPatientAccount(Database db){
        Scanner createAccountScanner = new Scanner(System.in);
        int flag = 0; //Flag if user is trying to create an existing account. 1 = account already exists.

        System.out.println("First name: ");
        String firstName = createAccountScanner.next();

        System.out.println("Last name: ");
        String lastName = createAccountScanner.next();

        System.out.println("Birthday (MM/DD/YYYY): ");
        String birthday = createAccountScanner.next();

        System.out.println("Create a Password: ");
        String password = createAccountScanner.next();

        //Give account a specific username.
        String username = firstName + lastName + birthday.replace("/", "");
        username = username.toLowerCase(Locale.ROOT);

        //Check to see if account already exists in the database.
        for(int i = 0; i < db.getPatientList().size(); i++)
            if(db.getPatient(i).getUsername().equals(username))
                flag = 1;

        if(flag==0) {
            System.out.println("Your account username will be: " + username);

            Patient newPatient = new Patient();
            newPatient.setFirstName(firstName);
            newPatient.setLastName(lastName);
            newPatient.setUsername(username);
            newPatient.setBirthday(birthday);
            newPatient.setPassword(password);


            //Add patient and add to database.json
            db.addPatient(newPatient);
        }
        else if(flag == 1){
            System.out.println("This account already exists. Please log in");
        }


        createAccountScanner.close();
    }

    public static void logInPatient(Database db){
        int flag = 0;
        Scanner patientLogInScan = new Scanner(System.in);
        while (flag == 0) {

            System.out.println("Username:");
            String username = patientLogInScan.next().toLowerCase(Locale.ROOT);

            System.out.println("Password:");
            String password = patientLogInScan.next().toLowerCase(Locale.ROOT);

            for(int i = 0; i< db.getPatientList().size(); i++){
                if(username.equals(db.getPatient(i).getUsername().toLowerCase(Locale.ROOT))
                        && password.equals(db.getPatient(i).getPassword())){
                    System.out.println("Log in successful");
                    flag = 1;
                }
            }

            if(flag == 0){
                System.out.println("This is not a correct username/password combination.\nPlease try again.");
            }
        }
        patientLogInScan.close();
    }

    public static void logInNurse(Database db){
        int flag = 0;
        Scanner nurseLogInScan = new Scanner(System.in);
        while (flag == 0) {

            System.out.println("Username:");
            String username = nurseLogInScan.next().toLowerCase(Locale.ROOT);

            System.out.println("Password:");
            String password = nurseLogInScan.next().toLowerCase(Locale.ROOT);

            for(int i = 0; i< db.getPatientList().size(); i++){
                if(username.equals(db.getNurse(i).getUsername().toLowerCase(Locale.ROOT))
                        && password.equals(db.getNurse(i).getPassword())){
                    System.out.println("Log in successful");
                    flag = 1;
                }
            }

            if(flag == 0){
                System.out.println("This is not a correct username/password combination.\nPlease try again.");
            }
        }
        nurseLogInScan.close();
    }

    public static void logInDoctor(Database db){
        int flag = 0;
        Scanner doctorLogInScan = new Scanner(System.in);
        while (flag == 0) {

            System.out.println("Username:");
            String username = doctorLogInScan.next().toLowerCase(Locale.ROOT);

            System.out.println("Password:");
            String password = doctorLogInScan.next().toLowerCase(Locale.ROOT);

            for(int i = 0; i< db.getPatientList().size(); i++){
                if(username.equals(db.getDoctor(i).getUsername().toLowerCase(Locale.ROOT))
                        && password.equals(db.getDoctor(i).getPassword())){
                    System.out.println("Log in successful");
                    flag = 1;
                }
            }

            if(flag == 0){
                System.out.println("This is not a correct username/password combination.\nPlease try again.");
            }
        }
        doctorLogInScan.close();
    }

    public static void updateJSON(Database db){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String newJSON = gson.toJson(db);

        try(FileWriter writer = new FileWriter("database.json")){
            writer.write(newJSON);
        } catch(IOException e){ e.printStackTrace();}

    }

    static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}