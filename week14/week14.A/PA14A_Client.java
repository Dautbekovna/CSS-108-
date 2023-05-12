import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PA14A_Client extends Application {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPaneInterest = new BorderPane();
        borderPaneInterest.setPadding(new Insets(5, 5, 5, 5));
        borderPaneInterest.setLeft(new Label("Annual Interest Rate:  "));
        borderPaneInterest.setMinWidth(200);
        TextField textFieldInterest = new TextField();
        textFieldInterest.setAlignment(Pos.BOTTOM_RIGHT);
        borderPaneInterest.setCenter(textFieldInterest);

        BorderPane borderPaneYears = new BorderPane();
        borderPaneYears.setPadding(new Insets(5, 5, 5, 5));
        borderPaneYears.setLeft(new Label("Number Of Years:  "));
        borderPaneYears.setMinWidth(200);
        TextField textFieldYears = new TextField();
        textFieldYears.setAlignment(Pos.BOTTOM_RIGHT);
        borderPaneYears.setCenter(textFieldYears);

        BorderPane borderPaneLoan = new BorderPane();
        borderPaneLoan.setPadding(new Insets(5, 5, 5, 5));
        borderPaneLoan.setLeft(new Label("Loan Amount:  "));
        borderPaneLoan.setMinWidth(200);
        TextField textFieldLoan = new TextField();
        textFieldLoan.setAlignment(Pos.BOTTOM_RIGHT);
        borderPaneLoan.setCenter(textFieldLoan);

        Button submitBtn = new Button("Submit");

        HBox hBox = new HBox();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(borderPaneInterest, borderPaneYears, borderPaneLoan);
        hBox.getChildren().addAll(vBox, submitBtn);

        BorderPane mainPane = new BorderPane();
        TextArea textArea = new TextArea();
        mainPane.setCenter(new ScrollPane(textArea));
        mainPane.setTop(hBox);

        Scene scene = new Scene(mainPane, 500, 300);
        primaryStage.setTitle("PA14A_Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        submitBtn.setOnAction(e -> {
            try {
                double annualInterestRate = Double.parseDouble(textFieldInterest.getText().trim());
                double numberOfYears = Double.parseDouble(textFieldYears.getText().trim());
                double loanAmount = Double.parseDouble(textFieldLoan.getText().trim());

                toServer.writeDouble(annualInterestRate);
                toServer.writeDouble(numberOfYears);
                toServer.writeDouble(loanAmount);
                toServer.flush();

                double monthlyPayment = fromServer.readDouble();
                double totalPayment = fromServer.readDouble();

                textArea.appendText("Annual Interest Rate: " + annualInterestRate + "\n");
                textArea.appendText("Number Of Years: " + numberOfYears + "\n");
                textArea.appendText("Loan Amount: " + loanAmount + "\n");
                textArea.appendText("Monthly Payment: " + monthlyPayment + "\n");
                textArea.appendText("Total Payment: " + totalPayment + "\n");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });

        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            textArea.appendText(ex.toString() + "\n");
        }
    }
}
