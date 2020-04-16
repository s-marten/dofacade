package ru.diasoft.micro.dofacade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.diasoft.micro.dofacade.mock.CreateLoanRes;
import ru.diasoft.micro.dofacade.mock.GetProductReq;
import ru.diasoft.micro.dofacade.mock.GetProductRes;
import ru.diasoft.micro.dofacade.mock.LoanReq;
import ru.diasoft.micro.dofacade.mock.PageflowItem;
import ru.diasoft.micro.dofacade.mock.PageflowReq;
import ru.diasoft.micro.dofacade.mock.PageflowRes;
import ru.diasoft.micro.dofacade.mock.ProductApplicationRes;
import ru.diasoft.micro.dofacade.mock.SendApplicationReq;
import ru.diasoft.micro.dofacade.mock.SendApplicationRes;
import ru.diasoft.micro.dofacade.mock.UploadAttachmentRes;

@RestController
public class DoFacadeController {

    @GetMapping(value = "/ping")
    public String ping() {
        return "OK (template)";
    }

    @PostMapping("api/pageflow/fabFTFWF/dsVirtualCardAppSave")
    public PageflowRes<SendApplicationRes> virtualCardAppSave(@RequestBody PageflowReq<SendApplicationReq> req) {
        var sendApplicationRes = new SendApplicationRes(1111);
        var pageflowItem = new PageflowItem<>(sendApplicationRes, "");
        return new PageflowRes<>("1", "1", pageflowItem, "1", "1");
    }

    @PostMapping("_upload")
    public PageflowRes<UploadAttachmentRes> uploadFile(@RequestPart(name = "file", required = false) MultipartFile file) {
        var item = new PageflowItem<>(new UploadAttachmentRes(), "");
        return new PageflowRes<>("1", "1", item, "1", "1");
    }

    @PostMapping("api/pageflow/FTFLOINTMVC/COMMON/dsLOSIntegrationLead")
    public PageflowRes<CreateLoanRes> loanCreateLead(@RequestBody PageflowReq<LoanReq> req) {
        var item = new PageflowItem<>(new CreateLoanRes(), "");
        return new PageflowRes<>("1", "1", item, "1", "1");
    }

    @PostMapping("api/pageflow/fabFTFWF/getApplication")
    public PageflowRes<GetProductRes> getProduct(@RequestBody PageflowReq<GetProductReq> req) {
        var item = new PageflowItem<>(new GetProductRes(new ProductApplicationRes()), "");
        return new PageflowRes<>("1", "1", item, "1", "1");
    }
}
