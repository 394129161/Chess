package main.project;

import main.project.controller.Player;
import main.project.five.controller.HumanPlayer;
import main.project.five.view.ChessResource;
import main.project.gui.Gui;

import java.util.ArrayList;

public class Base {
    public static void main(String[] args) {
        ArrayList<Player> playerList = new ArrayList<Player>();
        ChessResource chessResource = ChessResource.getInstance();
        playerList.add(new HumanPlayer(chessResource.BLACK_ONE));
        playerList.add(new HumanPlayer(chessResource.WHITE_ONE));

        new Gui(playerList);
    }
}
