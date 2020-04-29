package org.zerock.domain;

public class AuditoriumVO {

    private int pk;

    private String name;

    private int seatsNo;

    private int theater;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsNo() {
        return seatsNo;
    }

    public void setSeatsNo(int seatsNo) {
        this.seatsNo = seatsNo;
    }

    public int getTheater() {
        return theater;
    }

    public void setTheater(int theater) {
        this.theater = theater;
    }

    // Auditorium 모델 복사
    public void CopyData(AuditoriumVO param)
    {
        this.pk = param.getPk();
        this.name = param.getName();
        this.seatsNo = param.getSeatsNo();
        this.theater = param.getTheater();
    }
}
