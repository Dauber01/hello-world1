package com.wanxl.spring.cloud.weather.job;

import com.wanxl.spring.cloud.weather.service.WeatherDataCollectionService;
import com.wanxl.spring.cloud.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 定时工作的类
 * @author Lucifer
 * @date 2018／02／06 23:08
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean{

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("Weather data sync job start");
        //改为由城市数据API来提供数据
        List<City> cityList = null;
        try{
            cityList = new ArrayList<City>();
            City city = new City();
            city.setCityId("101280601");
            cityList.add(city);
        }catch (Exception e){
            log.error("ERROR" + e);
        }
        for (City city : cityList){
            String cityId = city.getCityId();
            log.info("Weather data sync job, cityId = {}",cityId);
            weatherDataCollectionService.sysncDataByCityId(cityId);
        }
        log.info("Weather data sync job end");
    }
}
