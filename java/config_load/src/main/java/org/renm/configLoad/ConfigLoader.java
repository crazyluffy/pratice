package org.renm.configLoad;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class ConfigLoader {
    private ConfigSource source;
    private ConfigDisplay display;

    public ConfigLoader(ConfigSource source) {
        this.source = source;
    }

    public ConfigLoader(ConfigSource source, ConfigDisplay display) {
        this.source = source;
        this.display = display;
    }

    public ConfigDisplay getDisplay() {
        return display;
    }

    public void setDisplay(ConfigDisplay display) {
        this.display = display;
    }

    @PostConstruct
    private void init() {
        List<ConfigLoad> sources = allSource();
        for (ConfigLoad configLoad : sources) {
            Config config = configLoad.load();
            show(config);
        }
    }

    private List<ConfigLoad> allSource() {
        ArrayList<ConfigLoad> list = new ArrayList<ConfigLoad>();
        list.add(source.getDbSource());
        list.add(source.getFileSource());
        return list;
    }

    private void show(Config config) {
        ConfigDisplay display = getDisplay();
        if (display != null) {
            display.display(config);
        } else {
            System.out.println(config);
        }

    }

}
