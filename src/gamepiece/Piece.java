package gamepiece;

import java.util.ArrayList;

import core.Cell;

public abstract class Piece implements Cloneable {

    private String id = null;
    private String path;
    private int color;

    protected ArrayList<Cell> possibleMoves = new ArrayList<Cell>(); // child classes have access to protected
    public abstract ArrayList<Cell> move(Cell pos[][], int x, int y); // abstract must be overridden

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Piece getCopy() throws CloneNotSupportedException {

        return (Piece) this.clone();
    }

}
