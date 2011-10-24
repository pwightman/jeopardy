/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeopardyserver.JeopardyProtocol;

/**
 *
 * @author parkerwightman
 */
public class JeopardyServerHUDHandler implements Runnable {
    Socket socket;
    boolean connected;
    JeopardyServerController controller;
    BufferedReader reader;
    PrintWriter writer;
    
    public JeopardyServerHUDHandler(Socket s, JeopardyServerController c, BufferedReader reader)
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

    private void interpretProtocol(String protocol)
    {
        int proto = Integer.parseInt(protocol);


    }

    public void sendDailyDouble(String question)
    {
        writer.println(JeopardyProtocol.DAILYDOUBLE);
        writer.println(question);

    }

    public void sendThinking()
    {
        writer.println(JeopardyProtocol.THINKING);
    }

    public void sendStartBuzzing()
    {
        writer.println(JeopardyProtocol.BEGINBUZZING);
    }

    public void sendStopBuzzing()
    {
        writer.println(JeopardyProtocol.STOPBUZZING);
    }

    public void sendPlayerTimeOut()
    {
        writer.println(JeopardyProtocol.PLAYTIMEROUTSOUND);
    }

    public void sendBoard(String[][] board)
    {
        writer.println(JeopardyProtocol.SENDBOARD);
        for(int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                writer.println(board[i][j]);
            }
    }


    public void sendChooseNewQuestion(String question, int col, int row)
    {
        writer.println(JeopardyProtocol.CHOOSEQUESTION);
        writer.println(question);
        writer.println(col);
        writer.println(row);
    }

    public void sendReadyNext()
    {
        writer.println(JeopardyProtocol.READYNEXT);
    }

    public void sendDisplayDailyDouble(int col, int row)
    {
        writer.println(JeopardyProtocol.DISPLAYDAILYDOUBLE);
        writer.println(col);
        writer.println(row);
    }
}
