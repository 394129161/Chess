package main.project.five.service;

import main.project.controller.Player;
import main.project.five.DTO.DropPoint;
import main.project.five.model.Situation;
import main.project.five.view.ChessResource;

import java.awt.*;
import java.util.ArrayList;

public class Referee extends main.project.service.Referee {
    private ArrayList<Player> playerList;

    private ChessResource chessResource = ChessResource.getInstance();

    private Situation situation = Situation.getInstance();

    private int playerIndex;

    private DropPoint dropPoint = DropPoint.getDropPoint();

    public Referee(ArrayList<Player> playerList) {
        this.playerList = playerList;

        // 初始化，黑棋先下
        for (int i=0; i<playerList.size(); i++) {
            if (playerList.get(i).getSide() == chessResource.BLACK_ONE) {
                this.playerIndex = i;
                break;
            }
        }

    }

    private boolean check() {
        if(situation.getWinner() != null) {
            return false;
        }
        if(this.getPlayer().canBeCtrled() == false) {
            return false;
        }
        if(situation.getComposition(dropPoint) != chessResource.NONE_ONE) {
            return false;
        }

        return true;
    }

    private void drop() {
        situation.setComposition(dropPoint, this.getPlayer().getSide());
    }

    private boolean judge() {
        if(this.countNum(0, 1)) {
            return true;
        }
        if(this.countNum(1, 1)) {
            return true;
        }
        if(this.countNum(1, 0)) {
            return true;
        }
        if(this.countNum(1, -1)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute() {
        if(check()) {
            drop();
            if(judge()) {
                wined();
            } else {
                nextPlayerIndex();
            }

        }

    }

    private void wined() {
        situation.setWinner(this.getPlayer());
    }

    public void reSet(){}

    private boolean countNum(int ex, int ey) {
        int num = 1;
        int i;
        int x = (int)dropPoint.getX();
        int y = (int)dropPoint.getY();
        Point point = new Point();


        for(i=1; x + i * ex < 15
              && x + i * ex >= 0
              && y + i * ey < 15
              && y + i * ey >= 0; i++) {
            point.setLocation(x + i*ex, y+i*ey);
            if(situation.getComposition(point) == this.getPlayer().getSide()) {
                num += 1;
            } else {
                break;
            }
        }
        for (i=-1; x + i * ex < 15
                && x + i * ex >= 0
                && y + i * ey < 15
                && y + i * ey >= 0; i--) {
            point.setLocation(x + i*ex, y+i*ey);
            if(situation.getComposition(point) == this.getPlayer().getSide()) {
                num += 1;
            } else {
                break;
            }
        }

        return (num >= 5);
    }


    @Override
    public Player getPlayer() {
        return playerList.get(playerIndex);
    }

    private void nextPlayerIndex() {
        playerIndex += 1;
        if(playerIndex == playerList.size()) {
            playerIndex = 0;
        }
    }
}
