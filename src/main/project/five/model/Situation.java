package main.project.five.model;

import java.awt.*;

public class Situation extends main.project.model.Situation {
    private static Situation situation = new Situation();

    public static Situation getInstance() {
        return situation;
    }

    private int N;
    private int[][] composition;

    private Situation() {
        this.N = 15;
        this.composition = new int[N][N];
    }


    @Override
    public Integer getComposition(Point point) {
        return this.composition[(int)point.getX()][(int)point.getY()];
    }

    @Override
    public void setComposition(Point point, int val) {
        this.composition[(int)point.getX()][(int)point.getY()] = val;
    }
}
