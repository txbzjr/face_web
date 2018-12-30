package face_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Controller
public class FileUploadController {
    @RequestMapping(value = "/img-upload",
            produces = "text/html; charset=utf-8",
            method = RequestMethod.POST)
    @ResponseBody
    public String Img_Upload(MultipartFile file) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        if(file.getSize()>0){
            //判断文件大小是否大于0
            String file_name = System.currentTimeMillis()+file.getOriginalFilename();
            //用毫秒级时间戳作为文件名
            if(file_name.endsWith("jpeg")||file_name.endsWith("jpg")||file_name.endsWith("png")){
                //判断文件类型
                File file_obj = new File("C:\\img",file_name);
                file.transferTo(file_obj);//保存
                return "上传成功 ["+simpleDateFormat.format(System.currentTimeMillis())+"] filename:["+file_name+"]";
            }else {
                return "文件类型错误 ["+simpleDateFormat.format(System.currentTimeMillis())+"]";
            }
        }else{
            return "上传失败 ["+simpleDateFormat.format(System.currentTimeMillis())+"]";
        }
    }
}