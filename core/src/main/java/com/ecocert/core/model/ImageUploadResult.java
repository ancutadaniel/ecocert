package com.ecocert.core.model;

public class ImageUploadResult {
    double longitude;
    double latitude;
    String imageUUID;
    String originalName;

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

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

    public String getImageUUID() {
        return imageUUID;
    }

    public void setImageUUID(String imageUUID) {
        this.imageUUID = imageUUID;
    }

    public ImageUploadResult(){

    }

    public ImageUploadResult(String imageUUID, String originalName) {
        this.imageUUID = imageUUID;
        this.originalName = originalName;
    }

    public ImageUploadResult(double longitude, double latitude, String imageUUID) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.imageUUID = imageUUID;
    }
}
