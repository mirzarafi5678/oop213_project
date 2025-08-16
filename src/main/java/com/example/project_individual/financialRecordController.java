package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class financialRecordController
{
    @javafx.fxml.FXML
    private TextField investAmountTextfiled;
    @javafx.fxml.FXML
    private TextField searchPurposeTestfiled;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> investamountColumn;
    @javafx.fxml.FXML
    private TextField addAmountTextfiled;
    @javafx.fxml.FXML
    private DatePicker DatePicker;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> purposeColumn;
    @javafx.fxml.FXML
    private TextField RevenueTextfiled;
    @javafx.fxml.FXML
    private TableView<Financial_Record> statementTable;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> addAmountcolumn;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> datecolumn;
    @javafx.fxml.FXML
    private TextField purposeTextfiled;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> revenueColumn;

    public ArrayList<Financial_Record> listOfRecord = new ArrayList<>();
    Alert alert = new Alert(Alert.AlertType.WARNING);

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        addAmountcolumn.setCellValueFactory(new PropertyValueFactory<>("add_Amount"));
        investamountColumn.setCellValueFactory(new PropertyValueFactory<>("Invest_amount"));
        revenueColumn.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        purposeColumn.setCellValueFactory(new PropertyValueFactory<>("purpose"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // list1 = new ArrayList<>();
        File file = new File("financial.bin");
        List<Financial_Record> list1= PutBinFile.readAllObjects(file);
        statementTable.getItems().addAll(list1);



    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        statementTable.getItems().clear();
        String a = searchPurposeTestfiled.getText();
        for(Financial_Record s: listOfRecord){
            if(s.getPurpose().equals(a)){
                statementTable.getItems().add(s);
            }
        }
    }

    @javafx.fxml.FXML
    public void DeleteButton(ActionEvent actionEvent) {
        statementTable.getItems().clear();
    }

    @javafx.fxml.FXML
    public void AddButton(ActionEvent actionEvent) throws IOException {

        boolean digitFound = false;
        for(int i=0; i<purposeTextfiled.getText().length();i++){
            if(purposeTextfiled.getText().charAt(i)>='0' && purposeTextfiled.getText().charAt(i)<='9'){
                digitFound = true;
            }
        }

        if(purposeTextfiled.getText().isEmpty() ||
                addAmountTextfiled.getText().isEmpty() || digitFound ||
                DatePicker.getValue().isAfter(LocalDate.now())
                || investAmountTextfiled.getText().isEmpty()){
            alert.setContentText("Fill up the form properly.");
            alert.show();
        }
        else{
            Financial_Record financialRecordToBeAdded = new Financial_Record(
                    Integer.parseInt(addAmountTextfiled.getText()),
                    Integer.parseInt(investAmountTextfiled.getText()),
                    Integer.parseInt(RevenueTextfiled.getText()),
                    purposeTextfiled.getText(),
                    searchPurposeTestfiled.getText(),
                    DatePicker.getValue());

//            File file = new File("financial.bin");
//            boolean exist = file.exists();
//            try{
//                FileOutputStream fos = new FileOutputStream(file, true);
//                ObjectOutputStream oos = exist ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos);

//                oos.writeObject(financialRecordToBeAdded);
//                oos.close();
//                fos.close();
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//            ArrayList<sd> list = BinaryFIleHelper.readobjects(file


            statementTable.getItems().add(financialRecordToBeAdded);
            listOfRecord.add(financialRecordToBeAdded);

            File FinancialFile = new File("financial.bin");
            PutBinFile.saveObject(FinancialFile,financialRecordToBeAdded);




            alert.setContentText("Successfully added");
            alert.show();

            addAmountTextfiled.clear();
            investAmountTextfiled.clear();
            purposeTextfiled.clear();
            RevenueTextfiled.clear();
            searchPurposeTestfiled.clear();
        }




    }





    @javafx.fxml.FXML
    public void BackDashboard(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",actionEvent);

    }


}