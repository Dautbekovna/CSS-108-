import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PA14B_Client extends Application {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label ClientLabel = new Label("Client: ");
        TextArea ClientTextArea = new TextArea();
        Label ServerLabel = new Label("Server: ");
        TextArea ServerTextArea = new TextArea();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(ClientLabel, ClientTextArea, ServerLabel, ServerTextArea);

        Scene scene = new Scene(new ScrollPane(vBox), 500, 300);
        primaryStage.setTitle("PA14B_Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        ClientTextArea.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                try {
                    String sentence = ClientTextArea.getText();
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
                        ServerTextArea.setText(clientText);
                    });
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).start();

    }
}
