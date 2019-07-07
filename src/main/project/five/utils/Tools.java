package main.project.five.utils;

import main.project.five.view.ChessResource;

import java.awt.*;

public class Tools {
    private Tools() {}
    private static ChessResource chessResource = ChessResource.getInstance();

    public static Point getPoint(Point mousePos) {
        int unitLength;
        unitLength = chessResource.getMapHeight()/chessResource.getN();
        return new Point((int)mousePos.getX()/unitLength, (int)mousePos.getY()/unitLength);
    }
}
