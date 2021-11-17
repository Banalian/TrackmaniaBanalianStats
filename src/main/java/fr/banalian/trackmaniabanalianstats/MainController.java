package fr.banalian.trackmaniabanalianstats;

import fr.banalian.trackmaniabanalianstats.Data.COTDData;
import fr.banalian.trackmaniabanalianstats.json.JsonParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;

public class MainController {

    @FXML
    private Label totalCOTDLabel;

    @FXML
    private Button refreshButton;


    /**
     * Create a Json object from String url
     * @param urlToParse the string url to parse the json from
     */
    public JSONObject createJsonObjectFromUrl(String urlToParse) {
        JSONObject json = null;
        try {
            json = JsonParser.parseJsonFromUrl(urlToParse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }


    @FXML
    public void refresh(ActionEvent event) {
        JSONObject data =  createJsonObjectFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/0");
        totalCOTDLabel.setText(data.getString("total"));
    }


    @FXML
    public void initialize() {
        JSONObject data =  createJsonObjectFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/0");
        totalCOTDLabel.setText(String.valueOf(data.get("total")));
    }

    public void test(){
        COTDData cotdData = new COTDData(0,"Test COTD",548,32,7,0, LocalDateTime.now(),2500);
    }
}
