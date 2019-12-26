package ru.diasoft.micro.dofacade.json.application

import com.fasterxml.jackson.annotation.JsonProperty

data class LoanReq(
    @JsonProperty("NAME")
    val name: String,
    @JsonProperty("MOBILE_NUMBER")
    val mobileNumber: String,
    @JsonProperty("IC_NUMBER")
    val icNumber: String,
    @JsonProperty("LEAD_NUMBER")
    val leadNumber: String,
    @JsonProperty("LEAD_SOURCE")
    val leadSource: String,
    @JsonProperty("COMMENT")
    val comment: String
)
