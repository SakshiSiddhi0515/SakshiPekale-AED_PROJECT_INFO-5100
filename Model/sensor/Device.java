/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.sensor;

import java.util.ArrayList;

/**
 *
 * @author sakshipekale
 */
public class Device {
    private String sensorName;
    private String sensorId;
    private Measurements hRSensorMeasurements;
    private ArrayList<Measurements> measurementList;
    
    public Device()
    {
        this.hRSensorMeasurements = new Measurements();
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

    public Measurements gethRSensorMeasurements() {
        return hRSensorMeasurements;
    }

    
    @Override
    public String toString() {
        return this.sensorName;
    }
    
    
}
