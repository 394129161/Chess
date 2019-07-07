package main.project.five.DTO;

import java.awt.*;

public class DropPoint extends Point implements main.project.DTO.DropPoint {
    private static DropPoint dropPoint = new DropPoint();

    private DropPoint() {}

    public static DropPoint getDropPoint() {
        return dropPoint;
    }
}
