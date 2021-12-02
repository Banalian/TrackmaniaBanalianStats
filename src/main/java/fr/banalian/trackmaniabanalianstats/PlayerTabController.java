package fr.banalian.trackmaniabanalianstats;

import fr.banalian.trackmaniabanalianstats.Data.PlayerData;
import fr.banalian.trackmaniabanalianstats.utilities.JsonParser;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.json.JSONObject;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;

public class PlayerTabController {


    @FXML
    private VBox vBoxTrophies;

    @FXML
    private VBox vBoxRegion;

    @FXML
    private Label displayNameLabel;

    @FXML
    private Label clubTagLabel;

    @FXML
    private Label uuidLabel;

    @FXML
    private Label startedPlayingLabel;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    @FXML
    public void initialize() {

        try {
            JSONObject jsonObject = JsonParser.parseJsonFromUrl("https://trackmania.io/api/player/8ff2fad2-059d-4a9a-99d3-93861e2e8f89");
            PlayerData playerData = JsonParser.createPlayerDataFromJSON(jsonObject);
            setBoxTrophiesInfo(playerData);
            setBoxRegionInfo(playerData);
            setLabels(playerData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setLabels(PlayerData playerData){
        displayNameLabel.setText("Display name : " + playerData.getDisplayName());
        clubTagLabel.setText("Club tag : " + playerData.getClubTag());
        uuidLabel.setText("Account ID : " + playerData.getAccountId());
        startedPlayingLabel.setText("Started playing : " + playerData.getStartedPlaying().format(dateTimeFormatter));
    }


    public void setBoxTrophiesInfo(PlayerData playerData){
        //add i images to the vBoxTrophies, with 3 images per line
        HBox hBox = null;
        int[] trophies = playerData.getTrophiesTab();
        int trophyTabSize = trophies.length;
        for (int i = 0; i < 9; i++) {
            if(i%3 == 0) {
                //create a new HBox
                hBox = new HBox();
                vBoxTrophies.getChildren().add(hBox);
            }
            ImageView imageView = new ImageView("file:img/trophies/" + i + ".png");
            SplitPane splitPanel = new SplitPane();
            splitPanel.setOrientation(Orientation.VERTICAL);
            splitPanel.setStyle("-fx-box-border: transparent;");
            splitPanel.setMinWidth(100);

            splitPanel.getItems().add(imageView);
            Label label;
            if(i < trophyTabSize) {
                label = new Label(String.valueOf(trophies[i]));
            }else{
                label = new Label("0");
            }

            splitPanel.getItems().add(label);
            //resize the image
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(64);
            imageView.setFitWidth(64);
            hBox.getChildren().add(splitPanel);
        }
    }


    public void setBoxRegionInfo(PlayerData playerData){
        //use the region data from PlayerData to set a label/flag for each region

        ArrayList<String> regions = playerData.getZone();
        ArrayList<Integer> regionPosition = playerData.getZonePosition();

        for (int i = 0; i < regions.size(); i++) {
            ImageView imageView = new ImageView("file:img/zone/" + regions.get(i) + ".jpg");
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(64);

            SplitPane splitPanel = new SplitPane();
            splitPanel.setOrientation(Orientation.HORIZONTAL);
            splitPanel.setStyle("-fx-box-border: transparent;");

            splitPanel.getItems().add(imageView);

            Label labelName = new Label(regions.get(i) + " : ");
            splitPanel.getItems().add(labelName);

            int position = regionPosition.get(i);
            String endPosition;
            if(position%10 == 1){
                endPosition = "st";
            }else if(position%10 == 2){
                endPosition = "nd";
            }else if(position%10 == 3){
                endPosition = "rd";
            }else{
                endPosition = "th";
            }
            Label labelPlace = new Label(String.valueOf(position)+endPosition);

            splitPanel.getItems().add(labelPlace);

            vBoxRegion.getChildren().add(splitPanel);
        }
    }
}
