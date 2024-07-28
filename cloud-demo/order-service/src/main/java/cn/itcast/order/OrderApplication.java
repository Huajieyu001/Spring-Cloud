package cn.itcast.order;

import cn.itcast.feign.config.MyFeignConfiguration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import feign.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
// 导入feign-api依赖,OrderService提示UserClient没有bean的时候，需要在@EnableFeignClient注解的参数里添加参数，如下
// 可以使用basePackages = "cn.itcast.feign.clients"扫描包，也可以直接用clients = {UserClient.class}导入指定类
@EnableFeignClients(defaultConfiguration = MyFeignConfiguration.class, basePackages = "cn.itcast.feign.clients")
@ComponentScan("cn.itcast")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule gerRule(){
//        return new RandomRule();
//    }

//    @Bean
//    public Logger.Level getLevel(){
//        return Logger.Level.BASIC;
//    }
}