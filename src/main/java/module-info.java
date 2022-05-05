module lab10.lab10simplearthmeticcalculatorpart1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;


    opens lab10.lab10simplearthmeticcalculatorpart1 to javafx.fxml;
    exports lab10.lab10simplearthmeticcalculatorpart1;
}