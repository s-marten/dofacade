package ru.diasoft.micro.dofacade.json

import com.fasterxml.jackson.annotation.JsonProperty

class PageflowRes<T>(

        @JsonProperty("instanceId")
        val instanceId: String?,
        @JsonProperty("type")
        val type: String?,
        @JsonProperty("item")
        val item: PageflowItem<T>,
        @JsonProperty("status")
        val status: String?,
        @JsonProperty("message")
        val message: String?
)

class PageflowItem<out T>(

        @JsonProperty("inputParams")
        val params: T,
        @JsonProperty("type")
        val type: String
)
