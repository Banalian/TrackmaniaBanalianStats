package fr.banalian.trackmaniabanalianstats;

import fr.banalian.trackmaniabanalianstats.Data.COTDData;
import fr.banalian.trackmaniabanalianstats.Data.PlayerCOTDData;
import fr.banalian.trackmaniabanalianstats.utilities.JsonParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.text.DecimalFormat;

public class MainController {

    /**
     * ==================================
     * LABELS
     * ==================================
     */

    @FXML
    private Label participationLabel;

    @FXML
    private Label winsLabel;

    @FXML
    private Label bestRankLabel;

    @FXML
    private Label bestDivLabel;

    @FXML
    private Label bestDivRankLabel;

    @FXML
    private Label avgRankLabel;

    @FXML
    private Label avgDivLabel;

    @FXML
    private Label avgDivRankLabel;

    /**
     * pattern used to format double values
     */
    private String avgPattern = "#.###";


    /**
     * Line chart to display the COTD ranks since the beginning
     */
    @FXML
    private LineChart<LocalDateTime, Integer> rankChart;




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
    public void initialize() {
        JSONObject data =  createJsonObjectFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/0");
        //totalCOTDLabel.setText(String.valueOf(data.get("total")));
        PlayerCOTDData playerCOTDData = JsonParser.createPlayerCOTDDataFromJSON(data);
        setLabelsFromPlayerCOTDData(playerCOTDData);
    }


    /**
     * Sets all the labels from the ui, using the playerCOTDData
     * @param playerCOTDData data to set the labels from
     */
    public void setLabelsFromPlayerCOTDData(PlayerCOTDData playerCOTDData) {
        participationLabel.setText("Participation : "+playerCOTDData.getTotalParticipation());

        winsLabel.setText("Total Wins : "+playerCOTDData.getTotalDivWins());

        bestRankLabel.setText("Best Rank : "+playerCOTDData.getBestOverallRank().getBestRank());

        bestDivLabel.setText("Best Division : "+playerCOTDData.getBestOverallRank().getBestDiv());

        bestDivRankLabel.setText("Best Division Rank : "+playerCOTDData.getBestOverallRank().getBestDivRank());

        DecimalFormat decimalFormat =  new DecimalFormat(avgPattern);
        avgRankLabel.setText("Average rank : "+decimalFormat.format(playerCOTDData.getAverageRank()*100)+"%");
        avgDivLabel.setText("Average Division : "+decimalFormat.format(playerCOTDData.getAverageDiv()));
        avgDivRankLabel.setText("Average Division Rank : "+Math.round(playerCOTDData.getAverageDivRank()*64));
    }
}
