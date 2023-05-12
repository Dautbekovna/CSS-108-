import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Figure extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Ellipse ellipse = new Ellipse(250, 250, 150, 100);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);

        Text text = new Text();
        text.setText("This is my ellipse");
        text.setX(130);
        text.setY(250);
        text.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 32));
        text.setFill(Color.YELLOW);
        text.setStroke(Color.RED);
        text.setUnderline(true);

        Group root = new Group(ellipse, text);
        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("My App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
