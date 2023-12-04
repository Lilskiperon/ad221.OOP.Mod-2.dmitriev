module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens lab11.Game to javafx.fxml;
    exports lab11.Game;
}