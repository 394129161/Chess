package main.project.controller;

import main.project.five.DTO.DropPoint;

import java.awt.*;

public abstract class Player {
    public abstract void interactive(Point mousePos);
    public abstract int getSide();
    public abstract boolean canBeCtrled();
}
