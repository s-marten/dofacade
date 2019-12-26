package ru.diasoft.micro.dofacade.json

import com.fasterxml.jackson.annotation.JsonProperty


open class InputParams(
        @JsonProperty("lastErrorMessage")
        var lastErrorMessage: String? = null
)