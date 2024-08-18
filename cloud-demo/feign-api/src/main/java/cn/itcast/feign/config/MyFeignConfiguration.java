package cn.itcast.feign.config;

//import cn.itcast.feign.factory.UserClientFallbackFactory;
import cn.itcast.feign.factory.UserClientFallbackFactory;
import feign.Logger;
import org.springframework.context.annotation.Bean;

public class MyFeignConfiguration {

    @Bean
    public Logger.Level getLevel(){
        return Logger.Level.BASIC;
    }

    @Bean
    public UserClientFallbackFactory createUserClientFallbackFactory(){
        return new UserClientFallbackFactory();
    }
}
