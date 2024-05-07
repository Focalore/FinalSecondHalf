module com.example.finalsecondhalf {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalsecondhalf to javafx.fxml;
    exports com.example.finalsecondhalf;
}