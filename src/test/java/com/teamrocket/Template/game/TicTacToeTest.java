package com.teamrocket.Template.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import com.teamrocket.Template.game.exception.BoardSpotAlreadyInUseException;
import com.teamrocket.Template.game.exception.InvalidBoardSpotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicTacToeTest {

    private TicTacToe ticTacToe;
    private String player;
    private String computer;

    @BeforeEach
    void setUp() {
        player = "X";
        computer = "O";
        ticTacToe = new TicTacToe(player, computer);
    }

    @Test
    void getField() throws Exception {
        ticTacToe.putSignForPlayer(0, 0);
        String field = ticTacToe.getField(0, 0);
        assertNotNull(field);
    }

    @Test
    @DisplayName("player can put a sign on the board")
    void playerCanPutASignOnTheBoard() throws Exception {
        ticTacToe.putSignForPlayer(0, 0);
        String field = ticTacToe.getField(0, 0);
        assertEquals(player, field);
    }

    @Test
    @DisplayName("computer can put a sign on the board")
    void computerCanPutASignOnTheBoard() throws Exception {
        ticTacToe.putSignForComputer(0, 0);
        String field = ticTacToe.getField(0, 0);
        assertEquals(computer, field);
    }

    @Test
    @DisplayName("cannot put a sign on an already taken spot")
    void cannotPutASignOnAnAlreadyTakenSpot() throws Exception {
        ticTacToe.putSignForPlayer(0, 0);
        assertThrows(BoardSpotAlreadyInUseException.class, () -> ticTacToe.putSignForPlayer(0, 0));
    }

    @Test
    @DisplayName("will throw if given an invalid indexing")
    void willThrowIfGivenAnInvalidIndexing() throws Exception {
        assertThrows(InvalidBoardSpotException.class, () -> ticTacToe.putSignForPlayer(4, 0));
    }
}