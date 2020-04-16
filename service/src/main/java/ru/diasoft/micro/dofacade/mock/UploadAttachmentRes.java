package ru.diasoft.micro.dofacade.mock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadAttachmentRes {

    @JsonProperty("fileId")
    String fileId = "fileId";
    @JsonProperty("fileInfoId")
    Integer fileInfoId = 65454;
    @JsonProperty("fileName")
    String fileName = "fileName";
    @JsonProperty("fileSize")
    Integer fileSize = 89454;
    @JsonProperty("fileType")
    String fileType = "fileType";
    @JsonProperty("saveType")
    String saveType = "saveType";
    @JsonProperty("tempKey")
    String tempKey = "tempKey";

}
