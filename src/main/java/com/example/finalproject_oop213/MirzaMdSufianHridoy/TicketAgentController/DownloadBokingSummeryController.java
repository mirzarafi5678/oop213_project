package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.CreateTicket;
import com.example.finalproject_oop213.MirzaMdSufianHridoy.PutObjectInBinFileOrTxtFile;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class DownloadBokingSummeryController {
    @javafx.fxml.FXML
    private Label ShowDeatil;
    Alert aa= new Alert(Alert.AlertType.ERROR);

    String str1="";
    @javafx.fxml.FXML
    void initialize(){
        String str= "";
        int tottalPrice = 0;
        int totalbooking=0;
        File f1 = new File("CreatedByCounter.bin");

        if (f1.exists()){try{
            FileInputStream fis = new FileInputStream(f1);
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


        }
        File f2 = new File("CreatedByCounter.bin");
        if (f2.exists()) {
            File f = new File("CreatedByCounter.bin");
            try{
                FileInputStream fis = new FileInputStream(f2);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(true){
                    int perPrice=0;
                    CreateTicket cp= (CreateTicket) ois.readObject();
                    if (cp.seattype.equals("Sitting Seats")){
                        perPrice+= (cp.numberofseat* 200) + (cp.numberofseat*cp.obj.price) + (cp.cargosapce * 20);
                        tottalPrice+=perPrice;
                    }
                    if (cp.seattype.equals("Chair Seats")){
                        perPrice+= (cp.numberofseat* 100) + (cp.numberofseat* cp.obj.price) + (cp.cargosapce * 20);
                        tottalPrice+=perPrice;

                    }if (cp.seattype.equals("Berths")){
                        perPrice+= (cp.numberofseat* 300) + (cp.numberofseat* cp.obj.price) + (cp.cargosapce * 20);
                        tottalPrice+=perPrice;
                    }

                }
            }
            catch(Exception e){
                //
            }
        }
        str= PutObjectInBinFileOrTxtFile.readObjFromBinaryFile("CreatedByCounter.bin");
        str1="Total revenue generated: " + tottalPrice+ "\n"
                +"Toal booked seat: "+ totalbooking+"\n" + str;


        ShowDeatil.setWrapText(true);
        ShowDeatil.setText("Total revenue generated: " + tottalPrice+ "\n"
                             +"Toal booked seat: "+ totalbooking+"\n"+str);

    }






    @javafx.fxml.FXML
    public void Savebutton(ActionEvent actionEvent) {
        PutObjectInBinFileOrTxtFile.overwriteTxtFile("SummeryDeatails.txt",str1);
        Alert aa= new Alert(Alert.AlertType.INFORMATION);
        aa.setContentText("Saved in pdf");
        aa.show();




    }



}
