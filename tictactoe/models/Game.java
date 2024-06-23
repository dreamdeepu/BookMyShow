package models;

import exception.InvalidBotCountException;
import exception.InvalidPlayerSizeException;
import exception.InvalidSymbolSetupException;
import service.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player> players;
    private WinningStrategy winningStrategy;
    private int dimension;
    private int numberOfSymbols;

    public Game(Board board, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = board;
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = players.size();
    }

    public static Builder builder(){
        return new Builder();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setBoard(Board board) {
        this.currentBoard = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public static class Builder{
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;
        private int dimension;

        private int numberOfSymbols;

        public Builder setBoard(Board board) {
            this.currentBoard = board;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setNumberOfSymbols(int numberOfSymbols) {
            this.numberOfSymbols = numberOfSymbols;
            return this;
        }

        private void validateNumberOfPlayers(){
            // if board size is n and no bot = n-1
            //else if bot present then n-2 players
            if(players.size()<currentBoard.getDimension()-2 || players.size()>= currentBoard.getDimension()){
                throw new InvalidPlayerSizeException("Players size should be n-2 or n-1 only");
            }
        }

        private void validatePlayerSymbols(){
            HashSet<Character> symbols = new HashSet<>();
            for(Player player : players){
                symbols.add(player.getSymbol());
            }
            if(symbols.size()!=players.size()){
                throw new InvalidSymbolSetupException("There should be unique symbols for all the players");
            }
        }

        private void validateBotCount(){
            int botCount=0;
            for(Player player : players){
                if(player.getPlayerType()==PlayerType.BOT){
                    botCount++;
                }
            }

            if(botCount>1 || botCount<0){
                 throw new InvalidBotCountException("We can only have max 1 bot per game");
            }
        }

        private void validate(){
            validateNumberOfPlayers();
            validatePlayerSymbols();
            validateBotCount();
        }

        public Game build(){
            validate();
            return new Game(new Board(dimension),players,winningStrategy);
//            return null;
        }
    }
}
