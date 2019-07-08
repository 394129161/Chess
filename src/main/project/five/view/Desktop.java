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

public class Desktop extends main.project.view.Desktop {
    private ImageIcon map;				//棋盘背景位图
    private ImageIcon blackchess;		//黑子位图
    private ImageIcon whitechess;		//白子位图

    ChessResource chess = ChessResource.getInstance();

    private Referee referee;
    private Player player;
    private Player winner;

    private Point paintPoint;
    private Point mousePos;
    private DropPoint dropPoint;

    public int N;							//棋盘边长
    private int h;							//棋盘长
    private int w;							//棋盘宽


    private Situation situation;

    public Desktop(ArrayList<Player> playerList) {
        dropPoint = DropPoint.getDropPoint();
        paintPoint = new Point();
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
        referee = Referee.getInstance();
        referee.playerMeeting(playerList);
        referee.init();
        winner = null;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

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

    @Override
    public void paintChess(Graphics g) {
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


    private class MouseClicked extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            // e.getX(),e.getY()
            mousePos.setLocation(e.getX(), e.getY());
            player = referee.getPlayer();
            player.interactive(mousePos);
            referee.execute();
            winner = situation.getWinner();
            repaint();

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

}
