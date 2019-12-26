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
    String cardNumber = "654654654654";

    @JsonProperty("DOCTYPENAME")
    String typeName = "DOCTYPENAME";

    @JsonProperty("STATE")
    String cardStatus = "STATE";

    @JsonProperty("DOCTYPESYSNAME")
    String productType = "name";

    @JsonProperty("Name")
    String cardHolder = "name";

}
