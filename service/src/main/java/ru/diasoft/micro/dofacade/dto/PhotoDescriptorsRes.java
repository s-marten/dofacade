package ru.diasoft.micro.dofacade.dto;

import java.util.Map;

import ru.diasoft.micro.dofacade.model.descriptor.Descriptor;

public class PhotoDescriptorsRes {

    private Map<Long, Descriptor> descriptorMap;

    public Map<Long, Descriptor> getDescriptorMap() {
        return descriptorMap;
    }

    public void setDescriptorMap(Map<Long, Descriptor> descriptorMap) {
        this.descriptorMap = descriptorMap;
    }
}
