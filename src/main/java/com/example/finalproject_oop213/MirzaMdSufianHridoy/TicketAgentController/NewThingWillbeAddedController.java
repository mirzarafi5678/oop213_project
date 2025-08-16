package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.LaunchTrip;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class NewThingWillbeAddedController {
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>EstimatedColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>PriceColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>DateColumn;
    @javafx.fxml.FXML
    private TableView <LaunchTrip>Tableview;
    @javafx.fxml.FXML
    private TextField RemoveTripTF;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>FromColumn;
    @javafx.fxml.FXML
    private TableColumn<LaunchTrip,String> ToColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>StartTimeColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>TripNumberColumn;
    @javafx.fxml.FXML
    private Label StatusShow;

    @javafx.fxml.FXML
    void initialize(){
        TripNumberColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("tripnumber"));
        FromColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("from"));
        ToColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("to"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("date"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("price"));
        EstimatedColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("estimatedhour"));
        StartTimeColumn.setCellValueFactory(new PropertyValueFactory<LaunchTrip,String>("starttime"));
    }


    Alert aa= new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    public void LoadDatabaseButton(ActionEvent actionEvent) {
        Tableview.getItems().clear();
        aa.setContentText("No content");
        File f = new File("LaunchInfo.bin");
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                while (true) {
                    try {
                        LaunchTrip trip = (LaunchTrip) ois.readObject();
                        System.out.println(trip.getTripnumber());
                        Tableview.getItems().add(trip);

                    } catch (EOFException e) {
                        break; // End of file
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Print exceptions for debugging
            }}else {
            aa.show();
        }
    }


    @javafx.fxml.FXML
    public void RemoveTripButton(ActionEvent actionEvent) {

        if ( RemoveTripTF.getText().isEmpty()){
            aa.setContentText("Put trip Number");
            aa.show();
            return;
        }


        boolean remove=PutObjectInBinFileOrTxtFile.removeALaunchTripFromBin(RemoveTripTF.getText());

        if (remove) {
            StatusShow.setWrapText(true);
            StatusShow.setText("Succesfully removed");

        }else {
            StatusShow.setWrapText(true);
            StatusShow.setText("Data is not in database");
        }


    }

    @javafx.fxml.FXML
    public void dashboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/TicketAgent-Dashboard-page.fxml", actionEvent);

    }
}
