package org.RedInJector.ConfigManager;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Config {
    private static final String CONFIG_FILE = "config.yml";
    private static Map<String, Object> config;

    public static void loadConfig() {
        Yaml yaml = new Yaml();
        InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        config = yaml.load(inputStream);
    }

    public static String getValue(String key) {

        Map<String, Object> localobject = config;

        String[] substrings = key.split("\\.");
        int n = 1;
        Object object = null;
        for (String substring : substrings) {
            if (substrings.length != n) {
                localobject = (Map<String, Object>) localobject.get(substring);
            } else
                object = localobject.get(substring);
            n++;
        }
        if(object == null)
            return "Not Found";

        return object.toString();
    }
}
