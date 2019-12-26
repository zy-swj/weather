package com.ruoyi.weather.service.impl;

import java.util.List;

import com.ruoyi.weather.domain.City;
import com.ruoyi.weather.mapper.CityMapper;
import com.ruoyi.weather.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 城市Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
@Service
public class CityServiceImpl implements ICityService
{
    @Autowired
    private CityMapper cityMapper;

    /**
     * 查询城市
     * 
     * @param id 城市ID
     * @return 城市
     */
    @Override
    public City selectCityById(String id)
    {
        return cityMapper.selectCityById(id);
    }

    /**
     * 查询城市列表
     * 
     * @param city 城市
     * @return 城市
     */
    @Override
    public List<City> selectCityList(City city)
    {
        return cityMapper.selectCityList(city);
    }

    /**
     * 新增城市
     * 
     * @param city 城市
     * @return 结果
     */
    @Override
    public int insertCity(City city)
    {
        return cityMapper.insertCity(city);
    }

    /**
     * 修改城市
     * 
     * @param city 城市
     * @return 结果
     */
    @Override
    public int updateCity(City city)
    {
        return cityMapper.updateCity(city);
    }

    /**
     * 删除城市对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCityByIds(String ids)
    {
        return cityMapper.deleteCityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除城市信息
     * 
     * @param id 城市ID
     * @return 结果
     */
    @Override
    public int deleteCityById(String id)
    {
        return cityMapper.deleteCityById(id);
    }
}
