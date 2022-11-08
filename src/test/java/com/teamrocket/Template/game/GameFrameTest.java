package com.teamrocket.Template.game;

import com.teamrocket.Template.game.exception.BoardSpotAlreadyInUseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
        Sign playersSign = gameFrame.assignSignToPlayer();
        assertNotSame(playersSign.player(), playersSign.computer());
    }

    @Test
    @DisplayName("when a move is made, the TicTacToe board has the correct move on it")
    void whenAMoveIsMadeTheTicTacToeBoardHasTheCorrectMoveOnIt() throws Exception {
        TicTacToe ticTacToe = gameFrame.startNewGame("X", "O");
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 2);
        gameFrame.drawGame(ticTacToe);
        assertNotNull(ticTacToe.getField(0, 1));
    }

    @Test
    @DisplayName("cant make a move on an already taken spot")
    void cantMakeAMoveOnAnAlreadyTakenSpot() throws Exception {
        TicTacToe ticTacToe = gameFrame.startNewGame("X", "O");
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 4);
        assertThrows(BoardSpotAlreadyInUseException.class, () -> gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 4));
    }

    @Test
    @DisplayName("can win with a column")
    void canWinWithAColumn() throws Exception {
        TicTacToe ticTacToe = gameFrame.startNewGame("X", "O");
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 1);
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 2);
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 3);
        assertTrue(gameFrame.hasWon(ticTacToe, ticTacToe.getPlayer()));
    }

    @Test
    @DisplayName("can win with a row")
    void canWinWithARow() throws Exception {
        TicTacToe ticTacToe = gameFrame.startNewGame("X", "O");
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 1);
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 4);
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 7);
        assertTrue(gameFrame.hasWon(ticTacToe, ticTacToe.getPlayer()));
    }

    @Test
    @DisplayName("can win with a diagonal line")
    void canWinWithADiagonalLine() throws Exception {
        TicTacToe ticTacToe = gameFrame.startNewGame("X", "O");
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 1);
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 5);
        gameFrame.makeMove(ticTacToe, ticTacToe.getPlayer(), 9);
        assertTrue(gameFrame.hasWon(ticTacToe, ticTacToe.getPlayer()));
    }
}