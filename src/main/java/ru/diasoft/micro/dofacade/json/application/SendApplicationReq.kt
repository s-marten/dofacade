package ru.diasoft.micro.dofacade.json.application

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class SendApplicationReq(

        val clientData: ClientData,
        val attachmentList: List<SendApplicationAttachmentReq>
)

data class ClientData(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Sex")
    val sex: Int,

    @JsonProperty("BirthDate")
    val dateOfBirth: Date,

    @JsonProperty("IDcardNumber")
    val idCardNumber: String,

    val mobilePhone: String,

    @JsonProperty("IdentPercent")
    val identityPercent: Int,

    @JsonProperty("Citizenship")
    val citizenship: String = "Vietnam"
)

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


