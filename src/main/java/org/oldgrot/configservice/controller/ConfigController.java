package org.oldgrot.configservice.controller;


import lombok.RequiredArgsConstructor;
import org.oldgrot.configservice.model.ServiceConfig;
import org.oldgrot.configservice.service.ConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/config")
public class ConfigController {

    private final ConfigService configService;

    @GetMapping("/{serviceName}")
    public ResponseEntity<ServiceConfig> getConfig(@PathVariable String serviceName) {
        return ResponseEntity.ok(configService.getConfig(serviceName));
    }
}

