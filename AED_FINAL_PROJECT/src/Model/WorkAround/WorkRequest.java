/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkAround;

import Model.UserAccount.Account_User;
import java.util.Date;

/**
 *
*@author Sakshi Sasalate
 */
public abstract class WorkRequest {

    private String message;
    private Account_User sender;
    private Account_User receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account_User getSender() {
        return sender;
    }

    public void setSender(Account_User sender) {
        this.sender = sender;
    }

    public Account_User getReceiver() {
        return receiver;
    }

    public void setReceiver(Account_User receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return this.message;
    }
    
    
}
