package com.example.profileconverter;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


public class profileConverterController implements Initializable {

    @FXML
    private JFXComboBox<String> exportChooser;
    @FXML
    private Label importLabel;
    @FXML
    private Label exportFileLabel;
    @FXML
    private Button importButton;
    @FXML
    private Button saveAsButton;
    @FXML
    private TextField fileNameTextField;

    private static File selectedFile;
    private static File selectedDirectory;
    private static final String PD = "PD";
    private static final String CYBER = "Cyber";
    private static final String CANDYPREME = "Candypreme";
    private static final String GHOST = "Ghost";
    private static final String SUPREME_SLAYER = "SupremeSlayer";
    private static final String PHANTOM = "Phantom";
    private static final String HASTEY = "Hastey";
    private static final String TRIP = "Trip";
    private static final String NIKE_SHOE_BOT = "NikeShoeBot";
    private static final String DASHE = "Dashe";
    private static final String BNB_AIO = "BNB AIO";
    private static final String BNB_NIKE = "BNB Nike";
    private static final String ALERTMESSAGE = "It seems we don't currently support this bot, please contact us through our site so we can add it.";
    private static final String ALERTTITLE = "File Wasn't Recognized As A Bot Profile";
    private static final String EVE = "EVE";

    private Preferences applicationPrefs = Preferences.userRoot().node("com/example/profileconverter");

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //exportChooser.getItems().addAll(PD, CYBER, DASHE, CANDYPREME, GHOST, SUPREME_SLAYER, PHANTOM, HASTEY, TRIP, NIKE_SHOE_BOT, BNB_AIO, BNB_NIKE, EVE);
        exportChooser.getItems().addAll(GHOST, PHANTOM, HASTEY, TRIP, NIKE_SHOE_BOT, BNB_AIO, BNB_NIKE, EVE, PD, CANDYPREME, DASHE, SUPREME_SLAYER);
        exportChooser.setValue("PHANTOM");
    }

    public void importFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Bot Profiles (csv, json, xml, txt)", "*.csv", "*.json", "*.xml", "*.txt");
        chooser.getExtensionFilters().add(extFilter);
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        selectedFile = chooser.showOpenDialog(importButton.getScene().getWindow());
        if (selectedFile != null) {
            String fileName = selectedFile.getName();
            importLabel.setText(fileName);
        }
    }

    public void saveAsFile() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose Folder");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        selectedDirectory = chooser.showDialog(saveAsButton.getScene().getWindow());
        if (selectedDirectory != null) {
            exportFileLabel.setText(selectedDirectory.getAbsolutePath());
        }
    }

    @SuppressWarnings("unchecked")
    private void jsonConversion(JSONArray array) {
        JSONObject profile = (JSONObject) array.get(0);
        if (profile.size() == 1) {
            // ANB, EVE
            if (profile.getOrDefault("ArrayOfBilling", null) != null) {
                //ANB
                //TODO fix this
                JSONArray anbArray = profileImports.anbImport(profile);
                exportFile(anbArray);
            } else if (profile.getOrDefault("ArrayOfProfile", null) != null) {
                //EVE
                JSONArray eveArray = profileImports.eveImport(profile);
                exportFile(eveArray);
            } else {
                // Cyber, CandyPreme, Dashe
                JSONObject info = (JSONObject) profile.get(profile.keySet().stream().findFirst().orElse(null));
                if (info.containsKey("card")) {
                    JSONArray dasheArray = profileImports.dasheImport(array);
                    exportFile(dasheArray);
                } else {
                    catchAllImport(array);
                }
            }
        } else {
            //Ghost 11, Hastey 16, NikeShoeBot 7, PD 8, Phantom 12, SupremeSlayer 6, Trip 15
            switch (profile.size()) {
                case 4:
                    if (profile.getOrDefault("tasks", "").toString().isEmpty()) {
                        catchAllImport(array);
                    } else {
                        JSONArray cyberArray = profileImports.cyberImport(array);
                        exportFile(cyberArray);
                    }
                    break;
                case 6:
                    if (profile.getOrDefault("locale", "").toString().isEmpty()) {
                        catchAllImport(array);
                    } else {
                        JSONArray sSArray = profileImports.supremeSlayerImport(array);
                        exportFile(sSArray);
                    }
                    break;
                case 7:
                    if (profile.getOrDefault("checkoutLimit", "").toString().isEmpty()) {
                        catchAllImport(array);
                    } else {
                        JSONArray nSBArray = profileImports.nikeShoeBotImport(array);
                        exportFile(nSBArray);
                    }
                    break;
                case 8:
                    if (profile.getOrDefault("id", "").toString().isEmpty()) {
                        catchAllImport(array);
                    } else {
                        JSONArray pdArray = profileImports.pdImport(array);
                        exportFile(pdArray);
                    }
                    break;
                case 11:
                    if (profile.getOrDefault("jigPhone", "").toString().isEmpty()) {
                        if (profile.getOrDefault("Same", "").toString().isEmpty()) {
                            catchAllImport(array);
                        } else {
                            JSONArray ghostArray = profileImports.ghostImport(array);
                            exportFile(ghostArray);
                        }
                    } else {
                        JSONArray pdArray1 = profileImports.pdImport(array);
                        exportFile(pdArray1);
                    }
                    break;
                case 12:
                    if (profile.getOrDefault("CCNumber", "").toString().isEmpty()) {
                        catchAllImport(array);
                    } else {
                        JSONArray phantomArray = profileImports.phantomImport(array);
                        exportFile(phantomArray);
                    }
                    break;
                case 15:
                    if (profile.getOrDefault("creditcardnumber", "").toString().isEmpty()) {
                        catchAllImport(array);
                    } else {
                        JSONArray tripArray = profileImports.tripImport(array);
                        exportFile(tripArray);
                    }
                    break;
                case 16:
                    if (profile.getOrDefault("cc_year", "").toString().isEmpty()) {
                        catchAllImport(array);
                    } else {
                        JSONArray hasteyArray = profileImports.hasteyImport(array);
                        exportFile(hasteyArray);
                    }
                    break;
                default:
                    catchAllImport(array);
                    break;
            }
        }

    }

    private void catchAllImport(JSONArray catchAllArray) {
        try {
            JSONObject profile = (JSONObject) catchAllArray.get(0);
            for (Iterator iterator = profile.keySet().iterator(); iterator.hasNext(); ) {
                String key = (String) iterator.next();
                JSONObject catchAllProfile = (JSONObject) profile.get(key);
                if (!catchAllProfile.getOrDefault("delivery", "").toString().isEmpty()) {
                    JSONArray cyberArrayAlt = profileImports.cyberImport(catchAllArray);
                    exportFile(cyberArrayAlt);
                } else if (!catchAllProfile.getOrDefault("phoneNumber", "").toString().isEmpty()) {
                    JSONArray cDArray = profileImports.candyPremeImport(catchAllArray);
                    exportFile(cDArray);
                }
            }
        } catch (Exception e) {
            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File Wasn't Recognized As A Bot Profile", "It seems we don't currently support this bot, please contact us through our site so we can add it. Support Code: SGX11");
        }
    }

    @SuppressWarnings("unchecked")
    public void convert() {
        if (selectedFile != null && !fileNameTextField.textProperty().getValue().isEmpty()) {
            String ext = selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".") + 1);
            switch (ext) {
                case ("csv"):
                    try (InputStream in = new FileInputStream(selectedFile)) {
                        JSONArray csvArray = new JSONArray();
                        CSV csv = new CSV(true, ',', in);
                        List<String> fieldNames = null;
                        if (csv.hasNext()) fieldNames = new ArrayList<>(csv.next());
                        while (csv.hasNext()) {
                            JSONObject csvProfile = new JSONObject();
                            List<String> x = csv.next();
                            for (int i = 0; i < fieldNames.size(); i++) {
                                csvProfile.put(fieldNames.get(i), x.get(i));
                            }
                            csvArray.add(csvProfile);
                        }
                        JSONArray masterCSVArray = profileImports.masterCSVImport(csvArray);
                        exportFile(masterCSVArray);
                    } catch (IOException e) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File Wasn't Recognized As A Bot Profile", "It seems we don't currently support this bot, please contact us through our site so we can add it. Support Code: SGX15");
                        e.printStackTrace();
                    }
                    break;
                case ("json"):
                    JSONParser parser = new JSONParser();
                    try {
                        if (parser.parse(new FileReader(selectedFile)) instanceof JSONObject) {
                            JSONObject obj = (JSONObject) parser.parse(new FileReader(selectedFile));
                            JSONArray a = new JSONArray();
                            a.add(obj);
                            jsonConversion(a);
                        } else if (parser.parse(new FileReader(selectedFile)) instanceof JSONArray) {
                            JSONArray a = (JSONArray) parser.parse(new FileReader(selectedFile));
                            jsonConversion(a);
                        } else {
                            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File Wasn't Recognized As A Bot Profile", "It seems we don't currently support this bot, please contact us through our site so we can add it. Support Code: SGX14");
                        }
                    } catch (IOException | ParseException | RuntimeException o) {
                        o.printStackTrace();
                    }
                    break;
                case ("xml"):
                    String xmlFile = selectedFile.getAbsolutePath();
                    try {
                        String xmlString = new String(Files.readAllBytes(Paths.get(xmlFile)));
                        org.json.JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
                        JSONParser xmlParser = new JSONParser();
                        try {
                            JSONObject Obj = (JSONObject) xmlParser.parse(xmlJSONObj.toString());
                            JSONArray a = new JSONArray();
                            a.add(Obj);
                            jsonConversion(a);
                        } catch (ParseException | RuntimeException e) {
                            e.printStackTrace();
                            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File Wasn't Recognized As A Bot Profile", "It seems we don't currently support this bot, please contact us through our site so we can add it. Support Code: SGX14");
                        }
                    } catch (IOException o) {
                        o.printStackTrace();
                    }
                    break;
                case ("txt"):
                    JSONParser txtParser = new JSONParser();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();

                        while (line != null) {
                            sb.append(line);
                            sb.append("\n");
                            line = br.readLine();
                        }
                        String content = sb.toString();
                        br.close();
                        JSONArray a = (JSONArray) txtParser.parse(content);
                        txtConversion(a);
                    } catch (IOException | ParseException e) {
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                            StringBuilder sb = new StringBuilder();
                            String line = br.readLine();

                            while (line != null) {
                                sb.append(line);
                                sb.append("\n");
                                line = br.readLine();
                            }
                            String content = sb.toString();
                            br.close();
                            JSONObject obj = (JSONObject) txtParser.parse(content);
                            JSONArray a = new JSONArray();
                            a.add(obj);
                            txtConversion(a);
                        } catch (IOException | ParseException | RuntimeException o) {
                            o.printStackTrace();
                            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File Wasn't Recognized As A Bot Profile", "It seems we don't currently support this bot, please contact us through our site so we can add it. Support Code: SGX14");
                        }
                    }
                    break;
                default:
                    Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File Wasn't Recognized As A Bot Profile", "It seems we don't currently support this bot, please contact us through our site so we can add it. Support Code: SGX12");
            }
        }
    }

    private void txtConversion(JSONArray array) {
        JSONObject profile = (JSONObject) array.get(0);
        // ANB, ANB AIO
        if (profile.containsKey("BillingDSMRegion")) {
            JSONArray bnbAIOArray = profileImports.bnbAIOImport(array);
            exportFile(bnbAIOArray);
        } else if (profile.containsKey("BillingAddress3")) {
            JSONArray bnbNikeArray = profileImports.bnbNikeImport(array);
            exportFile(bnbNikeArray);
        } else {
            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File Wasn't Recognized As A Bot Profile", "It seems we don't currently support this bot, please contact us through our site so we can add it. Support Code: SGX13");
        }

    }

    private void exportFile(JSONArray array) {
        array = profileSterilizer.universalProfileSterilizer(array);
        if (!array.isEmpty()) {
            switch (exportChooser.getValue()) {
                case (PD):
                    String pdPath = applicationPrefs.get("pd", null);
                    JSONArray pdArray = profileExports.pdExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONArrayFile(pdArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (CYBER):
                    String cyberPath = applicationPrefs.get("cyber", null);
                    JSONArray cyberArray = profileExports.cyberExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONArrayFile(cyberArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (PHANTOM):
                    String phantomPath = applicationPrefs.get("phantom", null);
                    JSONArray phantomArray = profileExports.phantomExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONArrayFile(phantomArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (HASTEY):
                    String hasteyPath = applicationPrefs.get("hastey", null);
                    JSONArray hasteyArray = profileExports.hasteyExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONArrayFile(hasteyArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (SUPREME_SLAYER):
                    String supremeSlayerPath = applicationPrefs.get("supreme_slayer", null);
                    JSONArray sSArray = profileExports.supremeSlayerExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONArrayFile(sSArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (CANDYPREME):
                    String candyPremePath = applicationPrefs.get("candy_preme", null);
                    JSONObject cDArray = profileExports.candyPremeExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONObjectFile(cDArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (DASHE):
                    String dashePath = applicationPrefs.get("dashe", null);
                    JSONObject dasheArray = profileExports.dasheExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONObjectFile(dasheArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (GHOST):
                    String ghostPath = applicationPrefs.get("ghost", null);
                    JSONArray ghostArray = profileExports.ghostExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONArrayFile(ghostArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (TRIP):
                    String tripPath = applicationPrefs.get("trip", null);
                    JSONArray tripArray = profileExports.tripExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONArrayFile(tripArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (NIKE_SHOE_BOT):
                    String nikeShowBotPath = applicationPrefs.get("nike_shoe_bot", null);
                    JSONArray nSBArray = profileExports.nikeShoeBotExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeJSONArrayFile(nSBArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (BNB_AIO):
                    String bnbAIOPath = applicationPrefs.get("bnb_aio", null);
                    JSONArray bnbAIOArray = profileExports.bnbAIOExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeTXTFile(bnbAIOArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (BNB_NIKE):
                    String bnbNikePath = applicationPrefs.get("bnb_nike", null);
                    JSONArray bnbNikeArray = profileExports.bnbNikeExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeTXTFile(bnbNikeArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                case (EVE):
                    String evePath = applicationPrefs.get("eve", null);
                    String eveArray = profileExports.eveExport(array);
                    if (selectedDirectory == null) {
                        Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "Please set save location in the Settings Tab!", "Set save location for the bot in the Settings Tab");
                    } else {
                        writeXMLFile(eveArray, selectedDirectory.getAbsolutePath());
                    }
                    break;
                default:
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText(ALERTTITLE);
                    errorAlert.setContentText(ALERTMESSAGE);
                    errorAlert.showAndWait();
            }
        } else {
            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File is missing information.", "A full name isn't present.");
        }
    }

    private void writeJSONArrayFile(JSONArray array, String path) {
        try (FileWriter file = new FileWriter(path + "\\" + fileNameTextField.textProperty().getValue() + ".json")) {
            String withoutBackSlash = array.toJSONString();
            withoutBackSlash = withoutBackSlash.replaceAll("\\\\", "");
            file.write(withoutBackSlash);
            importLabel.setText("");
            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File converted!", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJSONObjectFile(JSONObject object, String path) {
        try (FileWriter file = new FileWriter(path + "\\" + fileNameTextField.textProperty().getValue() + ".json")) {
            String withoutBackSlash = object.toJSONString();
            withoutBackSlash = withoutBackSlash.replaceAll("\\\\", "");
            file.write(withoutBackSlash);
            importLabel.setText("");
            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File converted!", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void writeTXTFile(JSONArray array, String path) {
        try (FileWriter file = new FileWriter(path + "\\" + fileNameTextField.textProperty().getValue() + ".txt")) {
            file.write(array.toJSONString());
            importLabel.setText("");
            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File converted!", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeXMLFile(String xml, String path) {
        try (FileWriter file = new FileWriter(path + "\\" + fileNameTextField.textProperty().getValue() + ".xml")) {
            file.write(xml);
            importLabel.setText("");
            Main.errorMessage((Stage) (saveAsButton).getScene().getWindow(), "File converted!", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
