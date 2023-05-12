import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle circle = new Circle(100);

        Label label = new Label();
        Button nextBtn = new Button("next");
        Button prevBtn = new Button("prev");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(prevBtn, label, nextBtn);
        hBox.setAlignment(Pos.CENTER);
        hBox.setMinHeight(60);
        hBox.setSpacing(20);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(circle, hBox);
        vBox.setAlignment(Pos.CENTER);

        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.AQUA, Color.FUCHSIA, Color.DARKGRAY, Color.YELLOW));
        ListIterator<Color> colorsIterator = colors.listIterator();
        ArrayList<String> items = new ArrayList<>(Arrays.asList("RED",  "AQUA", "FUCHSIA", "DARKGRAY", "YELLOW"));
        ListIterator<String> itemsIterator = items.listIterator();

        circle.setFill(colors.get(0));
        label.setText(items.get(0));

        nextBtn.setOnAction(e -> {
            if (colorsIterator.hasNext() && itemsIterator.hasNext()) {
                circle.setFill(colorsIterator.next());
                label.setText(itemsIterator.next());
                prevBtn.setDisable(false);
            } else {
                nextBtn.setDisable(true);
            }
        });
        prevBtn.setOnAction(e -> {
            if (colorsIterator.hasPrevious() && itemsIterator.hasPrevious()) {
                circle.setFill(colorsIterator.previous());
                label.setText(itemsIterator.previous());
                nextBtn.setDisable(false);
            } else {
                prevBtn.setDisable(true);
            }
        });

        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setTitle("Practice Activity #10.A");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
