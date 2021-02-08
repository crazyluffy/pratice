package org.renm.configLoad;

import org.renm.configLoad.implement.ConfigDbSource;
import org.renm.configLoad.implement.ConfigFileSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigSource {
    @Autowired
    ConfigFileSource fileSource;

    @Autowired
    ConfigDbSource dbSource;

    public ConfigFileSource getFileSource() {
        return fileSource;
    }

    public void setFileSource(ConfigFileSource fileSource) {
        this.fileSource = fileSource;
    }

    public ConfigDbSource getDbSource() {
        return dbSource;
    }

    public void setDbSource(ConfigDbSource dbSource) {
        this.dbSource = dbSource;
    }
}
