package core;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Player implements Serializable {

    private final String name;
    private Integer gamesPlayed;
    private Integer gamesWon;

    public Player(String name) {

        this.name = name.trim();
        gamesPlayed = 0;
        gamesWon = 0;
    }

    public String name() {

        return name;
    }

    public Integer gamesPlayed() {

        return gamesPlayed;
    }

    public Integer gamesWon() {

        return gamesWon;
    }

    public Integer winPercentage() {

        return gamesWon * 100 / gamesPlayed;
    }

    public void updateGamesPlayed() {

        gamesPlayed++;
    }

    public void updateGamesWon() {

        gamesWon++;
    }

    public static ArrayList<Player> fetchPlayers() {

        Player tempPlayer;
        ObjectInputStream input = null;
        ArrayList<Player> players = new ArrayList<>();

        try {
            File in = new File(System.getProperty("user.dir") + File.separator + "chessgamedata.dat");
            input = new ObjectInputStream(new FileInputStream(in));

            try {
                while (true) {
                    tempPlayer = (Player) input.readObject();
                    players.add(tempPlayer);
                }
            } catch (EOFException e) {
                input.close();
            }

        } catch (FileNotFoundException e) {
            players.clear();
            return players;

        } catch (IOException e) {
            e.printStackTrace();
            try {
                assert input != null;
                input.close();
            } catch (IOException ignored) {}
            JOptionPane.showMessageDialog(null, "Unable to read required game files!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Game file corrupt! Click OK to continue building new file!");

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return players;
    }

    public void updatePlayer() {

        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        Player tempPlayer;
        File inputFile = null;
        File outputFile = null;

    }

}
