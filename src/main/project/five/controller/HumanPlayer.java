package main.project.five.controller;

import main.project.five.DTO.DropPoint;
import main.project.five.utils.Tools;

import java.awt.*;

/**
 * 玩家类.
 * 该类是人类玩家类。
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class HumanPlayer extends main.project.controller.HumanPlayer {
    /** 该玩家是哪一边的(黑、白) */
    private int side;
    /** 鼠标与程序的交互是否可以控制棋面 */
    private boolean ctrlFlag;

    /**
     * 玩家类与棋面的交互.
     * 获得鼠标点击位置，得到落棋位置
     * @param mousePos
     *          鼠标点击位置
     */
    @Override
    public void interactive(Point mousePos) {
        Tools.getPoint(mousePos);
    }

    /**
     * 构建并初始化玩家对象.
     * 鼠标与程序交互可以控制棋面
     * @param side
     *          某一边(黑、白)
     */
    public HumanPlayer(int side) {
        this.side = side;
        this.ctrlFlag = true;
    }

    /**
     * 了解该玩家对象是否是可以通过鼠标交互的对象.
     * @return ctrlFlag
     *          true 是
     *          false 不是
     */
    public boolean canBeCtrled() {
        return ctrlFlag;
    }

    /**
     * 了解该玩家对象是哪一边的.
     * @return side
     *          BLACK_ONE
     *          WHITE_ONE
     */
    public int getSide() {
        return side;
    }
}
