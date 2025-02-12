module com.example.chessengineguiproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.chessengineguiproject to javafx.fxml;
    exports com.example.chessengineguiproject;
}