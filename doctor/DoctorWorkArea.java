/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.doctor;
import Model.common.Validation;
import Model.People.People_help;
import Model.sensor.VitalSign;
import Model.User.UserAccount;
import Model.Work.DataRequest;
import Model.Work.SupervisorRequest;
import Model.Work.WorkRequest;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Sakshi Sasalate
 */


public class DoctorWorkArea extends javax.swing.JPanel {
    
        private JPanel userProcessContainer;
        private UserAccount userAccount;
        private DataRequest sdtdwr;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public DoctorWorkArea(JPanel userProcessContainer, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;

        this.userAccount = userAccount;
        
        populateHelpSeekerComboBx();
        sendMedicationsPanel.setVisible(false);
        
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
    
    public void populateHelpSeekerComboBx()
    {
        helpSeekerComboBx.removeAllItems();
        if(userAccount.getWorkQueue().getWorkRequestList().isEmpty())
        {
          JOptionPane.showMessageDialog(null, "Helpseeker did not choose to send data yet!","warning", JOptionPane.WARNING_MESSAGE);
         return;    
        }
      HashSet<String> hsstateVal = new HashSet<>();  
     for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList())
        {
        if(!request.getMessage().equalsIgnoreCase(SupervisorRequest.REQUEST_APPROVAL))
        {
         String customer = (String)request.getSender().getUserName();
        hsstateVal.add(customer);
        }
        }
       for(String s1 : hsstateVal)
        {
         for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList())
        {
         String userName = (String)request.getSender().getUserName();
       if(userName.equals(s1))
       {
        People_help customer = (People_help)request.getSender().getPerson();
        helpSeekerComboBx.addItem(customer);
       }
       }    
        
        }
      
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        getDataForPatient = new javax.swing.JButton();
        helpSeekerComboBx = new javax.swing.JComboBox();
        getAlertFromHH = new javax.swing.JLabel();
        sendMedicationsPanel = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        currentMedicationsTxtArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        vitalSignTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        newMedicationTxtArea = new javax.swing.JTextArea();
        medications = new javax.swing.JLabel();
        medications1 = new javax.swing.JLabel();
        sendNewMedicationsBtn = new javax.swing.JButton();
        weightTextField = new javax.swing.JTextField();
        weight = new javax.swing.JLabel();
        systollicBPTextField = new javax.swing.JTextField();
        systollicBloodPressure = new javax.swing.JLabel();
        heartRateTextField = new javax.swing.JTextField();
        heartRate = new javax.swing.JLabel();
        respiratoryRateTextField = new javax.swing.JTextField();
        respiratoryRate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        viewDetailsJButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        getDataForPatient.setText("Get Vital Sign Data");
        getDataForPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDataForPatientActionPerformed(evt);
            }
        });

        helpSeekerComboBx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        getAlertFromHH.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        getAlertFromHH.setText("View Patient Medicinal Prescription");

        sendMedicationsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        currentMedicationsTxtArea.setColumns(20);
        currentMedicationsTxtArea.setRows(5);
        jScrollPane2.setViewportView(currentMedicationsTxtArea);

        vitalSignTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date/Time", "Patient Vital Condition"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vitalSignTable);

        newMedicationTxtArea.setColumns(20);
        newMedicationTxtArea.setRows(5);
        jScrollPane3.setViewportView(newMedicationTxtArea);

        medications.setText("Current Medications/Message:");

        medications1.setText("New Medications/Suggestions:");

        sendNewMedicationsBtn.setText("Send");
        sendNewMedicationsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendNewMedicationsBtnActionPerformed(evt);
            }
        });

        weightTextField.setEditable(false);

        weight.setText("Weight (Pounds):");

        systollicBPTextField.setEditable(false);

        systollicBloodPressure.setText("Systollic Blood Pressure:");

        heartRateTextField.setEditable(false);

        heartRate.setText("Heart Rate:");

        respiratoryRateTextField.setEditable(false);

        respiratoryRate.setText("Respiratory Rate:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setText("Prescription");

        viewDetailsJButton.setText("View Details ");
        viewDetailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsJButtonActionPerformed(evt);
            }
        });

        sendMedicationsPanel.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(medications, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(medications1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(sendNewMedicationsBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(weightTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(weight, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(systollicBPTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(systollicBloodPressure, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(heartRateTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(heartRate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(respiratoryRateTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(respiratoryRate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sendMedicationsPanel.setLayer(viewDetailsJButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout sendMedicationsPanelLayout = new javax.swing.GroupLayout(sendMedicationsPanel);
        sendMedicationsPanel.setLayout(sendMedicationsPanelLayout);
        sendMedicationsPanelLayout.setHorizontalGroup(
            sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                        .addComponent(medications1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                        .addComponent(medications)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(viewDetailsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendMedicationsPanelLayout.createSequentialGroup()
                        .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                                .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heartRate)
                                    .addComponent(respiratoryRate)
                                    .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(systollicBloodPressure, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(weight)))
                                .addGap(18, 18, 18)
                                .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(heartRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(systollicBPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(respiratoryRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendMedicationsPanelLayout.createSequentialGroup()
                        .addComponent(sendNewMedicationsBtn)
                        .addGap(159, 159, 159))))
        );
        sendMedicationsPanelLayout.setVerticalGroup(
            sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(respiratoryRate))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(respiratoryRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(viewDetailsJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(heartRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(heartRate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(systollicBPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(systollicBloodPressure))
                        .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(medications))
                            .addGroup(sendMedicationsPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(weight))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendNewMedicationsBtn)))
                .addGap(18, 18, 18)
                .addGroup(sendMedicationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medications1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(getAlertFromHH, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(helpSeekerComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(getDataForPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sendMedicationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(getAlertFromHH)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpSeekerComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getDataForPatient))
                .addGap(18, 18, 18)
                .addComponent(sendMedicationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void getDataForPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getDataForPatientActionPerformed
        if(helpSeekerComboBx.getSelectedIndex()<0)
        {
            JOptionPane.showMessageDialog(null, "Please Select a Helpseeker to view Data!","warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        People_help customer = (People_help)helpSeekerComboBx.getSelectedItem();
        populateVitalSignsJTable(customer);

        for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList())
        {
            if(!(request.getMessage().equalsIgnoreCase(SupervisorRequest.REQUEST_APPROVAL)))
            {
                People_help cust = (People_help)request.getSender().getPerson();
                if(cust.equals(customer))
                {
                    sdtdwr = (DataRequest)request;
                    currentMedicationsTxtArea.setText(sdtdwr.getMedication());
                }
            }
        }

        sendMedicationsPanel.setVisible(true);

    }//GEN-LAST:event_getDataForPatientActionPerformed

    private void sendNewMedicationsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendNewMedicationsBtnActionPerformed

        if(newMedicationTxtArea.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter new Medications","warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(newMedicationTxtArea.getText().length()>500)
        {
            JOptionPane.showMessageDialog(null, "Please enter characters less than 500 in medications Field ","warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try
        {
            if(sdtdwr.getStatus().equalsIgnoreCase("Completed"))
            {

                JOptionPane.showMessageDialog(null, "Request has been processed earlier!", "warning", JOptionPane.WARNING_MESSAGE);
                return;

            }
            String newMedications = newMedicationTxtArea.getText().replaceAll("\n", " ");
            sdtdwr.setNewMedication(newMedications);
            sdtdwr.setReqResult("Doctor Replied");
            sdtdwr.setStatus(SupervisorRequest.REQUEST_COMPLETED);

            JOptionPane.showMessageDialog(null, "New Medications has been sent successfully","success", JOptionPane.PLAIN_MESSAGE);
            newMedicationTxtArea.setText("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Unable to Send Request, Please try later","warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_sendNewMedicationsBtnActionPerformed

    private void viewDetailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsJButtonActionPerformed

        int selectedRow = vitalSignTable.getSelectedRow();
        if(selectedRow >= 0)
        {
            VitalSign vitalSign = (VitalSign)vitalSignTable.getValueAt(selectedRow, 0);
            respiratoryRateTextField.setText(String.valueOf(vitalSign.getRespiratoryRate()));
            heartRateTextField.setText(String.valueOf(vitalSign.getHeartRate()));
            systollicBPTextField.setText(String.valueOf(vitalSign.getSystolicBloodpressure()));
            weightTextField.setText(String.valueOf(vitalSign.getWeightInPounds()));

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Please select a row", "warning", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_viewDetailsJButtonActionPerformed

    public void populateVitalSignsJTable(People_help customer)
    {   
        try
        {
        if(customer.getVitalSignList().isEmpty())
        {
        JOptionPane.showMessageDialog(this, "Please update complete information first", "warning", JOptionPane.WARNING_MESSAGE);
        return;    
        }
        DefaultTableModel defaultTableModel = (DefaultTableModel)vitalSignTable.getModel();
        defaultTableModel.setRowCount(0);
        int age = Validation.calculateAge(customer.getDob());
        
        for(VitalSign vitalSign : customer.getVitalSignList())
        {
        String patientCondition = customer.patientCondition(age, vitalSign);
        Object [] rowData = new Object[2];
        rowData[0] = vitalSign;
        rowData[1] = patientCondition;
       
        defaultTableModel.addRow(rowData);
        }
        }
        catch(NullPointerException npe)
        {
            JOptionPane.showMessageDialog(this, "No records for the person", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea currentMedicationsTxtArea;
    private javax.swing.JLabel getAlertFromHH;
    private javax.swing.JButton getDataForPatient;
    private javax.swing.JLabel heartRate;
    private javax.swing.JTextField heartRateTextField;
    private javax.swing.JComboBox helpSeekerComboBx;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel medications;
    private javax.swing.JLabel medications1;
    private javax.swing.JTextArea newMedicationTxtArea;
    private javax.swing.JLabel respiratoryRate;
    private javax.swing.JTextField respiratoryRateTextField;
    private javax.swing.JLayeredPane sendMedicationsPanel;
    private javax.swing.JButton sendNewMedicationsBtn;
    private javax.swing.JTextField systollicBPTextField;
    private javax.swing.JLabel systollicBloodPressure;
    private javax.swing.JButton viewDetailsJButton;
    private javax.swing.JTable vitalSignTable;
    private javax.swing.JLabel weight;
    private javax.swing.JTextField weightTextField;
    // End of variables declaration//GEN-END:variables
}
