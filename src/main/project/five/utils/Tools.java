package main.project.five.utils;

import main.project.five.DTO.DropPoint;
import main.project.five.view.ChessResource;

import java.awt.*;

/**
 * 杂项工具类.
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class Tools {
    private Tools() {}
    private static ChessResource chessResource = ChessResource.getInstance();

    /**
     * 根据鼠标点击位置计算落棋位置
     * @param mousePos
     *          鼠标点击位置
     */
    public static void getPoint(Point mousePos) {
        int unitLength;
        DropPoint dropPoint = DropPoint.getDropPoint();
        unitLength = chessResource.getMapHeight()/chessResource.getN();
        dropPoint.setLocation((int)mousePos.getX()/unitLength, (int)mousePos.getY()/unitLength);
    }


}
