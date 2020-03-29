package ru.diasoft.micro.dofacade.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SendApplicationAttachmentReq {

    @JsonProperty("FILENAME")
    String name;

    @JsonProperty("ATTNAME")
    String attName;

    @JsonProperty("FILESIZE")
    Integer size;

    @JsonProperty("ATTACHTYPENAME")
    String type;

    @JsonProperty("FILETYPE")
    String fileType;

    @JsonProperty("DISKFILENAME")
    String filePath;

    @JsonProperty("ATTSIZE")
    Integer attSize;

    @JsonProperty("ATTFILEPATH")
    String attFilePath;
}
