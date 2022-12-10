/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdmin;

import business.EcoSystem;
import business.common.NeedHelp;
import business.common.ValidateStrings;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class CreateHelpJPanel extends javax.swing.JPanel {
 private JPanel userProcessContainer;
    private EcoSystem system;
    /**
     * Creates new form CreateHelpJPanel
     */
    public CreateHelpJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        

        addInputVerifiers();
        populateComboBxHelpType();
    }
@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        
        Color c1 = new Color(153,197,85);
        Color c2 = Color.white;
     
        GradientPaint gp = new GradientPaint(w/4, 0, c2, w/4, h, c1);
        setOpaque( false );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        setOpaque( true );
    }
    
    public void populateComboBxHelpType()
    {
      helpTypeComboBx.removeAllItems();
      helpTypeComboBx.addItem("Immediate");
      helpTypeComboBx.addItem("Need in a day");
      helpTypeComboBx.addItem("Not Immediate service");
      helpTypeComboBx.addItem("In a Week");
    }
    
     private void addInputVerifiers() {
        InputVerifier stringValidation = new ValidateStrings();
        helpnameJTxtField.setInputVerifier(stringValidation);
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        manageEnt2 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        helpnameJTxtField = new javax.swing.JTextField();
        helpName = new javax.swing.JLabel();
        createHelpJButton = new javax.swing.JButton();
        helpType = new javax.swing.JLabel();
        manageEnt1 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        helpTypeComboBx = new javax.swing.JComboBox();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        manageEnt2.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt2.setText("Heart Help");

        jLayeredPane1.setBackground(new java.awt.Color(193, 250, 144));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        helpName.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        helpName.setText("Help Offered");

        createHelpJButton.setText("Create Help");
        createHelpJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createHelpJButtonActionPerformed(evt);
            }
        });

        helpType.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        helpType.setText("Help Type");

        manageEnt1.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt1.setText("Create Help Offerred");

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        helpTypeComboBx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLayeredPane1.setLayer(helpnameJTxtField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(helpName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(createHelpJButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(helpType, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(manageEnt1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cancelBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(helpTypeComboBx, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(helpName)
                            .addComponent(helpType))
                        .addGap(29, 29, 29)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(helpTypeComboBx, 0, 215, Short.MAX_VALUE)
                            .addComponent(helpnameJTxtField)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(manageEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(createHelpJButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(manageEnt1)
                .addGap(38, 38, 38)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpName)
                    .addComponent(helpnameJTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(helpType)
                    .addComponent(helpTypeComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createHelpJButton)
                    .addComponent(cancelBtn))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(manageEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(backJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(manageEnt2)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(backJButton)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 947, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createHelpJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createHelpJButtonActionPerformed

        if(helpnameJTxtField.getText().trim().isEmpty() || helpTypeComboBx.getSelectedIndex()<0)
        {
            JOptionPane.showMessageDialog(this, "Please enter data in all fields", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        NeedHelp needHelp = system.addNeedHelp();
        needHelp.setHelp(helpnameJTxtField.getText());
        needHelp.setServiceType((String)helpTypeComboBx.getSelectedItem());

        JOptionPane.showMessageDialog(this, "Help has been created successfully", "success", JOptionPane.PLAIN_MESSAGE);

        resetFields();

    }//GEN-LAST:event_createHelpJButtonActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        resetFields();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

 public void resetFields()
    {
        helpnameJTxtField.setText("");
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton createHelpJButton;
    private javax.swing.JLabel helpName;
    private javax.swing.JLabel helpType;
    private javax.swing.JComboBox helpTypeComboBx;
    private javax.swing.JTextField helpnameJTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel manageEnt1;
    private javax.swing.JLabel manageEnt2;
    // End of variables declaration//GEN-END:variables
}
