/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Mayor;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author DELL
 */
public class ViewDetailedReportMayorJPanel extends javax.swing.JPanel {
    private HashMap<String,Integer> communitydetailsmap;
    private JPanel userProcessContainer;
    /**
     * Creates new form ViewDetailedReportMayorJPanel
     */
    public ViewDetailedReportMayorJPanel(JPanel userProcessContainer,HashMap<String,Integer> communitydetailsmap) {
        initComponents();
        this.communitydetailsmap = communitydetailsmap;
        this.userProcessContainer = userProcessContainer;
        
        populateDetailsForCommunity();
        populatePieDataChartPanel();
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
    
    public void populateDetailsForCommunity()
    {
         try
        {
        seniorsWithHeartPrbField.setText(String.valueOf(communitydetailsmap.get("SeniorswithheartProblem")));
       senWithNoHeartProbField.setText(String.valueOf(communitydetailsmap.get("SeniorswithNoheartProblem")));
       totSeniorPPLField.setText(String.valueOf(communitydetailsmap.get("TotalNoOfSeniorPeople")));
       senSendDataToDocField.setText(String.valueOf(communitydetailsmap.get("seniorsSendDataToDoctor")));
       senShareInfoField.setText(String.valueOf(communitydetailsmap.get("seniorsShareVitalInfo")));
       senNoSensorDevField.setText(String.valueOf(communitydetailsmap.get("seniorsWithNoSensorDevice")));
       senWithSensorField.setText(String.valueOf(communitydetailsmap.get("seniorsWithSensorDevice")));
        }
       catch(NullPointerException npe)
       {
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return; 
       }  
    }
    
    public void populatePieDataChartPanel()
    {
        pieChartDetailedReportPanel.removeAll();
        
        try
        {
         DefaultPieDataset dataSet = new DefaultPieDataset(); 
         dataSet.setValue("SeniorswithheartProblem",communitydetailsmap.get("SeniorswithheartProblem"));
         dataSet.setValue("SeniorswithNoheartProblem", communitydetailsmap.get("SeniorswithNoheartProblem") );
         dataSet.setValue("TotalNoOfSeniorPeople", communitydetailsmap.get("TotalNoOfSeniorPeople"));
         dataSet.setValue("seniorsSendDataToDoctor",communitydetailsmap.get("seniorsSendDataToDoctor"));
         dataSet.setValue("seniorsShareVitalInfo",  communitydetailsmap.get("seniorsShareVitalInfo"));
         dataSet.setValue("seniorsWithSensorDevice", communitydetailsmap.get("seniorsWithSensorDevice"));
         dataSet.setValue("seniorsWithNoSensorDevice", communitydetailsmap.get("seniorsWithNoSensorDevice"));
     
         JFreeChart  chart = ChartFactory.createPieChart3D("Pie Chart ", dataSet, true, true, Locale.ENGLISH);
          chart.setBackgroundPaint(Color.WHITE);
          chart.getTitle().setPaint(Color.BLUE);
            ChartPanel chartpanel = new ChartPanel(chart);
          chartpanel.setDomainZoomable(true);
          chartpanel.setBackground(Color.WHITE);
        pieChartDetailedReportPanel.setLayout(new BorderLayout());
        pieChartDetailedReportPanel.add(chartpanel, BorderLayout.EAST);
        pieChartDetailedReportPanel.revalidate();
        pieChartDetailedReportPanel.setVisible(true);
       }
       
       catch(NullPointerException npe)
       {
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return; 
       }
    }
    
    public void populateBarDataChartPanel()
    {
        if(communitydetailsmap==null || communitydetailsmap.isEmpty())
        {
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return;    
        }
        try
        {
            DefaultCategoryDataset dataSet = new DefaultCategoryDataset(); 
        if(communitydetailsmap.get("SeniorswithheartProblem")!=0)
        {
         dataSet.setValue(communitydetailsmap.get("SeniorswithheartProblem"),"Values","SeniorswithheartProblem");
        }
        if(communitydetailsmap.get("SeniorswithNoheartProblem")!=0)
        {
         dataSet.setValue(communitydetailsmap.get("SeniorswithNoheartProblem"),"Values","SeniorswithNoheartProblem" );
        }
        if(communitydetailsmap.get("TotalNoOfSeniorPeople")!=0)
        {
         dataSet.setValue(communitydetailsmap.get("TotalNoOfSeniorPeople"),"Values","TotalNoOfSeniorPeople" );
        }
        if(communitydetailsmap.get("seniorsSendDataToDoctor")!=0)
        {
         dataSet.setValue(communitydetailsmap.get("seniorsSendDataToDoctor"),"Values","seniorsSendDataToDoctor");
        }
        if(communitydetailsmap.get("seniorsShareVitalInfo")!=0)
        {
        dataSet.setValue(communitydetailsmap.get("seniorsShareVitalInfo"),"Values","seniorsShareVitalInfo"  );
        }
        if(communitydetailsmap.get("seniorsWithSensorDevice")!=0)
        {
        dataSet.setValue(communitydetailsmap.get("seniorsWithSensorDevice"),"Values","seniorsWithSensorDevice" );
        }
        if(communitydetailsmap.get("seniorsWithNoSensorDevice")!=0)
        {
        dataSet.setValue(communitydetailsmap.get("seniorsWithNoSensorDevice"),"Values","seniorsWithNoSensorDevice");
        }
        JFreeChart barchart = ChartFactory.createBarChart(" Bar Chart" ," Values " ,"Community Info", dataSet,PlotOrientation.VERTICAL, false, true, false);
             barchart.setBackgroundPaint(Color.WHITE);
             barchart.getTitle().setPaint(Color.BLUE);
             CategoryPlot plot = barchart.getCategoryPlot();
             plot.setBackgroundPaint(Color.CYAN);
             
            ChartFrame frame = new ChartFrame("Bar Chart  ", barchart);
            frame.setVisible(true);
            frame.setSize(450,350);
       }
       
       catch(NullPointerException npe)
       {
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return; 
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
        manageEnt1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        senSendDataToDocField = new javax.swing.JTextField();
        sendToDoc = new javax.swing.JLabel();
        seniorsWithHeartPrbField = new javax.swing.JTextField();
        totTransReq1 = new javax.swing.JLabel();
        totalSeniorPpl = new javax.swing.JLabel();
        senShareInfoField = new javax.swing.JTextField();
        noheartPrblm = new javax.swing.JLabel();
        hasHeartPblm = new javax.swing.JLabel();
        senWithNoHeartProbField = new javax.swing.JTextField();
        totSeniorPPLField = new javax.swing.JTextField();
        hasNoSensor = new javax.swing.JLabel();
        senWithSensorField = new javax.swing.JTextField();
        hasSensor = new javax.swing.JLabel();
        senNoSensorDevField = new javax.swing.JTextField();
        pieChartDetailedReportPanel = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();
        barchartBtn = new javax.swing.JButton();
        manageEnt2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        manageEnt1.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        manageEnt1.setText("View Detailed Report");

        jLayeredPane1.setBackground(new java.awt.Color(255, 204, 204));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        senSendDataToDocField.setEditable(false);
        senSendDataToDocField.setBackground(new java.awt.Color(153, 204, 0));

        sendToDoc.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        sendToDoc.setText("Total No of people who send data to doctor");

        seniorsWithHeartPrbField.setEditable(false);
        seniorsWithHeartPrbField.setBackground(new java.awt.Color(153, 204, 0));

        totTransReq1.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        totTransReq1.setText("Total No of people who share Vital Info");

        totalSeniorPpl.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        totalSeniorPpl.setText("Total No of  People who are in need of Help");

        senShareInfoField.setEditable(false);
        senShareInfoField.setBackground(new java.awt.Color(153, 204, 0));

        noheartPrblm.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        noheartPrblm.setText("No of  people with no heart problem ");

        hasHeartPblm.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        hasHeartPblm.setText("No of people with heart problem");

        senWithNoHeartProbField.setEditable(false);
        senWithNoHeartProbField.setBackground(new java.awt.Color(153, 204, 0));

        totSeniorPPLField.setEditable(false);
        totSeniorPPLField.setBackground(new java.awt.Color(153, 204, 0));

        hasNoSensor.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        hasNoSensor.setText("Total No of people who dont have sensor device");

        senWithSensorField.setEditable(false);
        senWithSensorField.setBackground(new java.awt.Color(153, 204, 0));

        hasSensor.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        hasSensor.setText("Total No of people who has sensor device");

        senNoSensorDevField.setEditable(false);
        senNoSensorDevField.setBackground(new java.awt.Color(153, 204, 0));

        jLayeredPane1.setLayer(senSendDataToDocField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(sendToDoc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(seniorsWithHeartPrbField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(totTransReq1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(totalSeniorPpl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(senShareInfoField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(noheartPrblm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(hasHeartPblm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(senWithNoHeartProbField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(totSeniorPPLField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(hasNoSensor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(senWithSensorField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(hasSensor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(senNoSensorDevField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hasNoSensor)
                    .addComponent(totalSeniorPpl, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hasHeartPblm, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(hasSensor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(noheartPrblm, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(totTransReq1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendToDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senNoSensorDevField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senShareInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senWithSensorField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senWithNoHeartProbField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seniorsWithHeartPrbField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totSeniorPPLField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senSendDataToDocField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalSeniorPpl)
                    .addComponent(totSeniorPPLField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hasHeartPblm)
                    .addComponent(seniorsWithHeartPrbField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noheartPrblm)
                    .addComponent(senWithNoHeartProbField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hasSensor)
                    .addComponent(senWithSensorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totTransReq1)
                    .addComponent(senShareInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hasNoSensor)
                    .addComponent(senNoSensorDevField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendToDoc)
                    .addComponent(senSendDataToDocField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pieChartDetailedReportPanelLayout = new javax.swing.GroupLayout(pieChartDetailedReportPanel);
        pieChartDetailedReportPanel.setLayout(pieChartDetailedReportPanelLayout);
        pieChartDetailedReportPanelLayout.setHorizontalGroup(
            pieChartDetailedReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pieChartDetailedReportPanelLayout.setVerticalGroup(
            pieChartDetailedReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        barchartBtn.setText("View Bar Chart");
        barchartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barchartBtnActionPerformed(evt);
            }
        });

        manageEnt2.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        manageEnt2.setText("Helping Hands Lead Work Area");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(367, 367, 367)
                                .addComponent(manageEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(backJButton)
                                .addGap(49, 49, 49)
                                .addComponent(barchartBtn)))
                        .addContainerGap(415, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pieChartDetailedReportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(manageEnt2)
                        .addGap(40, 40, 40)
                        .addComponent(pieChartDetailedReportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(manageEnt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton)
                    .addComponent(barchartBtn))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1163, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void barchartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barchartBtnActionPerformed
        populateBarDataChartPanel();
    }//GEN-LAST:event_barchartBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton barchartBtn;
    private javax.swing.JLabel hasHeartPblm;
    private javax.swing.JLabel hasNoSensor;
    private javax.swing.JLabel hasSensor;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel manageEnt1;
    private javax.swing.JLabel manageEnt2;
    private javax.swing.JLabel noheartPrblm;
    private javax.swing.JPanel pieChartDetailedReportPanel;
    private javax.swing.JTextField senNoSensorDevField;
    private javax.swing.JTextField senSendDataToDocField;
    private javax.swing.JTextField senShareInfoField;
    private javax.swing.JTextField senWithNoHeartProbField;
    private javax.swing.JTextField senWithSensorField;
    private javax.swing.JLabel sendToDoc;
    private javax.swing.JTextField seniorsWithHeartPrbField;
    private javax.swing.JTextField totSeniorPPLField;
    private javax.swing.JLabel totTransReq1;
    private javax.swing.JLabel totalSeniorPpl;
    // End of variables declaration//GEN-END:variables
}
