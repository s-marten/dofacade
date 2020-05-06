package ru.diasoft.micro.dqbiometricsid.dto;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class PhotoCompareReq {

    @NotNull
    private MultipartFile firstPhotoFile;

    @NotNull
    private MultipartFile secondPhotoFile;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private BigDecimal threshold;

    public MultipartFile getFirstPhotoFile() {
        return firstPhotoFile;
    }

    public void setFirstPhotoFile(MultipartFile firstPhotoFile) {
        this.firstPhotoFile = firstPhotoFile;
    }

    public MultipartFile getSecondPhotoFile() {
        return secondPhotoFile;
    }

    public void setSecondPhotoFile(MultipartFile secondPhotoFile) {
        this.secondPhotoFile = secondPhotoFile;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }
}
