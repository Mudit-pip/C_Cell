package com.lnmiit.c_cell;

public class location_details {

    private String details, location;
    private Double latitude, longitude;
    private boolean expandable;
    private int image_id;


    public location_details(String title, String location, Double latitude, Double longitude, int imageid) {
        this.details = title;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.expandable = false;
        this.image_id = imageid;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "location_details{" +
                "title='" + details + '\'' +
                ", location='" + location + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

