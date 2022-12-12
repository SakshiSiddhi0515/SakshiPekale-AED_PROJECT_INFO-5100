/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.helpSeeker;

import Model.System.EcoSystem;
import Model.common.NeedHelp;
import Model.common.ValidateStrings;
import Model.enterprise.enterprises;
import Model.network.network;
import Model.Org.Organization;
import Model.Org.OrgVolunteer;
import Model.User.UserAccount;
import Model.Work.HelpRequest;
import Model.Work.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Sakshi Sasalate
 */
public class GetHelpFromVolunteer extends javax.swing.JPanel {
    
       
    private JPanel userProcessContainer;
    private UserAccount userAccount; 
    private EcoSystem ecoSystem;
 
    
    /**
     * Creates new form GetHelpFromVolunteerJPanel
     */
    public GetHelpFromVolunteer(JPanel userProcessContainer, UserAccount userAccount, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.ecoSystem = ecoSystem;
      
        
         populateNeedHelpListTable();
         populateWorkRequestTable();
         addInputVerifiers();
         otherHelpPanelFrame.setVisible(false);
     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        
        Color c1 = new Color(255,102,102);
        Color c2 = Color.white;
     
        GradientPaint gp = new GradientPaint(w/4, 0, c2, w/4, h, c1);
        setOpaque( false );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        setOpaque( true );
    }
    
     private void addInputVerifiers() {
          
        InputVerifier stringValidation = new ValidateStrings();
        helpDetailsTxtField.setInputVerifier(stringValidation);
        commentsJTextField.setInputVerifier(stringValidation);
     }
     
    public void populateComboBxHelpType()
    {
      serviceTypeCombo.removeAllItems();
      serviceTypeCombo.addItem("NOW");
      serviceTypeCombo.addItem("Within 24 hrs");
      serviceTypeCombo.addItem("Schedule it accordingly");
      serviceTypeCombo.addItem("Within a week");
    }
    public void populateNeedHelpListTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)helpListJTable.getModel();
        dtm.setRowCount(0);
        
        for(NeedHelp nh : ecoSystem.getHelpList() )
        {
           Object[] rowData = new Object[4];
           rowData[0] = nh;
           rowData[1] = nh.getHelp();
           rowData[2] = nh.getServiceType();
           rowData[3] = nh.getNewHelp()== null ? null : nh.getNewHelp() ;
           
           dtm.addRow(rowData);
        }
    }
    
     public void populateWorkRequestTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)workRequestJTable.getModel();
        dtm.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
        for(WorkRequest workRequest : userAccount.getWorkQueue().getWorkRequestList())
        {
          if(workRequest.getMessage().equalsIgnoreCase("Need Help"))  
          { 
           HelpRequest helpWorkRequest = (HelpRequest)workRequest; 
           Object[] rowData = new Object[5];
           rowData[0] = helpWorkRequest.getRequestId();
           rowData[1] = helpWorkRequest.getNeedHelp().getHelp();
           rowData[2] = dateFormat.format(workRequest.getRequestDate());
           rowData[3] = helpWorkRequest.getReceiver() == null ? null : helpWorkRequest.getReceiver().getPerson().getName();
           rowData[4] = helpWorkRequest.getStatus();
           
           dtm.addRow(rowData);
          }
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        helpListJTable = new javax.swing.JTable();
        createRequestButton = new javax.swing.JButton();
        otherHelpPanelFrame = new javax.swing.JPanel();
        helpDetails = new javax.swing.JLabel();
        serviceType = new javax.swing.JLabel();
        serviceTypeCombo = new javax.swing.JComboBox();
        helpDetailsTxtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        manageEnt4 = new javax.swing.JLabel();
        manageEnt1 = new javax.swing.JLabel();
        manageEnt5 = new javax.swing.JLabel();
        manageEnt2 = new javax.swing.JLabel();
        manageEnt3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        gender1 = new javax.swing.JLabel();
        commentsJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        newHelpRadioBtn = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        helpListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Help Id", "Help Needed", "Help Type", "Help Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(helpListJTable);

        createRequestButton.setText("Create Request");
        createRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRequestButtonActionPerformed(evt);
            }
        });

        helpDetails.setFont(new java.awt.Font("Malayalam MN", 3, 14)); // NOI18N
        helpDetails.setText(" Enter details about the help needed.");

        serviceType.setText("Please indicate urgency");

        serviceTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select Amount", "5$", "10$", "15$", "20$" }));

        jLabel1.setText("Details:");

        javax.swing.GroupLayout otherHelpPanelFrameLayout = new javax.swing.GroupLayout(otherHelpPanelFrame);
        otherHelpPanelFrame.setLayout(otherHelpPanelFrameLayout);
        otherHelpPanelFrameLayout.setHorizontalGroup(
            otherHelpPanelFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherHelpPanelFrameLayout.createSequentialGroup()
                .addGroup(otherHelpPanelFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(otherHelpPanelFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(otherHelpPanelFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(otherHelpPanelFrameLayout.createSequentialGroup()
                                .addComponent(serviceType, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(serviceTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(otherHelpPanelFrameLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(helpDetailsTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(helpDetails))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        otherHelpPanelFrameLayout.setVerticalGroup(
            otherHelpPanelFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherHelpPanelFrameLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(helpDetails)
                .addGap(18, 18, 18)
                .addGroup(otherHelpPanelFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(helpDetailsTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(otherHelpPanelFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serviceType)
                    .addComponent(serviceTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        manageEnt4.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 14)); // NOI18N
        manageEnt4.setText("Select the radio button  ");

        manageEnt1.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 14)); // NOI18N
        manageEnt1.setText("Required Help not in the Table:");

        manageEnt5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        manageEnt5.setText("Our Volunteers");

        manageEnt2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        manageEnt2.setText("Helping Hands Club");

        manageEnt3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        manageEnt3.setText("Help Requests History:");

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Help Recieved", "Requested Date", "Volunteer Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestJTable);

        gender1.setText("Comments:");

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        newHelpRadioBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        newHelpRadioBtn.setText("New Help");
        newHelpRadioBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newHelpRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newHelpRadioBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageEnt5, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(backJButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createRequestButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(gender1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(commentsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12))
                        .addComponent(otherHelpPanelFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(manageEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manageEnt4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newHelpRadioBtn)))
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageEnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(manageEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(manageEnt2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(manageEnt5)
                            .addComponent(manageEnt3))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageEnt1)
                    .addComponent(manageEnt4)
                    .addComponent(newHelpRadioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createRequestButton)
                            .addComponent(backJButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(otherHelpPanelFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(commentsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gender1))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1277, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRequestButtonActionPerformed
        NeedHelp needHelp;

        if(newHelpRadioBtn.isSelected())
        {

            if(helpDetailsTxtField.getText().trim().isEmpty() || serviceTypeCombo.getSelectedIndex() <0)
            {
                JOptionPane.showMessageDialog(this, "Please Enter data in all the fields ", "warning", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            needHelp = ecoSystem.addNeedHelp();
            needHelp.setHelp("Others");
            needHelp.setNewHelp(helpDetailsTxtField.getText());
            needHelp.setServiceType((String)serviceTypeCombo.getSelectedItem());
        }
        else
        {
            int selectedRow = helpListJTable.getSelectedRow();
            if(selectedRow<0)
            {
                JOptionPane.showMessageDialog(this, "Please select a row", "warning", JOptionPane.PLAIN_MESSAGE);
                return;
            }

            needHelp = (NeedHelp)helpListJTable.getValueAt(selectedRow, 0);
        }

        try
        {

            if(commentsJTextField.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Enter comments.", "warning",JOptionPane.WARNING_MESSAGE);
                return;
            }

            String message = commentsJTextField.getText();

            HelpRequest HelpRequest = new HelpRequest();
            HelpRequest.setMessage("Need Help");
            HelpRequest.setSender(userAccount);
            HelpRequest.setStatus("Sent");
            HelpRequest.setNeedHelp(needHelp);
            HelpRequest.setComments(message);
            HelpRequest.setRequestDate(new Date());

            Organization org = null;
            for(network network : ecoSystem.getNetworkList())
            {
                if(network.equals(userAccount.getNetwork()))
                {
                    for(enterprises e : network.getEnterpriseDirectory().getEnterpriseList())
                    {
                        if(e.getEnterpriseType().equals(enterprises.EnterpriseType.School))
                        {

                            for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
                                if (organization instanceof OrgVolunteer){
                                    org = organization;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(HelpRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(HelpRequest);
            }

            JOptionPane.showMessageDialog(null, "Request has been created successfully", "success", JOptionPane.PLAIN_MESSAGE);
            commentsJTextField.setText("");
            helpDetailsTxtField.setText("");
            populateWorkRequestTable();
            if(newHelpRadioBtn.isSelected())
            {
                populateNeedHelpListTable();
                otherHelpPanelFrame.setVisible(false);
            }
            newHelpRadioBtn.setSelected(false);
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, "Unable to send request, Please try again !!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Unable to send request, Please try again !!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_createRequestButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void newHelpRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newHelpRadioBtnActionPerformed
        if(newHelpRadioBtn.isSelected())
        {
            populateComboBxHelpType();
            otherHelpPanelFrame.setVisible(true);
        }
        else
        {
            populateComboBxHelpType();
            otherHelpPanelFrame.setVisible(false);
        }
    }//GEN-LAST:event_newHelpRadioBtnActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField commentsJTextField;
    private javax.swing.JButton createRequestButton;
    private javax.swing.JLabel gender1;
    private javax.swing.JLabel helpDetails;
    private javax.swing.JTextField helpDetailsTxtField;
    private javax.swing.JTable helpListJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel manageEnt1;
    private javax.swing.JLabel manageEnt2;
    private javax.swing.JLabel manageEnt3;
    private javax.swing.JLabel manageEnt4;
    private javax.swing.JLabel manageEnt5;
    private javax.swing.JRadioButton newHelpRadioBtn;
    private javax.swing.JPanel otherHelpPanelFrame;
    private javax.swing.JLabel serviceType;
    private javax.swing.JComboBox serviceTypeCombo;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

                   
}