package ru.diasoft.micro.dofacade.dto;

import java.util.List;
import java.util.Objects;

public class PhotoCompareRes {

    private List<Long> photoIds = List.of();
    private boolean match;

    public List<Long> getPhotoIds() {
        return Objects.requireNonNullElse(photoIds, List.of());
    }

    public void setPhotoIds(List<Long> photoIds) {
        this.photoIds = photoIds == null ? List.of() : List.copyOf(photoIds);
    }

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }
}
