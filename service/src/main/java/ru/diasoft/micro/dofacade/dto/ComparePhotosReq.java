package ru.diasoft.micro.dofacade.dto;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ComparePhotosReq {

    @NotNull
    private MultipartFile firstPhotoFile;

    @NotNull
    private MultipartFile secondPhotoFile;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private BigDecimal threshold;
}
