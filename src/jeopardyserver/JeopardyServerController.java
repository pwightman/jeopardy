/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Timer;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.Timer;
import jeopardygame.JeopardyHUDController;
import jeopardyhost.JeopardyHostController;
import jeopardyplayer.JeopardyPlayerController;

/**
 *
 * @author parkerwightman
 */
public class JeopardyServerController {

    JeopardyGame game;
    ArrayList<String> playerNames;
    HashMap<Integer, JeopardyPlayerController> playerControllers;
    int currentQuestionCol;
    int currentQuestionRow;
    int currentPlayer;
    int lastCorrectPlayer;
    HashSet<Integer> previouslyBuzzedIn;
    int dailyDoubleWager;

    boolean playersCanBuzz;

    long time;
    int timeElapsed;
    Timer t;

    JeopardyHostController hostController;
    JeopardyPlayerController playerController;
    JeopardyHUDController hudController;

    ServerNetworkHandler network;

    /*
     * Be sure to give each player (client) and ID that they will buzz in with!!
     */

    public JeopardyServerController()
    {
        playerNames = new ArrayList<String>();
        playerControllers = new HashMap<Integer, JeopardyPlayerController>(3);
        network = new ServerNetworkHandler(this);

        Thread thread = new Thread(network);
        thread.start();



        playersCanBuzz = false;

        // TAKE THIS OUT IN THE END!!!!

//        new Thread(network).start();
//        try
//        {
//            pnh = new PlayerNetworkHandler();
//        }
//        catch(InterruptedException e) { }
    }

    public void setHostController(JeopardyHostController hostController)
    {
        this.hostController = hostController;
    }

    public void setHUDController(JeopardyHUDController hudController)
    {
        this.hudController = hudController;
    }

    public void initializeGame(Scanner files)
    {
        if(files == null || playerNames.size() < 2)
        {
            System.out.println("Cannot start game, requirements not met");
            return;
        }
        else
        {
            try
            {
                game = new JeopardyGame(playerNames.size(), playerNames, files);
                network.getHUDHandler().sendBoard(game.getBoardText());
                network.getHostHandler().sendBoard(game.getBoardText());
                currentPlayer = 0;
                lastCorrectPlayer = 0;
                sendScoreUpdate();
            }
            catch (JeopardyException e)
            {
                System.out.println("Server Controller cannot start the game");
            }
        }
    }

    public void sendDisplayDailyDouble()
    {
        network.getHUDHandler().sendDisplayDailyDouble(currentQuestionCol, currentQuestionRow);
    }


    public void sendScoreUpdate()
    {
        String[] names = new String[playerNames.size()];
        int[] scores = new int[playerNames.size()];
        for(int i = 0; i < playerNames.size(); i++)
        {
            names[i] = game.getPlayerName(i);
            scores[i] = game.getScoreForPlayer(i);
        }

        for(int i = 0; i < playerNames.size(); i++)
        {
            network.getPlayerHandler(i).sendScoreUpdate(playerNames.size(), names, scores);
        }
        network.getHostHandler().sendScoreUpdate(playerNames.size(), names, scores);
    }

    public int addPlayer(String name)
    {

        playerNames.add(name);
        System.out.println("Player " + name + " joined the game");
        return playerNames.size() - 1;
    }

    public void getNextQuestion(int col, int row)
    {
        // If the question has already been asked, don't ask it again!
        if(game.getQuestionAsked(col, row))
            return;
        else
            game.setQuestionAsked(col, row, true);


        currentQuestionCol = col;
        currentQuestionRow = row;

        String temp = game.getTextForQuestion(col, row);
        String answer = game.getAnswerForQuestion(col, row);
        if(!game.isDailyDouble(col, row))
        {
            network.getHostHandler().sendNextQuestion(temp, answer);
            network.getHUDHandler().sendChooseNewQuestion(temp, col, row);
        }
        else
        {
            network.getHostHandler().sendDailyDouble(temp, answer);
            network.getHUDHandler().sendDailyDouble(temp);
            int maxScore = game.getMoneyValueForQuestion(0, 4);
            if(game.getScoreForPlayer(lastCorrectPlayer) <= maxScore)
                network.getPlayerHandler(lastCorrectPlayer).sendDailyDouble(maxScore, game.getScoreForPlayer(lastCorrectPlayer));
            else
                network.getPlayerHandler(lastCorrectPlayer).sendDailyDouble(game.getScoreForPlayer(lastCorrectPlayer), game.getScoreForPlayer(lastCorrectPlayer));
        }
        return;
    }

    public void setDailyDoubleWager(int wager)
    {
        dailyDoubleWager = wager;
        System.out.println("Wager was set");
    }

    public void setCorrectDailyDouble(boolean correct)
    {
        System.out.println("Setting daily double score...");
        if(correct)
            game.setScoreForPlayer(lastCorrectPlayer, dailyDoubleWager + game.getScoreForPlayer(lastCorrectPlayer));
        else
            game.setScoreForPlayer(lastCorrectPlayer, game.getScoreForPlayer(lastCorrectPlayer) - dailyDoubleWager);
        sendScoreUpdate();
    }

    public int getMoneyValueForQuestion(int col, int row)
    {
        return game.getMoneyValueForQuestion(col, row);
    }

    public void notifyReadyNext()
    {
        network.getHUDHandler().sendReadyNext();
    }
    
    public void changeScoreForPlayer(String name, int newScore)
    {
        int id = playerNames.indexOf(name);
        if(id == -1)
            return;
        game.setScoreForPlayer(id, newScore);
        sendScoreUpdate();
    }

    public void startBuzzing()
    {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buzzerTimerRanOut();
            }
        };
        previouslyBuzzedIn = new HashSet<Integer>();
        network.getHostHandler().sendStartBuzzing();
        network.getHUDHandler().sendStartBuzzing();
        for(int i = 0; i < playerNames.size(); i++)
            network.getPlayerHandler(i).sendStartBuzzing();
        t = new Timer(10000, taskPerformer);
        t.setRepeats(false);
        t.start();


        time = (int)System.currentTimeMillis();
        System.out.println("Buzzing has begun ");
        playersCanBuzz = true;
    }

    public void continueBuzzing()
    {
        t.stop();
        playersCanBuzz = true;
        System.out.println("Player " + game.getPlayerName(currentPlayer) + " got it wrong!");
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buzzerTimerRanOut();
            }
        };
        network.getHostHandler().sendStartBuzzing();
        network.getHUDHandler().sendStartBuzzing();
        for(int i = 0; i < playerNames.size(); i++)
            network.getPlayerHandler(i).sendStartBuzzing();
        t = new Timer(10000 - timeElapsed, taskPerformer);
        t.setRepeats(false);
        t.start();
        
        System.out.println("Continuing buzzing with: " + timeElapsed);
    }

    public void initializeSecondRound(Scanner file)
    {
        game.loadSecondRound(file);
        network.getHUDHandler().sendBoard(game.getBoardText());
        network.getHostHandler().sendBoard(game.getBoardText());
        sendScoreUpdate();
    }

    
    synchronized public void notifyPlayerBuzzedInForQuestion(int player)
    {
        if (!playersCanBuzz || previouslyBuzzedIn.contains(player))
            return;
        previouslyBuzzedIn.add(player);
        network.getHostHandler().sendStopBuzzing();
        network.getHUDHandler().sendStopBuzzing();
        for(int i = 0; i < playerNames.size(); i++)
            network.getPlayerHandler(i).sendStopBuzzing();

        t.stop();
        playersCanBuzz = false;
        currentPlayer = player;
        network.getHostHandler().sendPlayerBuzzedIn(playerNames.get(player));
        timeElapsed = (int)System.currentTimeMillis() - (int)time;
        time = System.currentTimeMillis();
        System.out.println("Time after truncation: " + timeElapsed);

        if (time <= 0)
        {
            System.out.println("Blah" + time);
            buzzerTimerRanOut();
            return;
        }
        
        System.out.println(time);

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                questionTimerRanOut();
            }
        };
        t = new Timer(10000, taskPerformer);
        t.setRepeats(false);
        t.start();

        System.out.println("Player " + player + " has buzzed in.");

    }

    public void notifyAnswered(boolean correct)
    {
        if (playersCanBuzz)
            return;

        if (correct) {
            t.stop();
            System.out.println("Player " + game.getPlayerName(currentPlayer) + " got it right!");
            game.submitAnswerForPlayer(currentPlayer, currentQuestionCol, currentQuestionRow, correct);
            lastCorrectPlayer = currentPlayer;
            sendScoreUpdate();

        }
        else
        {
            System.out.println("Player " + game.getPlayerName(currentPlayer) + " got it wrong!");
            game.submitAnswerForPlayer(currentPlayer, currentQuestionCol, currentQuestionRow, correct);
            game.setQuestionAsked(currentQuestionCol, currentQuestionRow, false);
            sendScoreUpdate();
            continueBuzzing();
        }

        for(int i = 0; i < playerNames.size(); i++)
        {
            System.out.println(playerNames.get(i) + ": " + game.getScoreForPlayer(i));
        }

        // SEND SCORE UPDATE
    }

    /**
     * This runs when someone rings in but cannot answer in 5 seconds
     */
    public void questionTimerRanOut()
    {

        game.submitAnswerForPlayer(currentPlayer, currentQuestionCol, currentQuestionRow, false);
        
        for (int i = 0; i < playerNames.size(); i++)
        {
            System.out.println(playerNames.get(i) + ": " + game.getScoreForPlayer(i));
        }

        continueBuzzing();

        // NOTE: Send message notifiying that the question was not answered
        // within 5 seconds (Notifies HUD which plays a sound, for example.)
        System.out.println("Question Time ran out");
    }

    /**
     * This is called if no one buzzed in within 5 seconds
     */
    public void buzzerTimerRanOut()
    {
        playersCanBuzz = false;
        network.getHostHandler().sendEndBuzzing();
        network.getHUDHandler().sendStopBuzzing();

        for(int i = 0; i < playerNames.size(); i++)
            network.getPlayerHandler(i).sendStopBuzzing();

        network.getHUDHandler().sendPlayerTimeOut();

        // This is being set to true so that no one can ring in later until
        // the next time startBuzzing is called
        game.setQuestionAsked(currentQuestionCol, currentQuestionRow, true);
        System.out.println("Buzzer Time ran out");
    }

    public void startThinking()
    {
        network.getHUDHandler().sendThinking();
    }

}
