package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class leaderController {


    @FXML
    private ImageView back;

    @FXML
    private Label highScoreReader;

    @FXML
    private Circle inner;

    @FXML
    private Circle outer;

    @FXML
    private Label previousScoreReader;
    private Paint p;


    private void action(){
        p = inner.getFill();
        inner.setFill(outer.getFill());
    }




    public void initialize(){

        LeaderInfo leaderInfo = new LeaderInfo();
        String previous = String.valueOf(leaderInfo.getScore());
        int highscore = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("HighScore.txt")))) {
            highscore = Integer.parseInt(reader.readLine());
        }  catch (IOException e) {
            // throw new RuntimeException(e);
        }
        String high = String.valueOf(highscore);
        highScoreReader.setText(high);
        previousScoreReader.setText(previous);

        outer.setOnMousePressed(e -> {
                action();
                startTimeline();
        });
        inner.setOnMousePressed(e -> {
            action();
            startTimeline();
        });
        back.setOnMousePressed(e -> {
            action();
            startTimeline();
        });

    }

    private void startTimeline() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(100), event -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/try.fxml"));
                        Parent root = loader.load();
                        Stage newStage = new Stage();
                        newStage.initStyle(StageStyle.UNDECORATED);
                        newStage.setTitle("Player Screen");
                        newStage.setScene(new Scene(root));
                        newStage.setResizable(false);

                        Stage currentStage = (Stage) back.getScene().getWindow();
                        currentStage.close();

                        newStage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
        );
        timeline.play();
    }
}
