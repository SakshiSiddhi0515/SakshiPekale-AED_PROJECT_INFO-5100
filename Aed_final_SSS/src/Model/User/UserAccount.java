/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.User;
import Model.network.network;
import Model.People.People;
import Model.Role.Role;
import Model.Work.WorkQueue;

/**
 *
 * @author sakshipekale
 */
public class UserAccount {
    private String userName;
    private String password;
    private People people; 
    private Role role;
    private WorkQueue workQueue;
    private boolean enabled = true;
    private network network;
   
    
    public UserAccount() {
        workQueue = new WorkQueue();
    }
  
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public People getPerson() {
        return people;
    }

    public void setPerson(People people) {
        this.people = people;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return userName; //To change body of generated methods, choose Tools | Templates.
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setNetwork(network network) {
        this.network = network;
    }

    public network getNetwork() {
        return network;
    }

    
    
}
