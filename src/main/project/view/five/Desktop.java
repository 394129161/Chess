package main.project.view.five;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
// TODO: 2019/7/6 构建Point对象？
public class Desktop extends main.project.view.Desktop {
    private ImageIcon map;				//棋盘背景位图
    private ImageIcon blackchess;		//黑子位图
    private ImageIcon whitechess;		//白子位图

    private Point point;

    public int N;							//棋盘边长
    private int h;							//棋子长
    private int w;							//棋子宽

    public Desktop() {
        point = new Point();
        MouseClicked mouseClicked = new MouseClicked();
        this.addMouseListener(mouseClicked);
        map=new ImageIcon("src\\main\\project\\view\\gui\\resource\\five\\bg.jpg");
        blackchess=new ImageIcon("src\\main\\project\\view\\gui\\resource\\five\\blackchess.gif");
        whitechess=new ImageIcon("src\\main\\project\\view\\gui\\resource\\five\\whitechess.gif");

        N=15;
        h=blackchess.getIconHeight()*(N-1);
        w=blackchess.getIconWidth()*(N-1);
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
    }


    private class MouseClicked extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            // e.getX(),e.getY()
            point.setLocation(e.getX(), e.getY());
        }
    }

}
