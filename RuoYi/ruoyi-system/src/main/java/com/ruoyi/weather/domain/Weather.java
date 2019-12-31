package com.ruoyi.weather.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author 宋伟俊
 * @Date 2019/12/30 23:08
 **/
@Data
public class Weather {
    private String cityid;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private WeatherData[] data;
}
