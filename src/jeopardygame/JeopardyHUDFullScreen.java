/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JeopardyHUDFullScreen.java
 *
 * Created on Mar 18, 2011, 5:44:08 PM
 */

package jeopardygame;

/**
 *
 * @author parkerwightman
 */
public class JeopardyHUDFullScreen extends javax.swing.JPanel {

    /** Creates new form JeopardyHUDFullScreen */
    public JeopardyHUDFullScreen() {
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

        backgroundText = new javax.swing.JLabel();
        foregroundText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 150));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 15));
        setMaximumSize(new java.awt.Dimension(1920, 1200));
        setMinimumSize(new java.awt.Dimension(1920, 1200));
        setPreferredSize(new java.awt.Dimension(1920, 1200));
        setSize(new java.awt.Dimension(1920, 1200));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundText.setFont(new java.awt.Font("Calisto MT", 0, 100)); // NOI18N
        backgroundText.setForeground(new java.awt.Color(255, 255, 255));
        backgroundText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(backgroundText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1200));

        foregroundText.setFont(new java.awt.Font("Calisto MT", 0, 100));
        foregroundText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(foregroundText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1930, 1210));
    }// </editor-fold>//GEN-END:initComponents

    public void setText(String text)
    {
        foregroundText.setText("<html><div align=\"center\">" + text.toUpperCase() + "</div></html>");
        backgroundText.setText("<html><div align=\"center\">" + text.toUpperCase() + "</div></html>");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundText;
    private javax.swing.JLabel foregroundText;
    // End of variables declaration//GEN-END:variables

}
