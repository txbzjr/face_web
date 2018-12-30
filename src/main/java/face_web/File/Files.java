package face_web.File;

import java.util.List;

public class Files {
    private int count;
    private List<File_Info> File_Info ;
    private int IsEmpty;
    public void setIsEmpty(int count){this.IsEmpty = 1;}
    public int getIsEmpty(){return this.IsEmpty;}
    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setFile_Info(List<File_Info> File_Info){
        this.File_Info = File_Info;
    }
    public List<File_Info> getFile_Info(){
        return this.File_Info;
    }
}
