/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Role;

import Model.EcoSystem;
import Model.enterprisepkg.Enterprise;
import Model.Org.Organization;
import Model.userAccountpkg.UserAccount;
import javax.swing.JPanel;
import userInterface.adminRole.AdminWorkAreaJPanel;

/**
 *
 * @author sakshipekale
 */
public class Role_Admin extends Role {
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise, account);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
