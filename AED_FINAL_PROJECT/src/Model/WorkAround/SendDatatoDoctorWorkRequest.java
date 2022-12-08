/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkAround;

import Model.Sensors.VitalSigns;
import java.util.ArrayList;

/**
 *
*@author Sakshi Sasalate
 */
public class SendDataToDoctorWorkRequest extends WorkRequest{
    
    private String sendDataRequestId;
    private static int count = 000;
    private ArrayList<VitalSigns> vitalSignList;
    private String medication;
    private String newMedication;
    private String reqResult;
   
    
     public SendDataToDoctorWorkRequest()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("00");
        sb.append(count);
        sendDataRequestId = sb.toString();
        count++;
        vitalSignList = new ArrayList<>();
    }
    

    @Override
    public String toString() {
        
        return this.sendDataRequestId;       
    }

    public ArrayList<VitalSigns> getVitalSignList() {
        return vitalSignList;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setNewMedication(String newMedication) {
        this.newMedication = newMedication;
    }

    public String getNewMedication() {
        return newMedication;
    }

    public void setReqResult(String reqResult) {
        this.reqResult = reqResult;
    }

    public String getReqResult() {
        return reqResult;
    }

   
   
     
     
}
