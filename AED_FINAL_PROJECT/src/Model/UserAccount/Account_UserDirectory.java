/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.UserAccount;

import Model.people.People;
import Model.role.Roles;
import java.util.ArrayList;

/**
 *
*@author Sakshi Sasalate
 */
public class Account_UserDirectory {
    
    private ArrayList<Account_User> userAccountList;
    
    public Account_UserDirectory()
    {
      userAccountList = new ArrayList<>();
    }

    public ArrayList<Account_User> getUserAccountList() {
        return userAccountList;
    }
    
    public Account_User authenticateUser(String username, String password){
        for (Account_User ua : userAccountList)
        {
            System.out.println(ua.getUserName());
            System.out.println(ua.getPassword());
            if (ua.getUserName().equals(username) && ua.getPassword().equals(password)){
                return ua;
            } 
        }
        return null;
    }
    
    public Account_User addUserAccount(String username, String password, Person person, Role role){
        Account_User userAccount = new Account_User();
        userAccount.setUserName(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        boolean flag = true;
        for (Account_User ua : userAccountList){
            if (ua.getUserName().equals(username))
            {
              flag =  false;
            }
            else
            {
            flag =  true;
            }
        }
        return flag;
    }
    
    public void deleteUserAccount(Account_User userAccount)
    {
        userAccountList.remove(userAccount);
    }
    
}
