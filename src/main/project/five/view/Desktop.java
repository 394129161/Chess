package main.project.five.view;

import main.project.controller.Player;
import main.project.five.DTO.DropPoint;
import main.project.five.model.Situation;
import main.project.five.service.Referee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

// import main.project.view.five.Chess;

/**
 * 下棋部分的GUI容器组件.
 * 有关下棋本身的所有视图都在这个类。
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class Desktop extends main.project.view.Desktop {
    /** 棋盘背景位图 */
    private ImageIcon map;
    /** 黑子位图 */
    private ImageIcon blackchess;
    /** 白子位图 */
    private ImageIcon whitechess;

    /** 该棋类和棋盘的数据 */
    ChessResource chess = ChessResource.getInstance();

    /** 裁判类 */
    private Referee referee;
    /** 当前玩家 */
    private Player player;
    /** 赢家 */
    private Player winner;

    /** 鼠标点击位置 */
    private Point mousePos;
    /** 落棋位置 */
    private DropPoint dropPoint;

    /** 棋盘边长 */
    public int N;
    /** 棋盘长 */
    private int h;
    /** 棋盘宽 */
    private int w;

    /** 棋面状况 */
    private Situation situation;

    /**
     * 构建该容器并初始化
     * @param playerList
     *          玩家列表
     */
    public Desktop(ArrayList<Player> playerList) {
        dropPoint = DropPoint.getDropPoint();

        mousePos = new Point();

        MouseClicked mouseClicked = new MouseClicked();
        this.addMouseListener(mouseClicked);

        map = chess.getMap();
        blackchess =chess.getBlackChess();
        whitechess =chess.getWhiteChess();

        N=chess.getN();
        h=chess.getMapHeight();
        w=chess.getMapWidth();



        situation = Situation.getInstance();
        referee = new Referee(playerList);
        winner = null;

    }

    /**
     * 绘图.
     * @param g
     *        图像
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    /**
     * 绘制棋盘面.
     * @param g
     *        图像
     */
    @Override
    public void paintChessMap(Graphics g) {

        map.paintIcon(this, g,10,10);

        g.setColor(Color.BLACK);
        for(int j=0; j<N; j++){							//画线
            g.drawLine(h/N/2,h/N*j+h/N/2,w-w/N+(N%2)*(h/N/2),h/N*j+h/N/2);
            g.drawLine(w/N*j+h/N/2,h/N/2,w/N*j+h/N/2,h-h/N+(N%2)*(h/N/2));
        }
        g.fillRect(w/N*7+h/N/2-3,h/N*7+h/N/2-3,6,6);//画5个黑方块
        g.fillRect(w/N*3+h/N/2-3,h/N*3+h/N/2-3,6,6);
        g.fillRect(w/N*11+h/N/2-3,h/N*3+h/N/2-3,6,6);
        g.fillRect(w/N*3+h/N/2-3,h/N*11+h/N/2-3,6,6);
        g.fillRect(w/N*11+h/N/2-3,h/N*11+h/N/2-3,6,6);

    }

    /**
     * 根据棋面状况(situation)绘制棋子.
     * @param g
     *        图像
     */
    @Override
    public void paintChess(Graphics g) {
        Point paintPoint = new Point();
        int i,j;
        for(i=0;i<N;i++)
            for(j=0;j<N;j++){
                paintPoint.setLocation(i, j);
                if(situation.getComposition(paintPoint)==chess.BLACK_ONE){
                    blackchess.paintIcon(this,g,w/N*i,h/N*j);
                }
                else if(situation.getComposition(paintPoint)==chess.WHITE_ONE){
                    whitechess.paintIcon(this,g,w/N*i,h/N*j);
                }
            }
    }


    /**
     * 鼠标监听类，人机交互.
     */
    private class MouseClicked extends MouseAdapter {
        /**
         * 点击事件.
         * @param e
         *        鼠标事件
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            // 获得鼠标点击位置
            mousePos.setLocation(e.getX(), e.getY());
            // 获得当前玩家
            player = referee.getPlayer();
            // 玩家类与点击位置交互获得落棋位置
            player.interactive(mousePos);
            // 裁判根据落棋位置进行裁决
            referee.execute();
            // 获得当前赢家
            winner = situation.getWinner();
            // 刷新，重绘图像
            repaint();

            // 如果有赢家，返回对话框
            if (winner != null) {
                String winDialog;
                if(winner.getSide() == chess.BLACK_ONE) {
                    winDialog = "黑棋赢了";
                } else {
                    winDialog = "白棋赢了";
                }
                JOptionPane.showMessageDialog(null,winDialog);
            }

        }
    }

    /**
     * 重新开始.
     */
    public void reset() {
        referee.reset();
        repaint();
    }


}
