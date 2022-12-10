/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.common;

import java.util.Calendar;
import java.util.Date;
import Model.System.EcoSystem;
import Model.enterprise.enterprises;
import Model.network.network;
import Model.Org.OrgDoctor;
import Model.Org.OrgDonor;
import Model.Org.Organization;
import Model.Org.OrgSupervisor;
import Model.Org.OrgTransport;
import Model.Org.OrgVolunteer;
import Model.User.UserAccount;

/**
 *
 * @author sakshipekale
 */
public class Validation {
    public static boolean validateString(String name)
    {
        return true;
    }
    
    public static int calculateAge(Date dateOfBirth)
    {
       try
       {     
        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR))
        age--;
        return age;
       }
       catch(Exception e)
       {
        return 0;   
       }
    }
    
    
    public static OrgVolunteer getVolunteerOrganization(EcoSystem ecoSystem, UserAccount userAccount)
    {
        OrgVolunteer volunteerOrganization = null;
        try
        {
        for(network network : ecoSystem.getNetworkList())
        {
         if(network.equals(userAccount.getNetwork()))
         {
          for(enterprises enterprise : network.getEnterpriseDirectory().getEnterpriseList())
          {
            if(enterprise.getEnterpriseType().equals(enterprises.EnterpriseType.School))
            {
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
            {
             if(organization instanceof OrgVolunteer)
             {
              volunteerOrganization = (OrgVolunteer)organization; 
             }
            }
            }
          }
         }
        }
        }
        catch(NullPointerException npe)
        {
          npe.printStackTrace();
         return null;
        }
        return volunteerOrganization;
    }
    
    public static OrgVolunteer getVolunteerOrganizationInNw(EcoSystem ecoSystem, network nw)
    {
        OrgVolunteer volunteerOrganization = null;
        try
        {
        for( network network : ecoSystem.getNetworkList())
        {
         if(network.equals(nw))
         {
          for(enterprises enterprise : network.getEnterpriseDirectory().getEnterpriseList())
          {
            if(enterprise.getEnterpriseType().equals(enterprises.EnterpriseType.School))
            {
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
            {
             if(organization instanceof OrgVolunteer)
             {
              volunteerOrganization = (OrgVolunteer)organization; 
             }
            }
            }
          }
         }
        }
        }
        catch(NullPointerException npe)
        {
          npe.printStackTrace();
         return null;
        }
        return volunteerOrganization;
    }
    
      public static OrgDonor getDonorOrganization(EcoSystem ecoSystem, UserAccount userAccount)
    {
        OrgDonor donorOrganization = null;
        
        for(network network : ecoSystem.getNetworkList())
        {
         if(network.equals(userAccount.getNetwork()))
         {
          for(enterprises enterprise : network.getEnterpriseDirectory().getEnterpriseList())
          {
            if(enterprise.getEnterpriseType().equals(enterprises.EnterpriseType.NonProfit))
            {
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
            {
             if(organization instanceof OrgDonor)
             {
              donorOrganization = (OrgDonor)organization; 
             }
            }
            }
          }
         }
        }
        return donorOrganization;
    }
      
       public static OrgTransport getTransportOrganization(EcoSystem ecoSystem, UserAccount userAccount)
    {
        OrgTransport transportOrganization = null;
        
        for(network network : ecoSystem.getNetworkList())
        {
         if(network.equals(userAccount.getNetwork()))
         {
          for(enterprises enterprise : network.getEnterpriseDirectory().getEnterpriseList())
          {
            if(enterprise.getEnterpriseType().equals(enterprises.EnterpriseType.School))
            {
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
            {
             if(organization instanceof OrgTransport)
             {
              transportOrganization = (OrgTransport)organization; 
             }
            }
            }
          }
         }
        }
        return transportOrganization;
    } 
       
     public static OrgDoctor getDoctorOrganization(EcoSystem ecoSystem, UserAccount userAccount)
    {
        OrgDoctor doctorOrganization = null;
        try
        {
        for(network network : ecoSystem.getNetworkList())
        {
         if(network.equals(userAccount.getNetwork()))
         {
          for(enterprises enterprise : network.getEnterpriseDirectory().getEnterpriseList())
          {
            if(enterprise.getEnterpriseType().equals(enterprises.EnterpriseType.Hospital))
            {
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
            {
             if(organization instanceof OrgDoctor)
             {
              doctorOrganization = (OrgDoctor)organization; 
             }
            }
            }
          }
         }
        }
        }
        catch(NullPointerException npe)
        {
          npe.printStackTrace();
         return null;
        }
        return doctorOrganization;
    }   
     
      public static OrgSupervisor getSupervisorOrganization(EcoSystem ecoSystem, UserAccount userAccount)
    {
        OrgSupervisor supervisorOrganization = null;
        try
        {
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
             if(organization instanceof OrgSupervisor)
             {
              supervisorOrganization = (OrgSupervisor)organization; 
             }
            }
            }
          }
         }
        }
        }
        catch(NullPointerException npe)
        {
          npe.printStackTrace();
         return null;
        }
        return supervisorOrganization;
    }  
      
 
}
