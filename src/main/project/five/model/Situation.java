package main.project.five.model;

import main.project.controller.Player;

import java.awt.*;

public class Situation extends main.project.model.Situation {
    private static Situation situation = new Situation();

    public static Situation getInstance() {
        return situation;
    }

    private int N;
    private int[][] composition;
    private Player winner;

    private Situation() {
        this.N = 15;
        this.composition = new int[N][N];
        this.winner = null;
    }


    @Override
    public int getComposition(Point point) {
        return this.composition[(int)point.getX()][(int)point.getY()];
    }

    @Override
    public void setComposition(Point point, int side) {
        this.composition[(int)point.getX()][(int)point.getY()] = side;
    }

    public void setWinner(Player player) {
        winner = player;
    }

    public Player getWinner() {
        return winner;
    }
}
