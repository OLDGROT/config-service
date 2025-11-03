package org.oldgrot.configservice.model;

import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
public class ServiceConfig {
    private String serviceName;
    private Map<String, Object> config;
}
