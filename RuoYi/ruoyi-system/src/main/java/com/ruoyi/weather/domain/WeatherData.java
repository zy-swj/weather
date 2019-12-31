package com.ruoyi.weather.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author 宋伟俊
 * @Date 2019/12/30 10:01
 **/
@lombok.Data
public class WeatherData {
    private String day;
    private String date;
    private String week;
    private String wea;
    private String air;
    private String air_level;
    private String air_tips;
   // private List<Alarm> alarm;
    private String tem;
    private String tem1;
    private String tem2;
    private String[] win;
    private String win_speed;
    private List<Hours> hours;
    private List<IndexNumber> index;
}
