package ru.diasoft.micro.dofacade.json.attachment

import com.fasterxml.jackson.annotation.JsonProperty


data class UploadAttachmentRes(

        @JsonProperty("fileId")
        val fileId: String = "",
        @JsonProperty("fileInfoId")
        val fileInfoId: Int? = null,
        @JsonProperty("fileName")
        val fileName: String = "",
        @JsonProperty("fileSize")
        val fileSize: Int = 0,
        @JsonProperty("fileType")
        val fileType: String = "",
        @JsonProperty("saveType")
        val saveType: String = "",
        @JsonProperty("tempKey")
        val tempKey: String = ""
)
