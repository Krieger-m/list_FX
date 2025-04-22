module com.krieger.list_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.krieger.list_fx to javafx.fxml;
    exports com.krieger.list_fx;
}