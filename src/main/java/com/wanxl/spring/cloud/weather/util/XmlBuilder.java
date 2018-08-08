package com.wanxl.spring.cloud.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * xml转换为Bean
 * @author Lucifer
 * @date 2018／02／06 23:55
 */
public class XmlBuilder {

    /**
     * 将xml转为Bean的pojo
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception{
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        reader = new StringReader(xmlStr);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        xmlObject = unmarshaller.unmarshal(reader);
        if (null != reader){
            reader.close();
        }
        return xmlObject;
    }

}
