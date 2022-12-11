/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.People;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import Model.sensor.Measurements;
import Model.sensor.Device;
import Model.sensor.VitalSign;
import java.awt.event.ActionListener;

/**
 *
 * @author sakshipekale
 */
public class People_help extends People{
    private String helpSeekerId;
    private static int count = 001;
    private boolean shareVitalInfo = false;
    private boolean hasSensorDevice = false;
    private boolean hasCardiacProb = false;
    private boolean getAlerts = false;
    private ArrayList<VitalSign> vitalSignList;
    private ArrayList<String> vitalSignTrackList;
    private boolean sendDataToDoctor = false;
    private Device sensorDevice;
    
    
    public People_help()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("CUST");
        sb.append(count);
        helpSeekerId = sb.toString();
        count++;
        vitalSignList = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return this.getName();
    }

    public Device getSensorDevice() {
        return sensorDevice;
    }

  
    public String getHelpSeekerId() {
        return helpSeekerId;
    }
    private VitalSign vitalSign = null;
    
    private volatile boolean stop = false;
    private int counter = 0;
  
 
    public void addVitalSign(){
        counter =0;
        System.out.println("counter"+counter);
       Measurements hRSensorMeasurements  = new Measurements();
        hRSensorMeasurements.start();
        System.out.println("counter"+counter);
       Timer timer =  new Timer(true);
       TimerTask addtask = new TimerTask () {
      
            @Override
            public void run () {
             while(counter<5)
             {
           ArrayList<VitalSign> list = hRSensorMeasurements.generateVitalSign(vitalSignTrackList, vitalSignList);
               counter ++;   
               
               System.out.println(">list>> "+list.toString());
                vitalSignList = list;
             }
             if (counter >= 5) {
                stop=true;
                timer.cancel();
                timer.purge();
                this.cancel();
                
                return;
                
                }
          hRSensorMeasurements.requestStop();
            }
        };
      timer.schedule(addtask, 5000);  
      if(counter >= 5)
      {
          addtask.cancel();
      }
      
       
  }
  
  
    public void removeVitalSign(VitalSign vitalSign)
    {
        vitalSignList.remove(vitalSign);
    }
    
    public ArrayList<VitalSign> getPatientVitalSignHistory() {
        return vitalSignList;
    }

   
     public String patientCondition(int age, VitalSign patientVitalSign)
    {
    
       float respiratoryRateValue;
       int heartRateValue ;
       int systolicBloodpressureValue ;
       float weightInPoundsValue; 
       String patientCondition = null;
      
           respiratoryRateValue = patientVitalSign.getRespiratoryRate();
           heartRateValue = patientVitalSign.getHeartRate();
           systolicBloodpressureValue = patientVitalSign.getSystolicBloodpressure();
           weightInPoundsValue = patientVitalSign.getWeightInPounds();
           
       if( age >=1 && age <=3 )
       {
           if(respiratoryRateValue >= 20 && respiratoryRateValue <=30 && 
                   heartRateValue >= 80 && heartRateValue <= 130 &&
                   systolicBloodpressureValue >= 80 && systolicBloodpressureValue <= 110 &&
                   weightInPoundsValue >= 22 && weightInPoundsValue <= 31)
           {
              patientCondition = "NORMAL";
           }
            else
            {
               patientCondition = "ABNORMAL";
            }
       }
       else if( age >= 4 && age <= 5 )
       {
           if(respiratoryRateValue >= 20 && respiratoryRateValue <= 30 && 
                   heartRateValue >= 80 && heartRateValue <= 120 &&
                   systolicBloodpressureValue >= 80 && systolicBloodpressureValue <= 110 &&
                   weightInPoundsValue >= 31 && weightInPoundsValue <= 40)
           {
             patientCondition = "NORMAL";
           }
            else
            {
               patientCondition = "ABNORMAL";
            }
           
       }
       else if( age >= 6 && age <= 12 )
       {
           if(respiratoryRateValue >= 20 && respiratoryRateValue <= 30 && 
                   heartRateValue >= 70 && heartRateValue <= 110 &&
                   systolicBloodpressureValue >= 80 && systolicBloodpressureValue <= 120 &&
                   weightInPoundsValue >= 41 && weightInPoundsValue <= 92)
           {
             patientCondition = "NORMAL";
           }
            else
            {
               patientCondition = "ABNORMAL";
            }
       }
       else if ( age >= 13)
       {
           if(respiratoryRateValue >= 12 && respiratoryRateValue <= 20 && 
                   heartRateValue >= 55 && heartRateValue <= 105 &&
                   systolicBloodpressureValue >= 110 && systolicBloodpressureValue <= 120 &&
                   weightInPoundsValue > 110)
           {
             patientCondition = "NORMAL";
           }
            else
            {
               patientCondition = "ABNORMAL";
            }
           
       }
      
        return patientCondition;   
    }

    public void setVitalSignTrackList(ArrayList<String> vitalSignTrackList) {
        this.vitalSignTrackList = new ArrayList<>();
        this.vitalSignTrackList = vitalSignTrackList;
    }

  public ArrayList<String> getVitalSignTrackList() {
        return vitalSignTrackList;
    }

    public ArrayList<VitalSign> getVitalSignList() {
        return vitalSignList;
    }

    public boolean isShareVitalInfo() {
        return shareVitalInfo;
    }

    public void setShareVitalInfo(boolean shareVitalInfo) {
        this.shareVitalInfo = shareVitalInfo;
    }

    public boolean isHasSensorDevice() {
        return hasSensorDevice;
    }

    public void setHasSensorDevice(boolean hasSensorDevice) {
        this.hasSensorDevice = hasSensorDevice;
    }

    public boolean isGetAlerts() {
        return getAlerts;
    }

    public void setGetAlerts(boolean getAlerts) {
        this.getAlerts = getAlerts;
    }

    public boolean isHasCardiacProb() {
        return hasCardiacProb;
    }

    public void setHasCardiacProb(boolean hasCardiacProb) {
        this.hasCardiacProb = hasCardiacProb;
    }

    public boolean isSendDataToDoctor() {
        return sendDataToDoctor;
    }

    public void setSendDataToDoctor(boolean sendDataToDoctor) {
        this.sendDataToDoctor = sendDataToDoctor;
    }
 
}
