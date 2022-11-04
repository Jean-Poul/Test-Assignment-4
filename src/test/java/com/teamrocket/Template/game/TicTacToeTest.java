package com.teamrocket.Template.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeTest {
    private TicTacToe ticTacToe;
    private String player;
    private String computer;


    @BeforeEach
    void setUp() {
        player = "X";
        ticTacToe = new TicTacToe();
        ticTacToe.putSignForPlayer(0, 0);

    }

    @Test
    void getField() {


    }
}