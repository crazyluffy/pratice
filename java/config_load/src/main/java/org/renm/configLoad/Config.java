package org.renm.configLoad;

public class Config {
    private String config;

    public Config(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "Config{" +
                "config='" + config + '\'' +
                '}';
    }
}
