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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeopardyserver.JeopardyProtocol;

/**
 *
 * @author parkerwightman
 */
public class JeopardyServerHostHandler implements Runnable{
    Socket socket;
    boolean connected;
    JeopardyServerController controller;
    BufferedReader reader;
    PrintWriter writer;

    public JeopardyServerHostHandler(Socket s, JeopardyServerController c, BufferedReader reader)
    {
        socket = s;
        connected = false;
        controller = c;
        this.reader = reader;
    }

    public void run() {
        try
        {
            if(!socket.isConnected())
                System.out.println("It's closed");
            writer = new PrintWriter(socket.getOutputStream(), true);
            connected = true;

            while(connected)
            {
                System.out.println("Server host controller ready...");
                String protocol = reader.readLine();
                interpretProtocol(protocol);
            }

        } catch (IOException ex)
        {
            Logger.getLogger(JeopardyServerPlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void interpretProtocol(String protocol) throws IOException
    {
        int proto = Integer.parseInt(protocol);

        if(proto == JeopardyProtocol.STOPBUZZING)
        {
            System.out.println("Stopped buzzing");
        }
        else if(proto == JeopardyProtocol.FILEINFO)
        {

            try {
                int round = Integer.parseInt(reader.readLine());
                int lines = Integer.parseInt(reader.readLine());
                String file = "";
                System.out.println("Parsing file info...");
                System.out.println(lines);
                for(int i = 0; i < lines; i++)
                {
                    file += reader.readLine() + "\n";

                }
                System.out.println(file);
                if(round == 1)
                    controller.initializeGame(new Scanner(file));
                else if (round == 2)
                    controller.initializeSecondRound(new Scanner(file));
            } catch (IOException ex) {
                Logger.getLogger(JeopardyServerHostHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(proto == JeopardyProtocol.ANSWERED)
        {
            try {
                String correct = reader.readLine();
                if(correct.equals("correct"))
                    controller.notifyAnswered(true);
                else
                    controller.notifyAnswered(false);

            } catch (IOException ex) {
                Logger.getLogger(JeopardyServerHostHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if(proto == JeopardyProtocol.CHOOSEQUESTION)
        {
            try {
                controller.getNextQuestion(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()));
            } catch (IOException ex) {
                Logger.getLogger(JeopardyServerHostHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(proto == JeopardyProtocol.BEGINBUZZING)
        {
            controller.startBuzzing();
        }
        else if(proto == JeopardyProtocol.READYNEXT)
        {
            controller.notifyReadyNext();
        }
        else if( proto == JeopardyProtocol.DAILYDOUBLE)
        {
            String correct = reader.readLine();
            if(correct.equals("correct"))
                controller.setCorrectDailyDouble(true);
            else
                controller.setCorrectDailyDouble(false);
        }
        else if(proto == JeopardyProtocol.DISPLAYDAILYDOUBLE)
        {
            controller.sendDisplayDailyDouble();
        }
        else if(proto == JeopardyProtocol.THINKING)
        {
            controller.startThinking();
        }
        else if(proto == JeopardyProtocol.CHANGESCORE)
        {
            try
            {
                String name = reader.readLine();
                int newScore = Integer.parseInt(reader.readLine());
                controller.changeScoreForPlayer(name, newScore);

            } catch (IOException ex)
            {
                Logger.getLogger(JeopardyServerHostHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void sendNextQuestion(String question, String answer)
    {
        writer.println(JeopardyProtocol.CHOOSEQUESTION);
        writer.println(question);
        writer.println(answer);

    }

    public void sendStartBuzzing()
    {
        writer.println(JeopardyProtocol.BEGINBUZZING);
    }

    public void sendStopBuzzing()
    {
        writer.println(JeopardyProtocol.STOPBUZZING);
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

    public void sendEndBuzzing()
    {
        writer.println(JeopardyProtocol.ENDBUZZING);
    }

    public void sendBoard(String[][] board)
    {
        writer.println(JeopardyProtocol.SENDBOARD);
        for(int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                writer.println(board[i][j]);
            }
    }

    public void sendDailyDouble(String question, String answer)
    {
        writer.println(JeopardyProtocol.DAILYDOUBLE);
        writer.println(question);
        writer.println(answer);
    }

    public void sendPlayerBuzzedIn(String name)
    {
        writer.println(JeopardyProtocol.BUZZIN);
        writer.println(name);
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
