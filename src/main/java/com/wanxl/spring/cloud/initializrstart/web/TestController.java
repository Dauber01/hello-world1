package com.wanxl.spring.cloud.initializrstart.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author Lucifer
 * @do
 * @date 2018/06/13 16:16
 */
@RestController
public class TestController {

    @RequestMapping(value="/getpdf", method= RequestMethod.GET)
    public ResponseEntity<byte[]> getPDF() {
        try{
            // 读取pdf文件到字节里
            Path path = Paths.get("E:\\DevelopmentInstallationPackage\\ORACLE_PLSQL编程.pdf");

            byte[] contents = Files.readAllBytes(path);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = "output.pdf";
            headers.setContentDispositionFormData("attachment", filename);
            headers.setContentDispositionFormData("inline", filename);
            //headers.add("content-disposition", "inline;filename=" + filename);
            //headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
            return response;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 预览pdf文件
     */
    @RequestMapping(value = "/preview", method = RequestMethod.GET)
    public Object pdfStreamHandler(HttpServletRequest request, HttpServletResponse response) {

        File file = new File("E:\\DevelopmentInstallationPackage\\ORACLE_PLSQL编程.pdf");
        if (file.exists()){
            byte[] data = null;
            try {
                FileInputStream input = new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
                input.close();
            } catch (Exception e) {
                //logger.error("pdf文件处理异常：" + e.getMessage());
            }

        }else{
        }
        return "111";
    }

}
