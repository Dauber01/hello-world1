package com.wanxl.spring.cloud.weather.controller;

import com.wanxl.spring.cloud.weather.service.CityDataService;
import com.wanxl.spring.cloud.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 城市数据响应接口
 * @author Lucifer
 * @date 2018／02／27 00:26
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception{
        return cityDataService.listCity();
    }

}
