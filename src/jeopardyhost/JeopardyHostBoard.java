/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JeopardyHostBoard.java
 *
 * Created on Mar 5, 2011, 2:03:37 PM
 */

package jeopardyhost;

import javax.swing.JButton;

/**
 *
 * @author Mac
 */
public class JeopardyHostBoard extends javax.swing.JPanel {

    JButton[][] tiles;
    JeopardyHostFrame frame;

    /** Creates new form JeopardyHostBoard */
    public JeopardyHostBoard() {
        initComponents();


        tiles = new JButton[6][5];

        tiles[0][0] = Que00;
        ((JeopardyHostTileButton)Que00).setColAndRow(0, 0);
        tiles[0][1] = Que10;
        ((JeopardyHostTileButton)Que10).setColAndRow(0, 1);
        tiles[0][2] = Que20;
        ((JeopardyHostTileButton)Que20).setColAndRow(0, 2);
        tiles[0][3] = Que30;
        ((JeopardyHostTileButton)Que30).setColAndRow(0, 3);
        tiles[0][4] = Que40;
        ((JeopardyHostTileButton)Que40).setColAndRow(0, 4);
        tiles[1][0] = Que01;
        ((JeopardyHostTileButton)Que01).setColAndRow(1, 0);
        tiles[1][1] = Que11;
        ((JeopardyHostTileButton)Que11).setColAndRow(1, 1);
        tiles[1][2] = Que21;
        ((JeopardyHostTileButton)Que21).setColAndRow(1, 2);
        tiles[1][3] = Que31;
        ((JeopardyHostTileButton)Que31).setColAndRow(1, 3);
        tiles[1][4] = Que41;
        ((JeopardyHostTileButton)Que41).setColAndRow(1, 4);
        tiles[2][0] = Que02;
        ((JeopardyHostTileButton)Que02).setColAndRow(2, 0);
        tiles[2][1] = Que12;
        ((JeopardyHostTileButton)Que12).setColAndRow(2, 1);
        tiles[2][2] = Que22;
        ((JeopardyHostTileButton)Que22).setColAndRow(2, 2);
        tiles[2][3] = Que32;
        ((JeopardyHostTileButton)Que32).setColAndRow(2, 3);
        tiles[2][4] = Que42;
        ((JeopardyHostTileButton)Que42).setColAndRow(2, 4);
        tiles[3][0] = Que03;
        ((JeopardyHostTileButton)Que03).setColAndRow(3, 0);
        tiles[3][1] = Que13;
        ((JeopardyHostTileButton)Que13).setColAndRow(3, 1);
        tiles[3][2] = Que23;
        ((JeopardyHostTileButton)Que23).setColAndRow(3, 2);
        tiles[3][3] = Que33;
        ((JeopardyHostTileButton)Que33).setColAndRow(3, 3);
        tiles[3][4] = Que43;
        ((JeopardyHostTileButton)Que43).setColAndRow(3, 4);
        tiles[4][0] = Que04;
        ((JeopardyHostTileButton)Que04).setColAndRow(4, 0);
        tiles[4][1] = Que14;
        ((JeopardyHostTileButton)Que14).setColAndRow(4, 1);
        tiles[4][2] = Que24;
        ((JeopardyHostTileButton)Que24).setColAndRow(4, 2);
        tiles[4][3] = Que34;
        ((JeopardyHostTileButton)Que34).setColAndRow(4, 3);
        tiles[4][4] = Que44;
        ((JeopardyHostTileButton)Que44).setColAndRow(4, 4);
        tiles[5][0] = Que05;
        ((JeopardyHostTileButton)Que05).setColAndRow(5, 0);
        tiles[5][1] = Que15;
        ((JeopardyHostTileButton)Que15).setColAndRow(5, 1);
        tiles[5][2] = Que25;
        ((JeopardyHostTileButton)Que25).setColAndRow(5, 2);
        tiles[5][3] = Que35;
        ((JeopardyHostTileButton)Que35).setColAndRow(5, 3);
        tiles[5][4] = Que45;
        ((JeopardyHostTileButton)Que45).setColAndRow(5, 4);
    }

    public void setFrame(JeopardyHostFrame frame)
    {
        this.frame = frame;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Que00 = new JeopardyHostTileButton();
        Que01 = new JeopardyHostTileButton();
        Que02 = new JeopardyHostTileButton();
        Que03 = new JeopardyHostTileButton();
        Que04 = new JeopardyHostTileButton();
        Que05 = new JeopardyHostTileButton();
        Que10 = new JeopardyHostTileButton();
        Que11 = new JeopardyHostTileButton();
        Que12 = new JeopardyHostTileButton();
        Que13 = new JeopardyHostTileButton();
        Que14 = new JeopardyHostTileButton();
        Que15 = new JeopardyHostTileButton();
        Que20 = new JeopardyHostTileButton();
        Que21 = new JeopardyHostTileButton();
        Que22 = new JeopardyHostTileButton();
        Que23 = new JeopardyHostTileButton();
        Que24 = new JeopardyHostTileButton();
        Que25 = new JeopardyHostTileButton();
        Que30 = new JeopardyHostTileButton();
        Que31 = new JeopardyHostTileButton();
        Que32 = new JeopardyHostTileButton();
        Que33 = new JeopardyHostTileButton();
        Que34 = new JeopardyHostTileButton();
        Que35 = new JeopardyHostTileButton();
        Que40 = new JeopardyHostTileButton();
        Que41 = new JeopardyHostTileButton();
        Que42 = new JeopardyHostTileButton();
        Que43 = new JeopardyHostTileButton();
        Que44 = new JeopardyHostTileButton();
        Que45 = new JeopardyHostTileButton();

        setLayout(new java.awt.GridLayout(6, 6));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setFocusTraversalKeysEnabled(false);
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setFocusTraversalKeysEnabled(false);
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setFocusTraversalKeysEnabled(false);
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setFocusTraversalKeysEnabled(false);
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setFocusTraversalKeysEnabled(false);
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setFocusTraversalKeysEnabled(false);
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel6);

        Que00.setFocusTraversalKeysEnabled(false);
        Que00.setFocusable(false);
        Que00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que00);

        Que01.setFocusTraversalKeysEnabled(false);
        Que01.setFocusable(false);
        Que01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que01);

        Que02.setFocusTraversalKeysEnabled(false);
        Que02.setFocusable(false);
        Que02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que02);

        Que03.setFocusTraversalKeysEnabled(false);
        Que03.setFocusable(false);
        Que03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que03);

        Que04.setFocusTraversalKeysEnabled(false);
        Que04.setFocusable(false);
        Que04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que04);

        Que05.setBackground(new java.awt.Color(0, 0, 204));
        Que05.setFocusTraversalKeysEnabled(false);
        Que05.setFocusable(false);
        Que05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que05);

        Que10.setFocusTraversalKeysEnabled(false);
        Que10.setFocusable(false);
        Que10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que10);

        Que11.setFocusTraversalKeysEnabled(false);
        Que11.setFocusable(false);
        Que11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que11);

        Que12.setFocusTraversalKeysEnabled(false);
        Que12.setFocusable(false);
        Que12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que12);

        Que13.setFocusTraversalKeysEnabled(false);
        Que13.setFocusable(false);
        Que13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que13);

        Que14.setFocusTraversalKeysEnabled(false);
        Que14.setFocusable(false);
        Que14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que14);

        Que15.setFocusTraversalKeysEnabled(false);
        Que15.setFocusable(false);
        Que15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que15);

        Que20.setFocusTraversalKeysEnabled(false);
        Que20.setFocusable(false);
        Que20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que20);

        Que21.setFocusTraversalKeysEnabled(false);
        Que21.setFocusable(false);
        Que21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que21);

        Que22.setFocusTraversalKeysEnabled(false);
        Que22.setFocusable(false);
        Que22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que22);

        Que23.setFocusTraversalKeysEnabled(false);
        Que23.setFocusable(false);
        Que23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que23);

        Que24.setFocusTraversalKeysEnabled(false);
        Que24.setFocusable(false);
        Que24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que24);

        Que25.setFocusTraversalKeysEnabled(false);
        Que25.setFocusable(false);
        Que25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que25);

        Que30.setFocusTraversalKeysEnabled(false);
        Que30.setFocusable(false);
        Que30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que30);

        Que31.setFocusTraversalKeysEnabled(false);
        Que31.setFocusable(false);
        Que31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que31);

        Que32.setFocusTraversalKeysEnabled(false);
        Que32.setFocusable(false);
        Que32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que32);

        Que33.setFocusTraversalKeysEnabled(false);
        Que33.setFocusable(false);
        Que33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que33);

        Que34.setFocusTraversalKeysEnabled(false);
        Que34.setFocusable(false);
        Que34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que34);

        Que35.setFocusTraversalKeysEnabled(false);
        Que35.setFocusable(false);
        Que35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que35);

        Que40.setFocusTraversalKeysEnabled(false);
        Que40.setFocusable(false);
        Que40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que40);

        Que41.setFocusTraversalKeysEnabled(false);
        Que41.setFocusable(false);
        Que41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que41);

        Que42.setFocusTraversalKeysEnabled(false);
        Que42.setFocusable(false);
        Que42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que42);

        Que43.setFocusTraversalKeysEnabled(false);
        Que43.setFocusable(false);
        Que43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que43);

        Que44.setFocusTraversalKeysEnabled(false);
        Que44.setFocusable(false);
        Que44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que44);

        Que45.setFocusTraversalKeysEnabled(false);
        Que45.setFocusable(false);
        Que45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileClickedListener(evt);
            }
        });
        add(Que45);
    }// </editor-fold>//GEN-END:initComponents

    private void tileClickedListener(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tileClickedListener
        JeopardyHostTileButton button = (JeopardyHostTileButton)evt.getSource();
        System.out.println("" + button.col + " " + button.row);
        frame.questionChosen(button.col, button.row);
        tiles[button.col][button.row].setText("");
    }//GEN-LAST:event_tileClickedListener

    public void setupBoard(String[][] text)
    {
        jLabel1.setText("<html>" + text[0][0].toUpperCase() + "</html>");
        jLabel1.setText("<html>" + text[0][0].toUpperCase() + "</html>");
        jLabel2.setText("<html>" + text[1][0].toUpperCase() + "</html>");
        jLabel3.setText("<html>" + text[2][0].toUpperCase() + "</html>");
        jLabel4.setText("<html>" + text[3][0].toUpperCase() + "</html>");
        jLabel5.setText("<html>" + text[4][0].toUpperCase() + "</html>");
        jLabel6.setText("<html>" + text[5][0].toUpperCase() + "</html>");

        for(int i = 0; i < text.length; i++)
            for(int j = 1; j < text[i].length; j++)
                ((JeopardyHostTileButton)tiles[i][j - 1]).settext(text[i][j]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Que00;
    private javax.swing.JButton Que01;
    private javax.swing.JButton Que02;
    private javax.swing.JButton Que03;
    private javax.swing.JButton Que04;
    private javax.swing.JButton Que05;
    private javax.swing.JButton Que10;
    private javax.swing.JButton Que11;
    private javax.swing.JButton Que12;
    private javax.swing.JButton Que13;
    private javax.swing.JButton Que14;
    private javax.swing.JButton Que15;
    private javax.swing.JButton Que20;
    private javax.swing.JButton Que21;
    private javax.swing.JButton Que22;
    private javax.swing.JButton Que23;
    private javax.swing.JButton Que24;
    private javax.swing.JButton Que25;
    private javax.swing.JButton Que30;
    private javax.swing.JButton Que31;
    private javax.swing.JButton Que32;
    private javax.swing.JButton Que33;
    private javax.swing.JButton Que34;
    private javax.swing.JButton Que35;
    private javax.swing.JButton Que40;
    private javax.swing.JButton Que41;
    private javax.swing.JButton Que42;
    private javax.swing.JButton Que43;
    private javax.swing.JButton Que44;
    private javax.swing.JButton Que45;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
