//package com.example.demo;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.StackPane;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//import java.util.Objects;
//
//public class HelloApplication extends Application {
//
//    Stage window;
//    Scene scene1;
//
//
//
//    @Override
//    public void start(Stage stage) {
//        try {
////            String ssound = "/com/example/demo/wha.mp3";
////            Media sound = new Media(ssound);
////            MediaPlayer mediaPlayer = new MediaPlayer(sound);
////            mediaPlayer.play();
//
//            window = stage;
//            Parent root = FXMLLoader.load(getClass().getResource("FXML/try.fxml"));
//            Scene check = new Scene(root, 600, 400);
//            window.setResizable(false);
//            window.initStyle(StageStyle.UNDECORATED);
//            window.setTitle("Stick Hero");
//            check.setOnKeyPressed(e->{
//                extendLine();
//            });
//            window.setScene(check);
//            window.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    public void extendLine(){
//
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}
package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.Objects;

public class HelloApplication extends Application {

    Stage window;
    Scene scene1;
    private MediaPlayer mediaPlayer;



    @Override
    public void start(Stage stage) {
        try {

            String audioFilePath = "src/main/resources/com/example/demo/wha.mp3";

            File audioFile = new File(audioFilePath);
            String fullPath = audioFile.toURI().toString();

            Media media = new Media(fullPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);

            window = stage;
            Parent root = FXMLLoader.load(getClass().getResource("FXML/try.fxml"));
            Scene check = new Scene(root, 600, 400);
            window.setResizable(false);
            window.initStyle(StageStyle.UNDECORATED);
            window.setTitle("Stick Hero");
            check.setOnKeyPressed(e->{
                extendLine();
            });

            MediaThread mediaThread = new MediaThread(mediaPlayer);
            mediaThread.start();

            window.setScene(check);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void extendLine(){

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() {
        // Release resources when the application is closed
        mediaPlayer.stop();
        System.exit(0);
    }

    private static class MediaThread extends Thread {
        private final MediaPlayer mediaPlayer;

        public MediaThread(MediaPlayer mediaPlayer) {
            this.mediaPlayer = mediaPlayer;
        }

        @Override
        public void run() {
            mediaPlayer.setOnReady(() -> {
                // Run on the JavaFX Application Thread
                Platform.runLater(() -> mediaPlayer.play());
            });
        }
    }}