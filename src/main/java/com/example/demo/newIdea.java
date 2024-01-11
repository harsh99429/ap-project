package com.example.demo;

import javafx.animation.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

class WindowOpen implements Runnable{

    Stage stage;
    String screen;
    public WindowOpen(Stage stage,String screen){
        this.stage = stage;
        this.screen = screen;
    }

    @Override
    public void run() {
        String a = "FXML/" + this.screen + ".fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(a));
        Parent rootWithController = null;
        try {
            rootWithController = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene s = new Scene(rootWithController,600,400);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}

class WindowClose extends Thread{

    Stage stage ;

    @Override
    public void run() {
        stage.close();
    }
}

public class newIdea{

    private Pane this_pane;
    private boolean isFalling;

    private PlayerScreen a;
    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public boolean isFlip() {
        return flip;
    }

    private boolean flip;
    private int canrotate;

    public boolean isFalling() {
        return isFalling;
    }

    public void setFalling(boolean falling) {
        isFalling = falling;
    }

    public Pane getThis_pane() {
        return this_pane;
    }

    public void setThis_pane(Pane this_pane) {
        this.this_pane = this_pane;
    }

    @FXML
    private Group revivalGroup;

    @FXML
    private ImageView background;

    @FXML
    private ImageView cherry;


    @FXML
    private ImageView cherry1;
    @FXML
    private Text cherryReader1;
    @FXML
    private Rectangle cherryBox;

    @FXML
    private Rectangle scoreBox;
    @FXML
    private Text scoreReader11;
    @FXML
    private Text cherryScoreRevival;
    @FXML
    private ImageView cherryRevive;

    @FXML
    private Text cherryReader;

    @FXML
    private Rectangle initial;

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
    private Text status;

    @FXML
    private Line stick1;

    private int cherryCollected;
    private int scoreAchieved;

    private Paint p;
    private double initialUserX;
    private double initialUserY;
    private double stick1Start;
    private double stick2Start;
    private boolean CanStick1Extend;
    private boolean CanStick2Extend;
    private boolean cherryEaten;

    private boolean onLine;
    private ImageView newCherry;
    private boolean isRotated;

    private int revivalCount;
    private int revivalCost;

    private data d;
    public boolean isCanFlip() {
        return canFlip;
    }

    private boolean canFlip;

    public boolean isCherryPresent() {
        return isCherryPresent;
    }

    public void setCherryPresent(boolean cherryPresent) {
        isCherryPresent = cherryPresent;
    }

    private boolean isCherryPresent;

    public boolean isRotated() {
        return isRotated;
    }

    public void setRotated(boolean rotated) {
        isRotated = rotated;
    }

    public boolean isOnLine() {
        return onLine;
    }

    public boolean isPlayerRestriction() {
        return playerRestriction;
    }

    public void setPlayerRestriction(boolean playerRestriction) {
        this.playerRestriction = playerRestriction;
    }

    private boolean playerRestriction;
    public void setOnLine(boolean onLine) {
        this.onLine = onLine;
    }

    public boolean isCanStick1Extend() {
        return CanStick1Extend;
    }

    public void setCanStick1Extend(boolean canStick1Extend) {
        CanStick1Extend = canStick1Extend;
    }

    public boolean isCanStick2Extend() {
        return CanStick2Extend;
    }

    public void setCanStick2Extend(boolean canStick2Extend) {
        CanStick2Extend = canStick2Extend;
    }


    public void setBackground(ImageView background) {
        this.background = background;
    }

    public ImageView getCherry() {
        return cherry;
    }

    public void setCherry(ImageView cherry) {
        this.cherry = cherry;
    }

    public Text getCherryReader() {
        return cherryReader;
    }

    public void setCherryReader(Text cherryReader) {
        this.cherryReader = cherryReader;
    }

    public Rectangle getInitial() {
        return initial;
    }

    public void setInitial(Rectangle initial) {
        this.initial = initial;
    }

    public Circle getInner() {
        return inner;
    }

    public void setInner(Circle inner) {
        this.inner = inner;
    }

    public Rectangle getObstacle1() {
        return obstacle1;
    }

    public void setObstacle1(Rectangle obstacle1) {
        this.obstacle1 = obstacle1;
    }

    public Circle getOuter() {
        return outer;
    }

    public void setOuter(Circle outer) {
        this.outer = outer;
    }

    public ImageView getPause() {
        return pause;
    }

    public void setPause(ImageView pause) {
        this.pause = pause;
    }

    public Text getScoreReader() {
        return scoreReader;
    }

    public void setScoreReader(Text scoreReader) {
        this.scoreReader = scoreReader;
    }

    public Rectangle getScoreSavor() {
        return scoreSavor;
    }

    public void setScoreSavor(Rectangle scoreSavor) {
        this.scoreSavor = scoreSavor;
    }

    public Text getStatus() {
        return status;
    }

    public void setStatus(Text status) {
        this.status = status;
    }

    public Line getStick1() {
        return stick1;
    }

    public void setStick1(Line stick1) {
        this.stick1 = stick1;
    }


    public ImageView getUser() {
        return user;
    }

    public void setUser(ImageView user) {
        this.user = user;
    }

    private int check = 0;

    private boolean canCrossObstacle;
    private int rounds;
    private boolean canCrossInitial;

    public boolean isCanCrossInitial() {
        return canCrossInitial;
    }

    public void setCanCrossInitial(boolean canCrossInitial) {
        this.canCrossInitial = canCrossInitial;
    }

    public boolean isCanCrossObstacle() {
        return canCrossObstacle;
    }

    public void setCanCrossObstacle(boolean canCrossObstacle) {
        this.canCrossObstacle = canCrossObstacle;
    }

    @FXML
    private ImageView user;

    @FXML
    void displayPosition(MouseEvent event) {
        status.setText("X = " + event.getX() + "\n  Y = " + event.getY());
    }

    @FXML
    void lineIncrease() {
        if(check == 0 && !onLine){
            double initialEndY = stick1.getStartY();

            // Increase the length by extending the startY of first stick
            stick1.setStartY(initialEndY - 10);
            stick1.setEndY(stick1Start);

            //    System.out.println("increases");
        }
    }

    public void action(){
        p = inner.getFill();
        inner.setFill(outer.getFill());

    }

    public void action1(){
        inner.setFill(p);
    }

    public void initialize() throws IOException {
        canrotate=0;
        onLine = true;
        isRotated = true;
        playerRestriction = true;
        isFalling = false;
        cherryEaten = false;
        check = 0;
        initialUserX = initial.localToScene(getInitial().getX(),getInitial().getY()).getX();
        initialUserY = getCenterY(user);
        stick1Start = stick1.getEndY();
        rounds=0;
        cherryCollected = Integer.parseInt(cherryReader.getText());
        System.out.println("cherryCollected: " + cherryCollected);
        scoreAchieved = Integer.parseInt(scoreReader.getText());


        //Data collection
        d = new data(obstacle1.getBoundsInParent().getMinX(),
                obstacle1.getBoundsInParent().getMaxX(),
                stick1Start,
                initial.getBoundsInParent().getMinX(),
                initial.getBoundsInParent().getMaxX(),
                cherryCollected,
                scoreAchieved);

        //Data to store during pause and store
//        FileData f = new FileData();
//        f.convertDataToString(d);

        readScoreFromFile();
        outer.setOnMousePressed(e -> {
            action();
            openWindow();
        });

        inner.setOnMousePressed(e -> {
            action();

            Thread thread ;
            openWindow();

        });

        pause.setOnMousePressed(e -> {
            action();
            openWindow();
        });


        outer.setOnMouseReleased(e -> action1());
        inner.setOnMouseReleased(e -> action1());
        pause.setOnMouseReleased(e -> action1());

    }

    public void openWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/playerScreen.fxml"));
            Parent rootWithController = loader.load();
            Scene s = new Scene(rootWithController,600,400);
            Stage stage = new Stage();
            stage.setScene(s);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeWindow(){

    }

    @FXML
    void startRotation() {
        if(check == 0 && isRotated) {
            Rotate rotate = new Rotate(90, stick1.getEndX(), stick1.getEndY());
            stick1.getTransforms().add(rotate);

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                    new KeyFrame(Duration.seconds(0.5), new KeyValue(rotate.angleProperty(), 90))
            );

            timeline.setOnFinished(event -> {
                setRotated(false);
                setPlayerRestriction(false);
                canFlip = true;
                runUser();
            });

            // Play the animation
            timeline.play();
        }
    }

    void runUser() {

        if(check == 0 && !playerRestriction) {
            double l_y = (stick1.getEndY() - stick1.getStartY());
            double l_x = (stick1.getEndX() - stick1.getStartX());
            double length = Math.sqrt((l_y * l_y) + (l_x * l_x));
            double x = getCenterX(user);

            checkExtension();
            if (isCanCrossObstacle() && !isCanStick1Extend()) {
                // move to the end of the obstacle
                // calculating distance
                double[] coordinate = getTopRightCoordinates(obstacle1);
                double distance = coordinate[0] - 80;

                animateUserMovement(distance,this::drag,false);
                scoreAchieved++;
                check = 0;
                //  System.out.println("Crossed");
            } else {
                // move to the end of the line and fall
                double distance = length + x - 50;
                animateUserMovement(distance, this::animateUserFallMovement,true);
                isFalling=true;
                // System.out.println("Falling");
            }
        }

    }

    void checkIntersection(Line rod,Rectangle block){
        if(rod.getBoundsInParent().intersects(block.getBoundsInParent())){
            canCrossObstacle = true;
        }
        else{
            canCrossObstacle = false;
        }
    }


    private void animateUserMovement(double targetX, Runnable onFinishedCallback, boolean fall) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), user);
        transition.setToX(targetX);

        // Use a timeline to check for collisions at intervals
        Timeline collisionCheckTimeline = new Timeline(
                new KeyFrame(Duration.millis(1), event -> {
                    double currentX = user.getBoundsInParent().getMinX();
                    if (isCherryPresent && checkIntersectionCherry(currentX) && fall) {
                        //System.out.println("Intersects");
                        newCherry.setOpacity(0);
                    }
                    else if (isCherryPresent && checkIntersectionCherry(currentX) && !fall) {
                        //System.out.println("Intersects");
                        newCherry.setOpacity(0);
                        //Increment the score missing
                        cherryEaten = true;

                    }
                    // event to detect the fall in an inverted position
                    double lowerBound = obstacle1.getBoundsInParent().getMinX();
                    double upperBound = obstacle1.getBoundsInParent().getMaxX();
                    //System.out.println(lowerBound + " " + currentX + " " + upperBound + " " + flip);
                    if((lowerBound <= currentX && currentX <= upperBound) && flip && canrotate<1){
                        //  System.out.println("YOO");
                        canrotate++;
                        animateUserFallMovement();
                    }

                })
        );
        collisionCheckTimeline.setCycleCount(Animation.INDEFINITE);

        if (onFinishedCallback != null) {
            transition.setOnFinished(event -> {
                onFinishedCallback.run();

                if(cherryEaten){
                    cherryCollected++;
                    cherryEaten = false;
                }
                cherryWriter();
                scoreWriter();
                // Stop the collision check timeline when the animation is finished
                collisionCheckTimeline.stop();
            });
        }

        // Start the collision check timeline
        collisionCheckTimeline.play();

        // Start the animation
        transition.play();
    }

    public void cherryWriter(){
        cherryReader.setText(String.valueOf(cherryCollected));
    }

    public void scoreWriter(){
        scoreReader.setText(String.valueOf(scoreAchieved));
    }
    private void animateUserFallMovement() {
        TranslateTransition transition = new TranslateTransition(Duration.millis(100), user);
        transition.setToY(40);

        canFlip = false;

        transition.setOnFinished(event->{
            user.setOpacity(0);
            Rotate rotate1 = new Rotate(90, stick1.getEndX(), stick1.getEndY());
            stick1.getTransforms().add(rotate1);
            Timeline newtimeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rotate1.angleProperty(), 0)),
                    new KeyFrame(Duration.millis(100), new KeyValue(rotate1.angleProperty(), 90))
            );

            newtimeline.setOnFinished(event1->{
                setRotated(false);
                cherryBox.setOnMousePressed(e->{
                    revive();
                });
                cherry1.setOnMousePressed(e->{
                    revive();
                });
                cherryReader1.setOnMousePressed(e->{
                    revive();
                });

                scoreReader11.setOnMousePressed(e->{
                    skipToTheMain();
                });
                scoreBox.setOnMousePressed(e->{
                    skipToTheMain();
                });
                revivalCost = (int) Math.pow(2,revivalCount);
                System.out.println(revivalCost);
                String a1=String.valueOf(revivalCost);
                cherryReader1.setText(a1);
                revivalGroup.setOpacity(1);
            });
            newtimeline.play();
        });

        transition.play();
    }


    @FXML
    void revive() {
//        calculateRevive();
//        if(cherryCollected >= revivalCost){
//            cherryCollected -= revivalCost;
//            if(scoreAchieved >= revivalCount){
//                scoreAchieved -= revivalCount;
//            }
//            revivalCount++;
//            cherryWriter();
//            scoreWriter();
//            System.out.println("Helo");
//
//
//        }

       // calculateRevive();

        System.out.println("revive: " + revivalCost);
        System.out.println("called");
        if(revivalCost <= cherryCollected){
            a = new PlayerScreen();
            Stage current = (Stage) this_pane.getScene().getWindow();
            current.close();
            cherryCollected -= revivalCost;
            revivalCount++;
            cherryWriter();
            RevivalInfo revivalInfo = new RevivalInfo();
            revivalInfo.setCherry(Integer.parseInt(cherryReader.getText()));
            revivalInfo.setScore(Integer.parseInt(scoreReader.getText()));
            revivalInfo.setRevivalCount(revivalCount);
            revivalInfo.setInitialWidth(initial.getWidth());
            revivalInfo.setInitialRectangleX(initial.getBoundsInParent().getMinX());
            revivalInfo.setObstacleWidth(obstacle1.getWidth());
            revivalInfo.setObstacleX(obstacle1.getBoundsInParent().getMinX());
//        a.close();
            a.start(new Stage());
        }
        else{
            System.out.println("Cannot revive");
        }




//        user.setVisible(true);
    }

    private Rectangle cloneRectangle(Rectangle original,double x,double width) {
        Rectangle clone = new Rectangle();
        clone.setX(100);
        clone.setY(90);
        // Copy common properties
//        clone.setX(original.getX());
//        clone.setY(original.getY());
        clone.setWidth(width);
        clone.setHeight(original.getHeight());

        // Copy specific properties (customize as needed)
        clone.setFill(original.getFill());
        clone.setLayoutX(x); // Offset the clone
        clone.setLayoutY(original.getLayoutY());
        System.out.println("Done");
        return clone;
    }
    public void setInitialRectangle(double x,double width){
        // Rectangle newInitial = cloneRectangle(initial,x,width);

        //  this_pane.getChildren().remove(initial);
        //  Rectangle new_T= new Rectangle();


        System.out.println("Width: " + width);
        //   initial = new_T;
        initial.setFill(Color.BLACK);
        initial.setWidth(width);
        initial.setLayoutX(x);
    }


    public void save(){
        saveClass saveClass = new saveClass();
        saveClass.setScore(Integer.parseInt(scoreReader.getText()));
        saveClass.setRevivalCount(revivalCount);
        saveClass.setInitialWidth(initial.getWidth());
        saveClass.setInitialRectangleX(initial.getBoundsInParent().getMinX());
        saveClass.setObstacleWidth(obstacle1.getWidth());
        saveClass.setObstacleX(obstacle1.getBoundsInParent().getMinX());


    }
    public void setRevivalCount(int x){
        this.revivalCount = x;
    }
    public void setObstacleRectangle(double x,double width){
        obstacle1.setWidth(width);
        obstacle1.setLayoutX(x);
        obstacle1.setFill(Color.BLACK);
    }

    public void setCherryEaten(int x){

        // Remaining : Read from other file which contains the total cherry Count
        cherryReader.setText(String.valueOf(x));
        cherryCollected = Integer.parseInt(cherryReader.getText());
    }

    public void setScoreReader(int x){

        scoreReader.setText(String.valueOf(x));
        scoreAchieved = x;
    }

    private void recreateStick(){

        this_pane.getChildren().remove(stick1);
        Line stick2 = new Line();
        stick2.setStartY(40);
        stick2.setEndY(40);
        stick2.setLayoutX(81);
        stick2.setLayoutY(247);
        stick2.setStrokeWidth(5);
        this_pane.getChildren().add(stick2);
        stick1=stick2;


        //Properties ko coorect krna h
        setOnLine(false);
        isRotated = true;

    }
    private void moveUser(ImageView imageView) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), imageView);
        transition.setToX(0);
        transition.setToY(0);
        transition.play();

        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(2), initial);
        transition1.setToX(0);
        transition1.setToY(0);
        transition1.play();
    }


//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/playerScreen.fxml"));
//            Parent root = loader.load();
//
//            // Replace the scene
//            Scene newScene = new Scene(root, 600, 400);
//            Stage stage = (Stage) this_pane.getScene().getWindow();
//            stage.setScene(newScene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }





    void skipToTheMain() {

        //Capture the cherry

        String filePath = "Record.txt";
        try {

            FileWriter fileWriter = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Integer.toString(cherryCollected));
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }

        //Catching the leader
        LeaderInfo leaderInfo = new LeaderInfo();

        leaderInfo.setScore(scoreAchieved);
        System.out.println("SUCCESS");
        //Clear the file revivalINfo
        filePath = "revivalInfo";

        try {
            Files.write(Path.of(filePath), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File cleared successfully.");
            Stage stage = (Stage) (this_pane.getScene().getWindow());
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }



        Stage s = (Stage) user.getScene().getWindow();
        s.close();
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.start(new Stage());

    }

    void writeScoreInFile() throws IOException {
        FileWriter file = new FileWriter("Record.txt");
        file.write(String.valueOf(scoreAchieved));
    }

    public void readScoreFromFile() throws IOException{

        FileReader file = new FileReader("Record.txt");
        BufferedReader bufferedReader = new BufferedReader(file);
        String line = bufferedReader.readLine();
        if (line != null) {
            cherryCollected = Integer.parseInt(line.trim());
        }
        cherryWriter();
    }

    private void checkExtension() {

        if(check == 0) {
            double obstacleRightX = getTopRightCoordinates(obstacle1)[0];
            double lineRightX = getAbsoluteCoordinatesLine(stick1.getStartX(), stick1.getStartY())[0];
            //    System.out.println(obstacleRightX + "  " + lineRightX);
            if (obstacleRightX <= lineRightX) {
                setCanStick1Extend(true);
                // System.out.println("True");
            } else {
                setCanStick1Extend(false);
                // System.out.println("False");
            }
        }
    }

    private double[] getTopRightCoordinates(Rectangle rectangle) {
        double x = rectangle.getBoundsInParent().getMaxX() - 2;
        double y = rectangle.getBoundsInParent().getMinY();
        return new double[]{x, y};
    }

    private double getCenterX(ImageView imageView) {
        return imageView.getBoundsInParent().getMinX() + imageView.getBoundsInParent().getWidth() / 2;
    }

    private double getCenterY(ImageView imageView) {
        return imageView.getBoundsInParent().getMinY() + imageView.getBoundsInParent().getHeight() / 2;
    }

    private double[] getAbsoluteCoordinatesLine(double x, double y) {
        double absoluteX;
        double absoluteY;
        if(check == 0) {
            absoluteX = stick1.localToScene(x, y).getX();
            absoluteY = stick1.localToScene(x, y).getY();
        }
        else{
            absoluteX = stick1.localToScene(x, y).getX();
            absoluteY = stick1.localToScene(x, y).getY();
        }
        return new double[]{absoluteX, absoluteY};
    }

    public void drag() {
    canrotate=0;
//        System.out.println("Initial Rectangle Coordinates (before drag Animation):");
//        System.out.println("Min X: " + initial.getBoundsInParent().getMinX());
//        System.out.println("Max X: " + initial.getBoundsInParent().getMaxX());
//
//        System.out.println("Obstacle Coordinates (before drag Animation):");
//        System.out.println("Min X: " + obstacle1.getBoundsInParent().getMinX());
//        System.out.println("Max X: " + obstacle1.getBoundsInParent().getMaxX());

        canFlip = false;
        double targetX = initial.getBoundsInParent().getMaxX();
        double init_x= initial.getBoundsInParent().getMaxX();
        System.out.println("targetx is "+targetX);



        double extra = initial.getBoundsInParent().getMaxX() + obstacle1.getBoundsInParent().getMinX();
        double targetXObstacle = obstacle1.getBoundsInParent().getMaxX() - targetX;
        // System.out.println("obstacle target is "+targetXObstacle);
        animateLineMovement(stick1, stick1.getStartX(), -extra);
        animateRectangleMovement(initial, -targetX);
        animateRectangleMovement(obstacle1, -targetXObstacle);

        //       System.out.println("targetLineEndX " + extra);

        setUserAtInitial(user, -targetXObstacle + 20);
        Random rand = new Random();


        Rectangle new1= new Rectangle();
        new1.setHeight(118);

        double temp4=  rand.nextDouble(100);
        double rand_w=50+temp4;

        new1.setWidth(rand_w);
        double temp1=600-init_x-150;
        double temp2= rand.nextDouble(temp1);

        double rand_x= init_x+temp2;

        System.out.println("rand_x is "+rand_x);
        new1.setX(600);

        //new1.setX(temp1);
        new1.setY(284);
        new1.setFill(Color.BLACK);
        this_pane.getChildren().add(new1);
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.25),new1);
        t.setToX(-rand_x);
        t.play();


        if(isCherryPresent()){
            dragCherryFromLeft(newCherry);
        }
        cherryGenerator(targetX,600-rand_x,rand_w);
        // Create a timeline to execute an event after the animation is complete
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            // Print coordin    ates after the animation is complete
//            System.out.println("Initial Rectangle Coordinates (After drag Animation):");
//            System.out.println("Min X: " + initial.getBoundsInParent().getMinX());
//            System.out.println("Max X: " + initial.getBoundsInParent().getMaxX());
//
//            System.out.println("Obstacle Coordinates (After dragAnimation):");
//            System.out.println("Min X: " + obstacle1.getBoundsInParent().getMinX());
//            System.out.println("Max X: " + obstacle1.getBoundsInParent().getMaxX());

            setPlayerRestriction(true);
            //  place();
            this_pane.getChildren().remove(initial);
            //   this_pane.getChildren().remove(stick1);
            initial=obstacle1;
            obstacle1=new1;
            initial.setFill(Color.BLACK);
            Line stick2= new Line();
            this_pane.getChildren().add(stick2);
            readyYourStick(stick2);


            // stick1=stick2;

            // Call the place() method after the animation is complete

        }));

        // Set the timeline delay to match the duration of your animation
        timeline.setDelay(Duration.millis(1000)); // Change this value accordingly

        // Play the timeline
        timeline.play();

    }



    private void readyYourStick(Line stick2){
        stick2.setStartY(40);
        stick2.setEndY(40);
        stick2.setLayoutX(81);
        stick2.setLayoutY(247);
        stick2.setStrokeWidth(5);
        stick1=stick2;
        setOnLine(false);
        isRotated = true;
    }

    private void animateRectangleMovement(Rectangle rectangle, double targetX) {
        if (rectangle == initial) {
//            System.out.println("in animate");
//            System.out.println("Before Animation:");
//            System.out.println("Min X: " + initial.getBoundsInParent().getMinX());
//            System.out.println("Max X: " + initial.getBoundsInParent().getMaxX());
        }

        KeyValue keyValue = new KeyValue(rectangle.xProperty(), rectangle.getX() + targetX);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);

        Timeline timeline = new Timeline(keyFrame);
        timeline.setOnFinished(event -> {
            if (rectangle == initial) {
//                System.out.println("After Animation:");
//                System.out.println("Min X: " + initial.getBoundsInParent().getMinX());
//                System.out.println("Max X: " + initial.getBoundsInParent().getMaxX());
//                System.out.println("Exiting naimayte");
            }
        });

        timeline.play();
    }



    private void animateLineMovement(Line stick,double start, double end) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1.25), stick);
        double deltaX = end - start;
        transition.setByX(deltaX);
        transition.play();
    }

//    public void place() {
//        //  rounds++;
//        this_pane.getChildren().remove(initial);
//        this_pane.getChildren().remove(stick1);
//        System.out.println("here");
//        initial = obstacle1;
//        initial.setFill(Color.BLACK);
//
//        obstacle1 = new Rectangle(100, 118); // Set width and height
//        obstacle1.setX(590); // Start at the left edge of the scene
//        obstacle1.setY(284); // Adjust Y-coordinate as needed
//        this_pane.getChildren().add(obstacle1);
//        Line stick2 = new Line();
//        readyYourStick(stick2);
//
//        // Create a TranslateTransition to move the obstacle to x=250
//        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), obstacle1);
//
//
//        transition.setToX(-250);
//        transition.play();
//        transition.setOnFinished(event -> {
//            this_pane.getChildren().add(stick2);
//            cherryGenerator();
//
//        });
//    }

    public static int getRandomLeftCoordinate() {
        // Create a Random object
        Random random = new Random();
        int minValue = 84 + 20;
        int maxValue = 0;
        // Use nextInt to generate a random integer within the specified range
        // (maxValue - minValue + 1) ensures the result is within the inclusive range
        int randomValue = random.nextInt(maxValue - minValue + 1) + minValue;

        return randomValue;
    }



    private void setUserAtInitial(ImageView imageView, double targetX) {
        double currentX = imageView.getBoundsInParent().getMinX();
        // Calculate the distance to move
        double deltaX = (targetX - currentX)/2;
        // Create a TranslateTransition
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), imageView);
        // Set the new X-coordinate
        transition.setToX(0);

        // Play the animation
        transition.play();
    }

    private void cherryGenerator(double tx, double txo, double rand_w) {
        newCherry = new ImageView(cherry.getImage());
        setCherryPresent(true);

        // Get the x - coordinate
        double minX = tx;
        double maxX = txo;

        double initialXCoordinate = 600 - tx - 10;
        double finalXCoordinate = (minX + maxX) / 2;

        double yCoordinate = background.getScene().getHeight() - 100;
        double distanceToMove = -finalXCoordinate + initialXCoordinate;

        newCherry.setLayoutX(initialXCoordinate);
        newCherry.setLayoutY(yCoordinate);
        newCherry.setFitHeight(30);
        newCherry.setFitWidth(30);

        this_pane.getChildren().add(newCherry);

        // Create a TranslateTransition for the cherry
        TranslateTransition cherryTransition = new TranslateTransition(Duration.seconds(1), newCherry);
        cherryTransition.setToX(finalXCoordinate - initialXCoordinate);
        cherryTransition.play();
    }

    private void dragCherryFromRight(ImageView newCherry,double distanceToMove) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(100), newCherry);
        transition.setOnFinished(actionEvent -> {
            //this_pane.getChildren().remove(newCherry);
            printCherry();
        });
        transition.setToX(distanceToMove);
        transition.play();
    }

    private void dragCherryFromLeft(ImageView newCherry) {
        ImageView old=newCherry;


        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), newCherry);
        transition.setOnFinished(actionEvent -> {
            this_pane.getChildren().remove(newCherry);
        });

        double distanceToMove = old.getBoundsInParent().getMaxX() ;
        System.out.println(distanceToMove);
        transition.setByX(-1*distanceToMove);
        transition.play();
    }

    public void flipUser(){

        if(!isFlip() && isCanFlip()) {
            System.out.println("flipping");
            user.setY(+user.getBoundsInParent().getHeight());
            user.setRotate(180);
            user.setScaleX(-1);
            setFlip(true);
        }
        else{
            System.out.println("back to normal");
            user.setRotate(0);
            user.setY(0);
            user.setScaleX(1);
            setFlip(false);
        }
    }

    public boolean checkIntersectionCherry(double x){
        double position1 = newCherry.getBoundsInParent().getMinX();
        double position2 = newCherry.getBoundsInParent().getMaxX();
        if(isFlip() && (position1 <= x && position2 >= x)){
            return true;
        }
        return false;
    }



    void printCherry(){
        System.out.println("X - coordinates of cherry : " + newCherry.getBoundsInParent().getMinX() + " , " + newCherry.getBoundsInParent().getMaxX());
    }
    void printCoordinates(Line stick) {
        double[] startCoords = getAbsoluteCoordinatesLine(stick.getStartX(), stick.getStartY());
        double[] endCoords = getAbsoluteCoordinatesLine(stick.getEndX(), stick.getEndY());

        System.out.println("Stick - Start Coordinates : (" + startCoords[0] + ", " + startCoords[1] + ")");
        System.out.println("Stick - End Coordinates   : (" + endCoords[0] + ", " + endCoords[1] + ")");
    }
}