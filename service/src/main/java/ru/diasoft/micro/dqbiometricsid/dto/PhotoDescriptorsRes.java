package ru.diasoft.micro.dqbiometricsid.dto;

import java.util.Map;

import ru.diasoft.micro.dqbiometricsid.model.descriptor.Descriptor;

public class PhotoDescriptorsRes {

    private Map<Long, Descriptor> descriptorMap;

    public Map<Long, Descriptor> getDescriptorMap() {
        return descriptorMap;
    }

    public void setDescriptorMap(Map<Long, Descriptor> descriptorMap) {
        this.descriptorMap = descriptorMap;
    }
}
