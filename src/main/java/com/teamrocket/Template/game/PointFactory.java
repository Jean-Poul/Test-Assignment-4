package com.teamrocket.Template.game;

import java.util.Map;

public class PointFactory {

    private static final Map<Integer, BoardPoint> BOARD_POINTS = Map.of(
        1, new BoardPoint(0, 0),
        2, new BoardPoint(0, 1),
        3, new BoardPoint(0, 2),
        4, new BoardPoint(1, 0),
        5, new BoardPoint(1, 1),
        6, new BoardPoint(1, 2),
        7, new BoardPoint(2, 0),
        8, new BoardPoint(2, 1),
        9, new BoardPoint(2, 2)
    );

    private static final BoardPoint DEFAULT = new BoardPoint(100, 100);

    public static BoardPoint createBoardPoint(Integer field) {
        return BOARD_POINTS.getOrDefault(field, DEFAULT);
    }

}
