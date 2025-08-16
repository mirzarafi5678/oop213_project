package com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class cancelTripLaunchController {
    @javafx.fxml.FXML
    private Label bookDetailShow;
    @javafx.fxml.FXML
    private Label SHowStatus;
    @javafx.fxml.FXML
    private TextField writeReasonTF;

    @javafx.fxml.FXML
    void initialize(){
        bookDetailShow.setWrapText(true);
        bookDetailShow.setPrefWidth(400);            // Set preferred width
        bookDetailShow.setStyle("-fx-font-size: 14px; -fx-padding: 10;");
        if(sessionmanager.latestuser.pass==null){
            bookDetailShow.setText("Buy ticket first");
            return;}

        if(sessionmanager.latestuser.pass.obj==null){
            bookDetailShow.setText("Buy tickt first");
            return;
        }
        bookDetailShow.setText(sessionmanager.latestuser.pass.style2());



//        if (addInList.bb.size() > 0 && addInList.bb.get(addInList.bb.size() - 1) != null) {
//            bookDetailShow.setText( addInList.bb.get(addInList.bb.size() - 1).obj.toString());
//
//        }else{
//
//            bookDetailShow.setText("Buy tickt first");
//        }


    }




    @javafx.fxml.FXML
    public void BackToDashbiardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/Passenger-Dashboard-page.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void CancelTicketButton(ActionEvent actionEvent) {
          if(sessionmanager.latestuser.pass==null){
              SHowStatus.setText("Buy ticket first");
              return;

          }



        if (sessionmanager.latestuser.pass.obj ==null){
            SHowStatus.setText("You did not confirm the ticket .So cant remove");
            return;
        }

        sessionmanager.latestuser.pass.obj=null;
        sessionmanager.latestuser.pass.setBoughtticket(false);
        sessionmanager.latestuser.pass.setCancelticket(true);
        sessionmanager.latestuser.pass.totalprice=0;
        PutObjectInBinFileOrTxtFile.overwriteTxtFile("passengerdata.txt",sessionmanager.latestuser.pass.style2());

        PutObjectInBinFileOrTxtFile.updateUser(sessionmanager.latestuser);
        SHowStatus.setText("Succesfully removes");



    }

}
