package org.zerock.domain;

public class DirectorVO {

    private int pk;

    private String director;

    private String endDirector;

    private byte[] profileImg;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEndDirector() {
        return endDirector;
    }

    public void setEndDirector(String endDirector) {
        this.endDirector = endDirector;
    }

    public byte[] getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(byte[] profileImg) {
        this.profileImg = profileImg;
    }

    // Director 모델 복사
    public void CopyData(DirectorVO param)
    {
        this.pk = param.getPk();
        this.director = param.getDirector();
        this.endDirector = param.getEndDirector();
        this.profileImg = param.getProfileImg();
    }
}
