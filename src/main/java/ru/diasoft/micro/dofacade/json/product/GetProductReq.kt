package ru.diasoft.remote.json.product

import com.fasterxml.jackson.annotation.JsonProperty

data class GetProductReq(

    @JsonProperty("DOCUMENTID")
    val documentId: Int
)