package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;

public class SignUpPageController {
    @javafx.fxml.FXML
    private Label StatusShowLabel;
    @javafx.fxml.FXML
    private ComboBox <String> SelectUserComboBox;
    @javafx.fxml.FXML
    private TextField setUsernameTF;
    @javafx.fxml.FXML
    private TextField SetPasswordTF;
    Alert aa= new Alert(Alert.AlertType.ERROR);
//    ArrayList<alluserdata> arr1 = new ArrayList<>();
    @javafx.fxml.FXML
    void initialize(){
        SelectUserComboBox.getItems().addAll("Passenger","Ticket Agent","Financial Officer","Call Center Agent",
                 "Safety Inspector","Port Authority");

    }


    @javafx.fxml.FXML
    public void GoToLogInButton(ActionEvent actionEvent) throws IOException {

        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/login-page.fxml",actionEvent);


    }

    @javafx.fxml.FXML
    public void confirmButton(ActionEvent actionEvent) {
          if ( setUsernameTF.getText().isEmpty() || SetPasswordTF.getText().isEmpty() || SelectUserComboBox.getValue()==null ){
              aa.setContentText("Fill up EveryThing");
              aa.show();
              return;
          }
          alluserdata userdata = null;

        File f2 = new File("User.bin");
        if (f2.exists()) {
            try (FileInputStream fis = new FileInputStream(f2);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                while (true) {
                    try {
                        alluserdata t = (alluserdata) ois.readObject();

                        if (t.getSetUsername().equals(setUsernameTF.getText())) {
                            userdata = t;
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
            StatusShowLabel.setWrapText(true);
            StatusShowLabel.setText("This Username alreday used");



        }else {


            alluserdata datas =new alluserdata(
                    SetPasswordTF.getText(),

                    SelectUserComboBox.getValue(),
                    setUsernameTF.getText() );

            PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("User.bin",datas);
            System.out.println("added");
            StatusShowLabel.setWrapText(true);
            StatusShowLabel.setText("succesfully sign up .Now go log in page to your dashboard");

        }


    }
}
