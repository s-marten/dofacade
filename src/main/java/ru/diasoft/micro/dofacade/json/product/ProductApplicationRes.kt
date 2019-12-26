package ru.diasoft.micro.dofacade.json.product

import com.fasterxml.jackson.annotation.JsonProperty


data class ProductApplicationRes(

    @JsonProperty("CardNumber")
    val cardNumber: String?,

    @JsonProperty("DOCTYPENAME")
    val typeName: String?,

    @JsonProperty("STATE")
    val cardStatus: String,

    @JsonProperty("DOCTYPESYSNAME")
    val productType: String,

    @JsonProperty("Name")
    val cardHolder: String
)