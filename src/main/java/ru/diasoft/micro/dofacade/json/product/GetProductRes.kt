package ru.diasoft.remote.json.product

import com.fasterxml.jackson.annotation.JsonProperty
import ru.diasoft.micro.dofacade.json.product.ProductApplicationRes
import ru.diasoft.micro.dofacade.json.InputParams

data class GetProductRes(

    @JsonProperty("application")
    val productApplication: ProductApplicationRes
) : InputParams()