package com.wanxl.spring.cloud.weather.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * weather接口参数配置类
 * @author Lucifer
 * @date 2018／02／05 21:46
 */
@ConfigurationProperties("weather")
@Component
@Data
public class WeatherConfig {

    private String requestUrl;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
