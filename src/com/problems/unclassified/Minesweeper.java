package com.problems.unclassified;

import java.util.ArrayList;
import java.util.List;

public class Minesweeper {
    public static void main(String[] args){
        char[][] input = {{'B','1','E','1','B'},{'B','1','M','1','B'},{'B','1','1','1','B'},{'B','B','B','B','B'}};
        int[] click = {1, 2};
        Game game = new Game(input);
        game.click(click);
        System.out.println(game);
    }

    private static class Game {
        Square[][] board;

        public Game(char[][] input) {
            int rows = input.length;
            int cols = input[0].length;
            this.board = new Square[rows][cols];
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    this.board[i][j] = new Square(input[i][j]);
                }
            }

            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    List<Square> adjacent = new ArrayList<>();
                    if(i - 1 >= 0){
                        if(j - 1 >= 0) adjacent.add(this.board[i-1][j-1]);
                        if(j + 1 < cols) adjacent.add(this.board[i-1][j+1]);
                        adjacent.add(this.board[i-1][j]);
                    }
                    if(i + 1 < rows){
                        if(j - 1 >= 0) adjacent.add(this.board[i+1][j-1]);
                        if(j + 1 < cols) adjacent.add(this.board[i+1][j+1]);
                        adjacent.add(this.board[i+1][j]);
                    }
                    if(j - 1 >= 0) adjacent.add(this.board[i][j-1]);
                    if(j + 1 < cols) adjacent.add(this.board[i][j+1]);
                    Square square = this.board[i][j];
                    if(!adjacent.isEmpty()) square.setAdjacents(adjacent);
                }
            }
        }

        public void click(int[] click){
            Square square = this.board[click[0]][click[1]];
            square.reveal();
        }

        public char[][] getBoardState(){
            char[][] state = new char[this.board.length][this.board[0].length];
            for(int i=0;i<this.board.length;i++){
                for(int j=0;j<this.board[0].length;j++){
                    state[i][j] = this.board[i][j].getState();
                }
            }
            return state;
        }

        @Override
        public String toString() {
            StringBuilder string = new StringBuilder();
            string.append('[');
            for(int i=0;i<this.board.length;i++){
                string.append('[');
                String[] states = new String[this.board[0].length];
                for(int j=0;j<this.board[0].length;j++){
                    states[j] = this.board[i][j].toString();
                }
                string.append(String.join(",", states));
                string.append("]");
            }
            string.append("]");
            return string.toString();
        }
    }

    private static class Square{
        private char state;
        private List<Square> adjacents;
        private boolean isRevealed;
        private final boolean isMine;

        public Square(char state) {
            this.state = state;
            this.isMine = state=='M' || state=='X';
            this.isRevealed = state!='M' && state!='E';
            this.adjacents = new ArrayList<>();
        }

        public void reveal(){
            this.isRevealed = true;
            if(this.state == 'M') this.state='X';
            else if(this.state == 'E'){
                int mines = countMines();
                if(mines > 0){
                    this.state = String.valueOf(mines).charAt(0);
                }
                else{
                    this.state = 'B';
                    for(Square square : this.adjacents){
                        if(!square.isMine() && !square.isRevealed()) square.reveal();
                    }
                }
            }
        }

        private int countMines(){
            int count = 0;
            for(Square square:this.adjacents){
                if(square.isMine()) count++;
            }
            return count;
        }

        public char getState() {
            return state;
        }

        public void setState(char state) {
            this.state = state;
        }

        public List<Square> getAdjacents() {
            return adjacents;
        }

        public void setAdjacents(List<Square> adjacents) {
            this.adjacents = adjacents;
        }

        public boolean isRevealed() {
            return isRevealed;
        }

        public void setRevealed(boolean revealed) {
            isRevealed = revealed;
        }

        public boolean isMine() {
            return isMine;
        }

        @Override
        public String toString() {
            return "'" + this.state + "'";
        }
    }
}
