/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardygame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jeopardyserver.JeopardyProtocol;

/**
 *
 * @author parkerwightman
 */
public class JeopardyHUDNetworkHandler implements Runnable
{

    JeopardyHUDController controller;
    boolean running;
    Socket socket;
    PrintWriter writer;
    BufferedReader reader;
    String host;


    public JeopardyHUDNetworkHandler(JeopardyHUDController c)
    {
        controller = c;
    }

    public void run() {
        try
        {
            running = true;
            host = JOptionPane.showInputDialog(null, "HUD: Enter hostname");
            socket = new Socket(host, 3366);

            if(socket.isConnected())
                System.out.println("Success!");
            writer = new PrintWriter(socket.getOutputStream(), true);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            signIn();
            while(running)
            {
                String protocol = reader.readLine();
                readMessage(protocol);
            }
        } catch (UnknownHostException ex)
        {
            Logger.getLogger(JeopardyHUDNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JeopardyHUDNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readMessage(String protocol) throws IOException
    {
        int proto = Integer.parseInt(protocol);

        if(proto == JeopardyProtocol.READYNEXT)
        {
            controller.displayBoard();
        }
        if(proto == JeopardyProtocol.CHOOSEQUESTION)
        {
            String question = reader.readLine();
            int col = Integer.parseInt(reader.readLine());
            int row = Integer.parseInt(reader.readLine());
            controller.displayQuestion(question, col, row);
        }
        else if(proto == JeopardyProtocol.SENDBOARD)
        {
            String[][] board = new String[6][6];

            for(int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = reader.readLine();
                }
            controller.setupBoard(board);
        }
        else if(proto == JeopardyProtocol.DAILYDOUBLE)
        {
            String dd = reader.readLine();
            controller.displayDailyDouble(dd);
        }
        else if(proto == JeopardyProtocol.DISPLAYDAILYDOUBLE)
        {

            int col = Integer.parseInt(reader.readLine());
            int row = Integer.parseInt(reader.readLine());
            controller.displayQuestion(controller.dailyDoubleText, col, row);
            System.out.println("Displaying daily double...");
        }
        else if(proto == JeopardyProtocol.PLAYTIMEROUTSOUND)
        {
            controller.playTimeoutSound();
        }
        else if(proto == JeopardyProtocol.THINKING)
        {
            controller.playThinkingSound();
        }
        else if( proto == JeopardyProtocol.BEGINBUZZING)
        {
            controller.startBuzzing();
        }
        else if( proto == JeopardyProtocol.STOPBUZZING)
        {
            controller.stopBuzzing();
        }
    }

    public void signIn()
    {
        writer.println(JeopardyProtocol.SIGNIN);
        writer.println("hud");
    }
}
