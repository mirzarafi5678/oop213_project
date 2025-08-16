module com.example.finalproject_oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.base;
    requires transitive javafx.graphics;


    opens com.example.finalproject_oop213 to java.base, javafx.fxml;
    opens com.example.finalproject_oop213.MirzaMdSufianHridoy to javafx.fxml, java.base;
    opens com.example.finalproject_oop213.IsratJahan to javafx.fxml, java.base;
    opens com.example.finalproject_oop213.MirzaMdSufianHridoy.PassengerController to java.base, javafx.fxml;
    opens com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController to java.base, javafx.fxml;
    opens com.example.finalproject_oop213.ArifFaisal to javafx.fxml, java.base;
    opens com.example.finalproject_oop213.TouhidYash to javafx.fxml, java.base;


    opens com.example.launchcompanysundarban to javafx.fxml;


    opens com.example.project_individual to javafx.fxml;


    exports com.example;
    exports com.example.finalproject_oop213.MirzaMdSufianHridoy;
    exports com.example.launchcompanysundarban;
    exports com.example.project_individual;
    opens com.example to java.base, javafx.fxml;
}
