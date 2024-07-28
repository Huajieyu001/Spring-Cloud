package cn.itcast.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Order(0) // 设置顺序，也可以实现Ordered来设置
public class VerifyFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取request：这边不是servlet中的request
        ServerHttpRequest request = exchange.getRequest();
        // 获取参数Map
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        // 获取具体参数
        String authorization = queryParams.getFirst("Authorization");
        if("admin".equals(authorization)){
            // 放行
            return chain.filter(exchange);
        }
        // 拦截

        // 设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        // 实施拦截
        return exchange.getResponse().setComplete();
    }
}
