/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.volunteer;

/**
 *
 * @author DELL
 */
public class ViewAnonymousRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAnonymousRequestJPanel
     */
    public ViewAnonymousRequestJPanel() {
        initComponents();
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
        processHelpRquestJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        manageEnt1 = new javax.swing.JLabel();
        manageEnt = new javax.swing.JLabel();
        assignJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        anonymousHelpReqTable = new javax.swing.JTable();
        viewHelpSeekerBtn = new javax.swing.JButton();

        processHelpRquestJButton.setText("Process");
        processHelpRquestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processHelpRquestJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        manageEnt1.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt1.setText("Heart Help");

        manageEnt.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt.setText("Help Requests");

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        anonymousHelpReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Help Needed", "Help Seeker Name", "Reciever", "Request Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(anonymousHelpReqTable);

        viewHelpSeekerBtn.setText("View Requestor Profile");
        viewHelpSeekerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHelpSeekerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(viewHelpSeekerBtn)
                        .addGap(47, 47, 47)
                        .addComponent(assignJButton)
                        .addGap(37, 37, 37)
                        .addComponent(processHelpRquestJButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(300, 300, 300)
                            .addComponent(manageEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(manageEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(209, 209, 209)
                            .addComponent(refreshJButton))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(backJButton)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(394, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(manageEnt1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageEnt)
                    .addComponent(refreshJButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processHelpRquestJButton)
                    .addComponent(assignJButton)
                    .addComponent(viewHelpSeekerBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(backJButton)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processHelpRquestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processHelpRquestJButtonActionPerformed

        int selectedRow = anonymousHelpReqTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        NeedHelpWorkRequest request = (NeedHelpWorkRequest)anonymousHelpReqTable.getValueAt(selectedRow, 0);

        if(request.getReceiver() == null)
        {
            JOptionPane.showMessageDialog(null, "Please assign the request first", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(request.getStatus().equalsIgnoreCase("Completed"))
        {
            JOptionPane.showMessageDialog(null, "Request has been processed earlier!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(request.getStatus().equalsIgnoreCase("Processing") ||  request.getStatus().equalsIgnoreCase("Pending"))
        {
            if(request.getReceiver()!=userAccount)
            {
                JOptionPane.showMessageDialog(null, "Request has been processed earlier!", "warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        request.setStatus("Processing");

        ProcessAnonymousHelpReqPanel processAnonymousHelpReqPanel = new ProcessAnonymousHelpReqPanel(userProcessContainer, request, userAccount, directory);
        userProcessContainer.add("ProcessAnonymousHelpReqPanel", processAnonymousHelpReqPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_processHelpRquestJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateAnonymousHelpRequestTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = anonymousHelpReqTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest request = (WorkRequest)anonymousHelpReqTable.getValueAt(selectedRow, 0);
        if(request.getReceiver()!=null)
        {
            JOptionPane.showMessageDialog(null, "Request has been processed by Other Volunteers!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateAnonymousHelpRequestTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewHelpSeekerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHelpSeekerBtnActionPerformed
        int selectedRow = anonymousHelpReqTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest request = (WorkRequest)anonymousHelpReqTable.getValueAt(selectedRow, 0);
        UserAccount ua = request.getSender();

        ViewVolunteerProfile viewVolunteerProfile = new ViewVolunteerProfile(userProcessContainer, ua);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewVolunteerProfile", viewVolunteerProfile);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewHelpSeekerBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable anonymousHelpReqTable;
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel manageEnt;
    private javax.swing.JLabel manageEnt1;
    private javax.swing.JButton processHelpRquestJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton viewHelpSeekerBtn;
    // End of variables declaration//GEN-END:variables
}
