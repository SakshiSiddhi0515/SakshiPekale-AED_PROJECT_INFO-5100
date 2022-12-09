/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Work;
import Model.common.NeedHelp;
/**
 *
 * @author sakshipekale
 */
public class HelpRequest extends WorkRequest{
    private String requestId;
    private static int count = 000;
    private String comments;
    private NeedHelp needHelp;
    private String requestResult;
   

    public HelpRequest()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("REQ");
        sb.append(count);
        requestId = sb.toString();
        count++;
    }
    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setNeedHelp(NeedHelp needHelp) {
        this.needHelp = needHelp;
    }

    public NeedHelp getNeedHelp() {
        return needHelp;
    }

    public void setRequestResult(String requestResult) {
        this.requestResult = requestResult;
    }

    public String getRequestResult() {
        return requestResult;
    }


    
    @Override
    public String toString() {
        return getNeedHelp().getHelp();
    }
    
    
    
}
