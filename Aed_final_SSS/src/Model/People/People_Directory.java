/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.People;

import java.util.ArrayList;

/**
 *
 * @author sakshipekale
 */
public class People_Directory {
    private ArrayList<People_volunteer> volunteerList;
      private ArrayList<People_help> customerLsit;
      private ArrayList<People> personList;
    
      public People_Directory()
      {
            volunteerList = new ArrayList<>();
            customerLsit = new ArrayList<>();
            personList = new ArrayList<>();
      }
      
      public People_volunteer addVolunteer()
    {
        People_volunteer volunteer = new People_volunteer();
        volunteerList.add(volunteer);
        return volunteer;
    }
    
    public void removeVolunteer(People_volunteer volunteer)
    {
      volunteerList.remove(volunteer);
    }
    
    public People_help addCustomer()
    {
        People_help customer = new People_help();
        customerLsit.add(customer);
        return customer;
    }
    
    public void removeCustomer(People_help customer)
    {
        customerLsit.remove(customer);
    }
    

    public ArrayList<People_help> getCustomerLsit() {
        return customerLsit;
    }

    public ArrayList<People_volunteer> getVolunteerList() {
        return volunteerList;
    }


      public People addPerson()
    {
        People people = new People();
       personList.add(people);
        return people;
    }
    
    public void removePerson(People people)
    {
        personList.remove(people);
    }

    public ArrayList<People> getPersonList() {
        return personList;
    }

  
    

}
