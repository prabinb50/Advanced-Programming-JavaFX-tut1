package org.example.lab2javafx;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileReader;
import java.io.FileWriter;

public class HelloController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private RadioButton radioMale;

    @FXML
    private RadioButton radioFemale;

    @FXML
    private ChoiceBox<String> nation;

    @FXML
    private Label userINFO;

    @FXML
    private String gender;

    @FXML
    private TextField loginEmail;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Label loginINFO;


    String pathToCSV = "src/main/resources/userData.csv";

    @FXML
    public void initialize() {
        nation.getItems().addAll("Nepal", "India", "China", "Australia");
    }

    @FXML
    public void onClick(){
        String userEmail = email.getText();
        String userPassword = password.getText();

        if (radioMale.isSelected()){
            gender = "Male";
        }else {
            gender = "Female";
        }
        String nationality = nation.getValue();

        String userInfoLabel = "Email: " + userEmail + "\n" +
                "Gender: " + gender + "\n" +
                "Nationality: " + nationality;
        userINFO.setText(userInfoLabel);

        try {
            FileWriter filterWriter = new FileWriter(pathToCSV, true);
            CSVWriter csvWriter = new CSVWriter(filterWriter);
            String[] data = {userEmail, userPassword, gender, nationality};
            csvWriter.writeNext(data);
            csvWriter.close();
        }catch (Exception e){
            userINFO.setText(e.getMessage());


        }


    }
    @FXML
    public void onloginClick(){
        String emailText = loginEmail.getText();
        String passwordText = loginPassword.getText();

        try {
            FileReader fileReader = new FileReader(pathToCSV);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] rows;
            while ((rows = csvReader.readNext())!=null){
                if (emailText.equals(rows[0]) && passwordText.equals(rows[1])){
                    loginINFO.setText("logged in");
                    break;
                }
                else{
                    loginINFO.setText("Invalid");
                }

            }
        }catch (Exception e){

        }

    }


}



