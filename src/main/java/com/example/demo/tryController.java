package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class exitClass{
    static Stage window;
    static Scene scene1;
    static Button button1;
    static Button button2;


    static boolean ans = false;

    public static boolean displayExitBox(){
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        HBox h = new HBox(150);
        h.setAlignment(Pos.CENTER);

        button1 = new Button("YES");
        button2 = new Button("NO");

        button1.setOnAction(e -> {
            window.close();
            ans = true;
        });
        button2.setOnAction(e-> window.close());
        h.getChildren().addAll(button1,button2);
        Label l = new Label("Do you want to exit?\n");
        l.setAlignment(Pos.CENTER);
        l.setStyle("-fx-background-color: #CCCCCC;");
        l.setPrefHeight(100);
        l.setMaxWidth(300);

        VBox s = new VBox();
        s.setStyle("-fx-background-color: #CCCCCC;");
        s.getChildren().addAll(l,h);
        scene1 = new Scene(s,300,150);
        window.setScene(scene1);
        window.setTitle("STICK HERO");
        window.setResizable(false);
        window.showAndWait();
        return ans;

    }

}

public class tryController {

    //PLAY BUTTON
    @FXML
    private ImageView play;
    @FXML
    private Circle outer;
    @FXML
    private Circle inner;
    private Paint p;

    //EXIT BUTTON
    @FXML
    private ImageView exit;
    @FXML
    private Circle innerexit;
    @FXML
    private Circle outerexit;
    private Paint pa;

    static newIdea controller;


    private PlayerScreen playerScreen;


    //LEADERBOARD;
    @FXML
    private Rectangle leader;

    //RELOAD
    @FXML
    private Rectangle reload;

    @FXML
    public void action(Paint p,Circle inner,Circle outer){
        p = inner.getFill();
        inner.setFill(outer.getFill());

    }

    public void action1(Paint p,Circle inner){
        inner.setFill(p);
    }

    @FXML
    public void initialize(){


        //PLAY BUTTON
        outer.setOnMousePressed(e -> {
            action(p,inner,outer);
            startTimeline();
        });

        inner.setOnMousePressed(e -> {
            action(p,inner,outer);
            startTimeline();
        });

        play.setOnMousePressed(e -> {
            action(p,inner,outer);
            startTimeline();
        });
        outer.setOnMouseReleased(e -> action1(p,inner));
        inner.setOnMouseReleased(e -> action1(p,inner));
        play.setOnMouseReleased(e -> action1(p,inner));


        //EXIT BUTTON
        outerexit.setOnMousePressed(e -> {
            action(pa,innerexit,outerexit);
            startTimelineExit();
        });

        innerexit.setOnMousePressed(e -> {
            action(pa,innerexit,outerexit);
            startTimelineExit();
        });

        exit.setOnMousePressed(e -> {
            action(pa,innerexit,outerexit);
            startTimelineExit();
        });
        outerexit.setOnMouseReleased(e -> action1(pa,innerexit));
        innerexit.setOnMouseReleased(e -> action1(pa,innerexit));
        exit.setOnMouseReleased(e -> action1(pa,innerexit));

        leader.setOnMousePressed(e -> {
            try {
                Stage window = new Stage();

                window.initModality(Modality.APPLICATION_MODAL);
                // Load the FXML file
                Parent root = FXMLLoader.load(getClass().getResource("FXML/leader.fxml"));
                Stage currentStage = (Stage) leader.getScene().getWindow();
                currentStage.close();
                window.setResizable(false);
                window.initStyle(StageStyle.UNDECORATED);
                window.setTitle("Stick Hero");
                window.setScene(new Scene(root, 600, 400));
                window.show();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        reload.setOnMousePressed(e -> {
            Stage menuStage = (Stage) exit.getScene().getWindow();
            menuStage.close();
            progressOne();
            PlayerScreen playerScreen1 = new PlayerScreen();
            playerScreen1.start(new Stage());
        });

    }

    private void startTimeline() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(100), event -> {
                    playerScreen = new PlayerScreen();
                    Stage s = (Stage)inner.getScene().getWindow();
                    s.close();
                    playerScreen.start(new Stage());
                })
        );
        timeline.play();
    }

    private void startTimelineExit(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(100)));
        timeline.play();
        boolean ans = exitClass.displayExitBox();
        if(ans){
            Stage menuStage = (Stage) exit.getScene().getWindow();
            menuStage.close();
        }
        innerexit.setFill(Color.web("#99210f"));
    }

    public static void progressZero(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("progress")))) {
            writer.write(Integer.toString(0));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }

    public static void progressOne(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("progress")))) {
            writer.write(Integer.toString(1));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }




}
