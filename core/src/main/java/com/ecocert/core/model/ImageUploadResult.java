package com.ecocert.core.model;

public class ImageUploadResult {
    double longitude;
    double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public ImageUploadResult(){

    }
    public ImageUploadResult(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
