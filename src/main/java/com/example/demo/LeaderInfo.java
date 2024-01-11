package com.example.demo;

import java.io.*;

public class LeaderInfo {

    private final String FILE_PATH = "LeaderInfo";

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        updateFile();
    }

    public LeaderInfo(){
        readFromFile();
    }
    int score;

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            this.score = Integer.parseInt(reader.readLine());
        }  catch (IOException e) {
           // throw new RuntimeException(e);
        }
    }

    private void updateFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILE_PATH)))) {
            writer.write(Integer.toString(score));
            writer.newLine();
        } catch (IOException e) {
            //e.printStackTrace(); // Handle the exception as needed
        }

        int highScore = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("HighScore.txt")))) {
             highScore = Integer.parseInt(reader.readLine());
        }  catch (IOException e) {
            // throw new RuntimeException(e);
        }

        System.out.println("WHY not");

        //Updating the highScore

        System.out.println("High: "  + highScore);
        if(highScore < this.score){
            System.out.println("NICE");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("HighScore.txt")))) {
                writer.write(Integer.toString(score));
                writer.newLine();
            } catch (IOException e) {
                //e.printStackTrace(); // Handle the exception as needed
            }
        }

    }
}
