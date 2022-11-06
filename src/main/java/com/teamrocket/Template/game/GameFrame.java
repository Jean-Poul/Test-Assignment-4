package com.teamrocket.Template.game;

import static java.util.Objects.isNull;

import com.teamrocket.Template.game.exception.BoardSpotAlreadyInUseException;
import com.teamrocket.Template.game.exception.InvalidBoardSpotException;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class GameFrame {


    private final Random rand = new Random();

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


    public void drawGame(TicTacToe ticTacToe) {
        final String[][] frame = {
            {"+", "-", "+", "-", "+", "-", "+"},
            {"|", " ", "|", " ", "|", " ", "|"},
            {"+", "-", "+", "-", "+", "-", "+"},
            {"|", " ", "|", " ", "|", " ", "|"},
            {"+", "-", "+", "-", "+", "-", "+"},
            {"|", " ", "|", " ", "|", " ", "|"},
            {"+", "-", "+", "-", "+", "-", "+"},
        };

        int fieldNum = 0;
        for (String[] strings : frame) {
            for (String string : strings) {
                String s = string;
                if (s.equals(" ")) {
                    fieldNum++;
                    BoardPoint boardPoint = PointFactory.createBoardPoint(fieldNum);
                    String field = ticTacToe.getField(boardPoint.x(), boardPoint.y());
                    s = isNull(field) ? " " : field;
                }
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(TicTacToe ticTacToe, String player, Integer field)
        throws InvalidBoardSpotException, BoardSpotAlreadyInUseException {
        BoardPoint boardPoint = PointFactory.createBoardPoint(field);
        if (ticTacToe.getPlayer().equals(player)) {
            ticTacToe.putSignForPlayer(boardPoint.x(), boardPoint.y());
        } else {
            ticTacToe.putSignForComputer(boardPoint.x(), boardPoint.y());
        }
    }

    public boolean hasWon(TicTacToe ticTacToe, String player) {
        return hasWon(ticTacToe, player, 1);
    }

    private boolean hasWon(TicTacToe ticTacToe, String player, int field) {
        if (field == 10) {
            return false;
        }
        BoardPoint boardPoint = PointFactory.createBoardPoint(field);
        if (hasCol(ticTacToe, player, boardPoint) ||
            hasRow(ticTacToe, player, boardPoint) ||
            hasDiagonal(ticTacToe, player, boardPoint)
        ) {
            return true;
        }
        return hasWon(ticTacToe, player, ++field);
    }

    private boolean hasCol(TicTacToe ticTacToe, String player, BoardPoint boardPoint) {
        String[] move = ticTacToe.getMoves()[boardPoint.x()];
        for (String s : move) {
            if (!player.equals(s)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasRow(TicTacToe ticTacToe, String player, BoardPoint boardPoint) {
        for (int i = 0; i < 3; i++) {
            if (!player.equals(ticTacToe.getField(i, boardPoint.y()))) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDiagonal(TicTacToe ticTacToe, String player, BoardPoint boardPoint) {
        String field = ticTacToe.getField(1, 1);
        // If the player has nothing in the middle then what are we doing here
        if (!player.equals(field)) {
            return false;
        }

        if (player.equals(ticTacToe.getField(0, 0)) && player.equals(ticTacToe.getField(2, 2))) {
            return true;
        }
        return player.equals(ticTacToe.getField(0, 2)) && player.equals(ticTacToe.getField(2, 0));
    }

}
