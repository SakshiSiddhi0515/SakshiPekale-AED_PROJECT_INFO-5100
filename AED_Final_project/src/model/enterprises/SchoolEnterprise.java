/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.enterprises;

import business.enterprisepkg.Enterprise.EnterpriseType;
import business.rolepkg.Role;
import java.util.ArrayList;


/**
 *
 * @author DELL
 */
public class SchoolEnterprise extends Enterprise{
    
     public SchoolEnterprise(String name) {
        super(name, EnterpriseType.School);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}

