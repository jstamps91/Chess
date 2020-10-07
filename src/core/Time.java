package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Time {

    private JLabel label;
    Timer countdownTimer;
    int timeRemaining;

    public Time(JLabel passedLabel) {

        countdownTimer = new Timer(1000, new CountdownTimerListener());
        this.label = passedLabel;
        timeRemaining = Logic.timeRemaining;
    }

    public void start() {

        countdownTimer.start();
    }

    public void reset() {

        timeRemaining = Logic.timeRemaining;
    }

    class CountdownTimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int min, sec;

            if(timeRemaining > 0) {
                min = timeRemaining / 60;
                sec = timeRemaining % 60;
                label.setText(String.valueOf(min) + ";" +
                        (sec >= 10 ? String.valueOf(sec) : "0" + String.valueOf(sec)));
                timeRemaining--;
            } else {
                label.setText("Times Up!");
                reset();
                start();
                Logic.Mainboard.changeChance();
            }
        }
    }
}
