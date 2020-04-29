package org.zerock.domain;

public class SeatVO {

    private int pk;

    private int seatrow;

    private int seatnumber;

    private int auditorium;

    private String seatName;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getSeatrow() {
        return seatrow;
    }

    public void setSeatrow(int seatrow) {
        this.seatrow = seatrow;
    }

    public int getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    public int getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(int auditorium) {
        this.auditorium = auditorium;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    // Seat 모델 복사
    public void CopyData(SeatVO param)
    {
        this.pk = param.getPk();
        this.seatrow = param.getSeatrow();
        this.seatnumber = param.getSeatnumber();
        this.auditorium = param.getAuditorium();
        this.seatName = param.getSeatName();
    }
}