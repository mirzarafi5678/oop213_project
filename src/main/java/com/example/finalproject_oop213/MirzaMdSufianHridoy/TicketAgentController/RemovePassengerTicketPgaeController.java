package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.CreateTicket;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RemovePassengerTicketPgaeController {
    @javafx.fxml.FXML
    private TableColumn<CreateTicket,String> passengernamecolumn;
    @javafx.fxml.FXML
    private TextField PutIdTF;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>tripnumbercolumn;
    @javafx.fxml.FXML
    private TableColumn<CreateTicket,String> cargospacecolumn;
    @javafx.fxml.FXML
    private Label StatusShow;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>numberofseatcolumn;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>totalpricecolumn1;
    @javafx.fxml.FXML
    private TableView <CreateTicket>tableview;
    @javafx.fxml.FXML
    private TableColumn<CreateTicket,String> seattypecolumn;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>contactnumbercolumn;

    Alert aa= new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    private TableColumn<CreateTicket,String> IdColumn;

    @javafx.fxml.FXML
    void initialize(){
        passengernamecolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("nametf"));
        contactnumbercolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("contactnumber"));
        totalpricecolumn1.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("yourtotalprice"));
        numberofseatcolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("numberofseat"));
        seattypecolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("seattype"));
        cargospacecolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("cargosapce"));
        tripnumbercolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("tripnumber"));
        IdColumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("setid"));
    }


    @javafx.fxml.FXML
    public void DashboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/TicketAgent-Dashboard-page.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void loadButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        aa.setContentText("Database is empty");
        File f = new File("CreatedByCounter.bin");
        if (f.exists()){try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                tableview.getItems().add((CreateTicket)ois.readObject());
            }
        }
        catch(Exception e){
            //
        }
        }else {
            aa.show();
        }
    }

    @javafx.fxml.FXML
    public void removeButton(ActionEvent actionEvent) {

        if (PutIdTF.getText().isEmpty()){
            aa.setContentText("Please put passenger id");
            aa.show();
            return;
        }


        boolean remove=PutObjectInBinFileOrTxtFile.removeATicketFromBin(Integer.parseInt(PutIdTF.getText()));


        if (remove){
               StatusShow.setWrapText(true);
               StatusShow.setText("Successfully removed the passenger's all data from database. ");

        }else {
            StatusShow.setWrapText(true);
            StatusShow.setText("Passender's data is not in the database. ");
        }


    }
}
