package ru.diasoft.micro.dofacade.json

import com.fasterxml.jackson.annotation.JsonProperty


class PageflowReq<T>(

        @JsonProperty("pfParams")
        val params: T,
        @JsonProperty("operation")
        val operation: String = "START"
)