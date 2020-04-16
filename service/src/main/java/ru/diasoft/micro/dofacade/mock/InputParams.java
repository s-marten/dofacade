package ru.diasoft.micro.dofacade.mock;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputParams {

    @JsonProperty("lastErrorMessage")
    String lastErrorMessage;

}
