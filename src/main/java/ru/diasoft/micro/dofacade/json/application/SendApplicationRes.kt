package ru.diasoft.remote.json.application

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ru.diasoft.micro.dofacade.json.InputParams

@JsonClass(generateAdapter = true)
data class SendApplicationRes(

    @Json(name = "DOCUMENTID")
    val documentID: Int
) : InputParams()