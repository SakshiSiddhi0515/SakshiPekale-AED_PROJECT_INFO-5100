/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import business.common.NeedHelp;
import business.enterprisepkg.Enterprise;
import business.networkpkg.Network;
import business.organizationpkg.Organization;
import business.personpkg.Person;
import business.rolepkg.AdminRole;
import business.rolepkg.DoctorRole;
import business.rolepkg.DonorRole;
import business.rolepkg.DriverRole;
import business.rolepkg.HeartHelpManagerRole;
import business.rolepkg.MayorRole;
import business.rolepkg.SupervisorRole;
import business.rolepkg.SystemAdminRole;
import business.userAccountpkg.UserAccount;


/**
 *
 * @author DELL
 */
public class ConfigureASystem {
    public static EcoSystem configure()
    {
        EcoSystem system = EcoSystem.getInstance();
        Person person = system.getPersonDirectory().addPerson();
        person.setFirstName("Sys");
        person.setLastName("Admin");
        person.setName();
        
        UserAccount ua = system.getUserAccountDirectory().addUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        ua.setEnabled(true);
        
        NeedHelp needHelp = system.addNeedHelp();
        needHelp.setHelp("Snow Shovel");
        needHelp.setHelp("Grass Cutting");
        needHelp.setHelp("Gardening");
        needHelp.setHelp("Grocery Shopping");
       
        
        Network network = system.addNetwork();
      
        network.setCountry("United States");
        network.setState("Massachusetts");
        network.setCity("Boston");
    // School    
        Enterprise enterprise = network.getEnterpriseDirectory().addEnterprise("BostonSchool", Enterprise.EnterpriseType.School);
        person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("School Admin");
        person.setName();
        UserAccount account = enterprise.getUserAccountDirectory().addUserAccount("bsc", "bsc", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Volunteer);
        Organization organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Transport);
        person = organization.getPersonDirectory().addPerson();    
          
        person.setFirstName("Driver");
        person.setLastName("Transpport");
        person.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("dr1", "dr1", person, new DriverRole());
        account.setNetwork(network);
        account.setEnabled(true);
        
      // Heart Help
         enterprise = network.getEnterpriseDirectory().addEnterprise("BostonHeartHelp", Enterprise.EnterpriseType.HeartHelp);
         person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("Heart Help Admin");
        person.setName();
         account = enterprise.getUserAccountDirectory().addUserAccount("bhh", "bhh", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        enterprise.getOrganizationDirectory().addOrganization(Organization.Type.HelpSeeker);
        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Supervisor);
        person = organization.getPersonDirectory().addPerson();    
          
        person.setFirstName("Supervisor");
        person.setLastName("Boston");
        person.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bsup", "bsup", person, new SupervisorRole());
        account.setNetwork(network);
        account.setEnabled(true);
        
        // Manager
        
        person = organization.getPersonDirectory().addPerson();    
          
        person.setFirstName("Manager");
        person.setLastName("Boston");
        person.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bman", "bman", person, new HeartHelpManagerRole());
        account.setNetwork(network);
        account.setEnabled(true);
        
        
              // Non Profit
         enterprise = network.getEnterpriseDirectory().addEnterprise("NonProfit", Enterprise.EnterpriseType.NonProfit);
         person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("non proft Admin");
        person.setName();
         account = enterprise.getUserAccountDirectory().addUserAccount("bno", "bno", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Donor);
        person = organization.getPersonDirectory().addPerson();    
          
        person.setFirstName("Donor");
        person.setLastName("Boston");
        person.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bdon", "bdon", person, new DonorRole());
        account.setNetwork(network);
        account.setEnabled(true);
        
        
                  // Hospital
         enterprise = network.getEnterpriseDirectory().addEnterprise("Hospital", Enterprise.EnterpriseType.Hospital);
         person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("hospital Admin");
        person.setName();
         account = enterprise.getUserAccountDirectory().addUserAccount("bho", "bho", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Doctor);
        person = organization.getPersonDirectory().addPerson();    
          
        person.setFirstName("Doctor");
        person.setLastName("Boston");
        person.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bdoc", "bdoc", person, new DoctorRole());
        account.setNetwork(network);
        account.setEnabled(true);
        
                // Govt
         enterprise = network.getEnterpriseDirectory().addEnterprise("Govt", Enterprise.EnterpriseType.Government);
         person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("Govt Admin Admin");
        person.setName();
         account = enterprise.getUserAccountDirectory().addUserAccount("bgt", "bgt", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Mayor);
        person = organization.getPersonDirectory().addPerson();    
          
        person.setFirstName("mayor");
        person.setLastName("Boston");
        person.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bmay", "bmay", person, new MayorRole());
        account.setNetwork(network);
        account.setEnabled(true);
      
    return system;
    }
    
  
    
}
