package main.project.view;

import javax.swing.*;
import java.awt.*;

// TODO: 2019/7/6 this.addMouseListener

public abstract class Desktop extends JPanel{


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintChessMap(g);
        paintChess(g);
    }

    public abstract void paintChessMap(Graphics g);
    public abstract void paintChess(Graphics g);
}
