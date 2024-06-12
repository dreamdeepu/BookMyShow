package models;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private char symbol;
   private PlayerType playerType;

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Player() {
    }

    public Move makeMove(Board board){
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter the row for the target cell");
        int row = sn.nextInt();
        System.out.println("Enter the col for the target cell");
        int col = sn.nextInt();

        Cell playedMovecell = board.getMatrix().get(row).get(col);
        playedMovecell.setCellState(CellState.FILLED);
        playedMovecell.setPlayer(this);

        return new Move(playedMovecell,this);
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
