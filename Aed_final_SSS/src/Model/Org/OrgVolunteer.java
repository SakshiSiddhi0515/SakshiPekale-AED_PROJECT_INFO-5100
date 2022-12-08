/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Org;

import java.util.ArrayList;
import Model.Role.Role;
import Model.Role.VolunteerRole;

/**
 *
 * @author sakshipekale
 */
public class OrgVolunteer extends Organization{
    public OrgVolunteer()
    {
        super(Organization.Type.Volunteer.getValue());
    }
    
      @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new VolunteerRole());
        return roles;
    }
}
