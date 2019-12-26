package ru.diasoft.micro.dofacade.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanReq {

    @JsonProperty("NAME")
    String name;

    @JsonProperty("MOBILE_NUMBER")
    String mobileNumber;

    @JsonProperty("LEAD_SOURCE")
    String leadSource;

    @JsonProperty("IC_NUMBER")
    String idCardNumber;

    @JsonProperty("LEAD_NUMBER")
    String identityPercent  = "RH_132";

}
