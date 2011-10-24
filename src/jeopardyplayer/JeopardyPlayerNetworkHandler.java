/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jeopardyserver.JeopardyProtocol;

/**
 *
 * @author parkerwightman
 */
public class JeopardyPlayerNetworkHandler implements Runnable {

    JeopardyPlayerController controller;
    String host;
    Socket socket;
    boolean running;
    HashMap<String,Integer> protos;
    PrintWriter writer;
    BufferedReader reader;


    public JeopardyPlayerNetworkHandler(JeopardyPlayerController controller)
    {
        protos = JeopardyProtocol.getInstance();
        this.controller = controller;
        running = false;

    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public void run() {
        try {
            
            running = true;
            System.out.println("Player handler running...");
            
            socket = new Socket(host, 3366);
            if (socket.isConnected()) {
                System.out.println("Success!");
            }
            writer = new PrintWriter(socket.getOutputStream(), true);
            sendSignin(controller.name);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (running) {
                try {
                    String protocol = reader.readLine();
                    interpretProtocol(protocol);
                } catch (IOException ex) {
                    Logger.getLogger(JeopardyPlayerNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(JeopardyPlayerNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JeopardyPlayerNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void interpretProtocol(String protocol) throws IOException
    {
        int proto = Integer.parseInt(protocol);

        if( proto == JeopardyProtocol.SIGNEDIN)
            controller.setId(Integer.parseInt(reader.readLine()));
        else if( proto == JeopardyProtocol.BEGINBUZZING)
            controller.beginBuzzing();
        else if( proto == JeopardyProtocol.STOPBUZZING)
            controller.endBuzzing();
        else if( proto == JeopardyProtocol.SCORE)
        {
            int numPlayers = Integer.parseInt(reader.readLine());
            String[] names = new String[numPlayers];
            int[] scores = new int[numPlayers];

            for(int i = 0; i < numPlayers; i++)
            {
                names[i] = reader.readLine();
                scores[i] = Integer.parseInt(reader.readLine());
            }
            controller.updatePlayerScores(names, scores);
        }
        else if( proto == JeopardyProtocol.DAILYDOUBLE)
        {
            int maxWager = Integer.parseInt(reader.readLine());
            int currentScore = Integer.parseInt(reader.readLine());
            String wager = JOptionPane.showInputDialog(null, "How much will you wager?");
            String result = "";
            for (int i = 0; i < wager.length(); i++) {
                if(wager.charAt(i) != ',' && wager.charAt(i) != '.')
                    result += wager.charAt(i);
            }
            sendDailyDoubleWager(result);
        }
        else
            System.out.println("Bad protocol sent to player: " + protocol);
    }

    public void sendDailyDoubleWager(String wager)
    {
        writer.println(JeopardyProtocol.DAILYDOUBLE);
        writer.println(wager);
    }

    public void sendUserBuzzed()
    {
        writer.println(JeopardyProtocol.BUZZIN);
    }

    public void sendSignin(String name)
    {
        writer.println(JeopardyProtocol.SIGNIN);
        writer.println("player");
        writer.println(name);
        System.out.println("Sent player signin");
    }

}
