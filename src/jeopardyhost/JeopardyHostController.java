/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyhost;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Mac
 */
public class JeopardyHostController implements ComboBoxModel{

    public JeopardyHostFrame view;
    public boolean isDailyDouble;

    JeopardyHostNetworkHandler networkHandler;

    public JeopardyHostController()
    {
        view = new JeopardyHostFrame(this);
        view.setVisible(true);
        isDailyDouble = false;

        networkHandler = new JeopardyHostNetworkHandler(this);
    }

    public void connectToServer()
    {
        String host = JOptionPane.showInputDialog(null, "Jeopardy Host: Enter hostname");
        networkHandler.setHost(host);
        Thread t = new Thread(networkHandler);
        t.start();
    }

    public JeopardyHostFrame getView()
    {
        return view;
    }

    public void setupBoard(String[][] text)
    {
        view.getBoard().setupBoard(text);
    }

    public void sendQuestionChosen(int col, int row)
    {
        networkHandler.sendQuestionChosen(col, row);
    }

    public void updateQuestionInfo(String question, String answer)
    {
        view.getBoard().setVisible(false);
        view.bigQuestion.setText(question);
        view.questionAnswer.setText(answer);
        view.bigQuestion.setVisible(true);
    }

    public void initializeGame(int round)
    {
        JFileChooser chooser = new JFileChooser();

        int i = chooser.showOpenDialog(null);

        if(i != JFileChooser.APPROVE_OPTION)
            return;

        File roundOne = chooser.getSelectedFile();

//        i = chooser.showOpenDialog(null);
//
//        File roundTwo = chooser.getSelectedFile();
//
//        i = chooser.showOpenDialog(null);
//
//        File roundThree = chooser.getSelectedFile();

        File[] files = new File[] { roundOne, null, null };
        Scanner in;
        try {
            in = new Scanner(files[0]);
            //serverController.initializeGame(in);
            networkHandler.sendFileInfo(files[0], round);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JeopardyHostController.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    public void updatePlayerScores(String[] names, int[] scores)
    {
        String[] namesAndScores = new String[names.length];

        for(int i = 0; i < namesAndScores.length; i++)
            namesAndScores[i] = names[i] + " : " + scores[i];

        view.playerList.setListData(namesAndScores);
    }

    public void changeScore()
    {
        String name;
        String amount;
        do
        {
            name = JOptionPane.showInputDialog(null, "Enter name");
            amount = JOptionPane.showInputDialog(null, "Enter new score");
        } while (name == null || amount == null || name.isEmpty() || amount.isEmpty());
        networkHandler.sendScoreChange(name, amount);
    }

    public void setPlayerBuzzedInName(String name)
    {
        view.whoBuzzedIn.setText(name);
    }

    public void sendAnswer(boolean correct)
    {
        if(!isDailyDouble)
            networkHandler.sendAnswer(correct);
        else
            networkHandler.sendDailyDoubleAnswer(correct);
    }

    public void readyNext()
    {
        if(!isDailyDouble)
        {
            networkHandler.sendReadyNext();
            view.correctButton.setEnabled(false);
            view.incorrectButton.setEnabled(false);
            view.bigQuestion.setVisible(false);
            view.board.setVisible(true);
        }
        else
        {
            view.nextButton.setEnabled(false);
            view.correctButton.setEnabled(true);
            view.incorrectButton.setEnabled(true);
            networkHandler.sendDisplayDailyDouble();
            System.out.println("Daily double");
        }
    }

    public void sendThinking()
    {
        networkHandler.sendThinking();
    }


    public void sendStartBuzzing()
    {
        networkHandler.sendBeginBuzzing();
    }

    public void setSelectedItem(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getElementAt(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addListDataListener(ListDataListener ll) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeListDataListener(ListDataListener ll) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
