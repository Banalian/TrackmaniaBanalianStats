package fr.banalian.trackmaniabanalianstats;

import fr.banalian.trackmaniabanalianstats.Data.COTDData;
import fr.banalian.trackmaniabanalianstats.Data.PlayerCOTDData;
import fr.banalian.trackmaniabanalianstats.utilities.JsonParser;
import fr.banalian.trackmaniabanalianstats.utilities.Serializer;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.json.JSONObject;

import java.io.IOException;
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

    @FXML
    private TreeView <String> treeView;

    /**
     * pattern used to format double values
     */
    private String avgPattern = "#.###";


    /**
     * Line chart to display the COTD ranks since the beginning
     */
    @FXML
    private LineChart<String, Integer> rankChart;




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

        Serializer serializer = new Serializer();
        PlayerCOTDData playerCOTDData = serializer.deserializePlayerCOTDData();

        if(playerCOTDData == null) {
            JSONObject data =  createJsonObjectFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89/cotd/0");
            playerCOTDData = JsonParser.createPlayerCOTDDataFromJSON(data);
        }else{
            System.out.println("PlayerCOTDData already exists");
            try {
               JsonParser.updatePlayerCOTDDataFromJSON(playerCOTDData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        setLabelsFromPlayerCOTDData(playerCOTDData);

        setRankChartData(playerCOTDData);

        setTreeViewData(playerCOTDData);

        serializer.serializePlayerCOTDData(playerCOTDData);

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

        bestDivRankLabel.setText("Best Division Rank : "+playerCOTDData.getBestOverallRank().getBestRankInDiv());

        DecimalFormat decimalFormat =  new DecimalFormat(avgPattern);
        avgRankLabel.setText("Average rank : "+decimalFormat.format(playerCOTDData.getAverageRank()*100)+"%");
        avgDivLabel.setText("Average Division : "+decimalFormat.format(playerCOTDData.getAverageDiv()));
        avgDivRankLabel.setText("Average Division Rank : "+Math.round(playerCOTDData.getAverageDivRank()*64));
    }

    /**
     * Sets the data for the rank Chart, using the playerCOTDData
     * @param playerCOTDData Data to set the rank chart from
     */
    private void setRankChartData(PlayerCOTDData playerCOTDData) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Ranks from COTD");

        for(COTDData cotdData : playerCOTDData.getCOTDArrayListData()) {

            //if you want to display the (Rank/Total Player)*100 data
            /*
            double rankPercentage = ((double)cotdData.getRank()/(double)cotdData.getTotalPlayers())*100;
            series.getData().add(new XYChart.Data(cotdData.getDate().toString(), rankPercentage));
            */

            //if you want to display the Rank data alone
            series.getData().add(new XYChart.Data(cotdData.getDate().toString(), cotdData.getRank()));
        }

        rankChart.getData().add(series);
    }

    /**
     * Sets the treeview to display the data from the playerCOTDData
     * @param playerCOTDData data to set the treeview from
     */
    private void setTreeViewData(PlayerCOTDData playerCOTDData) {


        TreeItem<String> root = new TreeItem<>("COTD Data");
        root.setExpanded(true);

        for(COTDData cotdData : playerCOTDData.getCOTDArrayListData()) {

            TreeItem<String > name = new TreeItem<>(cotdData.getName());
            //name.setExpanded(true);


            TreeItem<String> id = new TreeItem<>("Id : " + cotdData.getId());
            TreeItem<String> rank = new TreeItem<>("Rank : "+ cotdData.getRank());
            TreeItem<String> totalPlayers = new TreeItem<>("Total Players : "+ cotdData.getTotalPlayers());
            TreeItem<String> date = new TreeItem<>("Date" + cotdData.getDate().toString());
            TreeItem<String> division = new TreeItem<>("Division : "+ cotdData.getDivision());
            TreeItem<String> divisionRank = new TreeItem<>("Division Rank : "+ cotdData.getDivRank());
            TreeItem<String> score = new TreeItem<>("Score : "+ cotdData.getScore());





            name.getChildren().addAll(id, rank, totalPlayers, date, division, divisionRank, score);
            root.getChildren().add(name);
        }

        treeView.setRoot(root);
    }
}
