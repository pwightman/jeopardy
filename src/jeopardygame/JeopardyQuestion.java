/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JeopardyQuestion.java
 *
 * Created on Mar 5, 2011, 1:00:59 PM
 */

package jeopardygame;

/**
 *
 * @author Mac
 */
public class JeopardyQuestion extends javax.swing.JPanel {



    /** Creates new form JeopardyQuestion */
    public JeopardyQuestion() {
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

        jLabelPointValue = new javax.swing.JLabel();
        backgroundText = new javax.swing.JLabel();
        foregroundText = new javax.swing.JLabel();

        jLabelPointValue.setFont(new java.awt.Font("Lucida Grande", 1, 100));
        jLabelPointValue.setForeground(new java.awt.Color(204, 153, 0));
        jLabelPointValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPointValue.setText("$100");

        setBackground(new java.awt.Color(0, 0, 150));
        setMaximumSize(new java.awt.Dimension(320, 200));
        setMinimumSize(new java.awt.Dimension(320, 200));
        setPreferredSize(new java.awt.Dimension(320, 200));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundText.setFont(new java.awt.Font("Impact", 0, 105)); // NOI18N
        backgroundText.setForeground(new java.awt.Color(251, 159, 0));
        backgroundText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        add(backgroundText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 200));

        foregroundText.setFont(new java.awt.Font("Impact", 0, 105)); // NOI18N
        foregroundText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(foregroundText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 340, 170));
    }// </editor-fold>//GEN-END:initComponents


    public void setText(String text)
    {
        foregroundText.setText("$" + text);
        backgroundText.setText("$" + text);
    }

    public void clearText()
    {
         foregroundText.setText("");
        backgroundText.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel backgroundText;
    private javax.swing.JLabel foregroundText;
    private javax.swing.JLabel jLabelPointValue;
    // End of variables declaration//GEN-END:variables

}