/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprise;

import java.util.ArrayList;
import Model.Role.Role;

/**
 *
 * @author sakshipekale
 */
public class EnterGovernment extends enterprises{
    public EnterGovernment(String name) {
        super(name, EnterpriseType.Government);
    }

    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
