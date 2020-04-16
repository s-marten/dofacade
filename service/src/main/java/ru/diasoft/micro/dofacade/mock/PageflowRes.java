package ru.diasoft.micro.dofacade.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageflowRes<T> {

    @JsonProperty("instanceId")
    String instanceId;
    @JsonProperty("type")
    String type;
    @JsonProperty("item")
    PageflowItem<T> item;
    @JsonProperty("status")
    String status;
    @JsonProperty("message")
    String message;

}
