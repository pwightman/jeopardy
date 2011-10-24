/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author parkerwightman
 */
public class GameBoard {

    Question[][] questions;
    String[] categories;

    public GameBoard(Scanner in)
    {
        try
        {
            questions = new Question[6][5];
            categories = new String[6];
            for(int i = 0; i < 6; i++)
            {
                categories[i] = in.nextLine();
                for(int j = 0; j < 5; j++)
                {
                    boolean dailyDouble = false;
                    String temp = in.nextLine();
                    // Check for option
                    if(temp.charAt(0) == '!')
                    {
                        // Since it's an option, check the option and then
                        // replenish temp with a new string from the file
                        if(temp.substring(1).equals("DD"))
                            dailyDouble = true;
                        temp = in.nextLine();
                    }

                    questions[i][j] = new Question(temp, in.nextLine(), Integer.parseInt(in.nextLine()), dailyDouble);

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getCategoryText(int col)
    {
        return categories[col];
    }



    public Question getQuestionAtColAndRow(int col, int row)
    {
        System.out.println("" + col + " " + row);
        return questions[col][row];
    }
}
