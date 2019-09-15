package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceGroupShow {

    private int id;

    private String label;

    private String type;

    private Boolean show;

    private List<DeviceGroupShow> children = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public List<DeviceGroupShow> getDeviceGroupShows() {
        return children;
    }

    public void addDeviceGroupShows(DeviceGroupShow deviceGroupShow) {
        this.children.add(deviceGroupShow);
    }

    public List<DeviceGroupShow> findChildren(List<DeviceGroup> deviceGroups) {
        List<DeviceGroupShow> deviceGroupShowList = new ArrayList<>();
        String[] childrenId = null;
        for(DeviceGroup deviceGroup: deviceGroups) {
            if(deviceGroup.getStrType().equals("parent")) {
                DeviceGroupShow deviceGroupShow = new DeviceGroupShow();
                deviceGroupShow.setId(deviceGroup.getIntId());
                deviceGroupShow.setLabel(deviceGroup.getStrLabel());
                deviceGroupShow.setType(deviceGroup.getStrType());
                deviceGroupShow.setShow(Boolean.parseBoolean(deviceGroup.getStrShow()));
                if(deviceGroup.getStrChildren() != null) {
                    childrenId = deviceGroup.getStrChildren().split(";");
                    for(String id : childrenId) {
                        int childId = Integer.parseInt(id);
                        for(DeviceGroup deviceGroup2 : deviceGroups) {
                            if(deviceGroup2.getStrType().equals("parent")) { continue; }
                            else {
                                if(deviceGroup2.getIntId() == childId) {
                                    DeviceGroupShow deviceGroupShow2 = new DeviceGroupShow();
                                    deviceGroupShow2.setId(deviceGroup2.getIntId());
                                    deviceGroupShow2.setLabel(deviceGroup2.getStrLabel());
                                    deviceGroupShow2.setType(deviceGroup2.getStrType());
                                    deviceGroupShow2.setShow(Boolean.parseBoolean(deviceGroup2.getStrShow()));
                                    deviceGroupShow.addDeviceGroupShows(deviceGroupShow2);
                                }
                            }
                        }
                    }
                }
                deviceGroupShowList.add(deviceGroupShow);
            }else {
                continue;
            }
        }
        return deviceGroupShowList;
    }
}
