package com.wanxl.spring.cloud.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * xml转Bean的中间类
 * @author Lucifer
 * @date 2018／02／06 23:52
 */
@Data
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    /** 城市列表. */
    @XmlElement(name = "d")
    private List<City> cityList;

}
