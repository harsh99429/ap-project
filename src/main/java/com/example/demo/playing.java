package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class playing {

    @FXML
    private ImageView background;

    @FXML
    private ImageView cherry;

    @FXML
    private Text cherryReader;

    @FXML
    private Circle inner;

    @FXML
    private Rectangle obstacle1;

    @FXML
    private Circle outer;

    @FXML
    private ImageView pause;

    @FXML
    private Text scoreReader;

    @FXML
    private Rectangle scoreSavor;

    @FXML
    private Line stick;

    @FXML
    private ImageView user;

    private Timeline rotateTimeline;

    private boolean isSpacePressed = false;

    private Paint p;

    public void action(){
        p = inner.getFill();
        inner.setFill(outer.getFill());

    }

    public void action1(){
        inner.setFill(p);
    }


    public void initialize(){





        outer.setOnMousePressed(e -> {
            action();
        });

        inner.setOnMousePressed(e -> {
            action();

        });

        pause.setOnMousePressed(e -> {
            action();
        });


        outer.setOnMouseReleased(e -> action1());
        inner.setOnMouseReleased(e -> action1());
        pause.setOnMouseReleased(e -> action1());

    }

    @FXML
    void lineIncrease(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE){
            System.out.println("Working");
        }
    }



}

