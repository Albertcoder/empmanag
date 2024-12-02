module com.example.empmanag {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.empmanag to javafx.fxml;
    exports com.example.empmanag;
}