/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JeopardyHUDSplashScreen.java
 *
 * Created on Mar 19, 2011, 7:01:51 PM
 */

package jeopardygame;

/**
 *
 * @author Mac
 */
public class JeopardyHUDSplashScreen extends javax.swing.JPanel {

    /** Creates new form JeopardyHUDSplashScreen */
    public JeopardyHUDSplashScreen() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dadEdition = new javax.swing.JLabel();
        dadEditionShadow = new javax.swing.JLabel();
        SplashLogo = new javax.swing.JLabel();
        SplashLogoGrey = new javax.swing.JLabel();
        SplashLogoDarkGrey = new javax.swing.JLabel();
        emptySplashLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dadEdition.setFont(new java.awt.Font("Impact", 0, 150)); // NOI18N
        dadEdition.setForeground(new java.awt.Color(255, 255, 0));
        dadEdition.setText("CHRISTMAS EDITION!");
        add(dadEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 780, -1, -1));

        dadEditionShadow.setFont(new java.awt.Font("Impact", 0, 150)); // NOI18N
        dadEditionShadow.setText("CHRISTMAS EDITION!");
        add(dadEditionShadow, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 790, -1, -1));

        SplashLogo.setFont(new java.awt.Font("Gyparody", 0, 450));
        SplashLogo.setForeground(new java.awt.Color(255, 255, 255));
        SplashLogo.setText("JEOPARDY!");
        SplashLogo.setMaximumSize(new java.awt.Dimension(1920, 1200));
        SplashLogo.setMinimumSize(new java.awt.Dimension(1920, 1200));
        SplashLogo.setPreferredSize(new java.awt.Dimension(1920, 1200));
        add(SplashLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 1770, 800));

        SplashLogoGrey.setFont(new java.awt.Font("Gyparody", 0, 456));
        SplashLogoGrey.setForeground(new java.awt.Color(204, 204, 204));
        SplashLogoGrey.setText("JEOPARDY!");
        SplashLogoGrey.setMaximumSize(new java.awt.Dimension(1920, 1200));
        SplashLogoGrey.setMinimumSize(new java.awt.Dimension(1920, 1200));
        SplashLogoGrey.setPreferredSize(new java.awt.Dimension(1920, 1200));
        add(SplashLogoGrey, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 1800, 800));

        SplashLogoDarkGrey.setFont(new java.awt.Font("Gyparody", 0, 460));
        SplashLogoDarkGrey.setForeground(new java.awt.Color(153, 153, 153));
        SplashLogoDarkGrey.setText("JEOPARDY!");
        SplashLogoDarkGrey.setMaximumSize(new java.awt.Dimension(1920, 1200));
        SplashLogoDarkGrey.setMinimumSize(new java.awt.Dimension(1920, 1200));
        SplashLogoDarkGrey.setPreferredSize(new java.awt.Dimension(1920, 1200));
        add(SplashLogoDarkGrey, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 1800, 800));

        emptySplashLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 50, true));
        add(emptySplashLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1200));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SplashLogo;
    private javax.swing.JLabel SplashLogoDarkGrey;
    private javax.swing.JLabel SplashLogoGrey;
    private javax.swing.JLabel dadEdition;
    private javax.swing.JLabel dadEditionShadow;
    private javax.swing.JLabel emptySplashLabel;
    // End of variables declaration//GEN-END:variables

}
