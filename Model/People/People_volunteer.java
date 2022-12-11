/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.People;

import java.util.ArrayList;
import Model.network.network;

/**
 *
 * @author sakshipekale
 */
public class People_volunteer extends People{
    private String volunteerId;
    private static int count = 001;
    private String latitiude;
    private String longitude;
    private ArrayList<People_review> testimonialList;
    
    
    public People_volunteer()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("VOL");
        sb.append(count);
        volunteerId = sb.toString();
        count++;
        testimonialList= new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.getName();
    }

  
    public String getVolunteerId() {
        return volunteerId;
    }

    public String getLatitiude() {
        return latitiude;
    }

    public void setLatitiude(String latitiude) {
        this.latitiude = latitiude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public ArrayList<People_review> getTestimonialList() {
        return testimonialList;
    }

   
    public People_review addTestimonial()
    {
        People_review testimonial = new People_review();
        testimonialList.add(testimonial);
        return testimonial;
    }
    
   
}
