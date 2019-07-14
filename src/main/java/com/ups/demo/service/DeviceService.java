package com.ups.demo.service;

import com.ups.demo.dao.BrandTypeMapper;
import com.ups.demo.dao.DeviceMapper;
import com.ups.demo.dao.ModelSeriesMapper;
import com.ups.demo.dao.SeriesBrandMapper;
import com.ups.demo.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class DeviceService {

    @Autowired
    private DeviceListHome deviceListHome;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private ModelSeriesMapper modelSeriesMapper;
    @Autowired
    private SeriesBrandMapper seriesBrandMapper;
    @Autowired
    private BrandTypeMapper brandTypeMapper;
    @Autowired
    private Device device;
    @Autowired
    private ModelSeriesKey modelSeriesKey;
    @Autowired
    private SeriesBrandKey seriesBrandKey;
    @Autowired
    private BrandTypeKey brandTypeKey;
    //使用事物可以保证数据的一致性和完整性(避免异常和错误等导致的数据信息异常)

    //查询所有设备
    //返回值为一组用于展示的List集合数据 格式为jason
    @Transactional(readOnly = true)
    public List<DeviceListHome> getAllDevice() {
        try {
            Thread.sleep(10);
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        List<DeviceListHome> deviceListHomes = new ArrayList<>();
        List<Device> deviceList = deviceMapper.getAllDevice();
        Iterator<Device>iterator = deviceList.iterator();
        while (iterator.hasNext()) {
            //根据型号找出对应的类型
            device = iterator.next();
            String modelId = device.getStrModelId();
            String seriesId = null;
            String brandId = null;
            String typeId = null;
            //以下三个if皆为避免空指针异常(相关表并没有数据)
            if(modelSeriesMapper.selectModelSeries(modelId) != null) {
                seriesId = modelSeriesMapper.selectModelSeries(modelId).getStrSeriesId();

            }
            if(seriesBrandMapper.selectSeriesBrand(seriesId) != null) {
                brandId = seriesBrandMapper.selectSeriesBrand(seriesId).getStrBrandId();
            }
            if(brandTypeMapper.selectBrandType(brandId) != null) {
                typeId = brandTypeMapper.selectBrandType(brandId).getStrTyprId();
            }
            deviceListHome.setDevice_name(device.getStrDeviceName());
            deviceListHome.setDevice_id(device.getStrId());
            deviceListHome.setDevice_modle(modelId);
            deviceListHome.setDevice_type(typeId);
            deviceListHomes.add(deviceListHome);
        }
        return deviceListHomes;
    }

    //查询单个设备
    @Transactional(readOnly = true)
    public Device getDevice(String deviceId) {
        try {
            Thread.sleep(10);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return deviceMapper.selectByPrimaryKey(deviceId);
    }

    //

}
