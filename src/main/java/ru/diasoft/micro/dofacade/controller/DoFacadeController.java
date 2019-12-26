package ru.diasoft.micro.dofacade.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.diasoft.micro.dofacade.mock.*;


@RestController
public class DoFacadeController {

    @GetMapping(value = "/ping")
    public String ping() {
        return "OK (template)";
    }

    @PostMapping("api/pageflow/fabFTFWF/dsVirtualCardAppSave")
    public PageflowRes<SendApplicationRes> virtualCardAppSave(@RequestBody PageflowReq<SendApplicationReq> req) {
        PageflowItem<SendApplicationRes> item = new PageflowItem<>(
                new SendApplicationRes(
                        1111
                ),
                ""
        );
        return new PageflowRes<SendApplicationRes>(
                "1",
                "1",
                item,
                "1",
                "1"
        );
    }

        @PostMapping("_upload")
    public PageflowRes<UploadAttachmentRes> uploadFile(@RequestPart(name = "file", required = false) MultipartFile file) {
            PageflowItem<UploadAttachmentRes> item = new PageflowItem<>(
                    new UploadAttachmentRes(),
                    ""
            );
            return new PageflowRes<UploadAttachmentRes>(
                    "1",
                    "1",
                    item,
                    "1",
                    "1"
            );
    }


    @PostMapping("api/pageflow/FTFLOINTMVC/COMMON/dsLOSIntegrationLead")
    public PageflowRes<CreateLoanRes> loanCreateLead(@RequestBody PageflowReq<LoanReq> req) {
        PageflowItem<CreateLoanRes> item = new PageflowItem<>(
                new CreateLoanRes(),
                ""
        );
        return new PageflowRes<CreateLoanRes>(
                "1",
                "1",
                item,
                "1",
                "1"
        );
    }

    @PostMapping("api/pageflow/fabFTFWF/getApplication")
    public PageflowRes<GetProductRes> getProduct(@RequestBody PageflowReq<GetProductReq> req) {
        PageflowItem<GetProductRes> item = new PageflowItem<>(
                new GetProductRes(new ProductApplicationRes()),
                ""
        );
        return new PageflowRes<GetProductRes>(
                "1",
                "1",
                item,
                "1",
                "1"
        );
    }


    //    @Multipart
//    @POST("_upload")
//    fun uploadFile(@Part("description") description: RequestBody, @Part file: MultipartBody.Part): Call<UploadAttachmentRes>


}
