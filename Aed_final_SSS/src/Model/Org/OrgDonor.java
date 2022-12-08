/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Org;

import Model.Role.DonorRole;
import Model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sakshipekale
 */
public class OrgDonor extends Organization{
    
    
    public OrgDonor()
    {
        super(Organization.Type.Donor.getValue());
    }
    
      @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DonorRole());
        return roles;
    }
}
