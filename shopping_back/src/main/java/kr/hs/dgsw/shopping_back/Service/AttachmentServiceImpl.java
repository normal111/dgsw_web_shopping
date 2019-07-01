package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Product;
import kr.hs.dgsw.shopping_back.Protocol.AttachmentProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    ProductService productService;

    @Override
    public AttachmentProtocol upload(MultipartFile srcFile) {
        String destFilePath = "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy\\MM\\dd\\"))
                + UUID.randomUUID().toString() + "_"
                + srcFile.getOriginalFilename();
        try {

            File destFile = new File(destFilePath);
            destFile.getParentFile().mkdirs();
            srcFile.transferTo(destFile);
            return new AttachmentProtocol(destFilePath, srcFile.getOriginalFilename());

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void download(HttpServletResponse response, String type, Long id) {
        try {
            String filePath;

            if (type.equalsIgnoreCase("product")) {
                Product product = this.productService.selectProduct(id);
                filePath = product.getImage();
            } else if (type.equalsIgnoreCase("comment")) {
                return;
            } else {
                return;
            }

            File file = new File(filePath);
            if (file.exists() == false) return;

            String mineType = URLConnection.guessContentTypeFromName(file.getName());
            if (mineType == null) mineType = "application/octet-stream";

            response.setContentType(mineType);
            response.setHeader("Content-Disposition", "inline; filename='제품이미지'");
            response.setContentLength((int) file.length());

            InputStream is = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(is, response.getOutputStream());
        } catch (Exception e) {
        }
    }
}
