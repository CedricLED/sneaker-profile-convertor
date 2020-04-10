package com.example.profileconverter;

import afester.javafx.svg.SvgLoader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class proxyTesterController implements Initializable {
    @FXML
    private JFXTreeTableView proxyTableView;
    @FXML
    private JFXComboBox proxySiteSelector;
    @FXML
    private JFXButton addProxiesButton;
    @FXML
    private JFXButton testProxiesButton;
    @FXML
    private JFXButton clearAllButton;

    private static final String KITH = "https://kith.com/";
    private static final String UNDEFEATED = "https://undefeated.com/";
    private static final String ADIDAS = "https://www.adidas.com/us";
    private static final String CONCEPTS = "https://cncpts.com/";
    private static final String XHIBITION = "https://www.xhibition.co/";
    private static final String JUICE = "https://juicestore.com/";

    Preferences applicationPrefs = Preferences.userRoot().node("com/example/profileconverter");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        proxySiteSelector.setEditable(true);
        proxySiteSelector.getItems().addAll(KITH, UNDEFEATED, ADIDAS, CONCEPTS, XHIBITION, JUICE);
        proxySiteSelector.setValue("Custom URL");
        addProxiesButton.setGraphic(loadSVG("/md-add-circle.svg"));
        testProxiesButton.setGraphic(loadSVG("/md-flash-white.svg"));
        clearAllButton.setGraphic(loadSVG("/md-flash-white.svg"));
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

}
