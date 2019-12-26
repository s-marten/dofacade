package ru.diasoft.micro.dofacade.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
