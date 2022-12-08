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
import userInterface.transport.DriverWorkAreaJPanel;

/**
 *
 * @author sakshipekale
 */
public class Role_driver extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DriverWorkAreaJPanel(userProcessContainer, account, organization, enterprise.getOrganizationDirectory());
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
     
}
