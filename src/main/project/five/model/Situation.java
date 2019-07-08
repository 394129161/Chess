package main.project.five.model;

import main.project.controller.Player;

import java.awt.*;

/**
 * 棋面状况.
 * 单例模式。
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class Situation extends main.project.model.Situation {
    /** 单例 */
    private static Situation situation = new Situation();
    /** 获得单例 */
    public static Situation getInstance() {
        return situation;
    }
    /** 每行or列可放入的棋子数 */
    private int N;
    /** 棋面 */
    private int[][] composition;
    /** 赢家 */
    private Player winner;

    /**
     * 构建并初始化棋面状况.
     */
    private Situation() {
        this.N = 15;
        this.init();
    }

    /**
     * 初始化棋面状况.
     */
    public void init() {
        this.composition = new int[N][N];
        this.winner = null;
    }

    /**
     * 获得棋面上某个位置的情况
     * @param point
     *        位置
     * @return side
     *          该位置是什么情况
     */
    @Override
    public int getComposition(Point point) {
        return this.composition[(int)point.getX()][(int)point.getY()];
    }

    /**
     * 设定棋面上某个位置的情况
     * @param point
     *          位置
     * @param side
     *          该位置的落子情况
     */
    @Override
    public void setComposition(Point point, int side) {
        this.composition[(int)point.getX()][(int)point.getY()] = side;
    }

    /**
     * 设置赢家对象
     * @param player
     *          被设置的赢家
     */
    public void setWinner(Player player) {
        winner = player;
    }

    /**
     * 获得赢家对象
     * @return Player
     *          赢家对象
     */
    public Player getWinner() {
        return winner;
    }
}
