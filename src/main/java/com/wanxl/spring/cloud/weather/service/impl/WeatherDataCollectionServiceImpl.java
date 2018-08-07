package com.wanxl.spring.cloud.weather.service.impl;

import com.wanxl.spring.cloud.weather.config.WeatherConfig;
import com.wanxl.spring.cloud.weather.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * weather data collection service
 * @author Lucifer
 * @date 2018／02／15 15:48
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService{

    @Autowired
    private WeatherConfig weatherConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void sysncDataByCityId(String cityId) {
        String url = weatherConfig.getRequestUrl() + "citykey=" + cityId;
        saveWeatherData(url);
    }

    private void saveWeatherData(String url){
        //先查询redis缓存,缓存有,获取缓存中的数据
        String responseBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //缓存没有,调用接口获取数据
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        if (responseEntity.getStatusCodeValue() == 200){
            responseBody = responseEntity.getBody();
            ops.set(url,responseBody,10, TimeUnit.SECONDS);
        }
    }


}
