package ru.diasoft.micro.dofacade.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date




data class SendApplicationAttachmentReq(

    @JsonProperty("FILENAME")
    val name: String,

    @JsonProperty("ATTNAME")
    val attName: String,

    @JsonProperty("FILESIZE")
    val size: Int,

    @JsonProperty("ATTACHTYPENAME")
    val type: String,

    @JsonProperty("FILETYPE")
    val fileType: String,

    @JsonProperty("DISKFILENAME")
    val filePath: String,

    @JsonProperty("ATTSIZE")
    val attSize: Int,

    @JsonProperty("ATTFILEPATH")
    val attFilePath: String
)


