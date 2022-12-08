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
public class SupervisorWorkRequest extends WorkRequest{
    
    public static String REQUEST_APPROVED = "Approved";
    public static String REQUEST_PENDING = "Pending";
    public static String REQUEST_REJECT = "Declined";
    public static String REQUEST_COMPLETED = "Completed";
    public static String REQUEST_APPROVAL = "Request for Approval";
    public static String REQUEST_SENT = "Sent";
    public static String REQUEST_ACCEPT = "Accepted";
    private String testResult;
    private String comments;
    

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

   
    
    
}
