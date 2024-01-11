package com.example.demo;

import java.io.*;

public class RevivalInfo {

    private int score;
    private int cherry;
    private int revivalCount;
    private double initialRectangleX;
    private double initialWidth;
    private double obstacleX;
    private double obstacleWidth;

    private static final String FILE_PATH = "revivalInfo";

    public RevivalInfo() {
        // Initialize with default values or load from file in constructor if needed\
        readFromFile();
    }

    // Getters and setters with file update

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        updateFile();
    }

    public int getCherry() {
        return cherry;
    }

    public void setCherry(int cherry) {
        this.cherry = cherry;
        updateFile();
    }

    public int getRevivalCount() {
        return revivalCount;
    }

    public void setRevivalCount(int revivalCount) {
        this.revivalCount = revivalCount;
        updateFile();
    }

    public double getInitialRectangleX() {
        return initialRectangleX;
    }

    public void setInitialRectangleX(double initialRectangleX) {
        this.initialRectangleX = initialRectangleX;
        updateFile();
    }

    public double getInitialWidth() {
        return initialWidth;
    }

    public void setInitialWidth(double initialWidth) {
        this.initialWidth = initialWidth;
        updateFile();
    }

    public double getObstacleX() {
        return obstacleX;
    }

    public void setObstacleX(double obstacleX) {
        this.obstacleX = obstacleX;
        updateFile();
    }

    public double getObstacleWidth() {
        return obstacleWidth;
    }

    public void setObstacleWidth(double obstacleWidth) {
        this.obstacleWidth = obstacleWidth;
        updateFile();
    }


    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            this.score = Integer.parseInt(reader.readLine());
            this.cherry = Integer.parseInt(reader.readLine());
            this.revivalCount = Integer.parseInt(reader.readLine());
            this.initialRectangleX = Double.parseDouble(reader.readLine());
            this.initialWidth = Double.parseDouble(reader.readLine());
            this.obstacleX = Double.parseDouble(reader.readLine());
            this.obstacleWidth = Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
           // e.printStackTrace(); // Handle the exception as needed
        }
    }

    // Update file method
    private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILE_PATH)))) {
            writer.write(Integer.toString(score));
            writer.newLine();
            writer.write(Integer.toString(cherry));
            writer.newLine();
            writer.write(Integer.toString(revivalCount));
            writer.newLine();
            writer.write(Double.toString(initialRectangleX));
            writer.newLine();
            writer.write(Double.toString(initialWidth));
            writer.newLine();
            writer.write(Double.toString(obstacleX));
            writer.newLine();
            writer.write(Double.toString(obstacleWidth));
        } catch (IOException e) {
            //e.printStackTrace(); // Handle the exception as needed
        }
    }

    public boolean isFileEmpty() {
        File file = new File(FILE_PATH);
        return !file.exists() || file.length() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Score: ").append(score).append("\n");
        sb.append("Cherry: ").append(cherry).append("\n");
        sb.append("Revival Count: ").append(revivalCount).append("\n");
        sb.append("Initial Rectangle X: ").append(initialRectangleX).append("\n");
        sb.append("Initial Rectangle Width: ").append(initialWidth).append("\n");
        sb.append("Obstacle X: ").append(obstacleX).append("\n");
        sb.append("Obstacle Width: ").append(obstacleWidth).append("\n");
        return sb.toString();
    }


}
