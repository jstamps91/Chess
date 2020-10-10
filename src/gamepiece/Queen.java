package gamepiece;

import core.Cell;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(String id, String path, int color) {

        setId(id);
        setPath(path);
        setColor(color);
    }


    @Override
    public ArrayList<Cell> move(Cell[][] state, int x, int y) {

        possibleMoves.clear();

        int tempX = x - 1;

        while(tempX >= 0) {
            if(state[tempX][y].getPiece() == null) {
                possibleMoves.add(state[tempX][y]);
            } else if(state[tempX][y].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                possibleMoves.add(state[tempX][y]);
                break;
            }
            tempX--;
        }
        tempX = x + 1;

        while(tempX < 8) {
            if(state[tempX][y].getPiece() == null) {
                possibleMoves.add(state[tempX][y]);
            } else if(state[tempX][y].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                possibleMoves.add(state[tempX][y]);
                break;
            }
            tempX++;
        }
        int tempY = y - 1;

        while(tempY >= 0) {
            if(state[x][tempY].getPiece() == null) {
                possibleMoves.add(state[x][tempY]);
            } else if(state[x][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                possibleMoves.add(state[x][tempY]);
                break;
            }
            tempY--;
        }
        tempY = y + 1;

        while(tempY < 8) {
            if(state[x][tempY].getPiece() == null) {
                possibleMoves.add(state[x][tempY]);
            } else if(state[x][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                possibleMoves.add(state[x][tempY]);
                break;
            }
            tempY++;
        }
        tempX = x + 1;
        tempY = y - 1;

        while(tempX < 8 && tempY >= 0) {
            if(state[tempX][tempY].getPiece() == null) {
                possibleMoves.add(state[tempX][tempY]);
            } else if(state[tempX][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                possibleMoves.add(state[tempX][tempY]);
                break;
            }
            tempX++;
            tempY--;
        }
        tempX = x - 1;
        tempY = y + 1;

        while(tempX >= 0 && tempY < 8) {
            if(state[tempX][tempY].getPiece() == null) {
                possibleMoves.add(state[tempX][tempY]);
            } else if(state[tempX][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                possibleMoves.add(state[tempX][tempY]);
                break;
            }
            tempX--;
            tempY++;
        }
        tempX = x - 1;
        tempY = y - 1;

        while(tempX >= 0 && tempY >= 0) {
            if (state[tempX][tempY].getPiece() == null) {
                possibleMoves.add(state[tempX][tempY]);
            } else if (state[tempX][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                possibleMoves.add(state[tempX][tempY]);
                break;
            }
            tempX--;
            tempY--;
        }
        tempX = x + 1;
        tempY = y + 1;

        while(tempX < 8 && tempY < 8) {
            if(state[tempX][tempY].getPiece() == null) {
                possibleMoves.add(state[tempX][tempY]);
            } else if(state[tempX][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                possibleMoves.add(state[tempX][tempY]);
                break;
            }
            tempX++;
            tempY++;
        }
        return possibleMoves;
    }
}
