/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

/**
 *
 * @author parkerwightman
 */
public class Player {
    private int score;
    private int correct;
    private int incorrect;
    private String name;
    private int ID;

    public Player(String name, int ID)
    {
        this.name = name;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public void addToScore(int moneyValue)
    {
        score += moneyValue;
    }

    public int getScore()
    {
        return score;
    }

    public void incrementCorrect()
    {
        correct++;
    }

    public void incrementIncorrect()
    {
        incorrect++;
    }

    public int getCorrect()
    {
        return correct;
    }

    public int getIncorrect()
    {
        return incorrect;
    }
}
