package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PlayerScreen extends Application {


    Stage window;
    Scene scene1;
    private newIdea controller;

    private int c = 0;

    RevivalInfo revivalInfo;

    @Override
    public void start(Stage stage) {
        try {

            revivalInfo = new RevivalInfo();
            window = stage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/playerScreen.fxml"));
            Parent rootWithController = loader.load();
            controller = loader.getController();

            Scene check = new Scene(rootWithController, 600, 400);
            Pane root = (Pane) check.getRoot();
            window.setResizable(false);
            window.initStyle(StageStyle.UNDECORATED);
            window.setTitle("Stick Hero");
            controller.setThis_pane(root);

            int checking = progressReading();
            System.out.println(checking);
            if (checking == 0) {
                if (!revivalInfo.isFileEmpty()) {
                    System.out.println(revivalInfo.getInitialWidth());
                    controller.setInitialRectangle(revivalInfo.getInitialRectangleX(), revivalInfo.getInitialWidth());
                    controller.setObstacleRectangle(revivalInfo.getObstacleX(), revivalInfo.getObstacleWidth());
                    controller.setCherryEaten(revivalInfo.getCherry());
                    System.out.println("in player Screen :" + revivalInfo.getCherry());
                    controller.setScoreReader(revivalInfo.getScore());
                    //Missing element --> group update is not done yet
                    controller.setRevivalCount(revivalInfo.getRevivalCount());
                }
            } else {
                saveClass saveClass = new saveClass();
                if (!saveClass.isFileEmpty()) {

                    System.out.println(saveClass.getInitialWidth());
                    controller.setInitialRectangle(saveClass.getInitialRectangleX(), saveClass.getInitialWidth());
                    controller.setObstacleRectangle(saveClass.getObstacleX(), saveClass.getObstacleWidth());
                    controller.setScoreReader(saveClass.getScore());
                    //Missing element --> group update is not done yet
                    controller.setRevivalCount(saveClass.getRevivalCount());
                    System.out.println(saveClass.todString());
                    tryController.progressZero();
                }

            }
            controller.setOnLine(false);

            check.setOnKeyPressed(e -> {
                System.out.println(e.getCode());
                if (e.getCode() == KeyCode.SPACE) {
                    if (controller.isOnLine()) {
                        System.out.println("You are already online");
                        controller.flipUser();
                    } else {
                        extendLine();
                        c = 1;
                    }
                }

                if (e.getCode() == KeyCode.S) {
                    //SAVE THE GAME
                    controller.save();
                }
            });



            check.setOnKeyReleased(e -> {
                System.out.println(e.getCode());
                if (e.getCode() == KeyCode.SPACE && c == 1) {
                    controller.setOnLine(true);
                    c = 0;
                    FallLine();
                    movePlayer();
                }

            });

            window.setScene(check);
            window.show();
        }
        catch(Exception e){
                e.printStackTrace();
        }
    }

    private void FallLine() {
        controller.startRotation();
    }

    public void extendLine(){
        controller.lineIncrease();
    }

    public static void main(String[] args) {
        launch();
    }


    public int progressReading(){
        int a = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("progress")))) {
            a = Integer.parseInt(reader.readLine());
        }  catch (IOException e) {
            // throw new RuntimeException(e);
        }

        return a;
    }


    public void movePlayer(){
        controller.checkIntersection(controller.getStick1(),controller.getObstacle1());
        controller.runUser();
    }

    public void close(){
        window.close();
    }
}
