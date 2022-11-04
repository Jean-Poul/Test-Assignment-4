package com.teamrocket.Template.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TicTacToe {
    private String[][] moves = new String[3][3];

    private String player;
    private String computer;

    public TicTacToe(String player, String computer) {
        this.player = player;
        this.computer = computer;
    }

    public String getField(Integer x, Integer y) {
        return this.moves[x][y];
    }

    public void putSignForPlayer( int x, int y) {
        this.moves[x][y] = player;
    }
}
