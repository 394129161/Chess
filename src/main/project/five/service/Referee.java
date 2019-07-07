package main.project.five.service;

import main.project.controller.Player;
import main.project.five.DTO.DropPoint;
import main.project.five.model.Situation;
import main.project.five.view.ChessResource;

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
        return false;
    }

    @Override
    public void execute() {
        if(check()) {
            drop();
            judge();
            nextPlayerIndex();
        }

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
