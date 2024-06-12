import models.*;
import service.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players, WinningStrategy winningStrategy){
        return null;
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public GameStatus getGameStatus(){
        return null;
    }

    public Player getWinner(){
        return null;
    }

    public Move executeMove(Game game, Player player){
        return null;
    }

    public Player checkWinner(Game game, Move move){
        return null;
    }

    public Board undoMove(Game game, Move lastPlayedMove){
        return null;
    }

    public void replayGame(Game game){

    }
}
