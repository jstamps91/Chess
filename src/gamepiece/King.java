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
    public ArrayList<Cell> move(Cell[][] state, int x, int y) {

        // King can move 1 step. All adjacent cells have been considered
        possibleMoves.clear();

        int[] possibleX = {x, x, x + 1, x + 1, x + 1, x - 1, x - 1, x - 1};
        int[] possibleY = {y - 1, y + 1, y - 1, y, y + 1, y - 1, y, y + 1};

        for (int i = 0; i < 8; i++) {
            if (possibleX[i] >= 0 && possibleX[i] < 8 &&
                    possibleY[i] >= 0 && possibleY[i] < 8) {
                if (state[possibleX[i]][possibleY[i]].getPiece() == null ||
                        state[possibleX[i]][possibleY[i]].getPiece().getColor() != this.getColor()) {
                    possibleMoves.add(state[possibleX[i]][possibleY[i]]);
                }
            }
        }
        return possibleMoves;
    }

    public boolean isInDanger(Cell state[][]) {

        for(int i = x + 1; i < 8; i++) {
            if(state[i][y].getPiece() == null) {
                continue;
            } else if(state[i][y].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                if((state[i][y].getPiece() instanceof Rook) || (state[i][y].getPiece() instanceof Queen)) {
                    return true;
                } else {
                    break;
                }
            }
        }

        for(int i = x - 1; i >= 0; i--) {
            if (state[i][y].getPiece() == null) {
                continue;
            } else if (state[i][y].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                if ((state[i][y].getPiece() instanceof Rook) || (state[i][y].getPiece() instanceof Queen)) {
                    return true;
                } else {
                    break;
                }
            }
        }

        for(int i = y + 1; i < 8; i++) {
            if (state[x][i].getPiece() == null) {
                continue;
            } else if (state[x][i].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                if ((state[x][i].getPiece() instanceof Rook) || (state[x][i].getPiece() instanceof Queen)) {
                    return true;
                } else {
                    break;
                }
            }
        }

        for(int i = y - 1; i >= 0; i--) {
            if (state[x][i].getPiece() == null) {
                continue;
            } else if (state[x][i].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                if ((state[x][i].getPiece() instanceof Rook) || (state[x][i].getPiece() instanceof Queen)) {
                    return true;
                } else {
                    break;
                }
            }
        }

        // Checking for attack from diagonal direction
        int tempX = x + 1, tempY = y - 1;






        return true;
    }


}
