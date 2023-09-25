module com.example.lifecalcfxml {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.lifecalcfxml to javafx.fxml;
    exports com.example.lifecalcfxml;
}