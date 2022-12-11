/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Org;

import java.util.ArrayList;
import Model.Role.Role_Admin;
import Model.Role.Role_helpseeker;
import Model.Role.Role;

/**
 *
 * @author sakshipekale
 */
public class OrgSeeker extends Organization{
    
    public OrgSeeker()
    {
        super(Organization.Type.HelpSeeker.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role_helpseeker());
        return roles;
    }
}
