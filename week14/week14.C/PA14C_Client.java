import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PA14C_Client extends Application {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane nameBorderPane = new BorderPane();
        nameBorderPane.setPadding(new Insets(5, 5, 5, 5));
        nameBorderPane.setLeft(new Label("Name: "));
        TextField nameTextField = new TextField();
        nameBorderPane.setRight(nameTextField);

        BorderPane messageBorderPane = new BorderPane();
        messageBorderPane.setPadding(new Insets(5, 5, 5, 5));
        messageBorderPane.setLeft(new Label("Enter Text: "));
        TextField messageTextField = new TextField();
        messageBorderPane.setRight(messageTextField);

        TextArea textArea = new TextArea();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(nameBorderPane, messageBorderPane, textArea);

        Scene scene = new Scene(new ScrollPane(vBox), 600, 300);
        primaryStage.setTitle("PA14C_Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        messageTextField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                try {
                    String sentence = nameTextField.getText() + ": " + messageTextField.getText();
                    toServer.writeUTF(sentence);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 8000);
                fromServer = new DataInputStream(socket.getInputStream());
                toServer = new DataOutputStream(socket.getOutputStream());

                while(true) {
                    String clientText = fromServer.readUTF();
                    Platform.runLater(() -> {
                        textArea.setText(clientText);
                    });
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).start();
    }
}
