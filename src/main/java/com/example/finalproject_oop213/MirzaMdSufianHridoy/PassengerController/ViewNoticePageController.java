package com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.LaunchTrip;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.NoticeMvc;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class ViewNoticePageController {
    @javafx.fxml.FXML
    private Label ShowNotice;
    @javafx.fxml.FXML
    private Label TotalNoticeShow;
    @javafx.fxml.FXML
    private TextField NoticeTF;

    @javafx.fxml.FXML
    void initialize(){

        String str="";
        int totalnum;
        str=PutObjectInBinFileOrTxtFile.getLastObjectFromBinaryFile("Notice.bin").toString();
        NoticeMvc a1=(NoticeMvc) PutObjectInBinFileOrTxtFile.getLastObjectFromBinaryFile("Notice.bin");
        totalnum =a1.count;

        TotalNoticeShow.setText(" "+String.valueOf(totalnum));
        ShowNotice.setWrapText(true);
        ShowNotice.setText(str);



    }


    @javafx.fxml.FXML
    public void DahboardButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/Passenger-Dashboard-page.fxml", actionEvent);


    }

    @javafx.fxml.FXML
    public void loadnoticebynumberbutton(ActionEvent actionEvent) {
        if (NoticeTF.getText().isEmpty()){
            Alert aa =new Alert(Alert.AlertType.ERROR);
            aa.setContentText("Please put number");
            aa.show();
            return;
        }


        NoticeMvc obj = null;
        File f2 = new File("Notice.bin");
        if (f2.exists()) {
            try (FileInputStream fis = new FileInputStream(f2);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                while (true) {
                    try {
                        NoticeMvc a1 = (NoticeMvc) ois.readObject();

                        if (a1.count == Integer.parseInt(NoticeTF.getText())) {
                            obj = a1;
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
        if (obj!=null){
            ShowNotice.setWrapText(true);
            ShowNotice.setText(obj.toString());
        }else{
            Alert aa =new Alert(Alert.AlertType.ERROR);
            aa.setContentText("Notice is not found");
            aa.show();
        }

    }
}
