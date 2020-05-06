package ru.diasoft.micro.dqbiometricsid.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

public class PhotoDescriptorsReq {

    @NotNull
    private List<Long> photoIds;

    public List<Long> getPhotoIds() {
        return photoIds;
    }

    public void setPhotoIds(List<Long> photoIds) {
        this.photoIds = photoIds;
    }
}
