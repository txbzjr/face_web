package face_web.File;

import com.google.gson.Gson;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class Get_File_Json {
    private String Json_String;
    public Get_File_Json(String file_path){
        File dir = new File(file_path);
        String[] files_array = dir.list();
        Gson gson = new Gson();
        if (files_array != null) {
            Collections.reverse(Arrays.asList(files_array));
            Files files1 = new Files();
            List<File_Info> file_list_json = new ArrayList<File_Info>();
            files1.setCount(files_array.length);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            for (String s : files_array) {
                try{
                    if(s.endsWith("jpeg")) {
                        file_list_json.add(new File_Info("./face_image/" + s,
                                simpleDateFormat.format(Long.parseLong(s.replace(".jpeg", "")))));
                    }else if(s.endsWith("jpg")){
                        file_list_json.add(new File_Info("./face_image/" + s,
                                simpleDateFormat.format(Long.parseLong(s.replace(".jpg", "")))));
                    }else if(s.endsWith("png")){
                        file_list_json.add(new File_Info("./face_image/" + s,
                                simpleDateFormat.format(Long.parseLong(s.replace(".png", "")))));
                    }else { break; }
                }catch (NumberFormatException ignored){ }
            }
            files1.setFile_Info(file_list_json);
            this.Json_String = gson.toJson(files1);
        }
    }
    public String Get_JsonString(){
        return this.Json_String;
    }
}
