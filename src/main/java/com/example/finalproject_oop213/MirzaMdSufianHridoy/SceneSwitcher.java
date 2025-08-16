package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import com.example.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {
    public static Stage stage;

    public static void switchTo(String fxml, ActionEvent actionEvent) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            //nextStage.setTitle("Student View");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }

    public static void switchTo(String fxml) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
//            nextStage.setTitle("Student View");
            nextStage.setScene(nextScene);
            nextStage.show();
        } catch (Exception e) {
            //
        }

    }

}
