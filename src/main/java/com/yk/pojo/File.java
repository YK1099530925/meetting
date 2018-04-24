package com.yk.pojo;

public class File {
    private Integer meettingid;

    private String filename;

    private String filedir;

    public Integer getMeettingid() {
        return meettingid;
    }

    public void setMeettingid(Integer meettingid) {
        this.meettingid = meettingid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFiledir() {
        return filedir;
    }

    public void setFiledir(String filedir) {
        this.filedir = filedir == null ? null : filedir.trim();
    }
}