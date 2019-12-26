package com.ruoyi.web.controller.weather;

import java.util.List;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.weather.domain.City;
import com.ruoyi.weather.service.ICityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市Controller
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/system/city")
public class CityController extends BaseController
{
    private String prefix = "system/city";

    @Autowired
    private ICityService cityService;

    @RequiresPermissions("system:city:view")
    @GetMapping()
    public String city()
    {
        return prefix + "/city";
    }

    /**
     * 查询城市列表
     */
    @RequiresPermissions("system:city:list")
    @PostMapping("/list")
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
    @RequiresPermissions("system:city:export")
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
    @RequiresPermissions("system:city:add")
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
    @RequiresPermissions("system:city:edit")
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
    @RequiresPermissions("system:city:remove")
    @Log(title = "城市", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cityService.deleteCityByIds(ids));
    }
}
