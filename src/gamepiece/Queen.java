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
    public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
        return null;
    }
}
