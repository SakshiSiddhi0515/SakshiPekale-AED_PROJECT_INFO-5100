/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enterprises;

import model.Org.Organization;
import model.organizationpkg.OrganizationDirectory;
/**
 *
 * @author DELL
 */


public abstract class Enterprise extends Organization{
    
    
    private String enterpriseId;
    private static int count = 1;
    private OrganizationDirectory organizationDirectory;
    private EnterpriseType enterpriseType;
    
    public Enterprise(String enterpriseName, EnterpriseType enterpriseType)
    {
        super(enterpriseName);
        this.enterpriseType = enterpriseType;
        organizationDirectory = new OrganizationDirectory();
        StringBuffer sb = new StringBuffer();
        sb.append("ENT");
        sb.append(count);
        enterpriseId = sb.toString();
        count++;
    }
    
    public enum EnterpriseType{
        
       School("School"),
       HeartHelp("HeartHelp"),
       NonProfit("NonProfit"),
       Government("Government"),
       Hospital("Hospital");
    
       
       private String value;
       
       private EnterpriseType(String value)
       {
         this.value = value;  
       }

        public String getValue() {
            return value;
        }
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
}