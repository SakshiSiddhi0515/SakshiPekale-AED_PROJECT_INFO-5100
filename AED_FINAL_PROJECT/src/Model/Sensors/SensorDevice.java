/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.sensors;

import java.util.ArrayList;

/**
 *
 *@author Sakshi Sasalate
 */
public class SensorDevice {
    
    private String sensorName;
    private String sensorId;
    private HRSensorsMeasurements hRSensorMeasurements;
    private ArrayList<HRSensorsMeasurements> measurementList;
    
    public SensorDevice()
    {
        this.hRSensorMeasurements = new HRSensorsMeasurements();
        measurementList= new ArrayList<>();
    }
    
    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public HRSensorsMeasurements gethRSensorMeasurements() {
        return hRSensorMeasurements;
    }

    
    @Override
    public String toString() {
        return this.sensorName;
    }
    
    
    
}
