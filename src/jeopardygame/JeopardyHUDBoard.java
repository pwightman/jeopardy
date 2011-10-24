/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JeopardyHUDBoard.java
 *
 * Created on Mar 9, 2011, 11:11:06 AM
 */

package jeopardygame;

import java.awt.Color;

/**
 *
 * @author parkerwightman
 */
public class JeopardyHUDBoard extends javax.swing.JPanel {

    public JeopardyQuestion[][] tiles;
    public JeopardyCategory[] categories;

    /** Creates new form JeopardyHUDBoard */
    public JeopardyHUDBoard() {
        initComponents();

        tiles = new JeopardyQuestion[6][5];
        categories = new JeopardyCategory[6];
        
        categories[0] = Cat0;
        categories[1] = Cat1;
        categories[2] = Cat2;
        categories[3] = Cat3;
        categories[4] = Cat4;
        categories[5] = Cat5;


        tiles[0][0] = Que00;
        tiles[0][1] = Que10;
        tiles[0][2] = Que20;
        tiles[0][3] = Que30;
        tiles[0][4] = Que40;
        tiles[1][0] = Que01;
        tiles[1][1] = Que11;
        tiles[1][2] = Que21;
        tiles[1][3] = Que31;
        tiles[1][4] = Que41;
        tiles[2][0] = Que02;
        tiles[2][1] = Que12;
        tiles[2][2] = Que22;
        tiles[2][3] = Que32;
        tiles[2][4] = Que42;
        tiles[3][0] = Que03;
        tiles[3][1] = Que13;
        tiles[3][2] = Que23;
        tiles[3][3] = Que33;
        tiles[3][4] = Que43;
        tiles[4][0] = Que04;
        tiles[4][1] = Que14;
        tiles[4][2] = Que24;
        tiles[4][3] = Que34;
        tiles[4][4] = Que44;
        tiles[5][0] = Que05;
        tiles[5][1] = Que15;
        tiles[5][2] = Que25;
        tiles[5][3] = Que35;
        tiles[5][4] = Que45;
    }

    public void setupBoard(String[][] text)
    {
        for(int i = 0; i < 6; i++)
            categories[i].setText(text[i][0]);

        for(int i = 0; i < text.length; i++)
            for(int j = 1; j < text[i].length; j++)
                tiles[i][j - 1].setText(text[i][j]);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cat0 = new jeopardygame.JeopardyCategory();
        Cat1 = new jeopardygame.JeopardyCategory();
        Cat2 = new jeopardygame.JeopardyCategory();
        Cat3 = new jeopardygame.JeopardyCategory();
        Cat4 = new jeopardygame.JeopardyCategory();
        Cat5 = new jeopardygame.JeopardyCategory();
        Que00 = new jeopardygame.JeopardyQuestion();
        Que01 = new jeopardygame.JeopardyQuestion();
        Que02 = new jeopardygame.JeopardyQuestion();
        Que03 = new jeopardygame.JeopardyQuestion();
        Que04 = new jeopardygame.JeopardyQuestion();
        Que05 = new jeopardygame.JeopardyQuestion();
        Que10 = new jeopardygame.JeopardyQuestion();
        Que11 = new jeopardygame.JeopardyQuestion();
        Que12 = new jeopardygame.JeopardyQuestion();
        Que13 = new jeopardygame.JeopardyQuestion();
        Que14 = new jeopardygame.JeopardyQuestion();
        Que15 = new jeopardygame.JeopardyQuestion();
        Que20 = new jeopardygame.JeopardyQuestion();
        Que21 = new jeopardygame.JeopardyQuestion();
        Que22 = new jeopardygame.JeopardyQuestion();
        Que23 = new jeopardygame.JeopardyQuestion();
        Que24 = new jeopardygame.JeopardyQuestion();
        Que25 = new jeopardygame.JeopardyQuestion();
        Que30 = new jeopardygame.JeopardyQuestion();
        Que31 = new jeopardygame.JeopardyQuestion();
        Que32 = new jeopardygame.JeopardyQuestion();
        Que33 = new jeopardygame.JeopardyQuestion();
        Que34 = new jeopardygame.JeopardyQuestion();
        Que35 = new jeopardygame.JeopardyQuestion();
        Que40 = new jeopardygame.JeopardyQuestion();
        Que41 = new jeopardygame.JeopardyQuestion();
        Que42 = new jeopardygame.JeopardyQuestion();
        Que43 = new jeopardygame.JeopardyQuestion();
        Que44 = new jeopardygame.JeopardyQuestion();
        Que45 = new jeopardygame.JeopardyQuestion();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1920, 1200));
        setMinimumSize(new java.awt.Dimension(1920, 1200));
        setLayout(new java.awt.GridLayout(6, 6));
        add(Cat0);
        add(Cat1);
        add(Cat2);
        add(Cat3);
        add(Cat4);
        add(Cat5);
        add(Que00);
        add(Que01);
        add(Que02);
        add(Que03);
        add(Que04);
        add(Que05);
        add(Que10);
        add(Que11);
        add(Que12);
        add(Que13);
        add(Que14);
        add(Que15);
        add(Que20);
        add(Que21);
        add(Que22);
        add(Que23);
        add(Que24);
        add(Que25);
        add(Que30);
        add(Que31);
        add(Que32);
        add(Que33);
        add(Que34);
        add(Que35);
        add(Que40);
        add(Que41);
        add(Que42);
        add(Que43);
        add(Que44);
        add(Que45);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jeopardygame.JeopardyCategory Cat0;
    private jeopardygame.JeopardyCategory Cat1;
    private jeopardygame.JeopardyCategory Cat2;
    private jeopardygame.JeopardyCategory Cat3;
    private jeopardygame.JeopardyCategory Cat4;
    private jeopardygame.JeopardyCategory Cat5;
    private jeopardygame.JeopardyQuestion Que00;
    private jeopardygame.JeopardyQuestion Que01;
    private jeopardygame.JeopardyQuestion Que02;
    private jeopardygame.JeopardyQuestion Que03;
    private jeopardygame.JeopardyQuestion Que04;
    private jeopardygame.JeopardyQuestion Que05;
    private jeopardygame.JeopardyQuestion Que10;
    private jeopardygame.JeopardyQuestion Que11;
    private jeopardygame.JeopardyQuestion Que12;
    private jeopardygame.JeopardyQuestion Que13;
    private jeopardygame.JeopardyQuestion Que14;
    private jeopardygame.JeopardyQuestion Que15;
    private jeopardygame.JeopardyQuestion Que20;
    private jeopardygame.JeopardyQuestion Que21;
    private jeopardygame.JeopardyQuestion Que22;
    private jeopardygame.JeopardyQuestion Que23;
    private jeopardygame.JeopardyQuestion Que24;
    private jeopardygame.JeopardyQuestion Que25;
    private jeopardygame.JeopardyQuestion Que30;
    private jeopardygame.JeopardyQuestion Que31;
    private jeopardygame.JeopardyQuestion Que32;
    private jeopardygame.JeopardyQuestion Que33;
    private jeopardygame.JeopardyQuestion Que34;
    private jeopardygame.JeopardyQuestion Que35;
    private jeopardygame.JeopardyQuestion Que40;
    private jeopardygame.JeopardyQuestion Que41;
    private jeopardygame.JeopardyQuestion Que42;
    private jeopardygame.JeopardyQuestion Que43;
    private jeopardygame.JeopardyQuestion Que44;
    private jeopardygame.JeopardyQuestion Que45;
    // End of variables declaration//GEN-END:variables

}