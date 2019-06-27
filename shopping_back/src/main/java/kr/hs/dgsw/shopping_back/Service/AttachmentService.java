package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Protocol.AttachmentProtocol;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface AttachmentService {
    AttachmentProtocol upload(MultipartFile srcFile);

    void download(HttpServletResponse response, String type, Long id);
}
