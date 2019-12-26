package ru.diasoft.remote.json.loan

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ru.diasoft.domain.model.product.ProcessedApplication
import ru.diasoft.micro.dofacade.json.InputParams

@JsonClass(generateAdapter = true)
data class CreateLoanRes(

    @Json(name = "LEAD_ID")
    val documentID: Int,

    @Json(name = "COMMENT")
    val comment: String
) : InputParams()

fun CreateLoanRes.toLoanApplication() = ProcessedApplication(
    //Сумму нам присылают с сервака в том же виде, в котором мы отправляем
    amount = comment.substring(0, comment.indexOf("\n")),
    applicationId = documentID
)