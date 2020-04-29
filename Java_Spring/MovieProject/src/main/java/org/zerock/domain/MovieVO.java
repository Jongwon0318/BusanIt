package org.zerock.domain;

import java.util.Date;

public class MovieVO {

    private int pk;

    private String title;

    private String engTitle;

    private int durationMin;

    private String rate;

    private Date openingDate;

    private String genre;

    private String description;

    private String trailer;

    private int reservationScore;

    private String nowOpen;

    private String nowShow;

    private byte[] mainImg;

    private byte[] thumbnailImg;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEngTitle() {
        return engTitle;
    }

    public void setEngTitle(String engTitle) {
        this.engTitle = engTitle;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getReservationScore() {
        return reservationScore;
    }

    public void setReservationScore(int reservationScore) {
        this.reservationScore = reservationScore;
    }

    public String getNowOpen() {
        return nowOpen;
    }

    public void setNowOpen(String nowOpen) {
        this.nowOpen = nowOpen;
    }

    public String getNowShow() {
        return nowShow;
    }

    public void setNowShow(String nowShow) {
        this.nowShow = nowShow;
    }

    public byte[] getMainImg() {
        return mainImg;
    }

    public void setMainImg(byte[] mainImg) {
        this.mainImg = mainImg;
    }

    public byte[] getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(byte[] thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }

    // Movie 모델 복사
    public void CopyData(MovieVO param)
    {
        this.pk = param.getPk();
        this.title = param.getTitle();
        this.engTitle = param.getEngTitle();
        this.durationMin = param.getDurationMin();
        this.rate = param.getRate();
        this.openingDate = param.getOpeningDate();
        this.genre = param.getGenre();
        this.description = param.getDescription();
        this.trailer = param.getTrailer();
        this.reservationScore = param.getReservationScore();
        this.nowOpen = param.getNowOpen();
        this.nowShow = param.getNowShow();
        this.mainImg = param.getMainImg();
        this.thumbnailImg = param.getThumbnailImg();
    }
}