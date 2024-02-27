module com.example.exercise22 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exercise22 to javafx.fxml;
    exports com.example.exercise22;
}