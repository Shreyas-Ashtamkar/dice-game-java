module bits.h20240192.java.dicegame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires annotations;

    opens bits.h20240192.java.dicegame to javafx.fxml;
    exports bits.h20240192.java.dicegame;
}