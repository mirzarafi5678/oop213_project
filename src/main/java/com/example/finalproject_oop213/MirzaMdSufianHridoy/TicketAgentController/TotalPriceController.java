package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.CreateTicket;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.*;

public class TotalPriceController {
    @javafx.fxml.FXML
    private Label TotalPrice;
    @javafx.fxml.FXML
    private Label PassengerCount;
    @javafx.fxml.FXML
    private Label malecount;
    @javafx.fxml.FXML
    private Label femalecount;

    @javafx.fxml.FXML
    void initialize() {
        int count = 0;
        int Malecount=0;
        int Femalecount=0;
        File f2 = new File("CreatedByCounter.bin");

        if (f2.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f2))) {
                while (true) {
                    try {
                     CreateTicket cp =(CreateTicket)ois.readObject();
                     count++;
                     if (cp.gender.equals("Male")){
                         Malecount+=1;
                     }
                     if (cp.gender.equals("Female")){
                         Femalecount+=1;
                     }
                    } catch (EOFException eof) {
                        break; // End of file reached, break the loop
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        PassengerCount.setText("       "+ String.valueOf(count));
        malecount.setText("         "+ String.valueOf(Malecount));
        femalecount.setText("         "+ String.valueOf(Femalecount));

    }




    @javafx.fxml.FXML
    public void SeeTotalButton(ActionEvent actionEvent) {
        int tottalPrice = 0;
        File f2 = new File("CreatedByCounter.bin");
        if (f2.exists()) {
            File f = new File("CreatedByCounter.bin");
            try{
                FileInputStream fis = new FileInputStream(f);
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
        TotalPrice.setWrapText(true);
        TotalPrice.setText("Total revenue generated: " + tottalPrice  );

    }
}