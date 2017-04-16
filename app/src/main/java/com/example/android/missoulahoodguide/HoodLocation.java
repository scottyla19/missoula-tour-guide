package com.example.android.missoulahoodguide;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by swlaforest on 4/15/2017.
 */

public class HoodLocation {
    private String mName;
    private String mAddress;
    private Uri mGeoLoc;
    private String mProperties;

    public HoodLocation(String name, String address){
        mName = name;
        mAddress = address;
    }

    public HoodLocation(String name, String address, String properties){
        mName = name;
        mAddress = address;
        mProperties = properties;
    }

    public HoodLocation(String name, String address, Uri geoLoc, String  properties){
        mName = name;
        mAddress = address;
        mGeoLoc = geoLoc;
        mProperties = properties;
    }

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public Uri getmGeoLoc() {
        return mGeoLoc;
    }

    public String getmProperties() {
        return mProperties;
    }

    @Override
    public String toString() {
        return "HoodLocation{" +
                "mName='" + mName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mGeoLoc='" + mGeoLoc + '\'' +
                ", mProperties=" + mProperties +
                '}';
    }

}
