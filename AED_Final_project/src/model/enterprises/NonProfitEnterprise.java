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
public class NonProfitEnterprise extends Enterprise
{

    
     public NonProfitEnterprise(String name) {
        super(name, EnterpriseType.NonProfit);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
