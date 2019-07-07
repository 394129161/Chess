package main.project.model;

import java.awt.*;

public abstract class Situation {

    private Object composition;

    public abstract int getComposition(Point point);

    public abstract void setComposition(Point point, int side);

}
