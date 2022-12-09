/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkAround;

import Model.people.volunteer;

/**
 *
*@author Sakshi Sasalate
 */
public class NeedTransportWorkRequest extends WorkRequest{
    
    private String transRequestId;
    private static int count = 000;
    private String needTransport;
    private String transReqResult;
    
    
     public NeedTransportWorkRequest()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("TRANS");
        sb.append(count);
        transRequestId = sb.toString();
        count++;
    }
     
    public void setNeedTransport(String needTransport) {
        this.needTransport = needTransport;
    }

    public String getNeedTransport() {
        return needTransport;
    }

    @Override
    public String toString() {
        volunteer volunteer = (volunteer)this.getSender().getPerson();
        String address = volunteer.getAddress1().concat(volunteer.getAddress2().concat(volunteer.getTown()));
        return address;
                
    }

    public String getTransReqResult() {
        return transReqResult;
    }

    public void setTransReqResult(String transReqResult) {
        this.transReqResult = transReqResult;
    }
     
     
}
