package main.project.five.controller;

import main.project.five.DTO.DropPoint;
import main.project.five.utils.Tools;

import java.awt.*;

public class HumanPlayer extends main.project.controller.HumanPlayer {
    private int side;
    private boolean ctrlFlag;

    @Override
    public void interactive(Point mousePos) {
        Tools.getPoint(mousePos);
    }

    public HumanPlayer(int side) {
        this.side = side;
        this.ctrlFlag = true;
    }

    public boolean canBeCtrled() {
        return ctrlFlag;
    }

    public int getSide() {
        return side;
    }
}
