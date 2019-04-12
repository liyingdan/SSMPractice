package com.lyd.Converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*转换日期类型的数据
* S：页面传递过来的类型
* T：转换后的类型*/
public class DateConverter implements Converter<String,Date>{

    @Override
    public Date convert(String s) {
        if(s != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            try {
                return simpleDateFormat.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
