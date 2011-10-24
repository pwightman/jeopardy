/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyplayer;

import java.awt.Color;
import javax.swing.JOptionPane;
import jeopardyserver.JeopardyServerController;

/**
 *
 * @author parkerwightman
 */
public class JeopardyPlayerController {

    JeopardyPlayerFrame view;

    JeopardyPlayerNetworkHandler networkHandler;
    int Id;
    public String name;

    public JeopardyPlayerController()
    {
        view = new JeopardyPlayerFrame(this);
        view.setVisible(true);
        networkHandler = new JeopardyPlayerNetworkHandler(this);
        
        
        
        
        Id = -1;

        name = "";
    }
    
    public void startSignin()
    {
        String host = JOptionPane.showInputDialog(null, "Enter IP (Ask Collin or Parker)");
        networkHandler.setHost(host);
        name = JOptionPane.showInputDialog(null, "Enter your name");
        view.playerName.setText(name);
        new Thread(networkHandler).start();
    }

    public void userBuzzed()
    {
        networkHandler.sendUserBuzzed();
    }



    /**
     * names and scores should be the same length!!!
     *
     * @param names
     * @param scores
     */
    public void updatePlayerScores(String[] names, int[] scores)
    {
        String[] namesAndScores = new String[names.length];

        for(int i = 0; i < namesAndScores.length; i++)
            namesAndScores[i] = names[i] + " : " + scores[i];
        
        view.playerList.setListData(namesAndScores);
    }

    public void beginBuzzing()
    {
        view.PlayerIndicatorLight.setBackground(Color.GREEN);
    }

    public void endBuzzing()
    {
        view.PlayerIndicatorLight.setBackground(Color.RED);
    }

    public String getPlayerName()
    {
        return name;
    }

    public void setId(int id)
    {
        System.out.println("Id changed to " + id);
        Id = id;
    }

}
