package com.wanxl.spring.cloud.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 缓存数据中的城市信息
 * @author Lucifer
 * @date 2018／02／06 23:42
 */
@Data
public class City {

    /** 城市ID. */
    private String cityId;

    /** 城市名字. */
    private String cityName;

    /** 城市编码. */
    private String cityCode;

    /** 所属省份. */
    private String province;

}
