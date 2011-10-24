/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author parkerwightman
 */
public class JeopardyGame {

    // Instance Variables

    GameBoard board;
    Player[] players;
    int round;

    public JeopardyGame(int numPlayers, List<String> names, Scanner jpdyFiles) throws JeopardyException
    {
        if(numPlayers != names.size())
             throw new JeopardyException();



        board = readJpdyFile(jpdyFiles);
        players = new Player[numPlayers];
        round = 1;

        for(int i = 0; i < numPlayers; i++)
        {
            players[i] = new Player(names.get(i), i);
        }
    }

    public void loadSecondRound(Scanner jpdyFiles)
    {
        board = readJpdyFile(jpdyFiles);
    }


    private GameBoard readJpdyFile(Scanner jpdyFiles)
    {
        return new GameBoard(jpdyFiles);
    }

    public int getRound()
    {
        return round;
    }

    public boolean isDailyDouble(int col, int row)
    {
        return board.getQuestionAtColAndRow(col, row).getDailyDouble();
    }

    public String[][] getBoardText()
    {
        String[][] text = new String[6][6];

        for(int i = 0; i < 6; i++)
        {
            text[i][0] = board.getCategoryText(i);
        }

        for(int i = 0; i < text.length; i++)
        {
            for(int j = 1; j < text[i].length; j++)
            {
                text[i][j] = String.valueOf(board.getQuestionAtColAndRow(i, j - 1).getMoneyValue());
            }
        }

        return text;
    }

    public void setScoreForPlayer(int id, int score)
    {
        players[id].setScore(score);
    }

    public void setRound(int round) throws InvalidRoundException
    {
        if(round < 4 && round > 0)
            this.round = round;
        else
            throw new InvalidRoundException();
    }

    public String getTextForQuestion(int col, int row)
    {
        return board.getQuestionAtColAndRow(col, row).getText();
    }

    public String getAnswerForQuestion(int col, int row)
    {
        return board.getQuestionAtColAndRow(col, row).getAnswer();
    }

    public int getNumPlayers()
    {
        return players.length;
    }

    public int getScoreForPlayer(int player)
    {
        return players[player].getScore();
    }

    public String getPlayerName(int player)
    {
        return players[player].getName();
    }

    public boolean getQuestionAsked(int col, int row)
    {
        return board.getQuestionAtColAndRow(col, row).hasBeenAsked();
    }

    public void setQuestionAsked(int col, int row, boolean asked)
    {
        board.getQuestionAtColAndRow(col, row).setAsked(asked);
    }

    public void submitAnswerForPlayer(int player, int col, int row, boolean correct)
    {
        int moneyValue = board.getQuestionAtColAndRow(col, row).getMoneyValue();
        if(!correct)
        {
            moneyValue *= -1;
            players[player].incrementIncorrect();
        }
        else
            players[player].incrementCorrect();
        board.getQuestionAtColAndRow(col, row).setAsked(true);
        players[player].addToScore(moneyValue);

    }

    public int getMoneyValueForQuestion(int col, int row)
    {
        return board.getQuestionAtColAndRow(col, row).getMoneyValue();
    }


}

class InvalidRoundException extends Exception
{

}

class JeopardyException extends Exception
{

}
