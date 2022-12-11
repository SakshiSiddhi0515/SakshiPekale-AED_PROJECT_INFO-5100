/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Mayor;
import Model.System.EcoSystem;
import Model.enterprise.enterprises;
import Model.network.network;
import Model.Org.OrgSeeker;
import Model.Org.OrgMayor;
import Model.Org.Organization;
import Model.People.People_help;
import Model.User.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class MayorWorkAreaJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private UserAccount userAccount;
    private OrgMayor mayorOrganization;
    private HashMap<String,Integer> communitydetailsmap;

    /**
     * Creates new form MayorWorkAreaJPanel
     */
    public MayorWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        this.userAccount = userAccount;
        this.mayorOrganization = (OrgMayor)organization;
        
        populateWorkRequestTable();
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
    
    public void populateWorkRequestTable()
    {
        DefaultTableModel model = (DefaultTableModel)communityHealthTable.getModel();
        model.setRowCount(0);
        
        try
        {
        communitydetailsmap = getHelpSeekerData();
        }
        catch(NullPointerException npe)
        {
        npe.printStackTrace();
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return;     
        }
         if(communitydetailsmap.isEmpty() || communitydetailsmap == null)
         {
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return;      
         }
    
         Object[] rowData = new Object[4];
         rowData[0] = communitydetailsmap.get("TotalNoOfSeniorPeople");
         rowData[1] = communitydetailsmap.get("AverageAge");
         rowData[2] = communitydetailsmap.get("SeniorswithheartProblem");
         rowData[3] = communitydetailsmap.get("SeniorswithNoheartProblem");
         
         model.addRow(rowData);
    }
    
    public OrgSeeker getHelpSeekerOrg()
    {
        OrgSeeker helpSeekerOrg = null;
        
        for(network network : ecoSystem.getNetworkList())
        {
         if(network.equals(userAccount.getNetwork()))
         {
          for(enterprises enterprise : network.getEnterpriseDirectory().getEnterpriseList())
          {
            if(enterprise.getEnterpriseType().equals(enterprises.EnterpriseType.Help))
            {
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
            {
             if(organization instanceof OrgSeeker)
             {
              helpSeekerOrg = (OrgSeeker)organization; 
             }
            }
            }
          }
         }
        }
        return helpSeekerOrg;
    }
    
    public HashMap<String,Integer> getHelpSeekerData()
    {
        int seniorCardiacProb = 0;
        int seniorNoCardiacProb = 0;
        int avgAge = 0;
        int seniorsWithSensorDevice = 0;
        int seniorsShareVitalInfo = 0;
        int seniorsSendDataToDoctor = 0;
        int seniorsWithNoSensorDevice = 0;
        
        OrgSeeker helpSeekerOrganization = getHelpSeekerOrg();
        if(helpSeekerOrganization == null)
        {
        JOptionPane.showMessageDialog(null, " Help Seeker Organization does not exist!","warning", JOptionPane.WARNING_MESSAGE);
        return null;     
        }
        if(helpSeekerOrganization.getPersonDirectory().getCustomerLsit().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "No Help Seekers Registered!","warning", JOptionPane.WARNING_MESSAGE);
        return null; 
        }
        int totalSeniors = helpSeekerOrganization.getPersonDirectory().getCustomerLsit().size();
      HashMap<String,Integer> seniorHeartPatientMap = new HashMap<>();
       for(People_help helpSeeker : helpSeekerOrganization.getPersonDirectory().getCustomerLsit())
          {
           if(helpSeeker.isHasCardiacProb())     
           {
            seniorCardiacProb ++;  
           } 
           if(!helpSeeker.isHasCardiacProb())
           {
            seniorNoCardiacProb ++;   
           }
           if(helpSeeker.isHasSensorDevice())
           {
            seniorsWithSensorDevice ++;   
           } 
           if(!helpSeeker.isHasSensorDevice())
           {
            seniorsWithNoSensorDevice++;   
           }
           if(helpSeeker.isSendDataToDoctor())
           {
            seniorsSendDataToDoctor ++;   
           } 
           if(helpSeeker.isShareVitalInfo())
           {
            seniorsShareVitalInfo ++;   
           } 
           avgAge+=helpSeeker.getAge();
          } 
        
               
       seniorHeartPatientMap.put("SeniorswithheartProblem", seniorCardiacProb);
       seniorHeartPatientMap.put("SeniorswithNoheartProblem", seniorNoCardiacProb);
       seniorHeartPatientMap.put("TotalNoOfSeniorPeople", totalSeniors);
       seniorHeartPatientMap.put("AverageAge", avgAge/totalSeniors);
       seniorHeartPatientMap.put("seniorsSendDataToDoctor",seniorsSendDataToDoctor);
       seniorHeartPatientMap.put("seniorsShareVitalInfo",seniorsShareVitalInfo);
       seniorHeartPatientMap.put("seniorsWithSensorDevice",seniorsWithSensorDevice);
       seniorHeartPatientMap.put("seniorsWithNoSensorDevice",seniorsWithNoSensorDevice);
       
       return seniorHeartPatientMap;
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
        jLabel6 = new javax.swing.JLabel();
        viewDetailedRprtMayorBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        communityHealthTable = new javax.swing.JTable();

        jLabel6.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        jLabel6.setText("Mayor Work Area");

        viewDetailedRprtMayorBtn.setText("View Detailed Report");
        viewDetailedRprtMayorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailedRprtMayorBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        jLabel7.setText("Community Health Report:");

        communityHealthTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Total Senior People", "Average age ", "Seniors with Heart problem", "Seniors with no health problems"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(communityHealthTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(viewDetailedRprtMayorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(367, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(viewDetailedRprtMayorBtn)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1169, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewDetailedRprtMayorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailedRprtMayorBtnActionPerformed
        if(communitydetailsmap.isEmpty() || communitydetailsmap == null)
        {
            JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ViewDetailedReportMayorJPanel viewDetailedReportMayorJPanel = new ViewDetailedReportMayorJPanel(userProcessContainer, communitydetailsmap);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewDetailedReportMayorJPanel", viewDetailedReportMayorJPanel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewDetailedRprtMayorBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable communityHealthTable;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewDetailedRprtMayorBtn;
    // End of variables declaration//GEN-END:variables
}
