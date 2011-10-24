/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyhost;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeopardyserver.JeopardyProtocol;

/**
 *
 * @author parkerwightman
 */
public class JeopardyHostNetworkHandler implements Runnable {

    JeopardyHostController controller;
    String host;
    Socket socket;
    boolean running;

    PrintWriter writer;
    BufferedReader reader;


    public JeopardyHostNetworkHandler(JeopardyHostController controller)
    {

        this.controller = controller;
        running = false;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public void run() {
        try
        {
            running = true;
            System.out.println("Host handler running...");
            socket = new Socket(host, 3366);
            if(socket.isConnected())
                System.out.println("Success!");
            writer = new PrintWriter(socket.getOutputStream(), true);
            sendSignin();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(running)
            {
                String protocol = reader.readLine();
                readMessage(protocol);
            }
        } catch (UnknownHostException ex)
        {
            Logger.getLogger(JeopardyHostNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JeopardyHostNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readMessage(String protocol) throws IOException
    {
        int proto = Integer.parseInt(protocol);

        if(proto == JeopardyProtocol.STOPBUZZING)
        {
            controller.view.HostIndicatorLight.setBackground(Color.RED);
        }
        else if(proto == JeopardyProtocol.BEGINBUZZING)
        {
            controller.view.HostIndicatorLight.setBackground(Color.GREEN);
            controller.view.correctButton.setEnabled(false);
            controller.view.incorrectButton.setEnabled(false);
            controller.view.startBuzzingButton.setEnabled(false);
        }
        else if(proto == JeopardyProtocol.BUZZIN)
        {
            String name = reader.readLine();
            controller.setPlayerBuzzedInName(name);
            controller.view.correctButton.setEnabled(true);
            controller.view.incorrectButton.setEnabled(true);
        }
        else if(proto == JeopardyProtocol.CHOOSEQUESTION)
        {
            String question = reader.readLine();
            String answer = reader.readLine();
            controller.updateQuestionInfo(question, answer);
            controller.view.startBuzzingButton.setEnabled(true);
        }
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
        else if (proto == JeopardyProtocol.ENDBUZZING) {

            controller.view.correctButton.setEnabled(false);
            controller.view.incorrectButton.setEnabled(false);

            controller.view.nextButton.setEnabled(true);
            controller.view.HostIndicatorLight.setBackground(Color.RED);
        }
        else if(proto == JeopardyProtocol.SENDBOARD)
        {
            String[][] board = new String[6][6];

            for(int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = reader.readLine();
                }
            controller.setupBoard(board);
            controller.view.loadGameButton.setEnabled(false);

        }
        else if( proto == JeopardyProtocol.DAILYDOUBLE)
        {
            controller.view.HostIndicatorLight.setBackground(Color.BLUE);
            System.out.println("Got daily double protocol");
            controller.isDailyDouble = true;
            String question = reader.readLine();
            String answer = reader.readLine();
            controller.updateQuestionInfo(question, answer);
            controller.view.nextButton.setEnabled(true);
        }

    }

    public void sendDisplayDailyDouble()
    {
        writer.println(JeopardyProtocol.DISPLAYDAILYDOUBLE);
    }

    public void sendSignin()
    {
        System.out.println("Sending host signin...");
        writer.println(JeopardyProtocol.SIGNIN);
        writer.println("host");
        System.out.println("Host signin sent");
    }

    public void sendAnswer(boolean correct)
    {

        controller.view.correctButton.setEnabled(false);
        controller.view.incorrectButton.setEnabled(false);
        writer.println(JeopardyProtocol.ANSWERED);
        if (correct) {
            writer.println("correct");
            controller.view.nextButton.setEnabled(true);
        }
        else
        {
            writer.println("incorrect");
        }
    }

    public void sendQuestionChosen(int col, int row)
    {
        writer.println(JeopardyProtocol.CHOOSEQUESTION);
        writer.println(col);
        writer.println(row);
    }

    public void sendFileInfo(File file, int round)
    {
        try {
            Scanner scan = new Scanner(file);
            int count = 0;
            while(scan.hasNextLine())
            {
                ++count;
                scan.nextLine();
            }

            scan.close();

            scan = new Scanner(file);

            writer.println(JeopardyProtocol.FILEINFO);
            writer.println(round);
            writer.println(count);
            while(scan.hasNextLine())
                writer.println(scan.nextLine());

//            writer.println("Hello");

        } catch (Exception ex) {
            Logger.getLogger(JeopardyHostNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendScoreChange(String name, String amount)
    {
        writer.println(JeopardyProtocol.CHANGESCORE);
        writer.println(name);
        writer.println(amount);

    }

    public void sendBeginBuzzing()
    {
        writer.println(JeopardyProtocol.BEGINBUZZING);
    }

    public void sendThinking()
    {
        writer.println(JeopardyProtocol.THINKING);
    }

    public void sendReadyNext()
    {
        writer.println(JeopardyProtocol.READYNEXT);
        
        controller.view.nextButton.setEnabled(false);
    }

    public void sendDailyDoubleAnswer(boolean correct) {
        writer.println(JeopardyProtocol.DAILYDOUBLE);
        if(correct)writer.println("correct");
        else writer.println("incorrect");
        controller.isDailyDouble = false;
        controller.readyNext();
    }
}
