/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

/**
 *
 * @author parkerwightman
 */
public class Question {
    String text;
    String answer;
    int moneyValue;
    boolean asked;
    boolean dailyDouble;

    public Question(String text, String answer, int moneyValue, boolean dailyDouble)
    {
        this.text = text;
        this.answer = answer;
        this.moneyValue = moneyValue;
        this.dailyDouble = dailyDouble;
        asked = false;
    }

    public String getText()
    {
        return text;
    }

    public int getMoneyValue()
    {
        return moneyValue;
    }

    public String getAnswer()
    {
        return answer;
    }

    public boolean hasBeenAsked()
    {
        return asked;
    }

    public void setAsked(boolean asked)
    {
        this.asked = asked;
    }

    public boolean getDailyDouble()
    {
        return dailyDouble;
    }



}
