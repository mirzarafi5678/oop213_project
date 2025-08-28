package com.example;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.AppendableObjectOutputStream;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.CreateTicket;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.LaunchTrip;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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

         List<LaunchTrip> trips = new ArrayList<>();



//        LaunchTrip t1  = new LaunchTrip("211","11-03-2025",2200,6,"7:10AM","Chittagong","Dhaka");
//        LaunchTrip t2  = new LaunchTrip("112","12-03-2025",900,8,"5:10AM","Sylhet","Sylhet");
//        LaunchTrip t3  = new LaunchTrip("113","15-03-2025",1500,3,"11:10AM","Chadpur","Chittagong");
//        LaunchTrip t4  = new LaunchTrip("114","17-03-2025",1250,9,"9:10PM","Barishal","Dhaka");
//        LaunchTrip t5  = new LaunchTrip("115","09-02-2025",100,11,"11:50PM","Rangpur","Chadpur");
//        LaunchTrip t6  = new LaunchTrip("116","19-04-2025",1300,13,"8:30AM","Vola","Dhaka");
//        LaunchTrip t7  = new LaunchTrip("117","20-03-2025",1450,7,"6:45AM","Khulna","Dhaka");
//        LaunchTrip t8  = new LaunchTrip("118","21-03-2025",1800,5,"10:15AM","Cox’s Bazar","Chittagong");
//        LaunchTrip t9  = new LaunchTrip("119","22-03-2025",2000,6,"12:30PM","Dhaka","Barishal");
//        LaunchTrip t10 = new LaunchTrip("120","23-03-2025",950,4,"8:20AM","Sylhet","Dhaka");
//        LaunchTrip t11 = new LaunchTrip("121","24-03-2025",1600,9,"7:00PM","Chittagong","Khulna");
//        LaunchTrip t12 = new LaunchTrip("122","25-03-2025",1200,6,"5:40AM","Barishal","Rangpur");
//        LaunchTrip t13 = new LaunchTrip("123","26-03-2025",1750,8,"11:25AM","Dhaka","Chadpur");
//        LaunchTrip t14 = new LaunchTrip("124","27-03-2025",1400,7,"9:15AM","Khulna","Sylhet");
//        LaunchTrip t15 = new LaunchTrip("125","28-03-2025",1900,5,"4:45PM","Rangpur","Dhaka");
//        LaunchTrip t16 = new LaunchTrip("126","29-03-2025",2100,10,"6:00PM","Cox’s Bazar","Barishal");
//        LaunchTrip t17 = new LaunchTrip("127","30-03-2025",1350,11,"7:30AM","Dhaka","Khulna");
//        LaunchTrip t18 = new LaunchTrip("128","31-03-2025",2200,12,"10:50PM","Chittagong","Dhaka");
//        LaunchTrip t19 = new LaunchTrip("129","01-04-2025",1000,4,"3:25PM","Sylhet","Chittagong");
//        LaunchTrip t20 = new LaunchTrip("130","02-04-2025",1250,9,"9:05AM","Barishal","Vola");
//
//
//         trips.add(t1);  trips.add(t2);  trips.add(t3);  trips.add(t4);  trips.add(t5);
//        trips.add(t6);  trips.add(t7);  trips.add(t8);  trips.add(t9);  trips.add(t10);
//        trips.add(t11); trips.add(t12); trips.add(t13); trips.add(t14); trips.add(t15);
//        trips.add(t16); trips.add(t17); trips.add(t18); trips.add(t19); trips.add(t20);
//
//
//
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
//            for (LaunchTrip trip : trips) {
//                oos.writeObject(trip);
//
//            }
//            oos.close();
//
//
//        }
//        catch (IOException e){
//            //
//        }
        launch();



    }
}