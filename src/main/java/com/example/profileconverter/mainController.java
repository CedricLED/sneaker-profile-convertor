package com.example.profileconverter;

import afester.javafx.svg.SvgLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    //These items are for the ChoiceBox example
    @FXML
    private TabPane tabpane;
    @FXML
    private Button minimizeApplication;
    @FXML
    private Button maximizeApplication;
    @FXML
    private Button closeApplication;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabpane.getTabs().get(0).setGraphic(loadTabImage("/GUIsettings.png"));
        tabpane.getTabs().get(1).setGraphic(loadTabImage("/GUIprofilegen.png"));
        tabpane.getTabs().get(2).setGraphic(loadTabImage("/GUIproxytester.png"));
        tabpane.getTabs().get(3).setGraphic(loadTabImage("/GUIproxygen.png"));
        tabpane.getTabs().get(4).setGraphic(loadTabImage("/GUIaccountgen.png"));
        minimizeApplication.setGraphic(loadSVG("/md-remove.svg"));
        maximizeApplication.setGraphic(loadSVG("/md-albums.svg"));
        closeApplication.setGraphic(loadSVG("/ios-power.svg"));
        tabpane.setTabMaxHeight(30);
        tabpane.setTabMaxWidth(70);
        tabpane.setTabMinHeight(30);
        tabpane.setTabMinWidth(70);
    }

    private ImageView loadTabImage(String path) {
        InputStream imageFile =
                getClass().getResourceAsStream(path);
        Image image = new Image(imageFile);
        ImageView iv = new ImageView(image);
        iv.setPreserveRatio(true);
        iv.setFitHeight(70);

        return iv;
    }

    private Group loadSVG(String path) {
        InputStream svgFile =
                getClass().getResourceAsStream(path);
        SvgLoader loader = new SvgLoader();
        Group svgImage = loader.loadSvg(svgFile);
        svgImage.setScaleX(0.05);
        svgImage.setScaleY(0.05);

        return new Group(svgImage);
    }

    public void minimizeApplication() {
        Stage stage = (Stage) minimizeApplication.getScene().getWindow();
        stage.setIconified(true);
    }

    public void maximizeApplication() {
        Stage stage = (Stage) minimizeApplication.getScene().getWindow();
        if (stage.isMaximized()) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }
    }

    public void closeApplication() {
        System.exit(0);
    }
}