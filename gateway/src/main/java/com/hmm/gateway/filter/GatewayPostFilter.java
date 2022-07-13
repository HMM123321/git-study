//package com.hmm.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @Author hmm
// * @Date 2021/11/26 14:11
// */
//public class GatewayPostFilter implements GatewayFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        if (request.getMethod() != HttpMethod.POST){
//            return chain.filter(exchange);
//        }
//        return postExchange(exchange);
//    }
//    private Mono<Void> postExchange(ServerWebExchange exchange){
//        MediaType contentType = exchange.getRequest().getHeaders().getContentType();
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
