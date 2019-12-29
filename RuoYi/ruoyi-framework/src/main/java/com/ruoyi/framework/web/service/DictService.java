package com.ruoyi.framework.web.service;

import java.util.List;

import com.ruoyi.weather.domain.City;
import com.ruoyi.weather.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 * 
 * @author ruoyi
 */
@Service("dict")
public class DictService
{
    @Autowired
    private ISysDictDataService dictDataService;
    @Autowired
    private ICityService cityDataService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictData> getType(String dictType)
    {
        return dictDataService.selectDictDataByType(dictType);
    }

    /**
     *查询城市列表
     * @return
     */
    public List<City> getCityType(){
        return cityDataService.selectCityList(new City());
    }
    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }
}
