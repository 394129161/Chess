package main.project.five.utils;

import main.project.five.DTO.DropPoint;
import main.project.five.view.ChessResource;

import java.awt.*;

public class Tools {
    private Tools() {}
    private static ChessResource chessResource = ChessResource.getInstance();

    public static void getPoint(Point mousePos) {
        int unitLength;
        DropPoint dropPoint = DropPoint.getDropPoint();
        unitLength = chessResource.getMapHeight()/chessResource.getN();
        dropPoint.setLocation((int)mousePos.getX()/unitLength, (int)mousePos.getY()/unitLength);
    }


}
