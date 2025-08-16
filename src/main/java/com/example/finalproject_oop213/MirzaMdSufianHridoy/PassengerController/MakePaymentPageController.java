package com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.sessionmanager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class MakePaymentPageController {
    @FXML
    private Label PriceofTicket;
    @FXML
    private TextField trxFiield;
    @FXML
    private Label StatusShow;
    @FXML
    private Label ticketDetails;

    @FXML
    void initialize(){

        ticketDetails.setWrapText(true);
        ticketDetails.setPrefWidth(400);
        ticketDetails.setStyle("-fx-font-size: 14px; -fx-padding: 10;");

        if (sessionmanager.latestuser.pass==null){
            ticketDetails.setText("Create passenger acc and buy ticket first");
            return;

        }

        if (sessionmanager.latestuser.pass.obj==null){
            ticketDetails.setText("Buy tickt first");
            return;

        }
        ticketDetails.setText(sessionmanager.latestuser.pass.obj.style1());


    }



    @FXML
    public void DashboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/Passenger-Dashboard-page.fxml",actionEvent);

    }

    @FXML
    public void ConfirmButton(ActionEvent actionEvent) {
        Alert aa= new Alert(Alert.AlertType.ERROR);

        if (sessionmanager.latestuser.pass==null){
            aa.setContentText("Buy ticket first");
            aa.show();
            return;
        }
        if (sessionmanager.latestuser.pass.obj==null){
            aa.setContentText("Buy ticket first");
            aa.show();
            return;
        }



        if (sessionmanager.latestuser.pass.boughtticket){
           aa.setContentText("You have already paid");
           aa.show();
           return;
        }


        if (trxFiield.getText().isEmpty()){
            aa.setContentText("Put trxId");
            aa.show();

        }else {

            sessionmanager.latestuser.pass.setBoughtticket(true);
            sessionmanager.latestuser.pass.setCancelticket(false);
            PutObjectInBinFileOrTxtFile.overwriteTxtFile("passengerdata.txt",sessionmanager.latestuser.pass.style2());

            PutObjectInBinFileOrTxtFile.updateUser(sessionmanager.latestuser);

//            addInList.bb.get(addInList.bb.size() - 1).setBoughtticket(true);
//            addInList.bb.get(addInList.bb.size() - 1).setCancelticket(false);
//            PutObjectInBinFileOrTxtFile.overwriteTxtFile("passengerdata.txt",addInList.bb.size() - 1);
//            need to put this thing in txt file


            StatusShow.setWrapText(true);
            StatusShow.setText("Thank you for buy the ticket. Print the downloaded ticket and Go " +
                    "to Ticket Counter manually to get your ticket by showing your printed pdf ");
        }

    }
    String  s2="";
    @FXML
    public void seePriceButton(ActionEvent actionEvent) {
        if (sessionmanager.latestuser.pass==null){
            PriceofTicket.setWrapText(true);
            PriceofTicket.setText("Create passenger acc and buy ticket first");
            return;}



        String S1="";

        if (sessionmanager.latestuser.pass.obj!=null) {
//            ticketDetails.setText( addInList.bb.get(addInList.bb.size() - 1).obj.toString());


        }else{

            PriceofTicket.setText("Buy tickt first");
            return;
        }
        int sum3 = 0;
        int sum1= sessionmanager.latestuser.pass.getNumberOfTicket() *
                sessionmanager.latestuser.pass.obj.price;

        int sum2= sessionmanager.latestuser.pass.needBaseCargoSpace * 20;

        if ( sessionmanager.latestuser.pass.typeOfSeat.equals("Sitting Seats") ){
             sum3 = sessionmanager.latestuser.pass.getNumberOfTicket() * 200;
             S1="The per person cost of your selected Sundarbans launch trip is "+sessionmanager.latestuser.pass.obj.price+" TK"+"\n"+"You have selected "
                     + sessionmanager.latestuser.pass.getNumberOfTicket() + " seats"+"\n"+"An additional "+ 200 +" TK applies for the selected Sitting Seats"+"\n"
             +"And cargo space is charged at "+20+ " TK per kg. You have taken " +sessionmanager.latestuser.pass.needBaseCargoSpace+ " kg of space."+"\n";

        }
        if ( sessionmanager.latestuser.pass.typeOfSeat.equals("Chair Seats") ){
             sum3 = sessionmanager.latestuser.pass.getNumberOfTicket() * 100;
            S1= "The per person cost of your selected Sundarbans launch trip is "+sessionmanager.latestuser.pass.obj.price+" TK"+"\n"+"You have selected "
                    + sessionmanager.latestuser.pass.getNumberOfTicket() + " seats"+"\n"+"An additional "+ 100 +" TK applies for the selected Chair Seats"+"\n"
                    +"And cargo space is charged at "+20+ " TK per kg. You have taken " +sessionmanager.latestuser.pass.needBaseCargoSpace+ " kg of space."+"\n";
        }
        if ( sessionmanager.latestuser.pass.typeOfSeat.equals("Berths") ) {
             sum3 = sessionmanager.latestuser.pass.getNumberOfTicket() * 300;
            S1= "The per person cost of your selected Sundarbans launch trip is "+sessionmanager.latestuser.pass.obj.price+" TK"+"\n"+"You have selected "
                    + sessionmanager.latestuser.pass.getNumberOfTicket() + " seats"+"\n"+"An additional "+ 300 +" TK applies for the selected Berths Seats"+"\n"
                    +"And cargo space is charged at "+20+ " TK per kg. You have taken " +sessionmanager.latestuser.pass.needBaseCargoSpace+ " kg of space."+"\n";
        }

//        int totalPrice=0;
        int totalPrice=  sum1 +sum2 + sum3;
        sessionmanager.latestuser.pass.totalprice=totalPrice;
        PutObjectInBinFileOrTxtFile.updateUser(sessionmanager.latestuser);

//        addInList.bb.get(addInList.bb.size() - 1).setTotalprice(totalPrice);

        String str = S1+"Base Ticket Price: " + sum1 + "\n"
                + "Cargo Space Charge: " + sum2 + "\n"
                + "Seat Type Charge: " + sum3 + "\n"
                + "------------------------\n"
                + "Total Price: " + totalPrice;


        s2=str;

        PriceofTicket.setWrapText(true);
        PriceofTicket.setText(str);

    }

    @FXML
    public void printButton(ActionEvent actionEvent) {
        PutObjectInBinFileOrTxtFile.writeStringToTxtFile1("ticketdetails.txt",s2);
        StatusShow.setWrapText(true);
        StatusShow.setText("Printed");
    }
}
//"Sitting Seats", "Chair Seats", "Berths"