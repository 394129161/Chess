package main.project.five.DTO;

import java.awt.*;

/**
 * 落棋位置.
 * 是java.awt.Point的单例实现
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class DropPoint extends Point implements main.project.DTO.DropPoint {
    private static DropPoint dropPoint = new DropPoint();

    private DropPoint() {}

    public static DropPoint getDropPoint() {
        return dropPoint;
    }
}
