package com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;


public class RateFeedbackPageController1 {
    @javafx.fxml.FXML
    private RadioButton radio9;
    @javafx.fxml.FXML
    private TextField WriteFeedbackTF;
    @javafx.fxml.FXML
    private RadioButton radio7;
    @javafx.fxml.FXML
    private RadioButton radio8;
    @javafx.fxml.FXML
    private RadioButton radio5;
    @javafx.fxml.FXML
    private RadioButton radio6;
    @javafx.fxml.FXML
    private RadioButton radio10;
    @javafx.fxml.FXML
    private RadioButton radio3;
    @javafx.fxml.FXML
    private RadioButton radio4;
    @javafx.fxml.FXML
    private RadioButton radio1;
    @javafx.fxml.FXML
    private RadioButton radio2;
    ToggleGroup tg1 = new ToggleGroup();
    ToggleGroup tg2 = new ToggleGroup();
    ToggleGroup tg3 = new ToggleGroup();
    ToggleGroup tg4 = new ToggleGroup();
    ToggleGroup tg5 = new ToggleGroup();


    @javafx.fxml.FXML
    void initialize(){
        radio1.setToggleGroup(tg1);radio2.setToggleGroup(tg1);
        radio3.setToggleGroup(tg2); radio4.setToggleGroup(tg2);
        radio5.setToggleGroup(tg3); radio6.setToggleGroup(tg3);
        radio7.setToggleGroup(tg4); radio8.setToggleGroup(tg4);
        radio9.setToggleGroup(tg5); radio10.setToggleGroup(tg5);

    }

    @javafx.fxml.FXML
    public void DashboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/Passenger-Dashboard-page.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void SubmitButton(ActionEvent actionEvent) {
        Alert aa = new Alert(Alert.AlertType.ERROR);
        Alert aa2 = new Alert(Alert.AlertType.INFORMATION);
        aa2.setTitle("Congratulations");

        if (sessionmanager.latestuser.pass==null){
            aa.setContentText("You cant give feedback because you did not buy ticket");
            aa.show();
            return;
        }

        if (sessionmanager.latestuser.pass.obj!=null) {

            //
        }
        else{
           aa.setContentText("You cant give feedback because you did not buy ticket");
           aa.show();
           return;
        }
        if ( tg1.getSelectedToggle()==null || tg2.getSelectedToggle()==null ||
                tg3.getSelectedToggle()==null || tg4.getSelectedToggle()==null ||
                tg5.getSelectedToggle()==null || WriteFeedbackTF.getText().isEmpty() ){

            aa.setContentText("Plz Give Feedback Properly");
            aa.show();
            return;
        }
        sessionmanager.latestuser.pass.setGivefeedback(true);
        PutObjectInBinFileOrTxtFile.overwriteTxtFile("passengerdata.txt",sessionmanager.latestuser.pass.style2());
        PutObjectInBinFileOrTxtFile.updateUser(sessionmanager.latestuser);
        aa2.setContentText(" Thanks for giving feedback. if u pay the money of ur selection ticket its good or if u dont pls make" +
                "payment of ur selected ticket ");
        aa2.show();

    }
}
