package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class pauseController {
    @FXML
    Button resume;
    @FXML
    Button restart;
    @FXML
    Button home;

    @FXML
    public void actionResume(){
        //Return to the previous state
    }

    @FXML
    public void actionPause(){

    }


    @FXML
    public void actionRestart(){
        //Save the previous stats

        //Open the new Game
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/screen.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.initStyle(StageStyle.UNDECORATED);
            newStage.setTitle("New Window");
            newStage.setScene(new Scene(root));
            newStage.setResizable(false);

            Stage currentStage = (Stage) resume.getScene().getWindow();
            currentStage.close();

            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void home(){

    }
}
