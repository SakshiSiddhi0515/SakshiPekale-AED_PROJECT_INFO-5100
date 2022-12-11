/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Role;
import Model.System.EcoSystem;
import Model.enterprise.enterprises;
import Model.Org.Organization;
import Model.User.UserAccount;
import javax.swing.JPanel;
import UI.transport.DriverWorkAreaJPanel;

/**
 *
 * @author sakshipekale
 */
public class Role_driver extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, enterprises enterprise, EcoSystem business) {
        return new DriverWorkAreaJPanel(userProcessContainer, account, organization, enterprise.getOrganizationDirectory());
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
     
}
