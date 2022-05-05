package lab10.lab10simplearthmeticcalculatorpart1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

import org.kordamp.bootstrapfx.BootstrapFX;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Calculator");
        stage.setMinWidth(800);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.centerOnScreen();


        HBox hBox = new HBox();
        ListView listView = new ListView();
        VBox vBox = new VBox();
        GridPane gridPane = new GridPane();
        Label label = new Label();
        hBox.getChildren().addAll(listView, vBox);
        vBox.getChildren().addAll(label, gridPane);
        Scene  scene = new Scene(hBox);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}