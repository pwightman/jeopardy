package jeopardyplayer;

import java.awt.event.KeyEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JeopardyPlayerFrame.java
 *
 * Created on Mar 3, 2011, 5:40:12 PM
 */

/**
 *
 * @author pwightman
 */
public class JeopardyPlayerFrame extends javax.swing.JFrame {

    JeopardyPlayerController controller;
    int id;
    /** Creates new form JeopardyPlayerFrame */
    public JeopardyPlayerFrame(JeopardyPlayerController controller) {
        this.controller = controller;
        initComponents();

        playerList.setFocusable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        buzzButton = new javax.swing.JButton();
        PlayerTimerLabel = new javax.swing.JLabel();
        PlayerTimerDisplay = new javax.swing.JLabel();
        PlayerIndicatorLight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buzzButton.setText("Buzz");
        buzzButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buzzButtonActionPerformed(evt);
            }
        });
        getContentPane().add(buzzButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 150, 54));

        PlayerTimerLabel.setLabelFor(PlayerTimerDisplay);
        PlayerTimerLabel.setText("Timer");
        getContentPane().add(PlayerTimerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        PlayerTimerDisplay.setFont(new java.awt.Font("Helvetica", 0, 48));
        PlayerTimerDisplay.setText("0:00");
        getContentPane().add(PlayerTimerDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 200, 60));

        PlayerIndicatorLight.setBackground(new java.awt.Color(255, 0, 0));
        PlayerIndicatorLight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout PlayerIndicatorLightLayout = new javax.swing.GroupLayout(PlayerIndicatorLight);
        PlayerIndicatorLight.setLayout(PlayerIndicatorLightLayout);
        PlayerIndicatorLightLayout.setHorizontalGroup(
            PlayerIndicatorLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );
        PlayerIndicatorLightLayout.setVerticalGroup(
            PlayerIndicatorLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        getContentPane().add(PlayerIndicatorLight, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 50, 50));

        playerList.setBackground(new java.awt.Color(0, 0, 150));
        playerList.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        playerList.setForeground(new java.awt.Color(255, 255, 255));
        playerList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "PlayerName: PlayerScore", " ", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(playerList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 210, 180));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Gyparody", 0, 36));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jeopardy!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica", 0, 18));
        jLabel2.setText("Contestant");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, 20));

        playerName.setFont(new java.awt.Font("Helvetica", 0, 36));
        getContentPane().add(playerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 240, 50));

        jLabel4.setText("Player");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buzzButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buzzButtonActionPerformed
        controller.userBuzzed();
    }//GEN-LAST:event_buzzButtonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_SPACE)
            controller.userBuzzed();

    }//GEN-LAST:event_formKeyPressed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JeopardyServerController c = new JeopardyServerController();
//
//                new JeopardyPlayerFrame(c).setVisible(true);
//                new JeopardyPlayerFrame(c).setVisible(true);
//                new JeopardyPlayerFrame(c).setVisible(true);
//                new JeopardyPlayerFrame(c).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PlayerIndicatorLight;
    private javax.swing.JLabel PlayerTimerDisplay;
    private javax.swing.JLabel PlayerTimerLabel;
    private javax.swing.JButton buzzButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JList playerList;
    public javax.swing.JLabel playerName;
    // End of variables declaration//GEN-END:variables

}