/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.helpSeeker;

import business.EcoSystem;
import business.common.Validation;
import business.enterprisepkg.Enterprise;
import business.networkpkg.Network;
import business.organizationpkg.VolunteerOrganization;
import business.personpkg.Volunteer;
import business.userAccountpkg.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;
import userInterface.volunteer.ViewVolunteerProfile;
/**
 *
 * @author Sakshi Sasalate
 */
public class SearchForVolunteerJPanel extends javax.swing.JPanel implements JMapViewerEventListener{
    
    private JPanel userProcessContainer;
    private UserAccount userAccount; 
    private EcoSystem ecoSystem;
    private VolunteerOrganization volOrg;
    
    private final JLabel zoomLabel;
    private final JLabel zoomValue;

    private final JLabel mperpLabelName;
    private final JLabel mperpLabelValue;
   
    /**
     * Creates new form SearchForVolunteer
     */
    public SearchForVolunteerJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.ecoSystem = ecoSystem;
       
        populateNetworkComboBox();
        setBackground(new Color(182,201,233));
         
       
        mperpLabelName = new JLabel("Meters/Pixels: ");
        mperpLabelValue = new JLabel(String.format("%s", jMapViewerVolunteer.getMeterPerPixel()));

        zoomLabel = new JLabel("Zoom: ");
        zoomValue = new JLabel(String.format("%s", jMapViewerVolunteer.getZoom()));
        
        populateMApToViewVolunteers();
        zoomValue.setVisible(true);
        zoomLabel.setVisible(true);
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
    
    public void populateNetworkComboBox()
    {
        networkListComboBox.removeAllItems();
        for(Network network: ecoSystem.getNetworkList())
        {
           networkListComboBox.addItem(network);
        }
    }

    
    public void populateMApToViewVolunteers()
    {
     jMapViewerVolunteer.repaint();
     jMapViewerVolunteer.revalidate();
        
     jInternalFrame1.setMaximizable(true);
     jInternalFrame1.setResizable(true);
     jMapViewerVolunteer.addJMVListener(this);
     jMapViewerVolunteer.setZoom(12);
     
    List<Coordinate> points = new ArrayList<>();
    ICoordinate iCoordinate = new Coordinate(42.2875968, -71.0794968);
       jMapViewerVolunteer.setDisplayPosition(iCoordinate,11);
         Coordinate coordinate = null;
         MapMarkerDot markerDot;
        double lat;
        double longt;
        boolean flag = false;
        Random rand = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        double randomNo = 0.010010; 
      if(volOrg!= null && !volOrg.getUserAccountDirectory().getUserAccountList().isEmpty()) 
      {
       for(UserAccount volunteerAccnt : volOrg.getUserAccountDirectory().getUserAccountList())
       {
        if(volunteerAccnt.isEnabled())
        {
        Volunteer volunteer = (Volunteer)volunteerAccnt.getPerson();    
          
           String la = volunteer.getLatitiude();
            String lo = volunteer.getLongitude();
       
            if(la!=null &&lo!=null)
            {
           double rd = (Math.random())/(Math.pow(10, 3));     
           randomNo = Double.parseDouble(decimalFormat.format(rd));
            lat = Double.parseDouble(la) - randomNo;
            longt = Double.parseDouble(lo)-randomNo;
            coordinate = new Coordinate(lat, longt);
            points.add(coordinate);
            markerDot = new MapMarkerDot(volunteer.getName(), coordinate);
            Style style = markerDot.getStyle();
            style.setBackColor(Color.CYAN);
            style.setColor(Color.RED);
            style.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            
            markerDot.setStyle(style);
           
            jMapViewerVolunteer.addMapMarker(markerDot);
            flag = true;
            }
            
        }
       }
      }
       if(flag)
       {
        jMapViewerVolunteer.addMapPolygon(new MapPolygonImpl(points));
  
        jMapViewerVolunteer.setDisplayToFitMapPolygons();
        
        jMapViewerVolunteer.setDisplayToFitMapMarkers();  
        jMapViewerVolunteer.setTileGridVisible(true);
        jMapViewerVolunteer.setZoom(12);
       }
    }
    
    public void populateVolunteerListTable(Network network)
    {
       
        DefaultTableModel model = (DefaultTableModel)volunteerListTable.getModel();
        model.setRowCount(0); 
        try
        {
        volOrg = (VolunteerOrganization)Validation.getVolunteerOrganizationInNw(ecoSystem, network);
        }
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(this, "Volunteer Organization has not been created yet!", "warning",JOptionPane.WARNING_MESSAGE);
          return;   
        }
        if(volOrg.getPersonDirectory().getVolunteerList().isEmpty())
        {
        JOptionPane.showMessageDialog(this, "No Volunteers to display as of now", "warning",JOptionPane.WARNING_MESSAGE);
          return;    
        }

     for(UserAccount volunteerAccnt : volOrg.getUserAccountDirectory().getUserAccountList())
       {
        if(volunteerAccnt.isEnabled())
        {
        Volunteer volunteer = (Volunteer)volunteerAccnt.getPerson();    
        if(volunteerAccnt.getNetwork().getCity().equals(network.getCity()))
        {
           Object[] row = new Object[5];
            row[0] = volunteer.getVolunteerId();
            row[1] = volunteer;
            row[2] = volunteer.getGender();
            row[3] = volunteer.getTown();
            row[4] = volunteerAccnt;
            model.addRow(row);   
        }
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
        networkListComboBox = new javax.swing.JComboBox();
        manageEnt1 = new javax.swing.JLabel();
        manageEnt2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        volunteerListTable = new javax.swing.JTable();
        ViewVolunteerProfileBtn = new javax.swing.JButton();
        requestVolunteerHelpbtn = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMapViewerVolunteer = new org.openstreetmap.gui.jmapviewer.JMapViewer();
        backJButton1 = new javax.swing.JButton();

        networkListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkListComboBoxActionPerformed(evt);
            }
        });

        manageEnt1.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt1.setText("Search For Volunteer");

        manageEnt2.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt2.setText("Heart Help");

        jLabel1.setText("Network:");

        volunteerListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Volunteer Id", "Name", "Gender", "City", "UserName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(volunteerListTable);

        ViewVolunteerProfileBtn.setText("View Volunteer Profile");
        ViewVolunteerProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewVolunteerProfileBtnActionPerformed(evt);
            }
        });

        requestVolunteerHelpbtn.setText("Request Volunteer For Help");
        requestVolunteerHelpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestVolunteerHelpbtnActionPerformed(evt);
            }
        });

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMapViewerVolunteer, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMapViewerVolunteer, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(manageEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(networkListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(manageEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(requestVolunteerHelpbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ViewVolunteerProfileBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(backJButton1)))
                .addGap(27, 27, 27)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(manageEnt2)
                .addGap(18, 18, 18)
                .addComponent(manageEnt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestVolunteerHelpbtn)
                    .addComponent(ViewVolunteerProfileBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backJButton1)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1172, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void networkListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkListComboBoxActionPerformed
        if(networkListComboBox.getSelectedIndex()>=0)
        {
            Network network = (Network)networkListComboBox.getSelectedItem();

            populateVolunteerListTable(network);
            populateMApToViewVolunteers();
        }

    }//GEN-LAST:event_networkListComboBoxActionPerformed

    private void ViewVolunteerProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewVolunteerProfileBtnActionPerformed

        int selectedRow = volunteerListTable.getSelectedRow();
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(this, "Please select a volunteer", "warning", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        UserAccount volUserAccount = (UserAccount)volunteerListTable.getValueAt(selectedRow, 4);

        ViewVolunteerProfile viewVolunteerProfile = new ViewVolunteerProfile(userProcessContainer, volUserAccount);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewVolunteerProfile", viewVolunteerProfile);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_ViewVolunteerProfileBtnActionPerformed

    private void requestVolunteerHelpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestVolunteerHelpbtnActionPerformed

        int selectedRow = volunteerListTable.getSelectedRow();
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(this, "Please select a volunteer", "warning", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        Volunteer volunteer = (Volunteer)volunteerListTable.getValueAt(selectedRow, 1);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestVolunteerForHelp", new RequestVolunteerForHelp(userProcessContainer, userAccount, volunteer, volOrg, ecoSystem));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_requestVolunteerHelpbtnActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewVolunteerProfileBtn;
    private javax.swing.JButton backJButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private org.openstreetmap.gui.jmapviewer.JMapViewer jMapViewerVolunteer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageEnt1;
    private javax.swing.JLabel manageEnt2;
    private javax.swing.JComboBox networkListComboBox;
    private javax.swing.JButton requestVolunteerHelpbtn;
    private javax.swing.JTable volunteerListTable;
    // End of variables declaration//GEN-END:variables
}
 @Override
    public void processCommand(JMVCommandEvent command) {
    if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM) ||
                command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
            updateZoomParameters();
        }   
    }
    
     private void updateZoomParameters() {
        if (mperpLabelValue != null)
            mperpLabelValue.setText(String.format("%s", jMapViewerVolunteer.getMeterPerPixel()));
        if (zoomValue != null)
            zoomValue.setText(String.format("%s", jMapViewerVolunteer.getZoom()));
    }
}
