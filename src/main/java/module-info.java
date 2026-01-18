
module KeystormArena.fxcore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    opens KeystormArena.fxcore to javafx.fxml;
    exports KeystormArena.fxcore;
}
