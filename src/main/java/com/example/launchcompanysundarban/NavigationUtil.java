package com.example.launchcompanysundarban;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.WeakHashMap;

public class NavigationUtil {


    private static final Map<StackPane, Deque<Node>> HISTORY = new WeakHashMap<>();

    private static Deque<Node> historyFor(StackPane stack) {
        return HISTORY.computeIfAbsent(stack, k -> new ArrayDeque<>());
    }


    public static void loadCenter(String fxmlPath, StackPane centerStack) {
        try {
            Node previous = centerStack.getChildren().isEmpty() ? null : centerStack.getChildren().get(0);

            FXMLLoader loader = new FXMLLoader(NavigationUtil.class.getResource(fxmlPath));
            Node node = loader.load();

            if (previous != null) {
                historyFor(centerStack).push(previous);
            }
            centerStack.getChildren().setAll(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void goBack(StackPane centerStack) {
        Deque<Node> hist = historyFor(centerStack);
        if (!hist.isEmpty()) {
            Node prev = hist.pop();
            centerStack.getChildren().setAll(prev);
        }
    }


    public static void clearHistory(StackPane centerStack) {
        historyFor(centerStack).clear();
    }

    public static void loadScene(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(NavigationUtil.class.getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setMaximized(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadScene2(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(NavigationUtil.class.getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.centerOnScreen();
//            stage.setMaximized(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
