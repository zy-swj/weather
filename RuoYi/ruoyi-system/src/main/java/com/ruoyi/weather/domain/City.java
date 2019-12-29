package com.ruoyi.weather.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 城市对象 city
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
public class City extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** $column.columnComment */
    @Excel(name = "城市英文", readConverterExp = "$column.readConverterExp()")
    private String cityen;

    /** $column.columnComment */
    @Excel(name = "城市中文", readConverterExp = "$column.readConverterExp()")
    private String cityzh;

    /** $column.columnComment */
    @Excel(name = "省英文", readConverterExp = "$column.readConverterExp()")
    private String provinceen;

    /** $column.columnComment */
    @Excel(name = "省中文", readConverterExp = "$column.readConverterExp()")
    private String provincezh;

    /** $column.columnComment */
    @Excel(name = "国家英文", readConverterExp = "$column.readConverterExp()")
    private String countryen;

    /** $column.columnComment */
    @Excel(name = "国家中文", readConverterExp = "$column.readConverterExp()")
    private String countryzh;

    /** $column.columnComment */
    @Excel(name = "省会(英)", readConverterExp = "$column.readConverterExp()")
    private String leaderen;

    /** $column.columnComment */
    @Excel(name = "省会(中)", readConverterExp = "$column.readConverterExp()")
    private String leaderzh;

    /** $column.columnComment */
    @Excel(name = "经度", readConverterExp = "$column.readConverterExp()")
    private String lat;

    /** $column.columnComment */
    @Excel(name = "纬度", readConverterExp = "$column.readConverterExp()")
    private String lon;


    public String getId() 
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public void setCityen(String cityen) 
    {
        this.cityen = cityen;
    }

    public String getCityen() 
    {
        return cityen;
    }


    public String getCityzh() 
    {
        return cityzh;
    }
    public void setCityzh(String cityzh)
    {
        this.cityzh = cityzh;
    }
    public void setProvinceen(String provinceen) 
    {
        this.provinceen = provinceen;
    }

    public String getProvinceen() 
    {
        return provinceen;
    }
    public void setProvincezh(String provincezh) 
    {
        this.provincezh = provincezh;
    }

    public String getProvincezh() 
    {
        return provincezh;
    }
    public void setCountryen(String countryen) 
    {
        this.countryen = countryen;
    }

    public String getCountryen() 
    {
        return countryen;
    }
    public void setCountryzh(String countryzh) 
    {
        this.countryzh = countryzh;
    }

    public String getCountryzh() 
    {
        return countryzh;
    }
    public void setLeaderen(String leaderen) 
    {
        this.leaderen = leaderen;
    }

    public String getLeaderen() 
    {
        return leaderen;
    }
    public void setLeaderzh(String leaderzh) 
    {
        this.leaderzh = leaderzh;
    }

    public String getLeaderzh() 
    {
        return leaderzh;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }
    public void setLon(String lon) 
    {
        this.lon = lon;
    }

    public String getLon() 
    {
        return lon;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cityen", getCityen())
            .append("cityzh", getCityzh())
            .append("provinceen", getProvinceen())
            .append("provincezh", getProvincezh())
            .append("countryen", getCountryen())
            .append("countryzh", getCountryzh())
            .append("leaderen", getLeaderen())
            .append("leaderzh", getLeaderzh())
            .append("lat", getLat())
            .append("lon", getLon())
            .toString();
    }
}
