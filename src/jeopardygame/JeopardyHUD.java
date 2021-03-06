/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JeopardyHUD.java
 *
 * Created on Mar 5, 2011, 12:50:08 PM
 */

package jeopardygame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

/**
 *
 * @author Mac
 */
public class JeopardyHUD extends javax.swing.JFrame {

    /** Creates new form JeopardyHUD */
    public JeopardyHUD() {
        this.setUndecorated(true);

        initComponents();

        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splashScreen = new jeopardygame.JeopardyHUDSplashScreen();
        board = new jeopardygame.JeopardyHUDBoard();
        fullScreen = new jeopardygame.JeopardyHUDFullScreen();
        dailyDouble = new jeopardygame.JeopardyHUDDailyDouble();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(splashScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(board, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(fullScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(dailyDouble, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JeopardyHUD().setVisible(true);
            }
        });
    }

    public void setupBoard(String[][] text)
    {
        board.setupBoard(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public jeopardygame.JeopardyHUDBoard board;
    public jeopardygame.JeopardyHUDDailyDouble dailyDouble;
    public jeopardygame.JeopardyHUDFullScreen fullScreen;
    public jeopardygame.JeopardyHUDSplashScreen splashScreen;
    // End of variables declaration//GEN-END:variables

}
