package face_web.controller;


import face_web.File.Get_File_Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Get_File_List {
    @RequestMapping(value = "/get-file-list",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    @ResponseBody
    public String get_file_list(){
        String img_path = "C:\\img";
        Get_File_Json get_file_json = new Get_File_Json(img_path);
        return get_file_json.Get_JsonString();
    }
    @RequestMapping("/")
    public String face_show(){
        return "show";
    }
}
