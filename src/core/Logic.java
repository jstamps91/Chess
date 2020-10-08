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
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Logic extends JFrame implements MouseListener {

    private static final long serialVersionUID = 1L;

    private static final int height = 700;
    private static final int width = 1110;
    private static Rook wr01, wr02, br01, br02;
    private static Bishop wb01, wb02, bb01, bb02;
    private static Knight wk01, wk02, bk01, bk02;
    private static Pawn wp[], bp[];
    private static Queen wq, bq;
    private static King wk, bk;
    private Cell cell, previous;
    private int chance = 0;
    private Cell boardState[][];
    private ArrayList<Cell> destinationList = new ArrayList<>();
    private Player white = null, black = null;
    private JPanel board = new JPanel(new GridLayout(8, 8));
    private JPanel wDetails = new JPanel(new GridLayout(3, 3));
    private JPanel bDetails = new JPanel(new GridLayout(3, 3));
    private JPanel wComboPanel = new JPanel();
    private JPanel bComboPanel = new JPanel();
    private JPanel controlPanel, whitePlayer, blackPlayer,
            displayTime, showPlayer, time, temp;
    private JSplitPane split;
    private JLabel label, mov;
    private static JLabel CHNC;
    private Time timer;
    public static Logic Mainboard;
    private boolean selected = false, end = false;
    private Container content;
    private ArrayList<Player> wPlayer, bPlayer;
    private ArrayList<String> wNames = new ArrayList<>();
    private ArrayList<String> bNames = new ArrayList<>();
    private JComboBox<String> wCombo, bCombo;
    private String wName = null, bName = null, winner = null;
    static String move;
    private Player tempPlayer;
    private JScrollPane wScroll, bScroll;
    private String[] WNames = {}, BNames = {};
    private JSlider timeSlider;
    private BufferedImage image;
    private Button start, wSelect, bSelect, wNewPlayer, bNewPlayer;
    public static int timeRemaining = 60;

    public static void main(String[] args) {
        // Variable initialization
        wr01=new Rook("WR01","White_Rook.png",0);
        wr02=new Rook("WR02","White_Rook.png",0);
        br01=new Rook("BR01","Black_Rook.png",1);
        br02=new Rook("BR02","Black_Rook.png",1);
        wk01=new Knight("WK01","White_Knight.png",0);
        wk02=new Knight("WK02","White_Knight.png",0);
        bk01=new Knight("BK01","Black_Knight.png",1);
        bk02=new Knight("BK02","Black_Knight.png",1);
        wb01=new Bishop("WB01","White_Bishop.png",0);
        wb02=new Bishop("WB02","White_Bishop.png",0);
        bb01=new Bishop("BB01","Black_Bishop.png",1);
        bb02=new Bishop("BB02","Black_Bishop.png",1);
        wq=new Queen("WQ","White_Queen.png",0);
        bq=new Queen("BQ","Black_Queen.png",1);
        wk=new King("WK","White_King.png",0,7,3);
        bk=new King("BK","Black_King.png",1,0,3);
        wp=new Pawn[8];
        bp=new Pawn[8];

        for(int i = 0; i < 8; i++) {
            wp[i] = new Pawn("WP0" + (i + 1), "White_Pawn.png", 0);
            bp[i] = new Pawn("BP0" + (i + 1), "Black_Pawn.png", 1);
        }

        // Game Board setup
        Mainboard = new Logic();
        Mainboard.setVisible(true);
        Mainboard.setResizable(false);
    }
    // Constructor
    private Logic() {

        timeRemaining = 60;
        timeSlider = new JSlider();

        move = "White";
        wName = null;
        bName = null;
        winner = null;
        board = new JPanel(new GridLayout(8, 8));
        wDetails = new JPanel(new GridLayout(3, 3));
        bDetails = new JPanel(new GridLayout(3, 3));
        wComboPanel = new JPanel();
        bComboPanel = new JPanel();
        wNames = new ArrayList<String>();
        bNames = new ArrayList<String>();

        board.setMinimumSize(new Dimension(800, 700));
        ImageIcon img = new ImageIcon(this.getClass().getResource("icon.png"));
        this.setIconImage(img.getImage());

        // Time Slider Details
        timeSlider.setMinimum(1);
        timeSlider.setMaximum(15);
        timeSlider.setValue(1);
        timeSlider.setMajorTickSpacing(2);
        timeSlider.setPaintLabels(true);
        timeSlider.setPaintTicks(true);
        timeSlider.addChangeListener(new TimeChange());

        // Fetch details of all players
        wPlayer = Player.fetchPlayers();
        for (Player player : wPlayer) {
            wNames.add(player.name());
        }

        bPlayer = Player.fetchPlayers();
        for (Player player : bPlayer) {
            bNames.add(player.name());
        }

        WNames = wNames.toArray(WNames);
        BNames = bNames.toArray(BNames);

        Cell cell;
        board.setBorder(BorderFactory.createLoweredBevelBorder());
        gamepiece.Piece P;
        content = getContentPane();
        setSize(width, height);
        setTitle("Chess");
        content.setBackground(Color.black);
        controlPanel = new JPanel();
        content.setLayout(new BorderLayout());
        controlPanel.setLayout(new GridLayout(3,3));
        controlPanel.setBorder(BorderFactory.createTitledBorder(
                null, "Statistics", TitledBorder.TOP, TitledBorder.CENTER,
                new Font("Lucida Calligraphy", Font.PLAIN, 20), Color.ORANGE));

        // Defines Player Box in Control Panel
        whitePlayer = new JPanel();
        whitePlayer.setBorder(BorderFactory.createTitledBorder(
                null, "White Player", TitledBorder.TOP, TitledBorder.CENTER,
                new Font("times new roman", Font.BOLD, 18), Color.RED));
        whitePlayer.setLayout(new BorderLayout());

        blackPlayer = new JPanel();
        blackPlayer.setBorder(BorderFactory.createTitledBorder(
                null, "Black Player", TitledBorder.TOP, TitledBorder.CENTER,
                new Font("times new roman", Font.BOLD, 18), Color.BLUE));
        blackPlayer.setLayout(new BorderLayout());

        JPanel whiteStats = new JPanel(new GridLayout(3,3));
        JPanel blackStats = new JPanel(new GridLayout(3,3));

        wCombo = new JComboBox<String>(WNames);
        bCombo = new JComboBox<String>(BNames);

        wScroll = new JScrollPane(wCombo);
        bScroll = new JScrollPane(bCombo);

        wComboPanel.setLayout(new FlowLayout());
        bComboPanel.setLayout(new FlowLayout());

        wSelect = new Button("Select");
        bSelect = new Button("Select");

        wSelect.addActionListener(new SelectHandler(0));
        bSelect.addActionListener(new SelectHandler(1));

        wNewPlayer = new Button("New Player");
        bNewPlayer = new Button("New Player");

        wNewPlayer.addActionListener(new Handler(0));
        bNewPlayer.addActionListener(new Handler(1));

        wComboPanel.add(wScroll);
        wComboPanel.add(wSelect);
        wComboPanel.add(wNewPlayer);
        bComboPanel.add(bScroll);
        bComboPanel.add(bSelect);
        bComboPanel.add(bNewPlayer);
        whitePlayer.add(wComboPanel, BorderLayout.NORTH);
        blackPlayer.add(bComboPanel, BorderLayout.NORTH);

        whiteStats.add(new JLabel("Name   :"));
        whiteStats.add(new JLabel("Played   :"));
        whiteStats.add(new JLabel("Won   :"));
        blackStats.add(new JLabel("Name   :"));
        blackStats.add(new JLabel("Played   :"));
        blackStats.add(new JLabel("Won   :"));

        whitePlayer.add(whiteStats, BorderLayout.WEST);
        blackPlayer.add(blackStats, BorderLayout.WEST);

        controlPanel.add(whitePlayer);
        controlPanel.add(blackPlayer);

        // Defines all of the Cells
        boardState = new Cell[8][8];

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                P = null;
                if(i == 0 && j == 0) {
                    P = br01;
                } else if(i == 0 && j == 7) {
                    P = br02;
                } else if(i == 7 && j == 0) {
                    P = wr01;
                } else if(i == 7 && j == 7) {
                    P = wr02;
                } else if(i == 0 && j == 1) {
                    P = bk01;
                } else if(i == 0 && j == 6) {
                    P = bk02;
                } else if(i == 7 && j == 1) {
                    P = wk01;
                } else if(i == 7 && j == 6) {
                    P = wk02;
                } else if(i == 0 && j == 2) {
                    P = bb01;
                } else if(i == 0 && j == 5) {
                    P = bb02;
                } else if(i == 7 && j == 2) {
                    P = wb01;
                } else if(i == 7 && j == 5) {
                    P = wb02;
                } else if(i == 0 && j == 3) {
                    P = bk;
                } else if(i == 0 && j == 4) {
                    P = bq;
                } else if(i == 7 && j == 3) {
                    P = wk;
                } else if(i == 7 && j == 4) {
                    P = wq;
                } else if (i == 1) {
                    P = bp[j];
                } else if (i == 6) {
                    P = wp[j];
                }

                cell = new Cell(i, j, P);
                cell.addMouseListener(this);
                board.add(cell);
                boardState[i][j] = cell;
            }

            showPlayer = new JPanel(new FlowLayout());
            showPlayer.add(timeSlider);
            JLabel setTime = new JLabel("Set Timer(in minutes)");
            start = new Button("Start");
            start.setBackground(Color.BLACK);
            start.setForeground(Color.WHITE);
            start.addActionListener(new START());
            start.setPreferredSize(new Dimension(120, 40));
            setTime.setFont(new Font("Arial", Font.BOLD, 16));
            label = new JLabel("Time starts now.", JLabel.CENTER);
            label.setFont(new Font("SERIF", Font.BOLD, 30));
            displayTime = new JPanel(new FlowLayout());
            time = new JPanel(new GridLayout(3,3));
            time.add(setTime);
            time.add(showPlayer);
            displayTime.add(start);
            time.add(displayTime);
            controlPanel.add(time);
            board.setMinimumSize(new Dimension(800, 700));

            // The Left layout when game is inactive
            temp = new JPanel() {
                private static final long serialVersionUID = 1L;

                @Override
                public void paintComponent(Graphics g) {

                    try {
                        image = ImageIO.read(this.getClass().getResource("clash.jpg"));
                    } catch(IOException e) {
                        System.out.println("Not Found");
                    }
                    g.drawImage(image, 0, 0, null);
                }
            };

            temp.setMinimumSize(new Dimension(800, 700));
            controlPanel.setMinimumSize(new Dimension(285, 700));
            split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, temp, controlPanel);

            content.add(split);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }


    public void changeTurn() {

        if(boardState[getKing(chance).getX()][getKing(chance).getY()].isCheck()) {
            chance ^= 1;
            gameOver();
        }

        if(!destinationList.isEmpty()) {
            cleanDestinations(destinationList);
        }

        if(previous != null) {
            previous.deselect();
            previous = null;
            chance ^= 1;
        }

        if(!end && timer != null) {
            timer.reset();
            timer.start();
            showPlayer.remove(CHNC);

            if(Logic.move.equals("White")) {
                Logic.move = "Black";
            } else {
                Logic.move = "White";
                CHNC.setText(Logic.move);
                showPlayer.add(CHNC);
            }
        }
    }
    // Method to retrieve Black or White King
    private King getKing(int color) {

        if(color == 0) {
            return wk;
        } else {
            return bk;
        }
    }

    private void cleanDestinations(ArrayList<Cell> destlist) {

        for (Cell value : destlist) {
            value.removePossibleDestination();
        }
    }

    private void highlightDestinations(ArrayList<Cell> destlist) {

        for (Cell value : destlist) {
            value.setPossibleDestination();
        }
    }

    private boolean isKingInDanger(Cell from, Cell to) {


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
