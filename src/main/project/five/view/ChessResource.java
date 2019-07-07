package main.project.five.view;

import javax.swing.*;

public class ChessResource {
    private static ChessResource chess = new ChessResource();

    public static ChessResource getInstance() {
        return chess;
    }

    private ImageIcon map;
    private ImageIcon blackChess;
    private ImageIcon whiteChess;
    private int mapHeight;
    private int mapWidth;
    private int N;
    public final int BLACK_ONE = -1;				//-1表黑子
    public final int WHITE_ONE = 1;					//1表白子
    public final int NONE_ONE = 0;					//0表无子

    private ChessResource() {
        this.map = new ImageIcon("src\\main\\project\\five\\resource\\bg.jpg");
        this.blackChess = new ImageIcon("src\\main\\project\\five\\resource\\blackchess.gif");
        this.whiteChess = new ImageIcon("src\\main\\project\\five\\resource\\whitechess.gif");
        this.N = 15;
        this.mapHeight = blackChess.getIconHeight()*(N-1);
        this.mapWidth = blackChess.getIconWidth()*(N-1);
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getN() {
        return N;
    }

    public ImageIcon getMap() {
        return map;
    }

    public ImageIcon getBlackChess() {
        return blackChess;
    }

    public ImageIcon getWhiteChess() {
        return whiteChess;
    }
}
