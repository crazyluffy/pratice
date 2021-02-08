package org.renm.configLoad.implement;

import org.renm.configLoad.Config;
import org.renm.configLoad.ConfigLoad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigDbSource implements ConfigLoad {

    @Value("${inner.config.db.connectString}")
    private String connectString;

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public Config load() {
        return new Config("config from db:" + connectString);
    }
}
