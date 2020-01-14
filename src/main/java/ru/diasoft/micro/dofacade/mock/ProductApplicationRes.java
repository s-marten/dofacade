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
    String cardNumber = "1111 1111 1111 1111";

    @JsonProperty("DOCTYPENAME")
    String typeName = "Issue virtual card";

    @JsonProperty("STATE")
    String cardStatus = "Checks";

    @JsonProperty("DOCTYPESYSNAME")
    String productType = "virtualCardApp";

    @JsonProperty("Name")
    String cardHolder = "Demo User";

}
