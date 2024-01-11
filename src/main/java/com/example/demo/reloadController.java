package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.ArrayList;

public class reloadController {


    private ArrayList<StorageUnit> storage = new ArrayList<>();
    @FXML
    private Circle inner;
    @FXML
    private Circle outer;
    @FXML
    private ImageView back;

    @FXML
    private TableView dataContainer;
    private Paint p;

    private void action(){
        p = inner.getFill();
        inner.setFill(outer.getFill());
    }

    private void action1(){
        inner.setFill(p);
    }

    public void showData() {
        TableColumn<StorageUnit, Integer> sNo = new TableColumn<>("S.NO.");
        TableColumn<StorageUnit, Integer> score = new TableColumn<>("SCORE");
        TableColumn<StorageUnit, Integer> cherry = new TableColumn<>("CHERRY");

        int val = 200;
        sNo.setPrefWidth(val);
        score.setPrefWidth(val);
        cherry.setPrefWidth(val);

        dataContainer.getColumns().addAll(sNo, score, cherry);

        // Set cell value factories for score and cherry columns
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        cherry.setCellValueFactory(new PropertyValueFactory<>("cherry"));

        // Custom cell factory for S.NO. column
        sNo.setCellFactory(col -> new TableCell<StorageUnit, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(String.valueOf(getIndex() + 1)); // Row numbers start from 1
                }
            }
        });

        // Add data to the table
        ObservableList<StorageUnit> data = FXCollections.observableArrayList(storage);
        dataContainer.setItems(data);
    }

    public void initialize(){

        showData();
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
                        HelloApplication trying = new HelloApplication();
                        Stage currentStage = (Stage) back.getScene().getWindow();
                        currentStage.close();
                        trying.start(new Stage());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
        );
        timeline.play();
    }
}
