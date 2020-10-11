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

    public boolean isInDanger(Cell[][] state) {

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

        while(tempX < 8 && tempY >= 0) {
            if(state[tempX][tempY].getPiece() == null) {
                tempX++;
                tempY--;
            } else if(state[tempX][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                if(state[tempX][tempY].getPiece() instanceof Bishop || state[tempX][tempY].getPiece() instanceof Queen) {
                    return true;
                } else {
                    break;
                }
            }
        }

        tempX = x - 1;
        tempY = y + 1;

        while(tempX >= 0 && tempY < 8) {
            if(state[tempX][tempY].getPiece() == null) {
                tempX--;
                tempY++;
            } else if(state[tempX][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                if(state[tempX][tempY].getPiece() instanceof Bishop || state[tempX][tempY].getPiece() instanceof Queen) {
                    return true;
                } else {
                    break;
                }
            }
        }

        tempX = x - 1;
        tempY = y - 1;

        while(tempX >= 0 && tempY >= 0) {
            if(state[tempX][tempY].getPiece() == null) {
                tempX--;
                tempY--;
            } else if(state[tempX][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                if(state[tempX][tempY].getPiece() instanceof Bishop || state[tempX][tempY].getPiece() instanceof Queen) {
                    return true;
                } else {
                    break;
                }
            }
        }

        tempX = x + 1;
        tempY = y + 1;

        while(tempX < 8 && tempY < 8) {
            if(state[tempX][tempY].getPiece() == null) {
                tempX++;
                tempY++;
            } else if(state[tempX][tempY].getPiece().getColor() == this.getColor()) {
                break;
            } else {
                if(state[tempX][tempY].getPiece() instanceof Bishop || state[tempX][tempY].getPiece() instanceof Queen) {
                    return true;
                } else {
                    break;
                }
            }
        }

        // Checking for attack from the Pawn of opposite color
        int[] posX = {x+1, x+1, x+2, x+2, x-1, x-1, x-2, x-2};
        int[] posY = {y-2, y+2, y-1, y+1, y-2, y+2, y-1, y+1};

        for(int i = 0; i < 8; i++) {
            if(posX[i] >= 0 && posX[i] < 8 && posY[i] >= 0 && posY[i] < 8) {
                if(state[posX[i]][posY[i]].getPiece() != null &&
                        state[posX[i]][posY[i]].getPiece().getColor() != this.getColor() &&
                        state[posX[i]][posY[i]].getPiece() instanceof Knight) {
                    return true;
                }
            }
        }


        int[] poX ={x+1, x+1, x+1, x, x, x-1, x-1, x-1};
        int[] poY ={y-1, y+1, y, y+1, y-1, y+1, y-1, y};

        for(int i = 0; i < 8; i++) {
            if(poX[i] >= 0 && poX[i] < 8 && poY[i] >= 0 && poY[i] < 8) {
                if(state[poX[i]][poY[i]].getPiece() != null &&
                        state[poX[i]][poY[i]].getPiece().getColor() != this.getColor() &&
                        state[poX[i]][poY[i]].getPiece() instanceof King) {
                    return true;
                }
            }
        }

        if(getColor() == 0) {
            if(x > 0 && y > 0 && state[x - 1][y - 1].getPiece() != null &&
                    state[x - 1][y - 1].getPiece().getColor() == 1 &&
                    state[x - 1][y - 1].getPiece() instanceof Pawn) {
                return true;
            }
            return x > 0 && y < 7 && state[x - 1][y + 1].getPiece() != null &&
                    state[x - 1][y + 1].getPiece().getColor() == 1 &&
                    state[x - 1][y + 1].getPiece() instanceof Pawn;
        } else {
            if(x < 7 && y > 0 && state[x + 1][y - 1].getPiece() != null &&
                    state[x + 1][y - 1].getPiece().getColor() == 1 &&
                    state[x + 1][y - 1].getPiece() instanceof Pawn) {
                return true;
            }
            return x < 7 && y < 7 && state[x + 1][y + 1].getPiece() != null &&
                    state[x + 1][y + 1].getPiece().getColor() == 1 &&
                    state[x + 1][y + 1].getPiece() instanceof Pawn;
        }
    }
}
