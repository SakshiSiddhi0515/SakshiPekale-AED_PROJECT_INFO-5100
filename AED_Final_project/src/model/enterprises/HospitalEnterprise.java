/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.enterprises;

import business.rolepkg.Role;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HospitalEnterprise extends Enterprise{
 
      
     public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}