package org.zerock.domain;

public class ReservationVO {

    private int pk;

    private int booker;

    private int screening;

    private String isActive;

    private String getPaid;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getBooker() {
        return booker;
    }

    public void setBooker(int booker) {
        this.booker = booker;
    }

    public int getScreening() {
        return screening;
    }

    public void setScreening(int screening) {
        this.screening = screening;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getGetPaid() {
        return getPaid;
    }

    public void setGetPaid(String getPaid) {
        this.getPaid = getPaid;
    }

    // Reservation 모델 복사
    public void CopyData(ReservationVO param)
    {
        this.pk = param.getPk();
        this.booker = param.getBooker();
        this.screening = param.getScreening();
        this.isActive = param.getIsActive();
        this.getPaid = param.getGetPaid();
    }
}
