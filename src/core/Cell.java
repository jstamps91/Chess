package core;

import gamepiece.King;
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

        setLayout(new BorderLayout());

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

        piece = p;
        ImageIcon img = new javax.swing.ImageIcon(this.getClass().getResource(p.getPath()));
        content = new JLabel(img);
        this.add(content);
    }

    public void removePiece() {

        piece = null;
        this.remove(content);
    }

    public Piece getPiece() {

        return this.piece;
    }

    public void select() {

        this.setBorder(BorderFactory.createLineBorder(Color.red, 6));
        this.isSelected = true;
    }

    public boolean isSelected() {

        return this.isSelected;
    }

    public void deselect() {

        this.setBorder(null);
        this.isSelected = false;
    }

    public void setPossibleDestination() {

        this.setBorder(BorderFactory.createLineBorder(Color.blue, 6));
        this.isPossibleDestination = true;
    }

    public void removePossibleDestination() {

        this.setBorder(null);
        this.isPossibleDestination = false;
    }

    public boolean isPossibleDestination() {

        return this.isPossibleDestination;
    }

    public void setCheck() {

        this.setBackground(Color.RED);
        this.isCheck = true;
    }

    public void removeCheck() {

        this.setBorder(null);

        if((x + y) % 2 == 0) {
            setBackground(new Color(113, 198, 113));
        } else {
            setBackground(Color.white);
        }

        this.isCheck = false;
    }

    public boolean isCheck() {

        return isCheck;
    }

}
