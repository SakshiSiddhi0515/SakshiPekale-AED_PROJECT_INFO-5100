/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprise;

import java.util.ArrayList;

/**
 *
 * @author sakshipekale
 */
public class EnterDirectory {
    private ArrayList<enterprises> enterpriseList;
    
    public EnterDirectory()
    {
        enterpriseList = new ArrayList<enterprises>();
    }
    
    
    public enterprises addEnterprise(String name, enterprises.EnterpriseType type)
    {
      enterprises enterprise = null;
      if(type ==enterprises.EnterpriseType.Help)
      {
       enterprise = new Enterhelp(name);
       enterpriseList.add(enterprise);     
      }
      else if (type == enterprises.EnterpriseType.Government){
            enterprise = new EnterGovernment(name);
            enterpriseList.add(enterprise);
        }
       else if (type == enterprises.EnterpriseType.NonProfit){
            enterprise = new EnterpriseNonprofit(name);
            enterpriseList.add(enterprise);
        }
        else  if(type ==enterprises.EnterpriseType.School)
        {
         enterprise = new EnterSchool(name);
         enterpriseList.add(enterprise);     
        }
      else  if(type ==enterprises.EnterpriseType.Hospital)
        {
         enterprise = new EnterHospital(name);
         enterpriseList.add(enterprise);     
        }

      return enterprise;
    }

    public ArrayList<enterprises> getEnterpriseList() {
        return enterpriseList;
    }
    
    public void deleteEnterprise(enterprises enterprise)
    {
        enterpriseList.remove(enterprise);
    }
}
