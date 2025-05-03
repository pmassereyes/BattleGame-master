module test.battle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens test.battle to javafx.fxml;
    exports test.battle;
}