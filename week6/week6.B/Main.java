import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.transform.Rotate.Y_AXIS;

public class Main extends Application {
    private Rectangle rectangle = new Rectangle();
    private TextField textField = new TextField();
    private Circle circle = new Circle();
    private TextArea textArea = new TextArea();
    private HBox hbox = new HBox();
    private VBox vbox = new VBox();
    private String s = "";
    private RotateTransition rotateTransition = new RotateTransition();
    @Override
    public void start(Stage primaryStage) throws Exception {
        circle.setCenterX(150);
        circle.setCenterY(150);
        circle.setRadius(50);
        circle.setFill(Color.CORAL);

        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.TAN);

        textField.setLayoutX(50);
        textField.setLayoutY(100);

        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(rectangle);
        rotateTransition.setAxis(Y_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
        rotateTransition.setAutoReverse(false);

        hbox.getChildren().add(circle);
        hbox.getChildren().add(rectangle);
        hbox.getChildren().add(textField);
        hbox.setSpacing(20);
        hbox.setPadding(new Insets(20));

        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        String cssLayout = "-fx-padding: 10;\n" +
                "-fx-border-style: solid inside;\n" +
                "-fx-border-width: 2;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-radius: 5;\n" +
                "-fx-border-color: blue;\n";
        vbox.setStyle(cssLayout);

        vbox.getChildren().add(hbox);
        vbox.getChildren().add(textArea);

        circle.setOnMouseClicked(e -> {
            s = e.getX() + " " + e.getY();
            textArea.appendText("Mouse event handler has been called. Location=(" + s + ")\n");
        });

        textField.setOnKeyTyped(e -> {
            rotateTransition.play();
            textArea.appendText("Key event handler has been called\n");
        });
        textField.setOnKeyReleased(e -> {
            rotateTransition.pause();
        });

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Practice Activity #6B");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
