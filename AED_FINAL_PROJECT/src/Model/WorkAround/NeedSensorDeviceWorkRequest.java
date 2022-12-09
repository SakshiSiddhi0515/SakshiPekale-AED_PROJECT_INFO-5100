/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkAround;

/**
 *
*@author Sakshi Sasalate
 */
public class NeedSensorDeviceWorkRequest extends WorkRequest{
    
    private String requestSensorId;
    private static int count = 001;
    private String comments;
    private String donationRequestResult;
    
    
    public NeedSensorDeviceWorkRequest()
    {
        
        StringBuffer sb = new StringBuffer();
        sb.append("SENSOR");
        sb.append(count);
        requestSensorId = sb.toString();
        count++;
    }

    public String getRequestSensorId() {
        return requestSensorId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getdonationRequestResult() {
        return donationRequestResult;
    }

    public void setdonationRequestResult(String requestResult) {
        this.donationRequestResult = requestResult;
    }

    @Override
    public String toString() {
        return this.requestSensorId;
    }
    
    
    
    
}
