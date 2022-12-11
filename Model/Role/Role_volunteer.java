 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Role;
import Model.System.EcoSystem;
import Model.enterprise.enterprises;
import Model.Org.Organization;
import Model.Org.OrgVolunteer;
import Model.User.UserAccount;
import javax.swing.JPanel;
import UI.volunteer.VolunteerWorkAreaJPanel;


/**
 *
 * @author sakshipekale
 */
public class Role_volunteer extends Role{
    
    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, 
            Organization organization, enterprises enterprise, EcoSystem ecosystem) {
        return new VolunteerWorkAreaJPanel(userProcessContainer, enterprise, userAccount, organization, ecosystem);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
