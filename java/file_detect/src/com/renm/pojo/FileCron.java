package com.renm.pojo;

public class FileCron {
    private int id;
    private String fileName;
    private String cron;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCron() {
        return cron;
    }

    @Override
    public String toString() {
        return "FileCron{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
