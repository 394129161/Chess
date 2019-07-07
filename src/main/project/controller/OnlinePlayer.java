package main.project.controller;

import java.awt.*;

public abstract class OnlinePlayer extends Player implements Online {
    public boolean ctrlFlag = false;
    @Override
    public void interactive(Point mousePos) {
    }
}
