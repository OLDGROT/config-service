package org.oldgrot.configservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.oldgrot.configservice.model.ServiceConfig;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ConfigService {

    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    private final String CONFIG_DIR = "configs";

    public ServiceConfig getConfig(String serviceName) {
        File file = new File(CONFIG_DIR + "/" + serviceName + ".yml");
        if (!file.exists()) {
            throw new RuntimeException("Configuration not found for " + serviceName);
        }

        try {
            Map<String, Object> props = mapper.readValue(file, Map.class);
            ServiceConfig config = new ServiceConfig();
            config.setServiceName(serviceName);
            config.setConfig(props);
            return config;
        } catch (IOException e) {
            throw new RuntimeException("Error reading config for " + serviceName, e);
        }
    }
}
