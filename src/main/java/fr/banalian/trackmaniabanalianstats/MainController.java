package fr.banalian.trackmaniabanalianstats;

import fr.banalian.trackmaniabanalianstats.json.JsonParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class MainController {

    @FXML
    private Label totalCOTDLabel;

    @FXML
    private Button refreshButton;

    private JsonParser jsonParser;

    /**
     * Create a Json object from String url
     * @param urlToParse the string url to parse the json from
     */
    public JSONObject createJsonObjectFromUrl(String urlToParse) {
        JSONObject json = null;
        try {
            json = jsonParser.parseJsonFromUrl(urlToParse);
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
        jsonParser = new JsonParser();
        JSONObject data =  createJsonObjectFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/0");
        totalCOTDLabel.setText(String.valueOf(data.get("total")));
    }
}
