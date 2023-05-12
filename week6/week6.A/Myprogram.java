import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Myprogram extends Application {
    private TextArea text = new TextArea();
    private Circle circle = new Circle();
    private int i = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        circle.setCenterX(150);
        circle.setCenterY(150);
        circle.setRadius(50);
        circle.setFill(Color.CORAL);

        VBox vbox = new VBox();
        String cssLayout = "-fx-padding: 10;\n" +
                "-fx-border-style: solid inside;\n" +
                "-fx-border-width: 2;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-radius: 5;\n" +
                "-fx-border-color: blue;\n";
        vbox.setStyle(cssLayout);

        circle.setOnMouseClicked(new ClickHandle());

        vbox.getChildren().add(circle);
        vbox.getChildren().add(text);

        Scene scene = new Scene(vbox,400,300);
        primaryStage.setTitle("Practice Activity #6A");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class ClickHandle implements EventHandler<javafx.scene.input.MouseEvent> {

        @Override
        public void handle(javafx.scene.input.MouseEvent event) {
            text.appendText("Mouse event handler has been called " + ++i +  "\n");
        }
    }
}
