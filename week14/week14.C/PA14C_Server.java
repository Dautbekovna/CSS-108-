import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class PA14C_Server extends Application {
    private String messageList = "";
    private TextArea textArea = new TextArea();
    private ArrayList<Socket> sockets = new ArrayList<Socket>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        textArea.setMinWidth(500);
        Scene scene = new Scene(new ScrollPane(textArea), 600, 300);
        primaryStage.setTitle("PA14C_Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                textArea.appendText("MultiThreadServer started at " + new Date() + '\n');

                while(true) {
                    Socket socket = serverSocket.accept();
                    sockets.add(socket);

                    Platform.runLater(() -> {
                        textArea.appendText("Connection from Socket[addr=" + socket.getInetAddress() +
                                ",port=" + socket.getPort() +
                                ",localport=" + socket.getLocalPort() +
                                "]" + new Date() + "\n");
                    });

                    DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                    outputToClient.writeUTF(messageList);
                    new Thread(new HandleAClient(socket)).start();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());

                while(true) {
                    String sentence = inputFromClient.readUTF() + "\n";
                    messageList += sentence;

                    sockets.forEach((s) -> {
                        try {
                            DataOutputStream outputToClient = new DataOutputStream(s.getOutputStream());
                            outputToClient.writeUTF(messageList);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
