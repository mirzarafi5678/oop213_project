package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class loginPageController {


    @javafx.fxml.FXML
    private TextField usernameTF;
    @javafx.fxml.FXML
    private PasswordField passwordTF;
    @javafx.fxml.FXML
    private ComboBox<String> UserTypeComboBox;

    @javafx.fxml.FXML
    void initialize(){
        UserTypeComboBox.getItems().addAll("Passenger","Ticket Agent","Financial Officer","Call Center Agent",
               "Safety Inspector","Port Authority","Operation Manager");
    }

    @javafx.fxml.FXML
    public void SignUpButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/SignUp_page.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void logInButton(ActionEvent actionEvent) throws IOException {

        if (usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty() || UserTypeComboBox.getValue()==null){
            Alert AA = new Alert(Alert.AlertType.ERROR);
            AA.setContentText("Fill up properly");
            AA.show();
            return;
        }


        alluserdata userdata = null;

        File f2 = new File("User.bin");
        if (f2.exists()) {
            try (FileInputStream fis = new FileInputStream(f2);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                while (true) {
                    try {
                        alluserdata aa = (alluserdata) ois.readObject();

                        if (aa.getSetUsername().equals(usernameTF.getText()) && aa.getSetpassword().equals(passwordTF.getText())
                                && aa.getSetusertype().equals(UserTypeComboBox.getValue()) ) {
                            userdata = aa;
                            break;
                        }

                    } catch (EOFException eof) {
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (userdata!=null){
            if (userdata.getSetusertype().equals("Passenger")){
                SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/Passenger-Dashboard-page.fxml",actionEvent);
               sessionmanager.latestuser=userdata;
                System.out.println("moved");

                return;
            }
            if (userdata.getSetusertype().equals("Ticket Agent")){
                SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/TicketAgent-Dashboard-page.fxml",actionEvent);
                System.out.println("moved");
                return;
            }
            if (userdata.getSetusertype().equals("Financial Officer")){
                SceneSwitcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",
                        actionEvent);
                System.out.println("moved");
                return;
            }
            if (userdata.getSetusertype().equals("Call Center Agent")){
                SceneSwitcher.switchTo("/com/example/project_individual/AgentDashboard.fxml",
                        actionEvent);
                System.out.println("moved");
                return;
            }
            if (userdata.getSetusertype().equals("Operation Manager")){
                SceneSwitcher.switchTo("/com/example/launchcompanysundarban/OperationManagerDashboard.fxml",actionEvent);
                System.out.println("moved");
                return;
            }



        }
        else {
                Alert AA = new Alert(Alert.AlertType.ERROR);
                AA.setContentText("Username / Password / usertype is incorrect");
                AA.show();

        }

    }

    @javafx.fxml.FXML
    public void guestUserButton(ActionEvent actionEvent) throws IOException {

        SceneSwitcher.switchTo("/com/example/launchcompanysundarban/GuestUserDashboard.fxml",actionEvent);

    }
}
