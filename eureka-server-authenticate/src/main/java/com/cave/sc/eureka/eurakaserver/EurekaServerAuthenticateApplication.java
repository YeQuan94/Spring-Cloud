package com.cave.sc.eureka.eurakaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableGlobalMethodSecurity
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerAuthenticateApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerAuthenticateApplication.class, args);
    }

    /**
     * 当我们添加了@EnableGlobalMethodSecurity并且没有配置UserDetailsService时
     * 启动SpringBoot，在控制台会打印出密码，账号是：user
     * Using generated security password: 6f0cc537-324b-4cb2-a8f3-000e8e7675d6
     */

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // 在password中一定要添加{noop}，否则会出现
        // java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
        // 或者使用BCryptPasswordEncoder加密
        manager.createUser(User.withUsername("user").password("{noop}password").roles("USER").build());
        return manager;
    }

}
