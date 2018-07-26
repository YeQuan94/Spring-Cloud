package com.cave.sc.config.cloudconfigclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YMLController {

    @Value("${profiles}")
    private String profiles;

    @RequestMapping("/profiles")
    public String profiles(){
        return this.profiles;
    }

}
