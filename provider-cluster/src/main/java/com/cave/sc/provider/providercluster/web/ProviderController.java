package com.cave.sc.provider.providercluster.web;

import com.cave.sc.provider.providercluster.annotation.LBAnnotation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProviderController {

    /**
     * 简单的测试，能够接受消费者的请求即可
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Map<String, String> provider(@PathVariable Long id){
        Map<String, String> map = new HashMap<>();
        map.put("key", "value:" + id);
        return map;
    }

    /**
     * Feign Server测试，参数传递Map
     * @param map
     * @return
     */
    @LBAnnotation
    @PostMapping("/map")
    public Map<String, String> parameter(@RequestBody Map<String, String> map){
        return map;
    }

}
