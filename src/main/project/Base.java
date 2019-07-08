package main.project;

import main.project.controller.Player;
import main.project.five.controller.HumanPlayer;
import main.project.five.view.ChessResource;
import main.project.gui.Gui;

import java.util.ArrayList;
// TODO: 2019/7/8  重构GUI，适应多棋类实现
// TODO: 2019/7/8  实现人机、联网
// TODO: 2019/7/8  实现多棋类
/**
 * 逻辑上的基类，GUI和Player的构建的基础
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class Base {
    /**
     * 构建程序.
     */
    public Base() {
        ArrayList<Player> playerList = new ArrayList<Player>();
        ChessResource chessResource = ChessResource.getInstance();
        playerList.add(new HumanPlayer(chessResource.BLACK_ONE));
        playerList.add(new HumanPlayer(chessResource.WHITE_ONE));

        new Gui(playerList);
    }
}
