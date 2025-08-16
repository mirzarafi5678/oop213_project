package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalaryincreaseFxmlController
{
    @javafx.fxml.FXML
    private TableColumn<SalaryIncrease,String> amountColumn;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private TableView<SalaryIncrease> tableView;
    @javafx.fxml.FXML
    private TextField employeeIDTextField;
    @javafx.fxml.FXML
    private TableColumn<SalaryIncrease,String> employeeNameColumn;
    @javafx.fxml.FXML
    private TableColumn<SalaryIncrease,String> employeeIDColumn;
    @javafx.fxml.FXML
    private TextField salaryTextField;
    ArrayList<SalaryIncrease> salaryList = new ArrayList<>();
    Alert alert = new Alert(Alert.AlertType.WARNING);
    @javafx.fxml.FXML
    private TextField percentField;

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        File file = new File("salary.bin");
        List<SalaryIncrease> list5= PutBinFile.readAllObjects(file);
        tableView.getItems().addAll(list5);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) throws IOException {
        if (salaryTextField.getText().isEmpty()||employeeIDTextField.getText().isEmpty()||
             employeeNameTextField.getText().isEmpty()){
            alert.setContentText("Fill up the from properly");
        }
        double salary = Double.parseDouble(salaryTextField.getText());
        if (salary <=0){
            alert.show();
            return;
        }

        SalaryIncrease salaryadd = new SalaryIncrease(Integer.parseInt(employeeIDTextField.getText()),
                Double.parseDouble(salaryTextField.getText()),employeeNameTextField.getText());

        tableView.getItems().add(salaryadd);
        salaryList.add(salaryadd);

        File SalaryFile = new File("salary.bin");
        PutBinFile.saveObject(SalaryFile,salaryadd);

        salaryTextField.clear();
        employeeNameTextField.clear();
        employeeIDTextField.clear();



    }

    @javafx.fxml.FXML
    public void IncreaseSalary(ActionEvent actionEvent) {
        tableView.getItems().clear();
        double a = Double.parseDouble(percentField.getText());
        for(SalaryIncrease s: salaryList){
            if (s.getSalary() != a){
                tableView.getItems().add(s);
            }
        }
    }
}