/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Org;

import java.util.ArrayList;
import Model.Role.Role_manager;
import Model.Role.Role;
import Model.Role.Role_supervisor;
/**
 *
 * @author sakshipekale
 */
public class OrgSupervisor extends Organization{
    
    public OrgSupervisor()
    {
        super(Organization.Type.Supervisor.getValue());
    }
    
     @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role_supervisor());
        roles.add(new Role_manager());
        return roles;
    }
}
