package core;

import gamepiece.Piece;
import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel implements Cloneable {

    private static final long serialVersionUID = 1L;
    private JLabel content;
    private Piece piece;
    int x, y;
    private boolean isPossibleDestination;
    private boolean isSelected;
    private boolean isCheck;

    public Cell(int x, int y, Piece p) {

        this.x = x;
        this.y = y;

        setLayout(new BorderLayout());

        if((x + y) % 2 == 0) {
            setBackground(new Color(113, 198, 113));
        } else {
            setBackground(Color.white);
        }

        if(p != null) {
            setPiece(p);
        }

    }


    public Cell(Cell cell) throws CloneNotSupportedException {

        this.x = cell.x;
        this.y = cell.y;

        setLayout(new BorderLayout);

        if((x + y) % 2 == 0) {
            setBackground(new Color(113, 198, 113));
        } else {
            setBackground(Color.white);
        }

        if(cell.getPiece() != null) {
            setPiece(cell.getPiece().getCopy());
        } else {
            piece = null;
        }
    }

    public void setPiece(Piece p) {

    }

    public void removePiece() {

    }

    public Piece getPiece() {

    }

    public void select() {

    }

    public boolean isSelected() {

    }

    public void deselect() {

    }

    public void setPossibleDestination() {

    }

    public void removePossibleDestination() {

    }

    public boolean isPossibleDestination() {

    }

    public void setCheck() {

    }

    public void removeCheck() {

    }

    public boolean isCheck() {

    }

}
