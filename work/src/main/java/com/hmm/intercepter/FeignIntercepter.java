package com.hmm.intercepter;

import feign.RequestTemplate;
import org.springframework.cloud.openfeign.encoding.BaseRequestInterceptor;
import org.springframework.cloud.openfeign.encoding.FeignClientEncodingProperties;

import java.util.UUID;

/**
 * @Author hmm
 * @Date 2022/9/15 09:37
 */
public class FeignIntercepter extends BaseRequestInterceptor {
    /**
     * Creates new instance of {@link BaseRequestInterceptor}.
     *
     * @param properties the encoding properties
     */
    protected FeignIntercepter(FeignClientEncodingProperties properties) {
        super(properties);
    }

    @Override
    public void apply(RequestTemplate template) {
        String access_token = "IAmToken"+ UUID.randomUUID().toString();
        template.header("Authorization",access_token);
    }
}
