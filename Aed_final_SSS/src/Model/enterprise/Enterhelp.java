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
public class Enterhelp extends enterprises{

    public ArrayList<Role> getSupportedRole() {
    return null;
    }
    
    public Enterhelp(String name)
    {
     super(name, enterprises.EnterpriseType.Help);  
    }
}
