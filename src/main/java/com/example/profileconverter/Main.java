package com.example.profileconverter;

import com.jfoenix.animation.alert.JFXAlertAnimation;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        Scene profileConverterScene = new Scene(root);
        profileConverterScene.setFill(Color.TRANSPARENT);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        //move around here
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
        primaryStage.setTitle("example.com");
        primaryStage.setScene(profileConverterScene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    static void errorMessage(Stage stage, String title, String text) {
        Text text1 = new Text(title + "\n");
        text1.setStyle("-fx-font-size: 30; -fx-fill: black;");
        Text text2 = new Text(text);
        text2.setStyle("-fx-font-size: 20; -fx-fill: goldenrod;");
        JFXButton button = new JFXButton("Accept");
        BoxBlur blur = new BoxBlur(3, 3, 3);
        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setBody(new TextFlow(text1, text2));
        layout.setActions(button);
        JFXAlert<Void> alert = new JFXAlert<>(stage);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
            alert.close();
        });
        alert.setOverlayClose(true);
        alert.setAnimation(JFXAlertAnimation.CENTER_ANIMATION);
        alert.setContent(layout);
        alert.initModality(Modality.NONE);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

