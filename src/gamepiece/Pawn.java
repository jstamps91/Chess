package gamepiece;

import core.Cell;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(String id, String path, int color) {

        setId(id);
        setPath(path);
        setColor(color);
    }

    @Override
    public ArrayList<Cell> move(Cell[][] state, int x, int y) {

        possibleMoves.clear();

        if(getColor() == 0) {

            if(x == 0) {
                return possibleMoves;
            }

            if(state[x - 1][y].getPiece() == null) {
                possibleMoves.add(state[x - 1][y]);

                if(state[4][y].getPiece() == null) {
                    possibleMoves.add(state[4][y]);
                }
            }

            if((y > 0) && (state[x - 1][y - 1].getPiece() != null) && (state[x - 1][y - 1].getPiece().getColor() != this.getColor())) {
                possibleMoves.add(state[x - 1][y - 1]);
            }

            if((y < 7) && (state[x - 1][y + 1].getPiece() != null) && (state[x - 1][y + 1].getPiece().getColor() != this.getColor())) {
                possibleMoves.add(state[x - 1][y + 1]);
            }

        } else {

            if(x == 8) {
                return possibleMoves;
            }
        }

        if(state[x + 1][y].getPiece() == null) {
            possibleMoves.add(state[x + 1][y]);

            if(x == 1) {

                if(state[3][y].getPiece() == null) {
                    possibleMoves.add(state[3][y]);
                }
            }
        }

        if((y > 0) && (state[x + 1][y - 1].getPiece() != null) && (state[x + 1][y - 1].getPiece().getColor() != this.getColor())) {
            possibleMoves.add(state[x + 1][y - 1]);
        }

        if((y < 7) && (state[x + 1][y + 1].getPiece() != null) && (state[x + 1][y + 1].getPiece().getColor() != this.getColor())) {
            possibleMoves.add(state[x + 1][y + 1]);
        }

        return possibleMoves;
    }
}
