package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.LaunchTrip;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class AddLaunchTripPageController {
    @javafx.fxml.FXML
    private TextField StartTimeTF;
    @javafx.fxml.FXML
    private TableView <LaunchTrip>Tableview;
    @javafx.fxml.FXML
    private TextField ToTF;
    @javafx.fxml.FXML
    private TextField PriceTF;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>ToColumn;
    @javafx.fxml.FXML
    private TableColumn<LaunchTrip,String> StartTimeColumn;
    @javafx.fxml.FXML
    private TextField FromTF;
    @javafx.fxml.FXML
    private TextField EstimatedTF;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>EstimatedColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>PriceColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>DateColumn;
    @javafx.fxml.FXML
    private Label StatusShow;
    @javafx.fxml.FXML
    private TextField DateTF;
    @javafx.fxml.FXML
    private TextField TripTF;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>FromColumn;
    @javafx.fxml.FXML
    private TableColumn <LaunchTrip,String>TripNumberColumn;
//     public String tripnumber, from, to, starttime;
//    public int estimatedhour, price;
//    public String date;
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
    public void AddDatabaseButton(ActionEvent actionEvent) {
             if ( TripTF.getText().isEmpty() || FromTF.getText().isEmpty() || DateTF.getText().isEmpty() || ToTF.getText().isEmpty()||
                      PriceTF.getText().isEmpty() || EstimatedTF.getText().isEmpty()|| StartTimeTF.getText().isEmpty()){
                 aa.setContentText("Fillup Everything");
                 aa.show();
                 return;
             }
//String tripnumber, String date, int price, int estimatedhour, String starttime,
//                      String to, String from
             LaunchTrip t = new LaunchTrip(TripTF.getText(),DateTF.getText(),Integer.parseInt(PriceTF.getText()),Integer.parseInt(EstimatedTF.getText()),
                     StartTimeTF.getText(),ToTF.getText(),FromTF.getText());
        PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("LaunchInfo.bin",t);
        StatusShow.setWrapText(true);
        StatusShow.setText("New data has been added to the database. Load the data to see the newly added entries");

    }




    @javafx.fxml.FXML
    public void DasboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/TicketAgent-Dashboard-page.fxml", actionEvent);
    }
}
