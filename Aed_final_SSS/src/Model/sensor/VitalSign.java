/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.sensor;

/**
 *
 * @author sakshipekale
 */
public class VitalSign {
    private float respiratoryRate;
    private int heartRate;
    private int systolicBloodpressure;
    private float weightInPounds;
    private String timeStamp;
 

    public float getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(float respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getSystolicBloodpressure() {
        return systolicBloodpressure;
    }

    public void setSystolicBloodpressure(int systolicBloodpressure) {
        this.systolicBloodpressure = systolicBloodpressure;
    }

    public float getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(float weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        
        return timeStamp;
    }
    
    
    
}
