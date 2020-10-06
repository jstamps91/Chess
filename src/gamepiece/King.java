package gamepiece;

import java.util.ArrayList;

import core.Cell;

public class King extends Piece {

    int x, y;


    public King(String id, String path, int color, int x, int y) {

        setX(x);
        setY(y);
        setId(id);
        setPath(path);
        setColor(color);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
        return null;
    }

    public boolean isInDanger(Cell state[][]) {

    }


}
