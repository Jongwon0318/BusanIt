package org.zerock.domain;

import java.util.Date;

public class ScreeningVO {

    private int pk;

    private int movie;

    private int theater;

    private int auditorium;

    private Date time;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int getTheater() {
        return theater;
    }

    public void setTheater(int theater) {
        this.theater = theater;
    }

    public int getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(int auditorium) {
        this.auditorium = auditorium;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    // Screening 모델 복사
    public void CopyData(ScreeningVO param)
    {
        this.pk = param.getPk();
        this.movie = param.getMovie();
        this.theater = param.getTheater();
        this.auditorium = param.getAuditorium();
        this.time = param.getTime();
    }
}