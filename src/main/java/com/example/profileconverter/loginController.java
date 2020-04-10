package com.example.profileconverter;

import afester.javafx.svg.SvgLoader;
import com.jfoenix.animation.alert.JFXAlertAnimation;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private JFXButton loginButton;
    @FXML
    private TextField licenseKeyTextField;
    @FXML
    private JFXButton closeApplication;
    @FXML
    private JFXButton minimizeApplication;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        minimizeApplication.setGraphic(loadSVG("/md-remove.svg"));
        closeApplication.setGraphic(loadSVG("/ios-power.svg"));
    }


    private void openSecondScene() {
        try {
            Stage primaryStage = (Stage) (loginButton).getScene().getWindow();
            Parent mainPane = FXMLLoader.load(getClass().getResource("/main.fxml"));
            Scene mainScene = new Scene(mainPane);
            mainScene.setFill(Color.TRANSPARENT);
            mainPane.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            //move around here
            mainPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            });
            primaryStage.setTitle("example.com");
            primaryStage.setScene(mainScene);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    void errorMessage(Stage stage, String title, String text) {
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

    public void authenticateKey() {
        String REQUEST_URL = "https://api.example.com/auth/verify";
        try {
            HttpResponse<String> response = Unirest.post(REQUEST_URL)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("uuid", licenseKeyTextField.textProperty().getValue())
                    .asString();
            switch (response.getStatus()) {
                case 200:
                    openSecondScene();
                    break;
                case 422:
                    errorMessage((Stage) (loginButton).getScene().getWindow(), "Your License Key Is Incorrect.", "Your License Key is missing a character.");
                    break;
                case 429:
                    errorMessage((Stage) (loginButton).getScene().getWindow(), "Try Again Later", "You tried too many different Email/License Key combinations.");
                    break;
                case 404:
                    errorMessage((Stage) (loginButton).getScene().getWindow(), "License Key Not Found", "Your license key was not found");
                    break;
            }

        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    Group loadSVG(String path) {
        InputStream svgFile =
                getClass().getResourceAsStream(path);
        SvgLoader loader = new SvgLoader();
        Group svgImage = loader.loadSvg(svgFile);
        svgImage.setScaleX(0.07);
        svgImage.setScaleY(0.07);

        return new Group(svgImage);
    }

    public void minimizeApplication() {
        Stage stage = (Stage) minimizeApplication.getScene().getWindow();
        stage.setIconified(true);
    }

    public void closeApplication() {
        System.exit(0);
    }
}