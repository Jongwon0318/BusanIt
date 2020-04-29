package org.zerock.domain;

public class TheaterVO {

    private int pk;

    private String location;

    private String subLocation;

    private String address;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Theater 모델 복사
    public void CopyData(TheaterVO param)
    {
        this.pk = param.getPk();
        this.location = param.getLocation();
        this.subLocation = param.getSubLocation();
        this.address = param.getAddress();
    }
}
