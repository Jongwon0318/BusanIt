package org.zerock.domain;

public class MovieInfoVO {

    private int movie;

    private int director;

    private byte[] stillcut;

    private String nation;

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    public byte[] getStillcut() {
        return stillcut;
    }

    public void setStillcut(byte[] stillcut) {
        this.stillcut = stillcut;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    // Movieinfo 모델 복사
    public void CopyData(MovieInfoVO param)
    {
        this.movie = param.getMovie();
        this.director = param.getDirector();
        this.stillcut = param.getStillcut();
        this.nation = param.getNation();
    }
}
