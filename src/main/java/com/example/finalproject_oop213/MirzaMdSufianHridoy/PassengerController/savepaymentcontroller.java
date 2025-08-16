package com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.*;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.mvcOFsavePayment;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class savepaymentcontroller {

    @javafx.fxml.FXML
    private TableColumn <mvcOFsavePayment,String>  BankSystemColumn;
    @javafx.fxml.FXML
    private TableColumn<mvcOFsavePayment,String> BankTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<mvcOFsavePayment,String> NumberColumn;
    @javafx.fxml.FXML
    private TextField HolderNameTF;
    @javafx.fxml.FXML
    private TableColumn <mvcOFsavePayment,String>HolderNameColumn;
    @javafx.fxml.FXML
    private TableColumn<mvcOFsavePayment,String> ExpirtDtaeColumn;
    @javafx.fxml.FXML
    private TextField NumberOrCardNoTF;
    @javafx.fxml.FXML
    private DatePicker ExpiryDateTF;
    @javafx.fxml.FXML
    private Label StatusShow;
    @javafx.fxml.FXML
    private TableView <mvcOFsavePayment>Tableview;
    @javafx.fxml.FXML
    private ComboBox <String>BankTypeComboBox;
    @javafx.fxml.FXML
    private TextField NameOfBankTF;
    @javafx.fxml.FXML
    void initialize (){
        BankTypeComboBox.getItems().addAll("Mobile Bnak","Card Bank");

        NumberColumn.setCellValueFactory( new PropertyValueFactory<mvcOFsavePayment,String>("numberorcardnum") );
        HolderNameColumn.setCellValueFactory( new PropertyValueFactory<mvcOFsavePayment,String>("holdername"));
        BankSystemColumn.setCellValueFactory( new PropertyValueFactory <mvcOFsavePayment,String>("nameofbanksystem"));
        ExpirtDtaeColumn.setCellValueFactory( new PropertyValueFactory<mvcOFsavePayment,String>("expirydate"));
        BankTypeColumn.setCellValueFactory( new PropertyValueFactory<mvcOFsavePayment,String>("banktype"));

    }



    @javafx.fxml.FXML
    public void DashboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/Passenger-Dashboard-page.fxml", actionEvent);


    }

    @javafx.fxml.FXML
    public void AddButton(ActionEvent actionEvent) {

        Alert aa = new Alert(Alert.AlertType.ERROR);
        if (HolderNameTF.getText().isEmpty() ||  NameOfBankTF.getText().isEmpty() || BankTypeComboBox.getValue()==null || ExpiryDateTF.getValue()==null){
            aa.setContentText("Fill up Everything");
            aa.show();
            return;
        }
//        String holdername, String banktype, String numberorcardnum, LocalDate expirydate, String nameofbanksystem

        mvcOFsavePayment data = new mvcOFsavePayment(HolderNameTF.getText(),
                BankTypeComboBox.getValue(),
                NumberOrCardNoTF.getText(),
                ExpiryDateTF.getValue(),NameOfBankTF.getText() );
//        addInList.addsavePayment(data);


        sessionmanager.latestuser.pass.add(data);
        PutObjectInBinFileOrTxtFile.updateUser(sessionmanager.latestuser);
        Tableview.getItems().add(data);
        StatusShow.setWrapText(true);
        StatusShow.setText("Successfully added");



    }

    @javafx.fxml.FXML
    public void loadDatabutton(ActionEvent actionEvent) {
       Tableview.getItems().clear();
        for (mvcOFsavePayment savepayment : sessionmanager.latestuser.pass.ss){
            Tableview.getItems().add(savepayment);

        }



    }
}
