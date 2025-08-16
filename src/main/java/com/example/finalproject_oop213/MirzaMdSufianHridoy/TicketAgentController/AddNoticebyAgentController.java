package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.NoticeMvc;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class AddNoticebyAgentController {
    @javafx.fxml.FXML
    private Label StatusShow;
    @javafx.fxml.FXML
    private TextArea TextAreaTF;


    @javafx.fxml.FXML
    public void DashboardButton(ActionEvent actionEvent) throws IOException {

        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/TicketAgent-Dashboard-page.fxml", actionEvent);

    }
    @javafx.fxml.FXML
    public void AddButton(ActionEvent actionEvent) {

        Alert aa = new Alert(Alert.AlertType.ERROR);

        if (TextAreaTF.getText().isEmpty()) {
            aa.setContentText("Please type notice");
            aa.show();
            return;
        }

        int latestCount1 = 0;

        Object nn = PutObjectInBinFileOrTxtFile.getLastObjectFromBinaryFile("Notice.bin");

        if (nn != null) {
            NoticeMvc hh = (NoticeMvc) nn;
            latestCount1 = hh.count + 1;
            NoticeMvc N = new NoticeMvc(latestCount1, TextAreaTF.getText());


            PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("Notice.bin", N);

            StatusShow.setWrapText(true);
            StatusShow.setText("Notice added to database" + "\n" + "Total notice added " + latestCount1);
        } else {
            int num = 1;
            NoticeMvc N = new NoticeMvc(num, TextAreaTF.getText());


            PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("Notice.bin", N);

            StatusShow.setWrapText(true);
            StatusShow.setText("Notice added to database" + "\n" + "Total notice added " + num);
        }

    }

}
