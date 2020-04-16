package ru.diasoft.micro.dofacade.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanRes extends InputParams {

    @JsonProperty("LEAD_ID")
    Integer documentID = 234234;

    @JsonProperty("COMMENT")
    String comment = "555\nCOMMENT";

}
