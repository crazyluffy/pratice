package org.renm.mybatis.pojo;

public class DetectTask {
    private int id;
    private String fileName;
    private String cron;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DetectTask{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }
}
