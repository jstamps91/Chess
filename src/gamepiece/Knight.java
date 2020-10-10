package gamepiece;

import core.Cell;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(String id, String path, int color) {

        setId(id);
        setPath(path);
        setColor(color);
    }


    @Override
    public ArrayList<Cell> move(Cell[][] state, int x, int y) {

        possibleMoves.clear();

        int posX[] = {x + 1, x + 1, x + 2, x + 2, x - 1, x - 1, x - 2, x - 2};
        int posY[] = {y - 2, y + 2, y - 1, y + 1, y - 2, y + 2, y - 1, y + 1};

        for(int i = 0; i < 8; i++) {
            if(posX[i] >= 0 && posX[i] < 8 && posY[i] >= 0 && posY[i] < 8) {
                if(state[posX[i]][posY[i]].getPiece() == null || state[posX[i]][posY[i]].getPiece().getColor() != this.getColor()) {
                    possibleMoves.add(state[posX[i]][posY[i]]);
                }
            }
        }
        return possibleMoves;
    }
}
