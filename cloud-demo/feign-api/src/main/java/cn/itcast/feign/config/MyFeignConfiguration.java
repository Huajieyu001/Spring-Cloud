package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class MyFeignConfiguration {

    @Bean
    public Logger.Level getLevel(){
        return Logger.Level.BASIC;
    }
}
