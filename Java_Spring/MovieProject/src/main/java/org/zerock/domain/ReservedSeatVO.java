package org.zerock.domain;

public class ReservedSeatVO {

    private int screening;

    private int seat;

    private int reservation;

    public int getScreening() {
        return screening;
    }

    public void setScreening(int screening) {
        this.screening = screening;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getReservation() {
        return reservation;
    }

    public void setReservation(int reservation) {
        this.reservation = reservation;
    }

    // Reservedseat 모델 복사
    public void CopyData(ReservedSeatVO param)
    {
        this.screening = param.getScreening();
        this.seat = param.getSeat();
        this.reservation = param.getReservation();
    }
}
