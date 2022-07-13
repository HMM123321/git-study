//package com.hmm.gateway.config;
//
//import com.hmm.gateway.filter.GatewayRateLimitFilterByIp;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.Duration;
//
///**
// * @Author hmm
// * @Date 2021/9/7 16:48
// */
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//        Duration duration = Duration.ofSeconds(1);
//        return builder.routes()
//                .route(r -> r.path("/")
//                        .filters(f -> f.filter(new GatewayRateLimitFilterByIp(10,1,duration)))
//                        .uri("http://localhost:8081")
//                ).build();
//    }
//}
