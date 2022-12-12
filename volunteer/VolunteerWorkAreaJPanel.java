/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.volunteer;
import Model.System.EcoSystem;
import Model.enterprise.enterprises;
import Model.Org.Organization;
import Model.Org.OrgVolunteer;
import Model.People.People_volunteer;
import Model.User.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author DELL
 */
public class VolunteerWorkAreaJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private enterprises enterprise;
    private UserAccount userAccount;  
    private OrgVolunteer organization;
    private EcoSystem ecosystem;

    /**
     * Creates new form VolunteerWorkAreaJPanel
     */
    public VolunteerWorkAreaJPanel(JPanel userProcessContainer,enterprises enterprise,UserAccount userAccount,Organization organization,EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.organization = (OrgVolunteer)organization;
        this.ecosystem = ecosystem;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        manageEnt = new javax.swing.JLabel();
        viewPersonalHelpRequestBtn = new javax.swing.JButton();
        manageVolunteerProfileBtn = new javax.swing.JButton();
        viewTestimonialsBtn = new javax.swing.JButton();
        manageEnt1 = new javax.swing.JLabel();
        viewAnonymousReqBtn = new javax.swing.JButton();
        viewVolProfileBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        manageEnt.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt.setText("Volunteer Task Manager ");

        viewPersonalHelpRequestBtn.setText("Personal Request");
        viewPersonalHelpRequestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPersonalHelpRequestBtnActionPerformed(evt);
            }
        });

        manageVolunteerProfileBtn.setText("Update Profile ");
        manageVolunteerProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVolunteerProfileBtnActionPerformed(evt);
            }
        });

        viewTestimonialsBtn.setText("Feedbacks");
        viewTestimonialsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTestimonialsBtnActionPerformed(evt);
            }
        });

        manageEnt1.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt1.setText("Helping Hands Clubs");

        viewAnonymousReqBtn.setText("Arbitary Request");
        viewAnonymousReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAnonymousReqBtnActionPerformed(evt);
            }
        });

        viewVolProfileBtn.setText("View Profile");
        viewVolProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewVolProfileBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(manageEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(manageEnt)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(manageVolunteerProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(viewPersonalHelpRequestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(viewTestimonialsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(viewVolProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(viewAnonymousReqBtn)))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(manageEnt1)
                .addGap(193, 193, 193)
                .addComponent(manageEnt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageVolunteerProfileBtn)
                    .addComponent(viewPersonalHelpRequestBtn)
                    .addComponent(viewTestimonialsBtn)
                    .addComponent(viewVolProfileBtn)
                    .addComponent(viewAnonymousReqBtn))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1165, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewPersonalHelpRequestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPersonalHelpRequestBtnActionPerformed
        if(userAccount.getWorkQueue().getWorkRequestList().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No Help Requests to display as of now! ","warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ViewPersonalHelpRequestsJPanel viewHelpRequestsJPanel = new ViewPersonalHelpRequestsJPanel(userProcessContainer, userAccount, enterprise.getOrganizationDirectory());
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewHelpRequestsJPanel", viewHelpRequestsJPanel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewPersonalHelpRequestBtnActionPerformed

    private void manageVolunteerProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVolunteerProfileBtnActionPerformed
        UpdateVolunteerProfile updateVolunteerProfile = new UpdateVolunteerProfile(userProcessContainer, userAccount, enterprise.getUserAccountDirectory());
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("UpdateVolunteerProfile", updateVolunteerProfile);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageVolunteerProfileBtnActionPerformed

    private void viewTestimonialsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTestimonialsBtnActionPerformed
        People_volunteer volunteer = (People_volunteer)userAccount.getPerson();
        if(volunteer.getTestimonialList().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No Testimonials to display as of now! ","warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ViewTestimonialJPanel viewTestimonialJPanel = new ViewTestimonialJPanel(userProcessContainer, userAccount);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewTestimonialJPanel", viewTestimonialJPanel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewTestimonialsBtnActionPerformed

    private void viewAnonymousReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAnonymousReqBtnActionPerformed
        if(organization.getWorkQueue().getWorkRequestList().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No Help Requests to display as of now! ","warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ViewAnonymousRequestJPanel viewAnonymousRequestJPanel = new ViewAnonymousRequestJPanel(userProcessContainer, userAccount,  organization, enterprise.getOrganizationDirectory());
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewAnonymousRequestJPanel", viewAnonymousRequestJPanel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAnonymousReqBtnActionPerformed

    private void viewVolProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewVolProfileBtnActionPerformed
        ViewVolunteerProfile viewVolunteerProfile = new ViewVolunteerProfile(userProcessContainer, userAccount);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewVolunteerProfile", viewVolunteerProfile);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewVolProfileBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel manageEnt;
    private javax.swing.JLabel manageEnt1;
    private javax.swing.JButton manageVolunteerProfileBtn;
    private javax.swing.JButton viewAnonymousReqBtn;
    private javax.swing.JButton viewPersonalHelpRequestBtn;
    private javax.swing.JButton viewTestimonialsBtn;
    private javax.swing.JButton viewVolProfileBtn;
    // End of variables declaration//GEN-END:variables
}