package ru.diasoft.micro.dofacade.json.loan

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateLoanReq(

    @JsonProperty("NAME")
    val name: String,

    @JsonProperty("MOBILE_NUMBER")
    val mobileNumber: String,

    @JsonProperty("LEAD_SOURCE")
    val leadSource: String,

    @JsonProperty("IC_NUMBER")
    val idCardNumber: String,

    @JsonProperty("LEAD_NUMBER")
    val identityPercent: String = "RH_132"
)

