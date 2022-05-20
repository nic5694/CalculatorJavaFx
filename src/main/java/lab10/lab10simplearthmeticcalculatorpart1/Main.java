package lab10.lab10simplearthmeticcalculatorpart1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import java.util.Objects;


public class Main extends Application {
    Label label;
    ListView<String> listView;
    boolean clicked = false;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) {
        stage.setTitle("Calculator");
        stage.setMaxWidth(500);
        stage.setMaxHeight(427);
        stage.setMinHeight(427);
        stage.setMinWidth(500);


        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: black");
        listView = new ListView();
        listView.setStyle("-fx-background-color: #5c5c5c");
        listView.setMinWidth(200);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!(label.getText().isEmpty())){
                    label.setText("");
                }
                label.setText(t1);
                clicked=false;
                styleLabel();
            }
        });
        VBox vBox = new VBox();
        vBox.setMinWidth(300);
        GridPane gridPane = new GridPane();
        label = new Label();
        label.setAlignment(Pos.CENTER);
        label.setMinHeight(100);
        label.setMinWidth(300);
        label.setStyle("-fx-font-size: 20px;");
        int x=0;
        for(int i=0;i<3;i++){
            for (int k=0;k<3;k++){
                gridPane.add(createCalculatorButton(Integer.toString(x + 1)),k,i);
                x++;
            }
        }
        gridPane.add(createCalculatorButton2("*"),4,0);
        gridPane.add(createCalculatorButton2("-"),4,1);
        gridPane.add(createCalculatorButton2("+"),4,2);
        gridPane.add(createCalculatorButton2("="),4,4);
        gridPane.add(createCalculatorButton2("/"),2,4);
        gridPane.add(createCalculatorButton2("c"),0,4);
        gridPane.add(createCalculatorButton("0"),1,4);


        hBox.getChildren().addAll(listView, vBox);
        vBox.getChildren().addAll(label, gridPane);
        vBox.setMinWidth(300);
        Scene  scene = new Scene(hBox);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        String cssLink = Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm();
        scene.getStylesheets().add(cssLink);
        stage.setScene(scene);

        stage.show();
    }
    private Button createCalculatorButton(String character){
        Button b1 = new Button(character);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-color: #5c5c5c");
        b1.setMinHeight(75);
        b1.setMinWidth(75);
        b1.setOnAction(actionEvent ->  {
                if (b1.getText().equalsIgnoreCase("c")) {
                    label.setText("");
                    label.getStyleClass().clear();
                } else if (b1.getText().equalsIgnoreCase("=") && (label.getText().isEmpty())) {
                    return;
                }else if(b1.getText().equalsIgnoreCase("=")&& !(label.getText().isEmpty())) {
                    labelevaluator();
                }else {
                    if (clicked) {
                        clicked = false;
                        label.setText("");
                    }

                    label.setText(label.getText() + b1.getText());
                    styleLabel();
                }
        });
        return b1;
    }
    private Button createCalculatorButton2(String character){
        Button b1 = new Button(character);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-color: orange");
        b1.setMinWidth(75);
        b1.setMinHeight(75);
        b1.setOnAction(actionEvent -> {
            if(b1.getText().equalsIgnoreCase("c")){
                label.setText("");
                label.getStyleClass().clear();
            }else if(b1.getText().equalsIgnoreCase("=") && !( label.getText().isEmpty())){
                labelevaluator();
            }
            else if(b1.getText().equalsIgnoreCase("=") && label.getText().isEmpty()){
                return;
            }
            else{
                if (isExpressionCorrect(label.getText())){
                    if(clicked){
                        label.setText("");
                        clicked=false;
                    }
                }
                label.setText(label.getText() + b1.getText());
                styleLabel();
            }
        });
        return b1;
    }

    private void labelevaluator() {
        if(isExpressionCorrect(label.getText())){
            ArithmeticExpression arithmeticExpression = new ArithmeticExpression(label.getText());
            listView.getItems().add(label.getText());
            label.setText(String.valueOf(arithmeticExpression.evaluate()));
            clicked=true;
            label.getStyleClass().clear();
            label.getStyleClass().addAll("lbl","lbl-primary");
        }
    }

    private boolean isExpressionCorrect(String expression){
        return expression.matches("^(\\d+[+\\-*/])+\\d+$");
        }
        private void styleLabel(){
        if(isExpressionCorrect(label.getText())){
            label.getStyleClass().clear();
            label.getStyleClass().addAll("lbl", "lbl-success");
        }else{
            label.getStyleClass().clear();
            label.getStyleClass().addAll("lbl", "lbl-danger");
        }
        }


}