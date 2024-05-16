module org.example.lab2javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.opencsv;

    opens org.example.lab2javafx to javafx.fxml;
    exports org.example.lab2javafx;
}