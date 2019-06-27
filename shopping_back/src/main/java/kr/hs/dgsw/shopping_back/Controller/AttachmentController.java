package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Protocol.AttachmentProtocol;
import kr.hs.dgsw.shopping_back.Service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/attachment")
    public AttachmentProtocol upload(@RequestPart MultipartFile srcFile) {
        return this.attachmentService.upload(srcFile);
    }

    @GetMapping("/download/{type}/{id}")
    public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable String type, @PathVariable Long id) {
        this.attachmentService.download(response, type, id);
    }
}