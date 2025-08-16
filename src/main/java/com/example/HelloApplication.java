package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/SignUp_page.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {




//        LaunchTrip t1 = new LaunchTrip("211","11-03-2025",2200,6,"7:10AM","Chittagong","Dhaka");
//        LaunchTrip t2 = new LaunchTrip("112","12-03-2025",900,8,"5:10AM","Sylhet","Sylhet");
//        LaunchTrip t3 = new LaunchTrip("113","15-03-2025",1500,3,"11:10AM","Chadpur","Chittagong");
//        LaunchTrip t4 = new LaunchTrip("114","17-03-2025",1250,9,"9:10PM","Barishal","Dhaka");
//        LaunchTrip t5 = new LaunchTrip("115","9-02-2025",100,11,"11:50PM","Rangpur","Chadpur");
//        LaunchTrip t6 = new LaunchTrip("116","19-04-2025",1300,13,"8:30AM","Vola","Dhaka");
//
//
//        PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("LaunchInfo.bin", t1);
//
//        PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("newbinfile",t2);
//        PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("newbinfile",t3);
//        PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("newbinfile",t4);
//        PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("newbinfile",t5);
//        PutObjectInBinFileOrTxtFile.writeObjInBinaryFile("newbinfile",t6);
//
//        System.out.println(PutObjectInBinFileOrTxtFile.readObjFromBinaryFile("newbinfile"));




//
////
//        File f = new File("LaunchInfo.bin");
//        try{
//            FileOutputStream fos = null;
//            ObjectOutputStream oos = null;
//            if(f.exists()){
//                fos = new FileOutputStream(f, true);
//                oos = new AppendableObjectOutputStream(fos);
//            }
//            else{
//                fos = new FileOutputStream(f);
//                oos = new ObjectOutputStream(fos);
//            }
//
//            oos.writeObject(t1); oos.writeObject(t2);oos.writeObject(t3);oos.writeObject(t4);oos.writeObject(t5);oos.writeObject(t6);
//            oos.close();
//        }
//        catch (IOException e){
//            //
//        }
        launch();



    }
}