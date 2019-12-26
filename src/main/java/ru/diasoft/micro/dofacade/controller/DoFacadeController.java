package ru.diasoft.micro.dofacade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoFacadeController {

    @GetMapping(value = "/ping")
    public String ping() {
        return "OK (template)";
    }


//    @POST("api/pageflow/fabFTFWF/dsVirtualCardAppSave")
//    fun virtualCardAppSave(@Body req: PageflowReq<SendApplicationReq>): Call<PageflowRes<SendApplicationRes>>
//
//    @POST("api/pageflow/FTFLOINTMVC/COMMON/dsLOSIntegrationLead")
//    fun loanCreateLead(@Body req: PageflowReq<LoanReq>): Call<PageflowRes<CreateLoanRes>>
//
//    @POST("api/pageflow/fabFTFWF/getApplication")
//    fun getProduct(@Body req: PageflowReq<GetProductReq>): Call<PageflowRes<GetProductRes>>

}
