/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.System;

import java.util.ArrayList;
import Model.common.NeedHelp;
import Model.network.network;
import Model.Org.Organization;
import Model.Role.Role;
import Model.Role.Role_systemadmin;

/**
 *
 * @author sakshipekale
 */
public class EcoSystem extends Organization{
    private ArrayList<network> networkList;
   private static EcoSystem ecoSystem;
   private ArrayList<NeedHelp> helpList;
    
   public EcoSystem()
   {
       super(null);
       networkList = new ArrayList<>();
       helpList = new ArrayList<>();
      
   }
   
   public static EcoSystem getInstance()
   {
    if(ecoSystem == null)
    {
      ecoSystem = new EcoSystem();
    }
    return ecoSystem;
   }

    public ArrayList<network> getNetworkList() {
        return networkList;
    }
   
    public network addNetwork()
    {
        network network = new network();
        networkList.add(network);
        return network;
    }
    
    public boolean checkIfUsernameIsUnique(String username)
    {
      if (!getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
        return false;
      }
      return true;
    }
   
    public void deleteNetwork(network network)
    {
        networkList.remove(network);
    }
   
   @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new Role_systemadmin());
        return roleList;
    }
   
    public NeedHelp addNeedHelp()
    {
        NeedHelp needHelp = new NeedHelp();
        helpList.add(needHelp);
        return needHelp;
    }
    
    public void deleteHelp(NeedHelp needHelp)
    {
        helpList.remove(needHelp);
    }

    public ArrayList<NeedHelp> getHelpList() {
        return helpList;
    }
    
    
}
