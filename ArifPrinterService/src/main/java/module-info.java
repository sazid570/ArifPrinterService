module com.example.arifprinterservice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.arifprinterservice to javafx.fxml;
    exports com.example.arifprinterservice;
}