import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;

public class main{

    private static Database db;
    private static Scanner scanner;
    private static Scanner intScanner;

    public static void main(String[] args){
        db = new Database();
        String content = "";
        scanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
        try {
            content = readFile("database.json", StandardCharsets.UTF_8);
        }
        catch(IOException e){};
        Gson gson = new Gson();
        db = gson.fromJson(content, db.getClass());

        logInMenu();

        scanner.close();
        intScanner.close();
    }

    public static void logInMenu()
    {
        //Choose what account to log into
        System.out.println("What type of account do you have?");
        System.out.println("1. Patient");
        System.out.println("2. Nurse");
        System.out.println("3. Doctor");

        int typeOfAccount = intScanner.nextInt();

        switch(typeOfAccount) {
            case 1: //PATIENT
                System.out.println("What would you like to do?\n1.Log in\n2.Create an Account");
                int logIn = scanner.nextInt();

                if(logIn == 1){ //Log into account
                    logInPatient();
                }
                else if(logIn == 2){ //Create an Account
                    createPatientAccount();
                    updateJSON();

                }
                break;
            case 2: //NURSE
                logInNurse();

                break;
            case 3: //DOCTOR
                logInDoctor();
                break;
            default:
                System.out.println("Incorrect input. Please try again.");
        }
    }

    public static void createPatientAccount(){
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
            if (db.getPatientList().get(i).getUsername().equals(username)) {
                flag = 1;
                break;
            }

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

    public static void logInPatient(){
        int flag = 0;
        int index = -1; //If log-in successful, store index of patient in database
        while (flag == 0) {

            System.out.println("Username:");
            String username = scanner.next().toLowerCase(Locale.ROOT);

            System.out.println("Password:");
            String password = scanner.next().toLowerCase(Locale.ROOT);

            for(int i = 0; i< db.getPatientList().size(); i++){
                if(username.equals(db.getPatientList().get(i).getUsername().toLowerCase(Locale.ROOT))
                        && password.equals(db.getPatientList().get(i).getPassword())){
                    System.out.println("Log in successful");
                    flag = 1;
                    index = i;
                }
            }

            if(flag == 0){
                System.out.println("This is not a correct username/password combination.\nPlease try again.");
            }
            else {//load patient home page
                patientHomePage(index);
            }
        }
    }

    public static void logInNurse(){
        int flag = 0;
        while (flag == 0) {

            System.out.println("Username:");
            String username = scanner.next().toLowerCase(Locale.ROOT);

            System.out.println("Password:");
            String password = scanner.next().toLowerCase(Locale.ROOT);

            for(int i = 0; i< db.getPatientList().size(); i++){
                if(username.equals(db.getNursesList().get(i).getUsername().toLowerCase(Locale.ROOT))
                        && password.equals(db.getNursesList().get(i).getPassword())){
                    System.out.println("Log in successful");
                    flag = 1;
                }
            }

            if(flag == 0){
                System.out.println("This is not a correct username/password combination.\nPlease try again.");
            }
            else if(flag == 1) { //Load nurse home page

            }
        }
    }

    public static void logInDoctor(){
        int flag = 0;
        while (flag == 0) {

            System.out.println("Username:");
            String username = scanner.next().toLowerCase(Locale.ROOT);

            System.out.println("Password:");
            String password = scanner.next().toLowerCase(Locale.ROOT);

            for(int i = 0; i< db.getPatientList().size(); i++){
                if(username.equals(db.getDoctorsList().get(i).getUsername().toLowerCase(Locale.ROOT))
                        && password.equals(db.getDoctorsList().get(i).getPassword())){
                    System.out.println("Log in successful");
                    flag = 1;
                }
            }

            if(flag == 0){
                System.out.println("This is not a correct username/password combination.\nPlease try again.");
            }
            else if (flag==1){//Load Doctor home page

            }
        }
    }

    public static void patientHomePage(int index){
        int flag = 0;
        while(flag == 0) {
            System.out.println("What would you like to do?\n" +
                    "1. View Upcoming Visits\n" +
                    "2. View Past Visits\n" +
                    "3. View Prescriptions\n" +
                    "4. View Messages\n" +
                    "5. Send Message\n" +
                    "6. View Your Doctor\n" +
                    "7. View Your Profile\n" +
                    "8. Add an appointment\n" +
                    "0. Log Out\n");

            int menuInput = intScanner.nextInt();
            switch (menuInput) {
                case 0: //Log Out
                    flag = 1;
                    logInMenu();
                    break;
                case 1:
                    //View Upcoming Visits
                    for (int i = 0; i < db.getAppointments().size(); i++)
                        //Goes through all appointments and prints the one the patient is in.
                        if(db.getPatientList().get(index).getUsername().equals(db.getAppointments().get(i).getPatientUsername()) && db.getAppointments().get(i).getUpcoming())
                            System.out.println(db.getAppointments().get(i).upcomingAppointmentToString());
                    break;
                case 2: //View Past Visits
                    for (int i = 0; i < db.getAppointments().size(); i++)
                        if(db.getPatientList().get(index).getUsername().equals(db.getAppointments().get(i).getPatientUsername()) && !db.getAppointments().get(i).getUpcoming())
                            System.out.println(db.getAppointments().get(i).pastAppointmentToString());
                    break;
                case 3://View Prescriptions
                    for (int i = 0; i < db.getPatientList().get(index).getPrescriptionList().size(); i++)
                        System.out.println(db.getPatientList().get(index).getPrescription(i).toString());
                    break;
                case 4://View Messages
                    for(int i =0; i < db.getPatientList().get(index).getMessages().size(); i++)
                        System.out.println(db.getPatientList().get(index).getMessages().get(i).toString());
                    break;
                case 5: //Send a message
                    sendMessage(db.getPatientList().get(index).getUsername());
                    break;
                case 6://View Doctor
                    int docIndex = -1;
                    for(int i = 0; i < db.getDoctorsList().size(); i++){
                        if(db.getDoctorsList().get(i).getUsername() == db.getPatientList().get(index).getDoctor()){
                            docIndex = i;
                        }
                    }
                    System.out.println(db.getDoctorsList().get(docIndex).toString());
                    break;
                case 7://View Profile
                    System.out.println(db.getPatientList().get(index).toString());
                    break;
                case 8: //add an appointment
                    patientAddAppointment(index);
                    updateJSON();
                    break;
            }
        }




    }

    public static void patientAddAppointment(int patientIndex){

        //Collect information regarding the appointment
        System.out.println("When will the appointment be?");
        String date = scanner.next();
        System.out.println("What time?");
        String time = scanner.next();
        scanner.nextLine();
        System.out.println("What is the reason for this appointment?");
        String concern = scanner.nextLine();

        //Create new appointment object.
        Appointments newAppointment = new Appointments();
        newAppointment.setUpcoming(true);
        newAppointment.setDate(date);
        newAppointment.setTime(time);
        newAppointment.setPatientUsername(db.getPatientList().get(patientIndex).getUsername());
        newAppointment.setDoctorUsername(db.getPatientList().get(patientIndex).getDoctor());
        newAppointment.setConcerns(concern);

        //Add appointment to appointments list and update JSON

        List<Appointments> temp = db.getAppointments();
        temp.add(newAppointment);
        db.setAppointments(temp);


    }
    public static void sendMessage(String senderUsername){
        int flag = 0;
        int type = -1; //-1 = undecided, 0 = patient, 1 = nurse, 2 = doctor
        int index = -1; //Index of the recipient in their respective category.
        String recipientUsername = "";


        //Get recipient username
        while(flag == 0) {

            System.out.println("Type recipient username:");
            recipientUsername = scanner.next();


            //Check all patients for username
            for(int i = 0; i < db.getPatientList().size(); i++){
                if(recipientUsername.equals(db.getPatientList().get(i).getUsername())) {
                    flag = 1; //User found
                    type = 0;
                    index = i;
                    break;
                }
            }

            //Check all nurses for username
            for(int i = 0; i < db.getNursesList().size(); i++){
                if(recipientUsername.equals(db.getNursesList().get(i).getUsername())) {
                    flag = 1; //User found
                    type = 1;
                    index = i;
                    break;
                }
            }

            //Check all Doctors for username
            for(int i = 0; i < db.getDoctorsList().size(); i++){
                if(recipientUsername.equals(db.getDoctorsList().get(i).getUsername())) {
                    flag = 1; //User found
                    type = 2;
                    index = i;
                    break;
                }
            }

            if(flag == 0)
                System.out.println("User not found, please try again.");
        }

        System.out.println("What is the subject of this e-mail?");
        String subject = scanner.next();
        System.out.println("What is the message you would like to send?");
        String message = scanner.next();

        //Create message object and fill information
        Message newMessage = new Message();

        newMessage.setMessage(message);
        newMessage.setRecipient(recipientUsername);
        newMessage.setSender(senderUsername);
        newMessage.setSubject(subject);

        //Add message to the correct user's account
        List<Message> placeholder = new ArrayList<>();
        switch(type){
            case 0: //Sending to a patient
                if(db.getPatientList().get(index).getMessages() == null) {
                    placeholder.add(newMessage);
                    db.getPatientList().get(index).setMessages(placeholder);
                }
                else {
                    placeholder = db.getPatientList().get(index).getMessages();
                    placeholder.add(newMessage);
                    db.getPatientList().get(index).setMessages(placeholder);
                }
                break;
            case 1: //Sending to a nurse
                if(db.getNursesList().get(index).getMessages() == null)
                {
                    placeholder.add(newMessage);
                    db.getNursesList().get(index).setMessages(placeholder);
                }
                else {
                    placeholder = db.getNursesList().get(index).getMessages();
                    placeholder.add(newMessage);
                    db.getNursesList().get(index).setMessages(placeholder);
                }
                break;
            case 2: //Sending to a doctor
                if(db.getDoctorsList().get(index).getMessages() == null){
                    placeholder.add(newMessage);
                    db.getDoctorsList().get(index).setMessages(placeholder);
                }
                else {
                    placeholder = db.getDoctorsList().get(index).getMessages();
                    placeholder.add(newMessage);
                    db.getDoctorsList().get(index).setMessages(placeholder);
                }
                break;
        }

        //Update JSON with new message data.
        updateJSON();
    }

    public static void updateJSON(){
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