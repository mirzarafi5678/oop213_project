package com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BuyLaunchTripPageController2 {
    @javafx.fxml.FXML
    private ComboBox <String> TypeOfSeatComboBox;
    @javafx.fxml.FXML
    private TableColumn<LaunchTrip,String> ToColumn;
    @javafx.fxml.FXML
    private TableView<LaunchTrip> TableviewShow;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String> StartTimeColumn;
    @javafx.fxml.FXML
    private ComboBox  <String> GenderComboBox;
    @javafx.fxml.FXML
    private TextField NeedBaseAmountTF;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>DateColumn;
    @javafx.fxml.FXML
    private TextField FullnameTF;
    @javafx.fxml.FXML
    private Label StatusShow;
    @javafx.fxml.FXML
    private TextField BkashNoTF;
    @javafx.fxml.FXML
    private TextField PhoneNoTF;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>FromColumn;
    @javafx.fxml.FXML
    private TextField TripNumberTF;
    @javafx.fxml.FXML
    private TextField NumberOfTicketTF;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>TripNumberColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>EstimatedHourColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>pricecolumn;

    @javafx.fxml.FXML
    void initialize(){

        GenderComboBox.getItems().addAll("Male", "Female");
        TypeOfSeatComboBox.getItems().addAll("Sitting Seats", "Chair Seats", "Berths");


        TripNumberColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("tripnumber"));
        FromColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("from"));
        ToColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("to"));
        StartTimeColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("starttime"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("date"));
        EstimatedHourColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("estimatedhour"));
        pricecolumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("price"));


    }


    @javafx.fxml.FXML
    public void loadtablebutton (ActionEvent actionEvent) {

        TableviewShow.getItems().clear();
        File f = new File("LaunchInfo.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    LaunchTrip trip = (LaunchTrip) ois.readObject();
//                    System.out.println(trip.getTripnumber());
                    TableviewShow.getItems().add(trip);

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




        @javafx.fxml.FXML
    public void BackDashboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/Passenger-Dashboard-page.fxml", actionEvent);


    }


    Alert aa= new Alert(Alert.AlertType.ERROR);

    @javafx.fxml.FXML
    public void ConfirmTicketButton(ActionEvent actionEvent) {

      if (FullnameTF.getText().isEmpty() || BkashNoTF.getText().isEmpty()||PhoneNoTF.getText().isEmpty()||
      NumberOfTicketTF.getText().isEmpty()|| GenderComboBox.getValue()==null || TypeOfSeatComboBox.getValue()==null||
      NeedBaseAmountTF.getText().isEmpty()|| TripNumberTF.getText().isEmpty()){
              Alert aa= new Alert(Alert.AlertType.ERROR);
              aa.setContentText("Fillup Properly");
              aa.show();
              return;

      }







        System.out.println("button worked");



        LaunchTrip obj = null;

        File f2 = new File("LaunchInfo.bin");
        if (f2.exists()) {
            try (FileInputStream fis = new FileInputStream(f2);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                while (true) {
                    try {
                        LaunchTrip trip = (LaunchTrip) ois.readObject();

                        if (trip.getTripnumber().equals(TripNumberTF.getText())) {
                            obj = trip;
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
        if (obj != null) {
            PassengerData datas = new PassengerData(
                    FullnameTF.getText(),
                    obj,
                    Integer.parseInt(NumberOfTicketTF.getText()),
                    Integer.parseInt(NeedBaseAmountTF.getText()),
                    TypeOfSeatComboBox.getValue(),
                    GenderComboBox.getValue(),
                    PhoneNoTF.getText(),
                    BkashNoTF.getText()

            );

            sessionmanager.latestuser.pass=datas;
            PutObjectInBinFileOrTxtFile.updateUser(sessionmanager.latestuser);
            PutObjectInBinFileOrTxtFile.overwriteTxtFile("passengerdata.txt",sessionmanager.latestuser.pass.style2());

//            addInList.addPassengerData(datas);
            StatusShow.setWrapText(true);
            StatusShow.setText("Successfully selected your trip . now go to payment options");

        } else {
            System.out.println("Trip not found!");




        }


    }

}

