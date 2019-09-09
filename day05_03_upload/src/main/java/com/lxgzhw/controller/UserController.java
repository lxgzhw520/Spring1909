package com.lxgzhw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, MultipartFile upload) throws Exception {
        //1.指定上传的位置
        String uploads = request.getSession().getServletContext().getRealPath("/uploads/");

        //2.判断路径是否存在
        File file1 = new File(uploads);
        if (!file1.exists()) {
            file1.mkdir();
        }

        //3.获取上传文件的名称
        String uploadFileName = upload.getOriginalFilename();

        //4.生成唯一名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String finalName = uuid + "_" + uploadFileName;

        //5.保存文件
        upload.transferTo(new File(uploads, finalName));

        //6.返回数据
        return "success";
    }

}
