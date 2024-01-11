module com.example.demo {
    requires javafx.controls;
    requires javafx.media;
    requires javafx.fxml;
    requires javafx.web;
    requires junit;
    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.trash;
    opens com.example.demo.trash to javafx.fxml;
}