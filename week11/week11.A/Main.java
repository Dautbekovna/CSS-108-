import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.misc.IOUtils;

import java.io.*;
import java.util.*;

public class Main extends Application {
    String[] keywordString = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};
    Set<String> keywordSet =
            new HashSet<>(Arrays.asList(keywordString));
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label title1 = new Label("Keyword Count");
        Label title2 = new Label("Enter a keyword:");

        TextField textField = new TextField();
        textField.setMinWidth(200);
        textField.setMaxWidth(450);
        Button searchBtn = new Button("Search a key from file: ");
        Label filename = new Label();
        HBox hBox = new HBox(searchBtn, filename);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        Label result = new Label();

        VBox vBox = new VBox(title1, title2, textField, hBox, result);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Search a key from file:");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Java Files", "*.java"));

        EventHandler<ActionEvent> searchEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    filename.setText(file.getName() + " file selected");
                    Set<String> word = new HashSet<>();
                    word.add(textField.getText());
                    try {
                        result.setText("Number of keywords in file: " + file.getName() + " is " + countWords(file, keywordSet) + "\n"
                        + "Number of the keyword: " + textField.getText() + " is " + countWords(file, word));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        searchBtn.setOnAction(searchEvent);

        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setTitle("Practice Activity #11.A");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private int countWords(File file, Set<String> words) throws FileNotFoundException {
        int count = 0;
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String word = input.next();
            if (words.contains(word)) count++;
        }
        return count;
    }
}
