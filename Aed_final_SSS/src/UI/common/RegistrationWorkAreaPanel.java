/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.common;
import business.EcoSystem;
import business.common.SendEmailAndTextMessage;
import business.common.ValidateDateOfBirth;
import business.common.ValidateEmailTextField;
import business.common.ValidateNumbers;
import business.common.ValidatePasswords;
import business.common.ValidatePhoneNumber;
import business.common.ValidateStrings;
import business.common.Validation;
import business.enterprisepkg.Enterprise;
import business.enterprisepkg.HeartHelpEnterprise;
import business.enterprisepkg.HospitalEnterprise;
import business.enterprisepkg.SchoolEnterprise;
import business.networkpkg.Network;
import business.organizationpkg.DoctorOrganization;
import business.organizationpkg.HelpSeekerOrganization;
import business.organizationpkg.Organization;
import business.organizationpkg.SupervisorOrganization;
import business.organizationpkg.VolunteerOrganization;
import business.personpkg.HelpSeeker;
import business.personpkg.Person;
import business.personpkg.PersonDirectory;
import business.personpkg.Volunteer;
import business.rolepkg.DoctorRole;
import business.rolepkg.HelpSeekerRole;
import business.rolepkg.VolunteerRole;
import business.userAccountpkg.UserAccount;
import business.workQueuepkg.SupervisorWorkRequest;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class RegistrationWorkAreaPanel extends javax.swing.JPanel {
  private JPanel userProcessContainer;
    private PersonDirectory personDirectory;
    private EcoSystem ecoSystem; 
    private Enterprise enterprise;
    private Organization organization;
    /**
     * Creates new form RegistrationWorkAreaPanel
     */
    public RegistrationWorkAreaPanel(JPanel userProcessContainer, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
       this.ecoSystem = ecoSystem;
       
       helpSeekerPane.setVisible(false);
         
        addInputVerifiers();
        
        populateCountryComboBox();
        volNetworkCombo.setVisible(false);
        volNetwork.setVisible(false);
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
    
      private void addInputVerifiers() {
          
        InputVerifier stringValidation = new ValidateStrings();
        firstNameField.setInputVerifier(stringValidation);
        lastNameField.setInputVerifier(stringValidation);
        addressField1.setInputVerifier(stringValidation);
        addressField2.setInputVerifier(stringValidation);
        townField.setInputVerifier(stringValidation);
        occupationField.setInputVerifier(stringValidation);
        addressField1.setInputVerifier(stringValidation);
        addressField2.setInputVerifier(stringValidation);
        userNameJTxtField.setInputVerifier(stringValidation);
        
        
        InputVerifier passwordValidation = new ValidatePasswords();
        passwordField.setInputVerifier(passwordValidation);
        confirmPasswordField.setInputVerifier(passwordValidation);
        
        InputVerifier dobValidtion = new ValidateDateOfBirth();
        DobField.setInputVerifier(dobValidtion);
        
        InputVerifier numberValidation = new ValidateNumbers();
        zipCodeField.setInputVerifier(numberValidation);
        
        InputVerifier emailValidtion = new ValidateEmailTextField();
        emailIDField.setInputVerifier(emailValidtion);
     
         InputVerifier phnumberValidation = new ValidatePhoneNumber();
        phoneNumberField.setInputVerifier(phnumberValidation);
      
    }
    
    private void populateCountryComboBox(){
        countryComboBox.removeAllItems();
         if(ecoSystem.getNetworkList().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Networks does not exist! Please create networks.");  
         return;        
        }
        countryComboBox.addItem("Please select a country");
        String networkVal = "";   
        HashSet<String> hs = new HashSet();
           
        for(Network network : ecoSystem.getNetworkList()){
           if(!network.getCountry().equals(networkVal))
           {
               hs.add(network.getCountry());
           }
        }
        for(String s : hs)
        {
         countryComboBox.addItem(s);
        }
        }
    
         private void populateNetworkComboBox()
         {
        
        helpSeekerNetworkCombo.removeAllItems();
         if(ecoSystem.getNetworkList().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Networks does not exist! Sorry for inconvenience.");  
         return;        
        }
        helpSeekerNetworkCombo.addItem("Please Choose a Network");
           
        for(Network network : ecoSystem.getNetworkList()){
             helpSeekerNetworkCombo.addItem(network);
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
        addressField2 = new javax.swing.JTextField();
        DobField = new javax.swing.JFormattedTextField();
        addressField1 = new javax.swing.JTextField();
        emailID1 = new javax.swing.JLabel();
        town = new javax.swing.JLabel();
        emailIDField1 = new javax.swing.JTextField();
        townField = new javax.swing.JTextField();
        zipCode = new javax.swing.JLabel();
        zipCodeField = new javax.swing.JTextField();
        occupation = new javax.swing.JLabel();
        occupationField = new javax.swing.JTextField();
        emailID = new javax.swing.JLabel();
        emailIDField = new javax.swing.JTextField();
        firstName = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        createProfileButton = new javax.swing.JButton();
        LastName = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        address2 = new javax.swing.JLabel();
        dateOfBirth = new javax.swing.JLabel();
        address1 = new javax.swing.JLabel();
        isHelpSeeker = new javax.swing.JRadioButton();
        isVolunteer = new javax.swing.JRadioButton();
        helpSeekerPane = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        userNameJTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        helpSeekerNw = new javax.swing.JLabel();
        helpSeekerNetworkCombo = new javax.swing.JComboBox();
        manageEnt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        stateComboBox = new javax.swing.JComboBox();
        isDoctorRadioBtn = new javax.swing.JRadioButton();
        volNetwork = new javax.swing.JLabel();
        volNetworkCombo = new javax.swing.JComboBox();

        emailID1.setText("Confirm Email Address:");

        town.setText("Town/City: ");

        zipCode.setText("Zip Code:");

        occupation.setText("Occupation:");

        emailID.setText("Email Address:");

        emailIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailIDFieldActionPerformed(evt);
            }
        });

        firstName.setText("First Name:");

        phoneNumber.setText("Phone Number:");

        phoneNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberFieldActionPerformed(evt);
            }
        });

        createProfileButton.setText("Register");
        createProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProfileButtonActionPerformed(evt);
            }
        });

        LastName.setText("Last Name:");

        address2.setText("Address Line2 : ");

        dateOfBirth.setText("Date Of Birth (MM/DD/YYYY):");

        address1.setText("Address Line1 : ");

        isHelpSeeker.setText("I Need Help");
        isHelpSeeker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isHelpSeekerActionPerformed(evt);
            }
        });

        isVolunteer.setText("I am a Volunteer");
        isVolunteer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isVolunteerActionPerformed(evt);
            }
        });

        helpSeekerPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        jLabel7.setText("Create User Account:");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        userNameJTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameJTxtFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Password");

        jLabel5.setText("Confirm Password");

        helpSeekerNw.setText("Please Select the Closest City");

        helpSeekerNetworkCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpSeekerNetworkComboActionPerformed(evt);
            }
        });

        helpSeekerPane.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(passwordField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(userNameJTxtField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(confirmPasswordField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(helpSeekerNw, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(helpSeekerNetworkCombo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout helpSeekerPaneLayout = new javax.swing.GroupLayout(helpSeekerPane);
        helpSeekerPane.setLayout(helpSeekerPaneLayout);
        helpSeekerPaneLayout.setHorizontalGroup(
            helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, helpSeekerPaneLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                        .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(helpSeekerNw, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(35, 35, 35)
                        .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameJTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(helpSeekerNetworkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        helpSeekerPaneLayout.setVerticalGroup(
            helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userNameJTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpSeekerNw)
                    .addComponent(helpSeekerNetworkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        manageEnt.setFont(new java.awt.Font("Malayalam MN", 3, 24)); // NOI18N
        manageEnt.setText("Welcome to Heart Help");

        jLabel1.setText("Gender:");

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose gender", "Female", "Male", "Transgender", "Unknown" }));
        genderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Country:");

        countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("State:");

        stateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboBoxActionPerformed(evt);
            }
        });

        isDoctorRadioBtn.setText("I am a Doctor");
        isDoctorRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isDoctorRadioBtnActionPerformed(evt);
            }
        });

        volNetwork.setText("Please Select the Closest City");

        volNetworkCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volNetworkComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(145, 145, 145)
                            .addComponent(isHelpSeeker)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(isVolunteer)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(isDoctorRadioBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 353, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lastNameField)
                                        .addComponent(DobField)
                                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailIDField)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(occupationField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(volNetworkCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailIDField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(zipCodeField)
                                            .addComponent(townField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(addressField2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(addressField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(occupation)
                                .addComponent(emailID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailID1)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(volNetwork)
                                    .addGap(212, 212, 212))
                                .addComponent(zipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(address2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(address1)
                                        .addComponent(town))
                                    .addGap(288, 288, 288))
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateOfBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(phoneNumber))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(228, 228, 228))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(helpSeekerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(createProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(431, 431, 431))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(manageEnt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isDoctorRadioBtn)
                    .addComponent(isVolunteer)
                    .addComponent(isHelpSeeker))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(phoneNumber)
                                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(LastName)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dateOfBirth)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(helpSeekerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstName))
                        .addGap(10, 10, 10)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address1))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(townField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(town))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zipCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(occupationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(occupation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailIDField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailID1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(volNetworkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(volNetwork))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(createProfileButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emailIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailIDFieldActionPerformed

    private void phoneNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberFieldActionPerformed

    private void createProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProfileButtonActionPerformed

        try
        {
            if(countryComboBox.getSelectedIndex()<1 || stateComboBox.getSelectedIndex()<1)
            {
                JOptionPane.showMessageDialog(null, "Please Enter valid data for country and state ","warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(genderComboBox.getSelectedIndex()<1 )
            {
                JOptionPane.showMessageDialog(null, "Please Enter valid gender ","warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Date dateOfBirthVal = new SimpleDateFormat("MM/dd/yyyy").parse(DobField.getText()) ;
            // Calculate age using dob
            int age = Validation.calculateAge(dateOfBirthVal);

            String phoneNumber = phoneNumberField.getText();
            String firstName =   firstNameField.getText();
            String lastName = lastNameField.getText();
            String address1 = addressField1.getText();
            String address2 = addressField2.getText();
            String town = townField.getText();
            String zipCode = zipCodeField.getText();
            String emailId = emailIDField.getText();
            String confirmEmail = emailIDField1.getText();
            String occupation = occupationField.getText();
            String gender = (String)genderComboBox.getSelectedItem();
            String country = (String)countryComboBox.getSelectedItem();
            String state = (String)stateComboBox.getSelectedItem();

            if(firstName != null && !firstName.isEmpty() &&
                lastName!= null && !lastName.isEmpty() &&
                address1!=null && !address1.isEmpty() &&
                address2!=null && !address2.isEmpty() &&
                town!=null && !town.isEmpty() &&
                occupation!=null && !occupation.isEmpty() &&
                emailId!=null && !emailId.isEmpty() &&
                confirmEmail!=null && !confirmEmail.isEmpty() &&
                zipCode != null && !zipCode.isEmpty() &&
                gender!=null && !gender.isEmpty() && age > 0 && !phoneNumber.isEmpty()
                &&  country!=null && !country.isEmpty()
                &&  state!=null && !state.isEmpty()
            )
            {
                if(buttonGroup1.getSelection()==null)
                {
                    JOptionPane.showMessageDialog(null, "Please select radio button to know if you are volunteer or need help or a doctor ","warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(!(confirmEmail.equals(emailId)))
                {
                    JOptionPane.showMessageDialog(null, "Email Address does not match, Please Enter valid email Address","warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Person person = null;
                if(isHelpSeeker.isSelected())
                {
                    if(passwordField.getPassword().length ==0 || confirmPasswordField.getPassword().length == 0 ||
                        userNameJTxtField.getText().trim().isEmpty() || helpSeekerNetworkCombo.getSelectedIndex()<1
                    )
                    {
                        JOptionPane.showMessageDialog(null, " Please Enter data in all fields","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    if(helpSeekerNetworkCombo.getSelectedIndex()<1)
                    {
                        JOptionPane.showMessageDialog(null, "Please choose a closest city","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if(age<50 || age==0 || age > 120)
                    {
                        JOptionPane.showMessageDialog(null, "Your age does not qualify as help seeker","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String userName = userNameJTxtField.getText();
                    String password = String.valueOf(passwordField.getPassword());
                    String confirmPassword =String.valueOf(confirmPasswordField.getPassword());

                    Network helpSeekerNw = (Network)helpSeekerNetworkCombo.getSelectedItem();
                    if(!(password.equals(confirmPassword)))
                    {
                        JOptionPane.showMessageDialog(null, "Password does not match, Please Enter valid Password Address","warning", JOptionPane.WARNING_MESSAGE);
                        organization.getPersonDirectory().getCustomerLsit().remove(person);
                        return;
                    }

                    getEnterprise(helpSeekerNw);
                    if(enterprise == null)
                    {
                        JOptionPane.showMessageDialog(null, "Enterprise does not exist for the network! "+helpSeekerNw.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    getOrganization("HelpSeeker",enterprise);

                    if(organization == null)
                    {
                        JOptionPane.showMessageDialog(null, "HelpSeeker Organization does not exist for the enterprise! "+enterprise.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    person = organization.getPersonDirectory().addCustomer();
                    person.setHelpSeeker(true);

                    for(Enterprise e : helpSeekerNw.getEnterpriseDirectory().getEnterpriseList())
                    {
                        for(UserAccount ua : e.getUserAccountDirectory().getUserAccountList())
                        {
                            if(ua.getUserName().equals(userName))
                            {
                                JOptionPane.showMessageDialog(null, "User Name already exists!, Please Enter valid user name","warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            else
                            {
                                for(Organization o : e.getOrganizationDirectory().getOrganizationList())
                                {
                                    for(UserAccount ua1 : o.getUserAccountDirectory().getUserAccountList())
                                    {
                                        if(ua1.getUserName().equals(userName))
                                        {
                                            JOptionPane.showMessageDialog(null, "User Name already exists!, Please Enter valid user name","warning", JOptionPane.WARNING_MESSAGE);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(!organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName))
                    {
                        JOptionPane.showMessageDialog(null, "User Name already exists!, Please Enter valid user name","warning", JOptionPane.WARNING_MESSAGE);
                        organization.getPersonDirectory().getCustomerLsit().remove((HelpSeeker)person);
                        return;
                    }
                    // To get help seeker org

                    UserAccount userAccount = organization.getUserAccountDirectory().addUserAccount(userName, password, person, new HelpSeekerRole());
                    userAccount.setPerson(person);
                    userAccount.setNetwork((Network)helpSeekerNw);

                    // Send Req to Supervisor for approval
                    SupervisorWorkRequest request = new SupervisorWorkRequest();
                    request.setMessage(SupervisorWorkRequest.REQUEST_APPROVAL);
                    request.setSender(userAccount);
                    request.setStatus(SupervisorWorkRequest.REQUEST_SENT);
                    request.setRequestDate(new Date());

                    // For Supervisor
                    for(Enterprise e : helpSeekerNw.getEnterpriseDirectory().getEnterpriseList())
                    {
                        if(e instanceof HeartHelpEnterprise)
                        {
                            for(Organization organization : e.getOrganizationDirectory().getOrganizationList())
                            {
                                if (organization instanceof SupervisorOrganization ){
                                    this.organization = organization;
                                    this.personDirectory = organization.getPersonDirectory();
                                }
                            }

                        }
                    }

                    if (organization!=null){
                        organization.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.setEnabled(false);
                    }
                }
                else if(isVolunteer.isSelected())
                {
                    if(age<10 || age==0 || age>100)
                    {
                        JOptionPane.showMessageDialog(null, "Your age does not qualify as Volunteer","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if(volNetworkCombo.getSelectedIndex()<1)
                    {
                        JOptionPane.showMessageDialog(null, "Please choose a closest city","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Network volNetwork = (Network)volNetworkCombo.getSelectedItem();
                    getEnterprise(volNetwork);

                    if(enterprise==null)
                    {
                        JOptionPane.showMessageDialog(null, "Enterprise does not exist for the network! " +volNetwork.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    getOrganization("Volunteer",enterprise);
                    if(organization==null)
                    {
                        JOptionPane.showMessageDialog(null, "Volunteer Organization does not exist for the enterprise! " +enterprise.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    person = organization.getPersonDirectory().addVolunteer();
                    person.setVolunteer(true);

                    String userName = SendEmailAndTextMessage.generateUserName(lastNameField.getText());
                    if(!organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName))
                    {
                        userName = SendEmailAndTextMessage.generateUserName(lastNameField.getText());
                    }
                    String password = SendEmailAndTextMessage.generatePassword(firstNameField.getText());
                    String emailMsg = buildEmailTxtMsg(userName, password);

                    boolean emailSent = SendEmailAndTextMessage.sendEmail(emailMsg, emailIDField.getText(),userName, password);
                    //                    if(!emailSent)
                    //                    {
                        //                    JOptionPane.showMessageDialog(null, "Please Enter a valid Email address! ","warning", JOptionPane.WARNING_MESSAGE);
                        //                    organization.getPersonDirectory().getVolunteerList().remove((Volunteer)person);
                        //                    return;
                        //                    }

                    UserAccount userAccount = organization.getUserAccountDirectory().addUserAccount(userName,password , person, new VolunteerRole());
                    userAccount.setPerson(person);
                    userAccount.setNetwork(volNetwork);

                    SupervisorWorkRequest request = new SupervisorWorkRequest();
                    request.setMessage(SupervisorWorkRequest.REQUEST_APPROVAL);
                    request.setSender(userAccount);
                    request.setStatus(SupervisorWorkRequest.REQUEST_SENT);
                    request.setRequestDate(new Date());

                    // For Supervisor
                    for(Enterprise e : volNetwork.getEnterpriseDirectory().getEnterpriseList())
                    {
                        if(e instanceof HeartHelpEnterprise)
                        {
                            for(Organization organization : e.getOrganizationDirectory().getOrganizationList())
                            {
                                if (organization instanceof SupervisorOrganization ){
                                    this.organization = organization;
                                    this.personDirectory = organization.getPersonDirectory();
                                }
                            }

                        }
                    }

                    if (organization!=null){
                        organization.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.setEnabled(false);
                    }
                }
                if(isDoctorRadioBtn.isSelected() )
                {
                    if(age<20 || age==0)
                    {
                        JOptionPane.showMessageDialog(null, "Your age does not qualify as Dcotor","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if(passwordField.getPassword().length ==0 || confirmPasswordField.getPassword().length == 0 ||
                        userNameJTxtField.getText().trim().isEmpty() || helpSeekerNetworkCombo.getSelectedIndex()<1
                    )
                    {
                        JOptionPane.showMessageDialog(null, " Please Enter data in all fields","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String userName = userNameJTxtField.getText();
                    String password = String.valueOf(passwordField.getPassword());
                    String confirmPassword =String.valueOf(confirmPasswordField.getPassword());

                    Network docNw = (Network)helpSeekerNetworkCombo.getSelectedItem();

                    if(!(password.equals(confirmPassword)))
                    {
                        JOptionPane.showMessageDialog(null, "Password does not match, Please Enter valid Password Address","warning", JOptionPane.WARNING_MESSAGE);
                        organization.getPersonDirectory().getPersonList().remove(person);
                        return;
                    }

                    getEnterprise(docNw);
                    if(enterprise==null)
                    {
                        JOptionPane.showMessageDialog(null, "Enterprise does not exist for the network! "+docNw.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    getOrganization("Doctor",enterprise);
                    if(organization==null)
                    {
                        JOptionPane.showMessageDialog(null, "Doctor Organization does not exist for the enterprise! "+enterprise.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    person = organization.getPersonDirectory().addPerson();

                    for(Enterprise e : docNw.getEnterpriseDirectory().getEnterpriseList())
                    {
                        for(UserAccount ua : e.getUserAccountDirectory().getUserAccountList())
                        {
                            if(ua.getUserName().equals(userName))
                            {
                                JOptionPane.showMessageDialog(null, "User Name already exists!, Please Enter valid user name","warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            else
                            {
                                for(Organization o : e.getOrganizationDirectory().getOrganizationList())
                                {
                                    for(UserAccount ua1 : o.getUserAccountDirectory().getUserAccountList())
                                    {
                                        if(ua1.getUserName().equals(userName))
                                        {
                                            JOptionPane.showMessageDialog(null, "User Name already exists!, Please Enter valid user name","warning", JOptionPane.WARNING_MESSAGE);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(!organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName))
                    {
                        JOptionPane.showMessageDialog(null, "User Name already exists!, Please Enter valid user name","warning", JOptionPane.WARNING_MESSAGE);
                        organization.getPersonDirectory().getPersonList().remove(person);
                        return;
                    }
                    // To get Doctor org

                    UserAccount userAccount = organization.getUserAccountDirectory().addUserAccount(userName, password, person, new DoctorRole());
                    userAccount.setPerson(person);
                    userAccount.setNetwork(docNw);

                    // Request to Supervisor
                    SupervisorWorkRequest request = new SupervisorWorkRequest();
                    request.setMessage(SupervisorWorkRequest.REQUEST_APPROVAL);
                    request.setSender(userAccount);
                    request.setStatus(SupervisorWorkRequest.REQUEST_SENT);
                    request.setRequestDate(new Date());

                    // For Supervisor
                    for(Enterprise e : docNw.getEnterpriseDirectory().getEnterpriseList())
                    {
                        if(e instanceof HeartHelpEnterprise)
                        {
                            for(Organization organization : e.getOrganizationDirectory().getOrganizationList())
                            {
                                if (organization instanceof SupervisorOrganization ){
                                    this.organization = organization;
                                    this.personDirectory = organization.getPersonDirectory();
                                }
                            }

                        }
                    }
                    if (organization!=null){
                        organization.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.setEnabled(false);
                    }
                }

                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setAddress2(address2);
                person.setAddress1(address1);
                person.setTown(town);
                person.setZipCode(zipCode);
                person.setOccupation(occupation);
                person.setEmailId(emailId);
                person.setDob(dateOfBirthVal);
                person.setPhoneNumber(phoneNumber);
                person.setGender(gender);
                person.setCountry(country);
                person.setState(state);
                person.setName();
                person.setAge(age);

                JOptionPane.showMessageDialog(null, "Your Profile has been created successfully", "success", JOptionPane.PLAIN_MESSAGE);
                resetFields();

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please Enter valid data in all the fields");
            }
        }

        catch(NumberFormatException npe)
        {
            JOptionPane.showMessageDialog(null, "Please Enter valid Number ! ");
            return;
        }
        catch(ParseException npe)
        {
            JOptionPane.showMessageDialog(null, "Please Enter data in all the fields");
            return;
        }
        catch(NullPointerException e )
        {
            JOptionPane.showMessageDialog(null, "Organization does not exist! ");
            return;
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null, "Please Enter data in all the fields");
            return;
        }
    }//GEN-LAST:event_createProfileButtonActionPerformed

    private void isHelpSeekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isHelpSeekerActionPerformed

        helpSeekerPane.setVisible(true);
        volNetworkCombo.setVisible(false);
        volNetwork.setVisible(false);
        populateNetworkComboBox();

    }//GEN-LAST:event_isHelpSeekerActionPerformed
public void resetFields()
    {
     userNameJTxtField.setText("");
     passwordField.setText("");
     confirmPasswordField.setText("");
    firstNameField.setText("");
    lastNameField.setText("");
    DobField.setText("");
    addressField1.setText("");
    addressField2.setText("");
    townField.setText("");
    zipCodeField.setText("");
    occupationField.setText("");
    emailIDField.setText("");
    emailIDField1.setText("");
    phoneNumberField.setText("");
    isHelpSeeker.setSelected(false);
    isVolunteer.setSelected(false);
    isDoctorRadioBtn.setSelected(false);
     
    }
public void getEnterprise(Network network)
    {
          try
                {
                 for (Network n : ecoSystem.getNetworkList())
                    {
                    if(n.getCity().equals(network.getCity()))   
                    {  
                   for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList())
                      {
                           if(e instanceof SchoolEnterprise && isVolunteer.isSelected())
                           {
                             this.enterprise = e;
                             network = n;
                            }
                           else if(e instanceof HeartHelpEnterprise && isHelpSeeker.isSelected())
                           {
                             this.enterprise = e;
                              network = n;
                            }
                            else if(e instanceof HospitalEnterprise && isDoctorRadioBtn.isSelected())
                           {
                             this.enterprise = e;
                              network = n;
                           }
                      }
                    }
                    }
                }
                catch(Exception e)
                {
                 JOptionPane.showMessageDialog(null, "Please create Enterprise","warning", JOptionPane.WARNING_MESSAGE);
                    return;    
                }
    }
    
    public String buildEmailTxtMsg(String usrNm, String pwd)
    {
      StringBuilder emailMsgTxt = new StringBuilder();
        emailMsgTxt.append("Please find username and password to login into our application");
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append("username : ".concat(usrNm));
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append("password : ".concat(pwd));
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append("Thank You");
        emailMsgTxt.append("HeartHelp");
        
        return emailMsgTxt.toString();
    }
    
    public void getOrganization(String orgVal, Enterprise e){
     
        try
        {
     for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
      
       if(orgVal.equals("Volunteer") && organization instanceof VolunteerOrganization)
        {
              this.organization = organization;
              this.personDirectory = organization.getPersonDirectory();
        
        }     
     else if(orgVal.equals("HelpSeeker") && organization instanceof HelpSeekerOrganization)
             {
               this.organization = organization;
               this.personDirectory = organization.getPersonDirectory();
             }  
       
       else if(orgVal.equals("Doctor") && organization instanceof DoctorOrganization)
             {
               this.organization = organization;
               this.personDirectory = organization.getPersonDirectory();
             } 
             }
        }
        catch(Exception ex)
        {
         return;     
        }
    }
    
    private void isVolunteerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isVolunteerActionPerformed
        helpSeekerPane.setVisible(false);
        volNetworkCombo.setVisible(true);
        volNetwork.setVisible(true);
        populateVolNetworkComboBox();
    }//GEN-LAST:event_isVolunteerActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void userNameJTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameJTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameJTxtFieldActionPerformed

    private void helpSeekerNetworkComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpSeekerNetworkComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpSeekerNetworkComboActionPerformed

    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboBoxActionPerformed

    private void countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryComboBoxActionPerformed

        stateComboBox.removeAllItems();

        if(countryComboBox.getSelectedIndex()>0)
        {
            stateComboBox.addItem("Please select a State");
            HashSet<String> hsstateVal = new HashSet<>();
            for (Network network : ecoSystem.getNetworkList())
            {
                if(network.getCountry().equals(countryComboBox.getSelectedItem()))
                {
                    hsstateVal.add(network.getState());
                }
            }
            for(String s1 : hsstateVal)
            {
                stateComboBox.addItem(s1);
            }
        }

    }//GEN-LAST:event_countryComboBoxActionPerformed

    private void stateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboBoxActionPerformed

    }//GEN-LAST:event_stateComboBoxActionPerformed

    private void isDoctorRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isDoctorRadioBtnActionPerformed
        helpSeekerPane.setVisible(true);
        volNetworkCombo.setVisible(false);
        volNetwork.setVisible(false);
        populateNetworkComboBox();
    }//GEN-LAST:event_isDoctorRadioBtnActionPerformed

    private void volNetworkComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volNetworkComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volNetworkComboActionPerformed
 public void fillForm()
    {
    firstNameField.setText("John");
    lastNameField.setText("Peter");
    DobField.setText("12/12/1938");
    genderComboBox.setSelectedItem("Female");
    addressField1.setText("433");
    addressField2.setText("Kenmore");
    townField.setText("boston");
    zipCodeField.setText("02145");
    occupationField.setText("student");
    emailIDField.setText("sruthi.ravula@gmail.com");
    emailIDField1.setText("sruthi.ravula@gmail.com");
    phoneNumberField.setText("8978989876");
  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField DobField;
    private javax.swing.JLabel LastName;
    private javax.swing.JLabel address1;
    private javax.swing.JLabel address2;
    private javax.swing.JTextField addressField1;
    private javax.swing.JTextField addressField2;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JComboBox countryComboBox;
    private javax.swing.JButton createProfileButton;
    private javax.swing.JLabel dateOfBirth;
    private javax.swing.JLabel emailID;
    private javax.swing.JLabel emailID1;
    private javax.swing.JTextField emailIDField;
    private javax.swing.JTextField emailIDField1;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JComboBox genderComboBox;
    private javax.swing.JComboBox helpSeekerNetworkCombo;
    private javax.swing.JLabel helpSeekerNw;
    private javax.swing.JLayeredPane helpSeekerPane;
    private javax.swing.JRadioButton isDoctorRadioBtn;
    private javax.swing.JRadioButton isHelpSeeker;
    private javax.swing.JRadioButton isVolunteer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel manageEnt;
    private javax.swing.JLabel occupation;
    private javax.swing.JTextField occupationField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel phoneNumber;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JComboBox stateComboBox;
    private javax.swing.JLabel town;
    private javax.swing.JTextField townField;
    private javax.swing.JTextField userNameJTxtField;
    private javax.swing.JLabel volNetwork;
    private javax.swing.JComboBox volNetworkCombo;
    private javax.swing.JLabel zipCode;
    private javax.swing.JTextField zipCodeField;
    // End of variables declaration//GEN-END:variables
}
