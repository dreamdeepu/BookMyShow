package models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
        this.player = null;
    }

    public void displayCell(){
        if(player==null){
            System.out.print(" | |");
        }else{
            System.out.print("|"+player.getSymbol()+"|");
        }
    }
}
