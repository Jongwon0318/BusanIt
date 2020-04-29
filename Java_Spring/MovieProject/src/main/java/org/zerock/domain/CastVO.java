package org.zerock.domain;

public class CastVO {

    private int movie;

    private int actor;

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int getActor() {
        return actor;
    }

    public void setActor(int actor) {
        this.actor = actor;
    }

    // Cast 모델 복사
    public void CopyData(CastVO param)
    {
        this.movie = param.getMovie();
        this.actor = param.getActor();
    }
}