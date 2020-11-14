package com.javapandeng.controller;

import com.javapandeng.utils.SystemContext;
import com.javapandeng.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hangzhi1063
 * @date 2020/11/5 9:00
 */
@Controller
@RequestMapping("/ueditor")
public class UeditorController {

    @ResponseBody
    @RequestMapping("/saveFile")
    public Map<String,Object> saveFile(@RequestParam(value = "upfile",required = false)MultipartFile file) throws IOException {
        Map<String,Object> parms = new HashMap<>();
        String n = UUIDUtils.create();
        String path = SystemContext.getRealPath() + "resource\\ueditor\\upload\\" + n + file.getOriginalFilename();
        File newfile = new File(path);
        file.transferTo(newfile);
        String visitUrl = "/resource/ueditor/upload/"+n+file.getOriginalFilename();
        parms.put("state","SUCCESS");
        parms.put("url",visitUrl);
        parms.put("size",file.getSize());
        parms.put("original",file.getOriginalFilename());
        parms.put("type",file.getContentType());
        return parms;

    }
}
