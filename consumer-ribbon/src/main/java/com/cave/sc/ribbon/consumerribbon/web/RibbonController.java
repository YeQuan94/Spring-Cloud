package com.cave.sc.ribbon.consumerribbon.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class RibbonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/map/{id}")
    public Map<String, String> getMap(@PathVariable Long id){
        // provider-cluster 是 application.yml中的 spring.application.name
        // 访问的是虚拟主机，默认情况下，虚拟主机与应用名称一致
        return this.restTemplate.getForObject("http://provider-cluster/" + id, Map.class);
    }

    @GetMapping("/log-detail")
    public void logDetail(){
        // 获取负载均衡后的提供者，并打印相关信息
        ServiceInstance instance = this.loadBalancerClient.choose("provider-cluster");
        RibbonController.LOGGER.info("{}:{}:{}", instance.getServiceId(), instance.getHost(), instance.getPort());
    }

}
