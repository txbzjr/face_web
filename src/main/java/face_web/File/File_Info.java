package face_web.File;

public class File_Info {
    private String file_address;
    private String file_time;
    File_Info(String file_address,String file_time){
        this.file_address = file_address;
        this.file_time = file_time;
    }
    public void setFile_address(String file_address){
        this.file_address = file_address;
    }
    public String getFile_address(){
        return this.file_address;
    }
    public void setFile_time(String file_time){
        this.file_time = file_time;
    }
    public String getFile_time(){
        return this.file_time;
    }
}
