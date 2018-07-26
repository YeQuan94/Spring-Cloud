package com.cave.sc.feign.consumerfeign.web;

import com.cave.sc.feign.consumerfeign.feign.ProviderFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FeignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignController.class);

    @Autowired
    private ProviderFeignClient providerFeignClient;

    @GetMapping("/map/{id}")
    public Map<String, String> provider(@PathVariable Long id){
        return this.providerFeignClient.provider(id);
    }

    @PostMapping("/map/map")
    public Map<String, String> parameter(@RequestBody Map<String, String> map){
        return this.providerFeignClient.parameter(map);
    }

}
