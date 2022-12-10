/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprise;

import java.util.ArrayList;
import Model.enterprise.enterprises.EnterpriseType;
import Model.Role.Role;

/**
 *
 * @author sakshipekale
 */
public class EnterpriseNonprofit extends enterprises {
    
     public EnterpriseNonprofit(String name) {
        super(name, EnterpriseType.NonProfit);
    }

    
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
