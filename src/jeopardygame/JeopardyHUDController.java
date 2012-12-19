/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardygame;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 *
 * @author Mac
 */
public class JeopardyHUDController {

    JeopardyHUD view;
    JeopardyHUDNetworkHandler handler;
    String dailyDoubleText;
    InputStream in;
    AudioStream as;
    Border green;
    Border red;


    public JeopardyHUDController()
    {
        try {
            view = new JeopardyHUD();
            view.setVisible(true);
            in = new FileInputStream("JeopardySounds/maintheme.wav");
            as = new AudioStream(in);
            green = BorderFactory.createLineBorder(Color.GREEN, 15);
            red = BorderFactory.createLineBorder(Color.RED, 15);
        } catch (IOException ex) {
            Logger.getLogger(JeopardyHUDController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public void connect()
    {
        String host = JOptionPane.showInputDialog(null, "HUD: Enter hostname");
        this.connectWithHost(host);       
    }
    
    public void connectWithHost(String host) 
    {
        AudioPlayer.player.start(as);
        File file = new File("JeopardySounds/maintheme.wav");
        if(!file.exists())
            System.out.println("File does not exist!");
        handler = new JeopardyHUDNetworkHandler(this, host);
        MusicPlayer player = new MusicPlayer(file);
        new Thread(player).start();
        new Thread(handler).start();
    }

    public void setupBoard(String[][] board)
    {
        try {
            AudioPlayer.player.stop(as);
            in = new FileInputStream(new File("JeopardySounds/boardfill.wav"));
            as = new AudioStream(in);
            AudioPlayer.player.start(as);
            view.setupBoard(board);
            view.splashScreen.setVisible(false);
            displayBoard();
        } catch (IOException ex) {
            Logger.getLogger(JeopardyHUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playThinkingSound()
    {
        try {
            AudioPlayer.player.stop(as);
            in = new FileInputStream(new File("JeopardySounds/thinkmusic.wav"));
            as = new AudioStream(in);
            AudioPlayer.player.start(as);
        } catch (IOException ex) {
            Logger.getLogger(JeopardyHUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startBuzzing()
    {
        view.fullScreen.setBorder(green);
    }

    public void stopBuzzing()
    {
        view.fullScreen.setBorder(red);
    }

    public void displayQuestion(String text, int col, int row)
    {
        clear(col, row);
        view.fullScreen.setText(text);
        view.board.setVisible(false);
        view.fullScreen.setVisible(true);
        view.dailyDouble.setVisible(false);
    }

    public void clear(int col, int row)
    {
        view.board.tiles[col][row].clearText();
    }

    public void displayBoard()
    {
        view.board.setVisible(true);
        view.fullScreen.setVisible(false);
        view.dailyDouble.setVisible(false);
    }

    public void playTimeoutSound()
    {
        try
        {
            in = new FileInputStream(new File("JeopardySounds/timeout.wav"));
            as = new AudioStream(in);
            AudioPlayer.player.start(as);
        } catch (IOException ex) {
            Logger.getLogger(JeopardyHUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayDailyDouble(String dailyDouble)
    {
        try {
            in = new FileInputStream(new File("JeopardySounds/dailydouble.wav"));
            as = new AudioStream(in);
            AudioPlayer.player.start(as);
            dailyDoubleText = dailyDouble;
            view.board.setVisible(false);
            view.fullScreen.setVisible(false);
            view.dailyDouble.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JeopardyHUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
