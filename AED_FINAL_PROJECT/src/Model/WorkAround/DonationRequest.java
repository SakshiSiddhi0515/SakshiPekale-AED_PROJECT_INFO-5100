/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.WorkAround;

import Model.role.Donation;



/**
 *
*@author Sakshi Sasalate
 */
public class DonationRequest extends WorkRequest{
    
    private String donatedBy;
    private String requestId;
    private static int count = 000;
    private Donation donation;
   
    public DonationRequest()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("DONATION");
        sb.append(count);
        requestId = sb.toString();
        count++;
    }

    public String getDonatedBy() {
        return donatedBy;
    }

    public void setDonatedBy(String donatedBy) {
        this.donatedBy = donatedBy;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public Donation getDonation() {
        return donation;
    }

    @Override
    public String toString() {
        return this.requestId;
    }
    
    
}
