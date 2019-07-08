package main.project.five.view;

import javax.swing.*;

/**
 * 棋类信息.
 * 单例模式实现
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class ChessResource {
    private static ChessResource chess = new ChessResource();

    public static ChessResource getInstance() {
        return chess;
    }

    /** 棋面位图 */
    private ImageIcon map;
    /** 黑棋位图 */
    private ImageIcon blackChess;
    /** 白棋位图 */
    private ImageIcon whiteChess;
    /** 棋盘长度 */
    private int mapHeight;
    /** 棋盘宽度 */
    private int mapWidth;
    /** 每行or列可以装下的棋子数 */
    private int N;
    /** GUI标题 */
    private String title;
    // TODO: 2019/7/8  能否使用枚举代替
    /** 黑棋 */
    public final int BLACK_ONE = -1;				//-1表黑子
    /** 白棋 */
    public final int WHITE_ONE = 1;					//1表白子
    /** 无棋子 */
    public final int NONE_ONE = 0;					//0表无子

    /**
     * 初始化棋类信息
     */
    private ChessResource() {
        this.map = new ImageIcon("src\\main\\project\\five\\resource\\bg.jpg");
        this.blackChess = new ImageIcon("src\\main\\project\\five\\resource\\blackchess.gif");
        this.whiteChess = new ImageIcon("src\\main\\project\\five\\resource\\whitechess.gif");
        this.N = 15;
        this.mapHeight = blackChess.getIconHeight()*(N-1);
        this.mapWidth = blackChess.getIconWidth()*(N-1);
        this.title = "Five";
    }

    /**
     * 获得棋盘长度
     * @return height
     *          长度
     */
    public int getMapHeight() {
        return mapHeight;
    }
    /**
     * 获得棋盘宽度
     * @return width
     *          宽度
     */
    public int getMapWidth() {
        return mapWidth;
    }

    /**
     * 获得棋盘每行or每列可装下的棋子数
     * @return N
     *         棋子数
     */
    public int getN() {
        return N;
    }

    /**
     * 获得棋盘面位图
     * @return ImageIcon
     *          棋盘面位图
     */
    public ImageIcon getMap() {
        return map;
    }
    /**
     * 获得黑棋位图
     * @return ImageIcon
     *          黑棋位图
     */
    public ImageIcon getBlackChess() {
        return blackChess;
    }
    /**
     * 获得白棋位图
     * @return ImageIcon
     *          白棋位图
     */
    public ImageIcon getWhiteChess() {
        return whiteChess;
    }
    /**
     * 获得GUi标题
     * @return String
     *          GUI标题
     */
    public String getTitle() {
        return title;
    }
}
