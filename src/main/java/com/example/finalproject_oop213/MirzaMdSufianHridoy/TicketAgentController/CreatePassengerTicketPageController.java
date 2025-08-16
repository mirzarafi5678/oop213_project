package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.CreateTicket;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.LaunchTrip;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class CreatePassengerTicketPageController {
    @javafx.fxml.FXML
    private TableColumn<CreateTicket,String> NameColumn;
    @javafx.fxml.FXML
    private TextField ContactNumberTF;
    @javafx.fxml.FXML
    private TextField NumberOfSeatTF;
    @javafx.fxml.FXML
    private ComboBox<String> GenderSelectComboBox;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>ContactNumberColumn;
    @javafx.fxml.FXML
    private TextField SetIdTF;
    @javafx.fxml.FXML
    private TextField CargoSpaceTF;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>IdColumn;
    @javafx.fxml.FXML
    private TextField TripNumberTF;
    @javafx.fxml.FXML
    private TextField NameTF;
    @javafx.fxml.FXML
    private TableView <CreateTicket>TableView;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String> TripNumberColumn;
    @javafx.fxml.FXML
    private ComboBox <String>SeatTypeComboBox;
    @javafx.fxml.FXML
    private Label status;

    @javafx.fxml.FXML
    void initialize(){
        GenderSelectComboBox.getItems().addAll("Male","Female");
        SeatTypeComboBox.getItems().addAll("Sitting Seats", "Chair Seats", "Berths");

        NameColumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("nametf"));
        ContactNumberColumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("contactnumber"));
        IdColumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("setid"));
        TripNumberColumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("tripnumber"));

    }


    @javafx.fxml.FXML
    public void DashboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/TicketAgent-Dashboard-page.fxml", actionEvent);


    }



    @javafx.fxml.FXML
    public void AddButton(ActionEvent actionEvent) {
        Alert aa = new Alert(Alert.AlertType.ERROR);

        if (GenderSelectComboBox.getValue()==null ||  SeatTypeComboBox.getValue()==null || ContactNumberTF.getText().isEmpty()
                || TripNumberTF.getText().isEmpty() || NameTF.getText().isEmpty() || CargoSpaceTF.getText().isEmpty()
                || SetIdTF.getText().isEmpty() || NumberOfSeatTF.getText().isEmpty() )   {

            aa.setContentText("Fillup Everything");
            aa.show();
            return;
        }

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
//        String nametf, LaunchTrip obj, int contactnumber, int numberofseat, int cargosapce,
//        int setid, String seattype, String gender, String tripnumber

        if (obj != null){
        CreateTicket p1 = new CreateTicket(NameTF.getText(),obj,Integer.parseInt(ContactNumberTF.getText() ),
                Integer.parseInt(NumberOfSeatTF.getText()),Integer.parseInt(CargoSpaceTF.getText()),Integer.parseInt(SetIdTF.getText()),
                SeatTypeComboBox.getValue(),GenderSelectComboBox.getValue(),TripNumberTF.getText());

            int TotalPrice=0;
            if (p1.seattype.equals("Sitting Seats")){
                TotalPrice+=(p1.numberofseat* 200) + (p1.numberofseat*p1.obj.price) + (p1.cargosapce * 20);
            }
            if (p1.seattype.equals("Chair Seats")){
                TotalPrice+=(p1.numberofseat* 100) + (p1.numberofseat*p1.obj.price) + (p1.cargosapce * 20);
            }
            if (p1.seattype.equals("Berths")){
                TotalPrice+=(p1.numberofseat* 300) + (p1.numberofseat*p1.obj.price) + (p1.cargosapce * 20);
            }


            p1.bigprice(TotalPrice);

            PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("CreatedByCounter.bin",p1);
            status.setWrapText(true);
            status.setText("Launch ticket available and added to database");
            TableView.getItems().add(p1);
        }else {
            status.setWrapText(true);
            status.setText("Launch ticket is no available");


        }

    }


    @javafx.fxml.FXML
    public void RewriteDtabaseButton(ActionEvent actionEvent) {
        File file = new File("CreatedByCounter.bin");

        if (file.exists()) {
            if (file.delete()) {
                status.setWrapText(true);
                status.setText("All data has been successfully removed. Now, add the new data to the database");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }



    }
}
