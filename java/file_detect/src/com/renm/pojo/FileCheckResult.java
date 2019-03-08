package com.renm.pojo;

import java.util.Date;

public class FileCheckResult {
    private int id;
    private Date time;
    private FCResult res;
    private FileCron fileCron;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public FCResult getRes() {
        return res;
    }

    public void setRes(FCResult res) {
        this.res = res;
    }

    public FileCron getFileCron() {
        return fileCron;
    }

    public void setFileCron(FileCron fileCron) {
        this.fileCron = fileCron;
    }
}
