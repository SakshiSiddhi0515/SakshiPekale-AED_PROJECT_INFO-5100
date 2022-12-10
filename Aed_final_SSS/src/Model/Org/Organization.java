/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Org;
import Model.People.People_Directory;
import Model.Role.Role;
import Model.User.UserAccountDirectory;
import Model.Work.WorkQueue;
import java.util.ArrayList;


/**
 *
 * @author sakshipekale
 */
public abstract class Organization {
    private String name;
    private UserAccountDirectory userAccountDirectory;
    private People_Directory personDirectory;
    private WorkQueue workQueue;
    private int orgId;
    private static int counter = 000;

    public Organization(String name) {
    this.name = name;
    userAccountDirectory = new UserAccountDirectory();
    personDirectory = new People_Directory();
    workQueue = new WorkQueue();
    counter++;
    orgId = counter;
    }
    
    public enum Type
    {
     Admin("Admin"),
     Volunteer("Volunteer Organization"),
     HelpSeeker("HelpSeeker Organization"),
     Supervisor("Supervisor Organization"),
     Donor("Donor Organization"),
     Transport("Transport Organization"),
     Mayor("Mayor Organization"),
     Doctor("Doctor Organization");
     
     private String value;
     
     private Type(String value)
     {
         this.value = value;
     }

        public String getValue() {
            return value;
        }
    }

    public People_Directory getPersonDirectory() {
        return personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public String getName() {
        return name;
    }
    
     public abstract ArrayList<Role> getSupportedRole();

    public int getOrgId() {
        return orgId;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
