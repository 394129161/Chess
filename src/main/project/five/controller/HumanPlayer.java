package main.project.five.controller;

import main.project.five.utils.Tools;

import java.awt.*;

public class HumanPlayer extends main.project.controller.HumanPlayer {
    @Override
    public Point interactive(Point mousePos) {
        return Tools.getPoint(mousePos);
    }
}
