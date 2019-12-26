package ru.diasoft.micro.dofacade.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendApplicationReq {

    @JsonProperty("clientData")
    ClientData clientData;
    @JsonProperty("attachmentList")
    List<SendApplicationAttachmentReq> attachmentList;

}
