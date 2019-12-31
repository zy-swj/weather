package com.ruoyi.web.controller.weather;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.weather.domain.City;
import com.ruoyi.weather.domain.Weather;
import com.ruoyi.weather.domain.WeatherData;
import com.ruoyi.weather.service.ICityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 城市Controller
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/system/week")
public class WeekController extends BaseController
{
    private String prefix = "system/week";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ICityService cityService;
private static final String  WEATHER_URI="https://www.tianqiapi.com/api/?version=v1&appid=75279447&appsecret=KxodR2FL&cityid=";
    @RequiresPermissions("system:week:view")
    @GetMapping()
    public String city()
    {
        return prefix + "/week";
    }

    /**
     * 查询城市天气
     * @return
     */
    @GetMapping("/findCityWeather")
    @ResponseBody
    public Weather cityWeather(String cityName, String cityId){
        ResponseEntity<Weather> responseEntity= restTemplate.getForEntity(WEATHER_URI+cityId,Weather.class);
        Weather weather =responseEntity.getBody();
        return weather;
    }
    /**
     * 查询城市列表
     */
    @RequiresPermissions("system:week:list")
    @PostMapping("/week")
    @ResponseBody
    public TableDataInfo list(City city)
    {
        startPage();
        List<City> list = cityService.selectCityList(city);
        return getDataTable(list);
    }

    /**
     * 导出城市列表
     */
    @RequiresPermissions("system:week:export")
    @Log(title = "城市", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(City city)
    {
        List<City> list = cityService.selectCityList(city);
        ExcelUtil<City> util = new ExcelUtil<City>(City.class);
        return util.exportExcel(list, "city");
    }

    /**
     * 新增城市
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存城市
     */
    @RequiresPermissions("system:week:add")
    @Log(title = "城市", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(City city)
    {
        return toAjax(cityService.insertCity(city));
    }

    /**
     * 修改城市
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        City city = cityService.selectCityById(id);
        mmap.put("city", city);
        return prefix + "/edit";
    }

    /**
     * 修改保存城市
     */
    @RequiresPermissions("system:week:edit")
    @Log(title = "城市", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(City city)
    {
        return toAjax(cityService.updateCity(city));
    }

    /**
     * 删除城市
     */
    @RequiresPermissions("system:week:remove")
    @Log(title = "城市", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cityService.deleteCityByIds(ids));
    }
}
