package org.zerock.domain;

public class ActorVO {

    private int pk;

    private String actor;

    private String engActor;

    private byte[] profileImg;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getEngActor() {
        return engActor;
    }

    public void setEngActor(String engActor) {
        this.engActor = engActor;
    }

    public byte[] getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(byte[] profileImg) {
        this.profileImg = profileImg;
    }

    // Actor 모델 복사
    public void CopyData(ActorVO param)
    {
        this.pk = param.getPk();
        this.actor = param.getActor();
        this.engActor = param.getEngActor();
        this.profileImg = param.getProfileImg();
    }
}
