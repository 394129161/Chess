package main.project.five.service;

import main.project.controller.Player;
import main.project.five.DTO.DropPoint;
import main.project.five.model.Situation;
import main.project.five.view.ChessResource;

import java.awt.*;
import java.util.ArrayList;

/**
 * 裁判类，用于裁决棋局.
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class Referee extends main.project.service.Referee {
    /** 玩家列表 */
    private ArrayList<Player> playerList;

    /** 棋类信息 */
    private ChessResource chessResource = ChessResource.getInstance();

    /** 棋面状况 */
    private Situation situation = Situation.getInstance();

    /** 当前下棋玩家在玩家列表中的索引 */
    private int playerIndex;

    /** 落棋位置 */
    private DropPoint dropPoint = DropPoint.getDropPoint();

    /**
     * 构建和初始化裁判类.
     */
    public Referee(ArrayList<Player> playerList) {
        this.init(playerList);

    }

    /**
     * 裁判类重置.
     * 用于重新开始
     */
    public void reset() {
        this.init(this.playerList);
        situation.init();
    }

    /**
     * 裁判类初始化.
     * @param playerList
     *          玩家列表
     */
    private void init(ArrayList<Player> playerList) {
        this.playerList = playerList;

        // 初始化，黑棋先下
        for (int i=0; i<playerList.size(); i++) {
            if (playerList.get(i).getSide() == chessResource.BLACK_ONE) {
                this.playerIndex = i;
                break;
            }
        }
    }

    /**
     * 检查当前落棋位置是否符合规则
     * @return boolean
     *      true 符合规则
     *      false 不符合规则
     */
    private boolean check() {
        // 有赢家了
        if(situation.getWinner() != null) {
            return false;
        }
        // 当前玩家不能下棋
        if(this.getPlayer().canBeCtrled() == false) {
            return false;
        }
        // 当前落棋位置有棋子
        if(situation.getComposition(dropPoint) != chessResource.NONE_ONE) {
            return false;
        }

        return true;
    }

    /** 落棋. */
    private void drop() {
        situation.setComposition(dropPoint, this.getPlayer().getSide());
    }

    /**
     * 判断是否出现胜负
     * @return boolean
     *      true 有胜负结果
     *      false 还没有决出胜负
     */
    private boolean judge() {
        if(this.countNum(0, 1)) {
            return true;
        }
        if(this.countNum(1, 1)) {
            return true;
        }
        if(this.countNum(1, 0)) {
            return true;
        }
        if(this.countNum(1, -1)) {
            return true;
        }
        return false;
    }

    /**
     * 裁判裁决.
     */
    @Override
    public void execute() {
        // 是否能下棋
        if(check()) {
            // 落棋
            drop();
            // 有无胜负
            if(judge()) {
                // 有胜负
                wined();
            } else {
                // 没胜负
                nextPlayerIndex();
            }

        }

    }

    /**
     * 出现胜负，为棋面状况设定赢家
     */
    private void wined() {
        situation.setWinner(this.getPlayer());
    }

    /**
     * 计算当前落子在某个方向上连子的个数
     * @param ex
     *        单位向量X
     * @param ey
     *        单位向量Y
     * @return boolean
     *        true 大于等于5颗
     *        false 没有到达五颗
     */
    private boolean countNum(int ex, int ey) {
        int num = 1;
        int i;
        int x = (int)dropPoint.getX();
        int y = (int)dropPoint.getY();
        Point point = new Point();


        for(i=1; x + i * ex < 15
              && x + i * ex >= 0
              && y + i * ey < 15
              && y + i * ey >= 0; i++) {
            point.setLocation(x + i*ex, y+i*ey);
            if(situation.getComposition(point) == this.getPlayer().getSide()) {
                num += 1;
            } else {
                break;
            }
        }
        for (i=-1; x + i * ex < 15
                && x + i * ex >= 0
                && y + i * ey < 15
                && y + i * ey >= 0; i--) {
            point.setLocation(x + i*ex, y+i*ey);
            if(situation.getComposition(point) == this.getPlayer().getSide()) {
                num += 1;
            } else {
                break;
            }
        }

        return (num >= 5);
    }


    /**
     * 获得当前玩家
     * @return Player
     *          当前玩家
     */
    @Override
    public Player getPlayer() {
        return playerList.get(playerIndex);
    }

    /**
     * 设置下一个玩家的索引
     */
    private void nextPlayerIndex() {
        playerIndex += 1;
        if(playerIndex == playerList.size()) {
            playerIndex = 0;
        }
    }
}
