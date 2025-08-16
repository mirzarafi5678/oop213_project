package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.CreateTicket;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class viewAllDataController {

    @javafx.fxml.FXML
    private TextField spacenumberTF;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>passengernamecolumn;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>tripnumbercolumn;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>cargospacecolumn;
    @javafx.fxml.FXML
    private Label showtotalbook;
    @javafx.fxml.FXML
    private TableColumn<CreateTicket,String> numberofseatcolumn;
    @javafx.fxml.FXML
    private TableView <CreateTicket>tableview;
    @javafx.fxml.FXML
    private Label nameshow;
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>contactnumbercolumn;
    @javafx.fxml.FXML
    private TableColumn<CreateTicket,String> totalpricecolumn1;
    @javafx.fxml.FXML
    private TableColumn<CreateTicket,String> seattypecolumn;
    Alert aa= new Alert(Alert.AlertType.ERROR);
    @javafx.fxml.FXML
    private TableColumn <CreateTicket,String>GenderColumn;

    @javafx.fxml.FXML

//    public String  nametf,tripnumber,gender,seattype;
//    public  int setid,cargosapce,numberofseat,contactnumber;
//    public LaunchTrip obj=null;
//    public int yourtotalprice=0;


    void initialize(){
        passengernamecolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("nametf"));
        contactnumbercolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("contactnumber"));
        totalpricecolumn1.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("yourtotalprice"));
        numberofseatcolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("numberofseat"));
        seattypecolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("seattype"));
        cargospacecolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("cargosapce"));
        tripnumbercolumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("tripnumber"));
        GenderColumn.setCellValueFactory(new PropertyValueFactory<CreateTicket,String>("gender"));



    }


    @javafx.fxml.FXML
    public void totalbookedbutton(ActionEvent actionEvent) {
        int totalbooking=0;
        File f = new File("CreatedByCounter.bin");

        if (f.exists()){try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                CreateTicket cp=(CreateTicket)ois.readObject();
                totalbooking+=cp.numberofseat;
            }
        }
        catch(Exception e){
            //
        }
        }else {
            aa.setContentText("Database is empty");
            aa.show();
            return;
        }
        showtotalbook.setText(" "+totalbooking);


    }

    @javafx.fxml.FXML
    public void filterbutton(ActionEvent actionEvent) {
        if (spacenumberTF.getText().isEmpty()){
            Alert aa=new Alert(Alert.AlertType.ERROR);
            aa.setContentText("put value");
            aa.show();
            return;

        }

        tableview.getItems().clear();
        System.out.println("button working");
        File f = new File("CreatedByCounter.bin");
        if (f.exists()){try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                CreateTicket cp=(CreateTicket)ois.readObject();
                if (cp.cargosapce <= Integer.parseInt(spacenumberTF.getText())){
                    tableview.getItems().add(cp);
                }
            }
        }
        catch(Exception e){
            //
        }
        }else {
            aa.setContentText("Database is empty");
            aa.show();
        }
    }

    @javafx.fxml.FXML
    public void loadtablebutton(ActionEvent actionEvent) {
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
    public void hightspaidnamebutton(ActionEvent actionEvent) {
        int max=0 ;
        String str="";
        File f = new File("CreatedByCounter.bin");
        if (f.exists()){try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                CreateTicket cp=(CreateTicket)ois.readObject();
                if (cp.yourtotalprice >= max){
                    max=cp.yourtotalprice;
                    str=cp.nametf;
                }
            }
        }
        catch(Exception e){
            //
        }
        }else {

            aa.setContentText("Database is empty");
            aa.show();
            return;
        }

        nameshow.setText(" "+str);


    }


    @javafx.fxml.FXML
    public void dashboardbutton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/TicketAgent-Dashboard-page.fxml", actionEvent);
    }
}
