/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JeopardyHostFrame.java
 *
 * Created on Mar 5, 2011, 2:02:19 PM
 */

package jeopardyhost;

import java.awt.event.KeyEvent;

/**
 *
 * @author Mac
 */
public class JeopardyHostFrame extends javax.swing.JFrame {

    JeopardyHostController controller;

    /** Creates new form JeopardyHostFrame */
    public JeopardyHostFrame(JeopardyHostController c) {
        initComponents();
        controller  = c;

    }

    public void questionChosen(int col, int row)
    {
        controller.sendQuestionChosen(col, row);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HostIndicatorLight = new javax.swing.JPanel();
        startBuzzingButton = new javax.swing.JButton();
        correctButton = new javax.swing.JButton();
        board = new jeopardyhost.JeopardyHostBoard();
        incorrectButton = new javax.swing.JButton();
        loadGameButton = new javax.swing.JButton();
        questionAnswer = new javax.swing.JLabel();
        bigQuestion = new jeopardyhost.JeopardyHostQuestion();
        whoBuzzedIn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ScoreCorrectionLabel = new javax.swing.JLabel();
        ScoreCorrectionGoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HostIndicatorLight.setBackground(new java.awt.Color(255, 0, 0));
        HostIndicatorLight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HostIndicatorLight.setFocusable(false);

        org.jdesktop.layout.GroupLayout HostIndicatorLightLayout = new org.jdesktop.layout.GroupLayout(HostIndicatorLight);
        HostIndicatorLight.setLayout(HostIndicatorLightLayout);
        HostIndicatorLightLayout.setHorizontalGroup(
            HostIndicatorLightLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 46, Short.MAX_VALUE)
        );
        HostIndicatorLightLayout.setVerticalGroup(
            HostIndicatorLightLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 46, Short.MAX_VALUE)
        );

        getContentPane().add(HostIndicatorLight, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 50, 50));

        startBuzzingButton.setText("Start Buzzing");
        startBuzzingButton.setEnabled(false);
        startBuzzingButton.setFocusable(false);
        startBuzzingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBuzzingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startBuzzingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 110, 30));

        correctButton.setBackground(new java.awt.Color(186, 237, 180));
        correctButton.setText("Correct");
        correctButton.setEnabled(false);
        correctButton.setFocusable(false);
        correctButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correctButtonActionPerformed(evt);
            }
        });
        getContentPane().add(correctButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 110, 60));

        board.setFocusable(false);
        board.setFrame(this);
        getContentPane().add(board, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 614, 390));

        incorrectButton.setBackground(new java.awt.Color(235, 195, 195));
        incorrectButton.setText("Incorrect");
        incorrectButton.setEnabled(false);
        incorrectButton.setFocusable(false);
        incorrectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incorrectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(incorrectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 110, 60));

        loadGameButton.setText("Load First Round");
        loadGameButton.setFocusable(false);
        loadGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loadGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        questionAnswer.setFont(new java.awt.Font("Helvetica", 0, 28)); // NOI18N
        questionAnswer.setFocusable(false);
        getContentPane().add(questionAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 480, 50));

        bigQuestion.setFocusable(false);
        getContentPane().add(bigQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 380));

        whoBuzzedIn.setFont(new java.awt.Font("Helvetica", 0, 28));
        whoBuzzedIn.setFocusable(false);
        getContentPane().add(whoBuzzedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 480, 50));

        jLabel1.setText("Answer:");
        jLabel1.setFocusable(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        jLabel2.setText("Who Buzzed In:");
        jLabel2.setFocusable(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.setFocusable(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 110, 30));

        jLabel3.setFont(new java.awt.Font("Gyparody", 0, 36));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jeopardy!");
        jLabel3.setFocusable(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 150, 50));

        jLabel4.setFont(new java.awt.Font("Helvetica CY", 0, 24));
        jLabel4.setText("Host Board");
        jLabel4.setFocusable(false);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 610, -1, -1));

        ScoreCorrectionLabel.setText("Score Correction");
        ScoreCorrectionLabel.setFocusable(false);
        getContentPane().add(ScoreCorrectionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, -1, 20));

        ScoreCorrectionGoButton.setText("Change Score");
        ScoreCorrectionGoButton.setFocusable(false);
        ScoreCorrectionGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScoreCorrectionGoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ScoreCorrectionGoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, 150, -1));

        jScrollPane1.setFocusable(false);

        playerList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        playerList.setFocusTraversalKeysEnabled(false);
        playerList.setFocusable(false);
        jScrollPane1.setViewportView(playerList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 160, 150));

        jButton1.setText("Think");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 110, -1));

        jButton2.setText("Load Second Round");
        jButton2.setFocusTraversalKeysEnabled(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setController(JeopardyHostController c)
    {
        controller = c;
    }

    public JeopardyHostBoard getBoard()
    {
        return board;
    }

    private void startBuzzingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBuzzingButtonActionPerformed
        controller.sendStartBuzzing();
    }//GEN-LAST:event_startBuzzingButtonActionPerformed

    private void correctButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correctButtonActionPerformed
        controller.sendAnswer(true);
    }//GEN-LAST:event_correctButtonActionPerformed

    private void incorrectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incorrectButtonActionPerformed
        controller.sendAnswer(false);
    }//GEN-LAST:event_incorrectButtonActionPerformed

    private void loadGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameButtonActionPerformed
        controller.initializeGame(1);
    }//GEN-LAST:event_loadGameButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (!controller.isDailyDouble) {
        bigQuestion.setVisible(false);
        questionAnswer.setText("");
        board.setVisible(true);
        }
        controller.readyNext();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controller.sendThinking();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            controller.sendAnswer(true);
        else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
            controller.sendAnswer(false);
        else if(evt.getKeyCode() == KeyEvent.VK_SPACE)
            controller.sendStartBuzzing();

    }//GEN-LAST:event_formKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controller.initializeGame(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ScoreCorrectionGoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScoreCorrectionGoButtonActionPerformed
        controller.changeScore();
    }//GEN-LAST:event_ScoreCorrectionGoButtonActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JeopardyHostFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel HostIndicatorLight;
    public javax.swing.JButton ScoreCorrectionGoButton;
    private javax.swing.JLabel ScoreCorrectionLabel;
    public jeopardyhost.JeopardyHostQuestion bigQuestion;
    public jeopardyhost.JeopardyHostBoard board;
    public javax.swing.JButton correctButton;
    public javax.swing.JButton incorrectButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton loadGameButton;
    public javax.swing.JButton nextButton;
    public javax.swing.JList playerList;
    public javax.swing.JLabel questionAnswer;
    public javax.swing.JButton startBuzzingButton;
    public javax.swing.JLabel whoBuzzedIn;
    // End of variables declaration//GEN-END:variables

}
