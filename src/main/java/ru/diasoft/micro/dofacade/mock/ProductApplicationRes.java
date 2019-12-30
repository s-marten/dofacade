package ru.diasoft.micro.dofacade.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductApplicationRes {

    @JsonProperty("CardNumber")
    String cardNumber = "1111111111111111";

    @JsonProperty("DOCTYPENAME")
    String typeName = "VIRTUALCARD";

    @JsonProperty("STATE")
    String cardStatus = "inProgress";

    @JsonProperty("DOCTYPESYSNAME")
    String productType = "name";

    @JsonProperty("Name")
    String cardHolder = "Demo user";

}
