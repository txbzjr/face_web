package face_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
@Controller
public class Del_All_Img {
    @RequestMapping(value = "/del",produces = "text/html; charset=utf-8",method = RequestMethod.GET)
    //设置响应体为text/html utf8
    @ResponseBody
    public String del_req(@RequestParam(value = "pass",defaultValue = "none")String pass){
        //接受密码请求参数pass到String pass变量
        if(pass.equals("1")){//判断删除操作密码是否正确密码
            if(deleteDir("C:\\img")){
                return "删除成功";
            }else {
                return "删除失败";
            }
        } else { return "密码错误"; }
    }
    private static boolean deleteDir(String path){
        File file = new File(path);
        if(!file.exists()){//判断是否待删除目录是否存在
            System.err.println("The dir are not exists!");
            return false; }
        String[] content = file.list();//取得当前目录下所有文件和文件夹
        if (content != null) {
            for(String name : content){
                File temp = new File(path, name);
                if(temp.isDirectory()){//判断是否是目录
                    deleteDir(temp.getAbsolutePath());//递归调用，删除目录里的内容
                    temp.delete();//删除空目录
                }else{
                    if(!temp.delete()){//直接删除文件
                        System.err.println("Failed to delete " + name);
                    }
                }
            }
        }
        return true;
    }
}
