package com.wanxl.spring.cloud.weather.service;

/**
 * weather data collection service
 * @author Lucifer
 * @date 2018／02／15 15:43
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市id同步天气
     * @param cityId
     */
    void sysncDataByCityId(String cityId);

}
