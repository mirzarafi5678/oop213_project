package com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.sessionmanager;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class DownloaadSceneController {
    @javafx.fxml.FXML
    private Label ShowTheTicket;
    @javafx.fxml.FXML
    private Label StatusShow;

    @javafx.fxml.FXML
    void initialize(){
        if (sessionmanager.latestuser.pass == null) {
            ShowTheTicket.setWrapText(true);
            ShowTheTicket.setText( "No data of passenger" );
            return;

        }else{
            ShowTheTicket.setWrapText(true);
            ShowTheTicket.setText(sessionmanager.latestuser.pass.style2());
        }


    }


    @javafx.fxml.FXML
    public void SaveibTxtFileButton(ActionEvent actionEvent) {
        if (sessionmanager.latestuser.pass != null) {
            PutObjectInBinFileOrTxtFile.overwriteTxtFile("passengerdata.txt",sessionmanager.latestuser.pass.style2());
//            PutObjectInBinFileOrTxtFile.writeObjectInTxtFile("passengerdata.txt",addInList.bb.get(addInList.bb.size() - 1));
            StatusShow.setWrapText(true);
            StatusShow.setText("Show your ticket details at the counter manually. The counter staff will " +
                    "check your details and decide whether you will get th e ticket or not.");

        }else{

            StatusShow.setText("    Buy the Ticket Fiest ");
            return;
        }


    }
}
