package com.mohmedhassan.tourguide;

import android.location.Location;

/**
 * Created by akueisara on 9/29/2016.
 */
public class Atraction {
    private String AtractionName;
    private String AtractionPhone;
    private String AtractionAddress;
    private String AtractionImageUrl;
    private Location AtractionLocation;

    public Atraction(String name, String phone, String address, String imageUrl, Location location) {
        AtractionName = name;
        AtractionPhone = phone;
        AtractionAddress = address;
        AtractionImageUrl = imageUrl;
        AtractionLocation = location;
    }

    public String getAttractionName() {
        return AtractionName;
    }

    public String getAttractionPhone() {
        return AtractionPhone;
    }

    public Location getLocation() {
        return AtractionLocation;
    }

    public String getAttractionAddress() {
        return AtractionAddress;
    }

    public String getImageResourceUrl(){
        return AtractionImageUrl;
    }

}
