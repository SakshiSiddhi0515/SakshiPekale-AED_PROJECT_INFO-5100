/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Org;

import java.util.ArrayList;
import Model.Org.Organization.Type;

/**
 *
 * @author sakshipekale
 */
public class OrgDirectory {
    private ArrayList<Organization> organizationList;
    
    public  OrgDirectory()
    {
      organizationList = new ArrayList<>();
    }
    
    public Organization addOrganization(Type type)
    {
       Organization organization = null;
        if (type.getValue().equals(Type.Volunteer.getValue())){
            organization = new OrgVolunteer();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HelpSeeker.getValue())){
            organization = new OrgSeeker();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Supervisor.getValue())){
            organization = new OrgSupervisor();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Donor.getValue())){
            organization = new OrgDonor();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Transport.getValue())){
            organization = new OrgTransport();
            organizationList.add(organization);
        }
          else if (type.getValue().equals(Type.Mayor.getValue())){
            organization = new OrgMayor();
            organizationList.add(organization);
        }
           else if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new OrgDoctor();
            organizationList.add(organization);
        }
        return organization;
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public void deleteOrganization(Organization organization)
    {
      organizationList.remove(organization);
    }
}
