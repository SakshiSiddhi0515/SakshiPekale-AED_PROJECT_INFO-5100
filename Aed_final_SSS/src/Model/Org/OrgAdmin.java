/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Org;
import Model.Role.Role_Admin;
import Model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sakshipekale
 */
public class OrgAdmin extends Organization{
    
    public OrgAdmin() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role_Admin());
        return roles;
    }
}
