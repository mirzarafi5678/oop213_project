package com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.*;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewOtherTripController1 {
    @javafx.fxml.FXML
    private TableColumn<LaunchTrip,String> DateColumn;
    @javafx.fxml.FXML
    private Label StatusShow;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String >EstimatedJourneyHourColumn;
    @javafx.fxml.FXML
    private TableView <LaunchTrip >Tableview;
    @javafx.fxml.FXML
    private TextField LowestJourneyTF;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String >FromColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String >ToColumn;
    @javafx.fxml.FXML
    private TableColumn<LaunchTrip,String > StartTimeColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String >TripNumberColumn;

    @javafx.fxml.FXML
    void initialize(){
        TripNumberColumn.setCellValueFactory( new PropertyValueFactory<LaunchTrip,String>("tripnumber"));
        EstimatedJourneyHourColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("estimatedhour"));
        FromColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("from"));
        ToColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("to"));
        StartTimeColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("starttime"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("date"));

    }





    @javafx.fxml.FXML
    public void DahboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/Passenger-Dashboard-page.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void FilterButton(ActionEvent actionEvent) {
        Tableview.getItems().clear();
        int str= Integer.parseInt(LowestJourneyTF.getText());
        File f = new File("LaunchInfo.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    LaunchTrip trip = (LaunchTrip) ois.readObject();
                    if (trip.getEstimatedhour() <= str ){
                        Tableview.getItems().add(trip);
                    }


                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void ShowMyLaunchTripButton(ActionEvent actionEvent) {
        if (sessionmanager.latestuser.pass==null){
            StatusShow.setText("Buy tickt first");
            return;

        }


        if (sessionmanager.latestuser.pass.obj != null) {
//            ticketDetails.setText( addInList.bb.get(addInList.bb.size() - 1).obj.toString());

        }else{

            StatusShow.setText("Buy tickt first");
            return;
        }
        StatusShow.setWrapText(true);
        StatusShow.setText(sessionmanager.latestuser.pass.obj.toString());


    }

    @javafx.fxml.FXML
    public void LoadTableButton(ActionEvent actionEvent) {
        Tableview.getItems().clear();
        File f = new File("LaunchInfo.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    LaunchTrip trip = (LaunchTrip) ois.readObject();
//                    System.out.println(trip.getTripnumber());
                    Tableview.getItems().add(trip);

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

