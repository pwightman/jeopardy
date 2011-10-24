/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyhost;

import javax.swing.JButton;

/**
 *
 * @author Mac
 */
public class JeopardyHostTileButton extends JButton {

    public int col, row;

    public void setColAndRow(int col, int row)
    {
        this.col = col;
        this.row = row;
    }

    public void settext(String text)
    {
        this.setText("<html>" + text + "</html>");
    }
}
