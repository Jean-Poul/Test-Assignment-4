package com.teamrocket.Template.game;

import static java.util.Objects.nonNull;

import com.teamrocket.Template.game.exception.BoardSpotAlreadyInUseException;
import com.teamrocket.Template.game.exception.InvalidBoardSpotException;
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
        if (x >= moves.length) {
            return null;
        }
        if (y >= moves[x].length) {
            return null;
        }
        return moves[x][y];
    }

    private void putSign(String sign, int x, int y) throws BoardSpotAlreadyInUseException, InvalidBoardSpotException {
        if (x >= moves.length) {
            throw new InvalidBoardSpotException("Invalid x value %s".formatted(x));
        }
        if (y >= moves[x].length) {
            throw new InvalidBoardSpotException("Invalid y value %s".formatted(y));
        }
        if (nonNull(moves[x][y])) {
            throw new BoardSpotAlreadyInUseException("The spot %s %s is already in use".formatted(x, y));
        }
        moves[x][y] = sign;
    }

    public void putSignForPlayer(int x, int y) throws BoardSpotAlreadyInUseException, InvalidBoardSpotException {
        putSign(player, x, y);
    }

    public void putSignForComputer(int x, int y) throws BoardSpotAlreadyInUseException, InvalidBoardSpotException {
        putSign(computer, x, y);
    }
}
