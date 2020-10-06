package core;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gamepiece.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Logic extends JFrame implements MouseListener {

    private Logic() {

    }

    public void changeTurn() {

    }

    private King getKing(int color) {

    }

    private void cleanDestinations(ArrayList<Cell> destlist) {

    }

    private void highlightDestinations(ArrayList<Cell> destlist) {

    }

    private boolean kingInDanger(Cell from, Cell to) {

    }

    private ArrayList<Cell> filterDestination(ArrayList<Cell> destlist, Cell from) {

    }

    private ArrayList<Cell> inCheckFilter(ArrayList<Cell> destlist, Cell from, int color) {

    }

    public boolean checkmate(int color) {

    }

    private void gameOver() {

    }

    public void mouseClicked(MouseEvent arg0) {

    }

    //Other Irrelevant abstract function. Only the Click Event is captured.
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    class START implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class TimeChange implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {

        }
    }

    class SelectHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }



}
