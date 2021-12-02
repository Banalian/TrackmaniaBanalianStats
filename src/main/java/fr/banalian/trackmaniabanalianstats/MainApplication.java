package fr.banalian.trackmaniabanalianstats;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 800);
        stage.setTitle("Banalian's stat tracker");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:img/icon.png"));
        stage.show();


        //to hide all the divider lines in the split pane from the profile tab
        for (Node node : scene.getRoot().lookupAll(".split-pane-divider")) {
            node.setVisible(false);
        }

    }

    public static void main(String[] args) {
        launch();
    }
}