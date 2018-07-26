package com.cave.sc.feign.consumerfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * FeignClient中的name属性指向一个MicroServices名称
 * 该Client接口专门调用该服务
 * 同时集成了Eureka和Ribbon（注册中心和负载均衡）
 */
@FeignClient(name = "provider-cluster")
public interface ProviderFeignClient {

    // RESTFul传递普通参数和对象
    // @PathVariable一定需要添加value属性，并且指定内容，否则启动的时候会报错
    // 在FeignClient接口中和普通Controller不一样，Controller可以不指定，而Feign不行

    // Feign对于RESTFul的编写非常规范，因此要使用@RequestParam，@PathVariable，@RequestBody进行参数修饰

    @GetMapping("{id}")
    Map<String, String> provider(@PathVariable("id") Long id);

    @PostMapping("/map")
    Map<String, String> parameter(@RequestBody Map<String, String> map);

}
