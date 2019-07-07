package main.project.five.view;

import main.project.five.DTO.DropPoint;
import main.project.five.model.Situation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// import main.project.view.five.Chess;

public class Desktop extends main.project.view.Desktop {
    private ImageIcon map;				//棋盘背景位图
    private ImageIcon blackchess;		//黑子位图
    private ImageIcon whitechess;		//白子位图

    ChessResource chess = ChessResource.getInstance();

    private Point paintPoint;
    private Point mousePos;
    private DropPoint dropPoint;

    public int N;							//棋盘边长
    private int h;							//棋盘长
    private int w;							//棋盘宽

    public final int BLACK_ONE;					//-1表黑子
    public final int WHITE_ONE;					//1表白子
    public final int NONE_ONE;					//0表无子

    private Situation situation;

    public Desktop() {
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

        BLACK_ONE = -1;
        WHITE_ONE = 1;
        NONE_ONE = 0;

        situation = Situation.getInstance();
        // repaint();
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
                if(situation.getComposition(paintPoint)==BLACK_ONE){
                    blackchess.paintIcon(this,g,w/N*i,h/N*j);
                }
                else if(situation.getComposition(paintPoint)==WHITE_ONE){
                    whitechess.paintIcon(this,g,w/N*i,h/N*j);
                }
            }
    }


    private class MouseClicked extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            // e.getX(),e.getY()
            mousePos.setLocation(e.getX(), e.getY());

        }
    }

}
