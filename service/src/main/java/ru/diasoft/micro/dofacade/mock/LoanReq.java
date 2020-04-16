package ru.diasoft.micro.dofacade.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanReq {
    @JsonProperty("NAME")
    String name;
    @JsonProperty("MOBILE_NUMBER")
    String mobileNumber;
    @JsonProperty("IC_NUMBER")
    String icNumber;
    @JsonProperty("LEAD_NUMBER")
    String leadNumber;
    @JsonProperty("LEAD_SOURCE")
    String leadSource;
    @JsonProperty("COMMENT")
    String comment;
}
