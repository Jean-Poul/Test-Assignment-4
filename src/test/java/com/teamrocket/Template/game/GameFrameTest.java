package com.teamrocket.Template.game;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class GameFrameTest {
    @Autowired
    GameFrame gameFrame;

    @Test
    void isNotNull() {
        assertNotNull(gameFrame);

    }

    @Test
    void startNewGameTest() {
        String player = "x";
        String computer = "o";
        TicTacToe ticTacToe = gameFrame.startNewGame(player, computer);
        assertTrue(ticTacToe.getPlayer().equals(player) && ticTacToe.getComputer().equals(computer));
    }


    @Test
    void assignSignToPlayer() {
        String playersSign = gameFrame.assignSignToPlayer();
        assertTrue(playersSign.equals("X") || playersSign.equals("O"));
    }

    @Test
    void makeMove() {
    }

    @Test
    void drawGame() {
    }
}