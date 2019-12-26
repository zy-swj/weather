package com.ruoyi.weather.mapper;

import com.ruoyi.weather.domain.City;

import java.util.List;

/**
 * 城市Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
public interface CityMapper 
{
    /**
     * 查询城市
     * 
     * @param id 城市ID
     * @return 城市
     */
    public City selectCityById(String id);

    /**
     * 查询城市列表
     * 
     * @param city 城市
     * @return 城市集合
     */
    public List<City> selectCityList(City city);

    /**
     * 新增城市
     * 
     * @param city 城市
     * @return 结果
     */
    public int insertCity(City city);

    /**
     * 修改城市
     * 
     * @param city 城市
     * @return 结果
     */
    public int updateCity(City city);

    /**
     * 删除城市
     * 
     * @param id 城市ID
     * @return 结果
     */
    public int deleteCityById(String id);

    /**
     * 批量删除城市
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCityByIds(String[] ids);
}
