/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.System;
import Model.common.NeedHelp;
import Model.enterprise.enterprises;
import Model.network.network;
import Model.Org.Organization;
import Model.People.People;
import Model.Role.Role_Admin;
import Model.Role.Role_doctor;
import Model.Role.Role_donor;
import Model.Role.Role_driver;
import Model.Role.Role_manager;
import Model.Role.Role_mayor;
import Model.Role.Role_supervisor;
import Model.Role.Role_systemadmin;
import Model.User.UserAccount;

/**
 *
 * @author sakshipekale
 */
public class ConfigureSystem {
    
    public static EcoSystem configure()
    {
        EcoSystem system = EcoSystem.getInstance();
        People people = system.getPersonDirectory().addPeople();
        people.setFirstName("Sys");
        people.setLastName("Admin");
        people.setName();
        
        UserAccount ua = system.getUserAccountDirectory().addUserAccount("sysadmin", "sysadmin", people, new Role_systemadmin());
        ua.setEnabled(true);
        
        NeedHelp needHelp = system.addNeedHelp();
        needHelp.setHelp("Snow Shovel");
        needHelp.setHelp("Grass Cutting");
        needHelp.setHelp("Gardening");
        needHelp.setHelp("Grocery Shopping");
       
        
        network network = system.addnetwork();
      
        network.setCountry("United States");
        network.setState("Massachusetts");
        network.setCity("Boston");
    // School    
        enterprises enterprise = network.getEnterpriseDirectory().addEnterprise("BostonSchool", enterprises.EnterpriseType.School);
        people = enterprise.getPersonDirectory().addPerson();
        people.setLastName("School Admin");
        people.setName();
        UserAccount account = enterprise.getUserAccountDirectory().addUserAccount("bsc", "bsc", people, new Role_Admin());
        account.setEnabled(true);
        account.setNetwork(network);
        enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Volunteer);
        Organization organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Transport);
        people = organization.getPersonDirectory().addPerson();    
          
        people.setFirstName("Driver");
        people.setLastName("Transpport");
        people.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("dr1", "dr1", people, new Role_driver());
        account.setNetwork(network);
        account.setEnabled(true);
        
      // Heart Help
         enterprise = network.getEnterpriseDirectory().addEnterprise("BostonHeartHelp", enterprises.EnterpriseType.Help);
         people = enterprise.getPersonDirectory().addPerson();
        people.setLastName("Heart Help Admin");
        people.setName();
         account = enterprise.getUserAccountDirectory().addUserAccount("bhh", "bhh", people, new Role_Admin());
        account.setEnabled(true);
        account.setNetwork(network);
        enterprise.getOrganizationDirectory().addOrganization(Organization.Type.HelpSeeker);
        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Supervisor);
        people = organization.getPersonDirectory().addPerson();    
          
        people.setFirstName("Supervisor");
        people.setLastName("Boston");
        people.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bsup", "bsup", people, new Role_supervisor());
        account.setNetwork(network);
        account.setEnabled(true);
        
        // Manager
        
        people = organization.getPersonDirectory().addPerson();    
          
        people.setFirstName("Manager");
        people.setLastName("Boston");
        people.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bman", "bman", people, new Role_manager());
        account.setNetwork(network);
        account.setEnabled(true);
        
        
              // Non Profit
         enterprise = network.getEnterpriseDirectory().addEnterprise("NonProfit", enterprises.EnterpriseType.NonProfit);
         people = enterprise.getPersonDirectory().addPerson();
        people.setLastName("non proft Admin");
        people.setName();
         account = enterprise.getUserAccountDirectory().addUserAccount("bno", "bno", people, new Role_Admin());
        account.setEnabled(true);
        account.setNetwork(network);
        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Donor);
        people = organization.getPersonDirectory().addPerson();    
          
        people.setFirstName("Donor");
        people.setLastName("Boston");
        people.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bdon", "bdon", people, new Role_donor());
        account.setNetwork(network);
        account.setEnabled(true);
        
        
                  // Hospital
         enterprise = network.getEnterpriseDirectory().addEnterprise("Hospital", enterprises.EnterpriseType.Hospital);
         people = enterprise.getPersonDirectory().addPerson();
        people.setLastName("hospital Admin");
        people.setName();
         account = enterprise.getUserAccountDirectory().addUserAccount("bho", "bho", people, new Role_Admin());
        account.setEnabled(true);
        account.setNetwork(network);
        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Doctor);
        people = organization.getPersonDirectory().addPerson();    
          
        people.setFirstName("Doctor");
        people.setLastName("Boston");
        people.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bdoc", "bdoc", people, new Role_doctor());
        account.setNetwork(network);
        account.setEnabled(true);
        
                // Govt
         enterprise = network.getEnterpriseDirectory().addEnterprise("Govt", enterprises.EnterpriseType.Government);
         people = enterprise.getPersonDirectory().addPerson();
        people.setLastName("Govt Admin Admin");
        people.setName();
         account = enterprise.getUserAccountDirectory().addUserAccount("bgt", "bgt", people, new Role_Admin());
        account.setEnabled(true);
        account.setNetwork(network);
        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Mayor);
        people = organization.getPersonDirectory().addPerson();    
          
        people.setFirstName("mayor");
        people.setLastName("Boston");
        people.setName();
        
        account = organization.getUserAccountDirectory().addUserAccount("bmay", "bmay", people, new Role_mayor());
        account.setNetwork(network);
        account.setEnabled(true);
      
    return system;
    }
    
  
    
}
