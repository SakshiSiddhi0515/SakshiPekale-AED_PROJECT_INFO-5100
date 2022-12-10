/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Org;

import java.util.ArrayList;
import Model.Role.Role_mayor;
import Model.Role.Role;

/**
 *
 * @author sakshipekale
 */
public class OrgMayor extends Organization{
  
    public OrgMayor()
    {
        super(Organization.Type.Mayor.getValue());
    }
    
     @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role_mayor());
        return roles;
    }  
}
