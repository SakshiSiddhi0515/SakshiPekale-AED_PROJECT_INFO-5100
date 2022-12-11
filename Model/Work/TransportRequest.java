/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Work;
import Model.People.People_volunteer;

/**
 *
 * @author sakshipekale
 */
public class TransportRequest extends WorkRequest{
    private String transRequestId;
    private static int count = 000;
    private String needTransport;
    private String transReqResult;
    
    
     public TransportRequest()
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
        People_volunteer volunteer = (People_volunteer)this.getSender().getPerson();
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
