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
public class EnterHospital extends enterprises{
    public EnterHospital(String name) {
        super(name, EnterpriseType.Hospital);
    }

    
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
