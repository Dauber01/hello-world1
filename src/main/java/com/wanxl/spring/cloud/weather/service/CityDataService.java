package com.wanxl.spring.cloud.weather.service;

import com.wanxl.spring.cloud.weather.vo.City;

import java.util.List;

/**
 * 城市数据服务
 * @author Lucifer
 * @date 2018／02／07 00:04
 */
public interface CityDataService {

    List<City> listCity() throws Exception;

}
