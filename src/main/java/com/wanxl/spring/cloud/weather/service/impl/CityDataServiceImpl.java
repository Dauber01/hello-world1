package com.wanxl.spring.cloud.weather.service.impl;

import com.wanxl.spring.cloud.weather.service.CityDataService;
import com.wanxl.spring.cloud.weather.util.XmlBuilder;
import com.wanxl.spring.cloud.weather.vo.City;
import com.wanxl.spring.cloud.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 城市数据服务
 * @author Lucifer
 * @date 2018／02／07 00:06
 */
@Service
public class CityDataServiceImpl implements CityDataService{

    @Override
    public List<City> listCity() throws Exception {
        //读取xml文件内容
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = bf.readLine()) != null){
            buffer.append(line);
        }
        bf.close();
        //将文件内容转换为object
        CityList cityList = (CityList)XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
        return cityList.getCityList();
    }
}
