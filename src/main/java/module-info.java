module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens Modular_2  to javafx.fxml;
    exports Modular_2;
}