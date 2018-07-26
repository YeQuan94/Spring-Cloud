package com.cave.sc.hystrix.consumerhystrix.web;

import com.cave.sc.hystrix.consumerhystrix.feign.ProviderFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HystrixController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixController.class);

    @Autowired
    private ProviderFeignClient providerFeignClient;

    // @HystrixCommand参数非常多，到时候需要详细配置
    @HystrixCommand(fallbackMethod = "fallback")
    @PostMapping("/map/map")
    public Map<String, String> parameter(@RequestBody Map<String, String> map){
        return this.providerFeignClient.parameter(map);
    }

    // 回调方法
    public Map<String, String> fallback(Map<String, String> map){
        map.put("a", "a");
        return map;
    }

}
