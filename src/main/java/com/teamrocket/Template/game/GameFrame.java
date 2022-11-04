package com.teamrocket.Template.game;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GameFrame {


    private Random rand = new Random();

    public GameFrame() {

    }

    public TicTacToe startNewGame(String player, String computer) {
        return new TicTacToe(player, computer);
    }

    public String assignSignToPlayer() {
        int computerScore = rand.nextInt(1, 7);
        int playerScore = rand.nextInt(1, 7);
        System.out.println("Computer's score: " + computerScore);
        System.out.println("Your score: " + playerScore);
        if (computerScore > playerScore) {
            System.out.println("Computer starts wit X !");
            return "O";
        } else if (computerScore < playerScore) {
            System.out.println("You start wit X !");
            return "X";
        } else {
            return assignSignToPlayer();
        }
    }


    public void makeMove() {
        //todo Logic for making a move
        drawGame();

    }

    public void drawGame() {


        final String[][] frame = {
                {"+", "-", "+", "-", "+", "-", "+"},
                {"|", " ", "|", " ", "|", " ", "|"},
                {"+", "-", "+", "-", "+", "-", "+"},
                {"|", " ", "|", " ", "|", " ", "|"},
                {"+", "-", "+", "-", "+", "-", "+"},
                {"|", " ", "|", " ", "|", " ", "|"},
                {"+", "-", "+", "-", "+", "-", "+"},
        };


        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame[i].length; j++) {
                System.out.print(frame[i][j] + " ");
            }
            System.out.println();
        }
    }


}
