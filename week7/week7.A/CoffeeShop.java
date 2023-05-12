import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoffeeShop extends Application {
    private String milkChoice;
    private String addChoice;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(getPane(), 600, 400);
        primaryStage.setTitle("Practice Activity #7A");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    protected BorderPane getPane() {
        Text header = new Text("My Coffee Shop");
        header.setStyle("-fx-font-family: 'Brush Script MT'; -fx-font-size: 16;");

        Text drinkTitle = new Text("Drink:");

        ComboBox<String> drinkList = new ComboBox<>();
        drinkList.getItems().addAll("Latte", "Cappuccino",
                "Americano", "Black Tea", "Green Tea");
        drinkList.setValue("Latte");

        Text milkTitle = new Text("Milk Option:");
        ToggleGroup group = new ToggleGroup();

        RadioButton wholeMilk = new RadioButton("Whole Milk");
        wholeMilk.setStyle("-fx-font-size: 12px; -fx-font-family: Arial;");
        wholeMilk.setToggleGroup(group);
        wholeMilk.setOnAction(e -> {
            if (wholeMilk.isSelected()) {
                milkChoice = "Whole Milk";
            }
        });

        RadioButton soyMilk = new RadioButton("Soy Milk");
        soyMilk.setStyle("-fx-font-size: 12px; -fx-font-family: Arial;");
        soyMilk.setToggleGroup(group);
        soyMilk.setOnAction(e -> {
            if (soyMilk.isSelected()) {
                milkChoice = "Soy Milk";
            }
        });

        RadioButton almondMilk = new RadioButton("Almond Milk");
        almondMilk.setStyle("-fx-font-size: 12px; -fx-font-family: Arial;");
        almondMilk.setToggleGroup(group);
        almondMilk.setOnAction(e -> {
            if (almondMilk.isSelected()) {
                milkChoice = "Almond Milk";
            }
        });

        RadioButton noMilk = new RadioButton("No Milk");
        noMilk.setStyle("-fx-font-size: 12px; -fx-font-family: Arial;");
        noMilk.setToggleGroup(group);
        noMilk.setOnAction(e -> {
            if (noMilk.isSelected()) {
                milkChoice += "No Milk ";
            }
        });

        VBox milkVbox = new VBox();
        milkVbox.setSpacing(5);
        milkVbox.getChildren().addAll(milkTitle, wholeMilk, almondMilk, soyMilk, noMilk);

        Text addTitle = new Text("Add:");
        CheckBox sugarCheck = new CheckBox("Sugar");
        sugarCheck.setOnAction(e -> {
            if (sugarCheck.isSelected()) {
                addChoice += "Sugar ";
            }
        });

        CheckBox hotCheck = new CheckBox("Extra Hot");
        hotCheck.setOnAction(e -> {
            if (hotCheck.isSelected()) {
                addChoice += "Extra Hot ";
            }
        });

        CheckBox milkCheck = new CheckBox("Extra Milk");
        milkCheck.setOnAction(e -> {
            if (milkCheck.isSelected()) {
                addChoice += "Extra Milk ";
            }
        });

        CheckBox strawCheck = new CheckBox("Straw");
        strawCheck.setOnAction(e -> {
            if (strawCheck.isSelected()) {
                addChoice += "Straw ";
            }
        });

        CheckBox napkinsCheck = new CheckBox("Napkins");
        napkinsCheck.setOnAction(e -> {
            if (napkinsCheck.isSelected()) {
                addChoice += "Napkins ";
            }
        });

        VBox addVbox = new VBox();
        addVbox.setSpacing(5);
        addVbox.getChildren().addAll(addTitle, sugarCheck, hotCheck, milkCheck, strawCheck, napkinsCheck);

        HBox hbox = new HBox();
        hbox.setMaxWidth(400);
        hbox.setSpacing(200);
        hbox.getChildren().addAll(milkVbox, addVbox);

        TextField coffee = new TextField();
        TextField milk = new TextField();
        TextField add = new TextField();

        Button order = new Button("Place Order");
        order.setOnAction(e -> {
            milk.setText(milkChoice);
            coffee.setText(drinkList.getValue());
            add.setText(addChoice);
        });

        HBox choicesHbox = new HBox();
        choicesHbox.setSpacing(5);
        choicesHbox.getChildren().addAll(coffee, milk, add);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-padding: 20px;");
        vbox.getChildren().addAll(header, drinkTitle, drinkList, hbox, order, choicesHbox);

        BorderPane paneForChoices = new BorderPane();
        paneForChoices.setCenter(vbox);

        return paneForChoices;
    }
}
