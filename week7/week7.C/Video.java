import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.util.Duration;

public class Video extends Application {
    private static final String MEDIA_URL = "file:///Users/sch_aa_vk/Downloads/metalfamily.mp4";
    @Override
    public void start(Stage primaryStage) throws Exception {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(400);
        mediaView.setFitWidth(400);

        Button playBtn = new Button("play");
        playBtn.setOnAction(e -> {
            if(playBtn.getText().equals("play")) {
                mediaPlayer.play();
                playBtn.setText("pause");
            } else {
                mediaPlayer.pause();
                playBtn.setText("play");
            }
        });
        Button rewindBtn = new Button("stop");
        rewindBtn.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(
                slVolume.valueProperty().divide(100)
        );

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playBtn, rewindBtn, new Label("Volume"), slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("Practice #7C");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
