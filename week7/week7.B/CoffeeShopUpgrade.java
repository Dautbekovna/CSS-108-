import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CoffeeShopUpgrade extends Application {
    private String milkChoice = "";
    private String addChoice = "";
    private int cost = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(getPane(), 600, 800);
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

        Label image = new Label();
        image.setPrefSize(100, 50);
        ImageView i = new ImageView();
        i.setFitWidth(100);
        i.setFitHeight(100);
        i.setImage(new Image(changeImage(drinkList)));
        image.setGraphic(i);

        TextArea textArea = new TextArea();
        textArea.setText(changeText(drinkList));

        drinkList.setOnAction(e -> {
            i.setImage(new Image(changeImage(drinkList)));
            image.setGraphic(i);
            textArea.setText(changeText(drinkList));
        });

        HBox imageBox = new HBox();
        imageBox.getChildren().addAll(image, textArea);

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
                milkChoice = "No Milk";
            }
        });

        VBox milkVbox = new VBox();
        milkVbox.setSpacing(5);
        milkVbox.getChildren().addAll(milkTitle, wholeMilk, almondMilk, soyMilk, noMilk);

        Text addTitle = new Text("Add:");
        CheckBox sugarCheck = new CheckBox("Sugar");
        CheckBox hotCheck = new CheckBox("Extra Hot");
        CheckBox milkCheck = new CheckBox("Extra Milk");
        CheckBox strawCheck = new CheckBox("Straw");
        CheckBox napkinsCheck = new CheckBox("Napkins");

        HBox imagesHbox = new HBox();

        EventHandler<ActionEvent> handler = e -> {
            ArrayList<ImageView> is = new ArrayList<>();
            String s = "";
            if (sugarCheck.isSelected()) {
                s += "Sugar ";
                ImageView im = new ImageView();
                im.setFitHeight(50);
                im.setFitWidth(50);
                im.setImage(new Image("https://avatars.mds.yandex.net/i?id=891a7f028f986227f16758e4274d16e78abe5c08-7755612-images-thumbs&n=13"));
                is.add(im);
            }
            if (hotCheck.isSelected()) {
                s += "Ex.Hot ";
                ImageView im = new ImageView();
                im.setFitHeight(50);
                im.setFitWidth(50);
                im.setImage(new Image("https://kartinkin.net/uploads/posts/2022-03/1647265216_16-kartinkin-net-p-kartinki-plamya-ognya-26.jpg"));
                is.add(im);
            }
            if (milkCheck.isSelected()) {
                s += "Ex.Milk ";
                ImageView im = new ImageView();
                im.setFitHeight(50);
                im.setFitWidth(50);
                im.setImage(new Image("https://images.medicaldaily.com/sites/medicaldaily.com/files/2015/03/26/milk.jpg"));
                is.add(im);
            }
            if (strawCheck.isSelected()) {
                s += "Straw ";
                ImageView im = new ImageView();
                im.setFitHeight(50);
                im.setFitWidth(50);
                im.setImage(new Image("https://img.freepik.com/premium-vector/colored-drinking-straws_53562-1792.jpg?w=2000"));
                is.add(im);
            }
            if (napkinsCheck.isSelected()) {
                s += "Napkins ";
                ImageView im = new ImageView();
                im.setFitHeight(50);
                im.setFitWidth(50);
                im.setImage(new Image("https://www.appliance-parts-experts.com/assets/images/blogpictures/tissuescartoon_s.jpg"));
                is.add(im);
            }
            String[] arr = s.split(" ");
            s = "";
            for (int j = 0; j < arr.length; j++) {
                if (j == arr.length - 1) {
                    s += arr[j];
                } else {
                    s += arr[j] + ", ";
                }
            }
            addChoice = s;
            imagesHbox.getChildren().clear();
            for (int j = 0; j < is.size(); j++) {
                Label img = new Label();
                img.setGraphic(is.get(j));
                imagesHbox.getChildren().add(img);
            }
        };
        sugarCheck.setOnAction(handler);
        hotCheck.setOnAction(handler);
        milkCheck.setOnAction(handler);
        strawCheck.setOnAction(handler);
        napkinsCheck.setOnAction(handler);

        VBox addVbox = new VBox();
        addVbox.setSpacing(5);
        addVbox.getChildren().addAll(addTitle, sugarCheck, hotCheck, milkCheck, strawCheck, napkinsCheck);

        HBox hbox = new HBox();
        hbox.setMaxWidth(400);
        hbox.setSpacing(10);
        hbox.getChildren().addAll(milkVbox, addVbox, imagesHbox);

        TextField coffee = new TextField();
        TextField milk = new TextField();
        TextField add = new TextField();
        Text text = new Text("");

        Button order = new Button("Place Order");
        order.setOnAction(e -> {
            String[] arr = addChoice.split(",");
            cost += arr.length * 5;
            if (milkChoice != "No Milk") {
                cost += 100;
            }
            if (drinkList.getValue().contains("Tea")) {
                cost += 150;
            } else {
                cost += 300;
            }
            milk.setText(milkChoice);
            coffee.setText(drinkList.getValue());
            add.setText(addChoice);
            text.setText("Amount due: KZT " + cost);
            cost = 0;
        });

        HBox choicesHbox = new HBox();
        choicesHbox.setSpacing(5);
        choicesHbox.getChildren().addAll(coffee, milk, add, text);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-padding: 20px;");
        vbox.getChildren().addAll(header, drinkTitle, imageBox, drinkList, hbox, order, choicesHbox);

        BorderPane paneForChoices = new BorderPane();
        paneForChoices.setCenter(vbox);

        return paneForChoices;
    }

    private String changeImage(ComboBox<String> drinkList) {
        String s = drinkList.getValue();
        String res = "";
        switch(s) {
            case "Latte":
                res = "https://cdn.pixabay.com/photo/2020/10/05/06/12/drink-5628282_1280.jpg";
                break;
            case "Cappuccino":
                res = "https://omtea.ru/wp-content/uploads/d/1/6/d1624164a4860281338ec0bb8aa44a2b.png";
                break;
            case "Americano":
                res = "https://avatars.mds.yandex.net/i?id=519338dd4d201153d931228e1e9ac9f5-5504462-images-thumbs&ref=rim&n=33&w=353&h=300";
                break;
            case "Black Tea":
                res = "https://podacha-blud.com/uploads/posts/2022-12/1670195373_3-podacha-blud-com-p-chashka-chernogo-chaya-foto-3.jpg";
                break;
            case "Green Tea":
                res = "https://media.visualstories.com/uploads/images/1/87/5376943-1280_473678624-1368962_l.jpg";
                break;
        }
        return res;
    }

    private String changeText(ComboBox<String> drinkList) {
        String s = drinkList.getValue();
        String res = "";
        switch(s) {
            case "Latte":
                res = "latte is ...";
                break;
            case "Cappuccino":
                res = "cappuccino is ...";
                break;
            case "Americano":
                res = "americano is ...";
                break;
            case "Black Tea":
                res = "black tea is ...";
                break;
            case "Green Tea":
                res = "green tea is ...";
                break;
        }
        return res;
    }
}
