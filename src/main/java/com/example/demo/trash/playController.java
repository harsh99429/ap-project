package com.example.demo.trash;

import com.example.demo.rectangle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

class move{
    public void drag(){

    }
}
class Line{

    double lineLength;
    public void extend(){

    }
    public void fall(){

    }

    public void uniqueSolutionForCherry(Pillar p1,Pillar p2){
        Cherry v = new Cherry();
        v.createCherry();
    }
}

class Cherry{
    private ImageView cherry;

    public void createCherry(){}

    public void diminishCherry(){

    }
}
class Pillar extends move{
    private rectangle p;
    private double height;
    private double width;
    private void setHeight(){}
    private void setWidth(){}
    public void drawObstacle(){}

    public void saveObstacle(){

    }
}

class Player extends move{
    double playerPositionX;
    double playerPositionY;
    int cherryCount;
    int score;
    int revive;
    int revivalCost = 1;
    boolean onLine;

    public void run(){
        if(onLine){

        }
    }

    public void flip(){
        if(!onLine){

        }
    }

    public void eatCherry(Cherry c){
        c.diminishCherry();
        cherryCount++;
    }

    public void crossedAPillar(){
        score++;
    }

    public void wannaRevive(int globalCherry){
        if(revivalCost > globalCherry){
            //Cannot revive the player
        }
        else{
            revivalCost *= 2;
            if(cherryCount > 0){
                cherryCount --;
            }
            if(score > 0){
                score --;
            }
        }
    }

}

public class playController {

    Stage gameWindow;
    @FXML
    private ImageView pause;

    public void stageFinder() {
        //give the current game screen
    }

    @FXML
    public void initialize() {
        System.out.println("success");
        pause.setOnMouseClicked(e -> {
            openPauseDialog();
        });


    }

    public void openPauseDialog() {
        try {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("FXML/pause.fxml"));
            window.setResizable(false);
            window.setTitle("Stick Hero");
            window.initStyle(StageStyle.UNDECORATED);
            window.setScene(new Scene(root));
            window.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
