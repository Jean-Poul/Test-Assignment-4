package com.teamrocket.Template;

import com.teamrocket.Template.game.GameFrame;
import com.teamrocket.Template.game.Sign;
import com.teamrocket.Template.game.TicTacToe;
import com.teamrocket.Template.game.exception.BoardSpotAlreadyInUseException;
import com.teamrocket.Template.game.exception.InvalidBoardSpotException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class TemplateApplication {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        Sign sign = gameFrame.assignSignToPlayer();
        TicTacToe ticTacToe = gameFrame.startNewGame(sign.player(), sign.computer());
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;
        while (isPlaying) {
            gameFrame.drawGame(ticTacToe);
            System.out.printf("""
                    Where do you want to put your %s?
                    Choose a field between 1 and 9
                    %n""", sign.player());
            String line = scanner.nextLine();
            try {
                int field = Integer.parseInt(line);
                gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), field);
                if (gameFrame.hasWon(ticTacToe, ticTacToe.getPlayer())) {
                    gameFrame.drawGame(ticTacToe);
                    System.out.println("Yay you won!");
                    isPlaying = false;
                }
                tryMoveComputer(gameFrame, ticTacToe);
                if (gameFrame.hasWon(ticTacToe, ticTacToe.getComputer())) {
                    gameFrame.drawGame(ticTacToe);
                    System.out.println("You lost to a shitty AI lol");
                    isPlaying = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("please input a valid number");
            } catch (InvalidBoardSpotException | BoardSpotAlreadyInUseException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static void tryMoveComputer(GameFrame gameFrame, TicTacToe ticTacToe) {
        try {
            int computerScore = RANDOM.nextInt(1, 10);
            gameFrame.makeMove(ticTacToe, ticTacToe.getComputer(), computerScore);
        } catch (InvalidBoardSpotException | BoardSpotAlreadyInUseException e) {
            tryMoveComputer(gameFrame, ticTacToe);
        }
    }

}
