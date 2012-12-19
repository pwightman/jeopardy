 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author parkerwightman
 */
public class JeopardyServerPlayerHandler implements Runnable {

    Socket socket;
    boolean connected;
    JeopardyServerController controller;

    BufferedReader reader;
    PrintWriter writer;
    int id;

    public JeopardyServerPlayerHandler(Socket s, JeopardyServerController c, BufferedReader reader, int id)
    {
        this.id = id;
        this.reader = reader;
        socket = s;
        connected = false;
        controller = c;

    }

    public void run() {
        try
        {
            connected = true;
            writer = new PrintWriter(socket.getOutputStream(), true);
            sendPlayerId();
            while(connected)
            {
                String protocol = reader.readLine();
                interpretProtocol(protocol);
            }

        } catch (IOException ex)
        {
            Logger.getLogger(JeopardyServerPlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendPlayerId()
    {
        writer.println(JeopardyProtocol.SIGNEDIN);
        writer.println(id);
    }

    public void interpretProtocol(String protocol) throws IOException
    {
        int proto = Integer.parseInt(protocol);
        if (proto == JeopardyProtocol.BUZZIN)
        {
            controller.notifyPlayerBuzzedInForQuestion(id);
        }
        else if( proto == JeopardyProtocol.DAILYDOUBLE)
        {
            controller.setDailyDoubleWager(Integer.parseInt(reader.readLine()));
            controller.sendDisplayDailyDouble();
        }


    }

    public void sendDailyDouble(int maxWager, int currentScore)
    {
        writer.println(JeopardyProtocol.DAILYDOUBLE);
        writer.println(maxWager);
        writer.println(currentScore);
    }

    public void sendScoreUpdate(int numPlayers, String[] names, int[] scores)
    {
        writer.println(JeopardyProtocol.SCORE);
        writer.println(numPlayers);
        for(int i = 0; i < numPlayers; i++)
        {
            writer.println(names[i]);
            writer.println(scores[i]);
        }
    }

    public void sendStartBuzzing()
    {
        writer.println(JeopardyProtocol.BEGINBUZZING);
    }


    public void sendStopBuzzing()
    {
        writer.println(JeopardyProtocol.STOPBUZZING);
    }

    public void setConnected(boolean connected)
    {
        this.connected = connected;
    }

    public boolean getConnected()
    {
        return connected;
    }



}
