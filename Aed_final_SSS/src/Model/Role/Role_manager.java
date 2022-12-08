/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Role;
import Model.EcoSystem;
import Model.enterprisepkg.Enterprise;
import Model.Org.Organization;
import model.userAccountpkg.UserAccount;
import javax.swing.JPanel;
import userInterface.manager.HeartHelpEnterpriseManagerWorkArea;

/**
 *
 * @author sakshipekale
 */
public class Role_manager extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem business) {
        return new HeartHelpEnterpriseManagerWorkArea(userProcessContainer, enterprise,business, account);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    } 
}
