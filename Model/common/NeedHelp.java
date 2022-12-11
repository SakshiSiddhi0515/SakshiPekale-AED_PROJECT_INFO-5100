/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.common;

import java.util.ArrayList;

/**
 *
 * @author sakshipekale
 */
public class NeedHelp {
     
    private String help;
    private String timetaken;
    private String serviceType;
    private String helpId;
    
    private String newHelp;
    
    private ArrayList<String> otherHelpList;
    
    private static int count = 01;
    
    public NeedHelp()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("HELP");
        sb.append(count);
        helpId = sb.toString();
        count++;
        
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return this.helpId;
    }
    

    public ArrayList<String> getOtherHelpList() {
        return otherHelpList;
    }

    public String getNewHelp() {
        return newHelp;
    }

    public void setNewHelp(String newHelp) {
        this.newHelp = newHelp;
    }

    

    public String getTimetaken() {
        return timetaken;
    }

    public void setTimetaken(String timetaken) {
        this.timetaken = timetaken;
    }
    
}
