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
import java.util.Date;

public class PA14A_Server extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();

        Scene scene = new Scene(new ScrollPane(textArea), 500, 300);
        primaryStage.setTitle("PA14A_Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() -> textArea.appendText("Server started at " + new Date() + "\n"));
                Socket socket = serverSocket.accept();

                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while(true) {
                    double annualInterestRate = inputFromClient.readDouble();
                    double numberOfYears = inputFromClient.readDouble();
                    double loanAmount = inputFromClient.readDouble();

                    double monthlyInterestRate = annualInterestRate / 1200;
                    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                            (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
                    double totalPayment = monthlyPayment * numberOfYears * 12;

                    outputToClient.writeDouble(monthlyPayment);
                    outputToClient.writeDouble(totalPayment);

                    Platform.runLater(() -> {
                        textArea.appendText("Annual Interest Rate: " + annualInterestRate + "\n");
                        textArea.appendText("Number Of Years: " + numberOfYears + "\n");
                        textArea.appendText("Loan Amount: " + loanAmount + "\n");
                        textArea.appendText("Monthly Payment: " + monthlyPayment + "\n");
                        textArea.appendText("Total Payment: " + totalPayment + "\n");
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
