package com.wanxl.spring.cloud.initializrstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lucifer
 * @do 注入一个map
 * @date 2018/07/10 14:39
 */
@Configuration
@ImportResource(locations = {"classpath:application-bean.xml"})
public class MapConfigration {

   /* @Bean
    public Map<String, String> getSourceMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "heihei");
        map.put("2", "haha");
        map.put("3", "xixi");
        return map;
    }*/

}
