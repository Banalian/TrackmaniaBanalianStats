package fr.banalian.trackmaniabanalianstats;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;

public class PlayerTabController {

    @FXML
    private HBox hBoxTrophies;


    @FXML
    public void initialize() {

        //add i images to the hbox
        for (int i = 0; i < 9; i++) {
            ImageView imageView = new ImageView("file:img/trophies/" + i + ".png");
            SplitPane splitPanel = new SplitPane();
            splitPanel.setOrientation(Orientation.VERTICAL);
            splitPanel.setStyle("-fx-box-border: transparent;");

            splitPanel.getItems().add(imageView);
            splitPanel.getItems().add(new Label(String.valueOf(i)));
            //resize the image
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(64);
            imageView.setFitWidth(64);
            hBoxTrophies.getChildren().add(splitPanel);
        }
    }
}
