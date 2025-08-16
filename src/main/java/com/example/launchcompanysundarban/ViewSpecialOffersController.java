package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class ViewSpecialOffersController {

    @FXML private Button backBtn;
    @FXML private Button loginBtn;

    @FXML private ListView<String> offersList;
    @FXML private TextArea offerDetails;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        loadOffers();
        NotificationManager.getNotifications().addListener((ListChangeListener<Notification>) c -> loadOffers());

        offersList.getSelectionModel().selectedItemProperty().addListener((obs, o, n) -> {
            offerDetails.setText(n == null ? "" : n);
        });
    }

    private void loadOffers() {
        List<String> promos = NotificationManager.getNotifications().stream()

                .map(Notification::getMessage)
                .filter(m -> m != null && (
                        m.toLowerCase().startsWith("fare/promo update") ||
                                m.toLowerCase().contains("fare:") ||
                                m.toLowerCase().contains("promo")
                ))
                .collect(Collectors.toList());

        if (promos.isEmpty()) {
            promos = List.of(" Eid Special Offer: 20% Off on All Trips!");
        }
        offersList.setItems(FXCollections.observableArrayList(promos));
        if (!promos.isEmpty()) {
            offersList.getSelectionModel().selectFirst();
        }
    }
}
