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
public class EnterSchool extends enterprises{
    public EnterSchool(String name) {
        super(name, EnterpriseType.School);
    }

  
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
