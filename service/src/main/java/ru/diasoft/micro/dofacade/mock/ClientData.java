package ru.diasoft.micro.dofacade.mock;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientData {

    @JsonProperty("Name")
    String name;

    @JsonProperty("Sex")
    Integer sex;

    @JsonProperty("BirthDate")
    Date dateOfBirth;

    @JsonProperty("IDcardNumber")
    String idCardNumber;

    @JsonProperty("mobilePhone")
    String mobilePhone;

    @JsonProperty("IdentPercent")
    Integer identityPercent;

    @JsonProperty("Citizenship")
    String citizenship = "Vietnam";

}
