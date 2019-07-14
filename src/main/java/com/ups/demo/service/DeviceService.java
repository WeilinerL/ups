package com.ups.demo.service;

import com.ups.demo.dao.*;
import com.ups.demo.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
    private DataMapper dataMapper;
    @Autowired
    private Device device;
    @Autowired
    private ModelSeriesKey modelSeriesKey;
    @Autowired
    private SeriesBrandKey seriesBrandKey;
    @Autowired
    private BrandTypeKey brandTypeKey;
    @Autowired
    private Data data;
    //使用事物可以保证数据的一致性和完整性(避免异常和错误等导致的数据信息异常)


    //查询所有设备
    //返回值为一组用于展示的List集合数据 格式为jason
    @Scheduled(cron = "* 0/5 * * * ?") //每五分钟执行一次(数据五分钟采集一次)
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
                //根据型号查对应的系列
                seriesId = modelSeriesMapper.selectModelSeries(modelId).getStrSeriesId();

            }
            if(seriesBrandMapper.selectSeriesBrand(seriesId) != null) {
                //根据系列查对应的品牌
                brandId = seriesBrandMapper.selectSeriesBrand(seriesId).getStrBrandId();
            }
            if(brandTypeMapper.selectBrandType(brandId) != null) {
                //根据品牌查对应的类型
                typeId = brandTypeMapper.selectBrandType(brandId).getStrTyprId();
            }
            deviceListHome.setDevice_name(device.getStrDeviceName());
            deviceListHome.setDevice_id(device.getStrId());
            deviceListHome.setDevice_modle(modelId);
            deviceListHome.setDevice_type(typeId);
            deviceListHome.setDevice_status(alarmCheck());
            deviceListHomes.add(deviceListHome);
        }
        return deviceListHomes;
    }

    /**
     * 采集在系统当前时间左右五分钟内的所匹配的数据
     * @return
     */

    public String alarmCheck() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date now = new Date();
        //当前时间向前加五分钟或者向后减五分钟
        //用于捕获采集存储到相应表里的数据
        String date = sdf.format(new Date(now.getTime()));
        String date1 = sdf.format(new Date(now.getTime() + 60000));
        String date2 = sdf.format(new Date(now.getTime() + 120000));
        String date3 = sdf.format(new Date(now.getTime() + 180000));
        String date4 = sdf.format(new Date(now.getTime() + 240000));
        String date5 = sdf.format(new Date(now.getTime() + 300000));
        String date6 = sdf.format(new Date(now.getTime() - 60000));
        String date7 = sdf.format(new Date(now.getTime() - 120000));
        String date8 = sdf.format(new Date(now.getTime() - 180000));
        String date9 = sdf.format(new Date(now.getTime() - 240000));
        String date10 = sdf.format(new Date(now.getTime() - 300000));
        data = dataMapper.selectByTime("%" + date + "%", "%" + date1 + "%", "%" + date2 + "%", "%" + date3 + "%", "%" + date4 + "%", "%" + date5 + "%",
                "%" + date6 + "%", "%" + date7 + "%", "%" + date8 + "%", "%" + date9 + "%", "%" + date10 + "%");
        if(data != null) {
            if(data.getDoubleParsedValues().equals("0") || data.getStrDataType().equals("状态量")) {
                return "正常";
            }else {
                return "异常";
            }
        }
        return "暂无数据";
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
