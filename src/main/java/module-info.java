module fr.banalian.trackmaniabanalianstats {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens fr.banalian.trackmaniabanalianstats to javafx.fxml;
    exports fr.banalian.trackmaniabanalianstats;
}