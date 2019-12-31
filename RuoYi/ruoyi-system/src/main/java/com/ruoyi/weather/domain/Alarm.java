package com.ruoyi.weather.domain;

import lombok.Data;

/**
 * @Author 宋伟俊
 * @Date 2019/12/30 10:10
 **/
@Data
public class Alarm {
    private  String alarm_type;
    private  String alarm_level;
    private  String alarm_content;
}
