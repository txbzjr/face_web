var data_json,file_json_obj;
var count_img = 0;
window.onload=function(){
    $.get("./get-file-list",function(data,status){
        file_json_obj = data;
        if(file_json_obj.count>0){
            data_json = file_json_obj.File_Info;
            document.getElementById("count_all").innerHTML="总共"+file_json_obj.count+"个识别结果";
            flash_img();
            if(getCookie('hid')==1){
                document.getElementById("hid_a").innerHTML="当前为原图模式：";document.getElementById("hid_sw").value="点击切换至缩略图模式";
            }else{
                document.getElementById("hid_a").innerHTML="当前为缩略图模式：";document.getElementById("hid_sw").value="点击切换至原图模式";
            }
        }else{
            document.getElementById("hid_sw").style.display = "none";
            document.getElementById("more").style.display = "none";
            document.getElementById("button").style.display = "none";
            document.getElementById("img_count").style.display = "none";
            document.getElementById("speed").innerHTML="图片消失在虚空中";
        }

    });
};
function fresh_img(){
    var select_count = document.getElementById("img_count");
    var flash_img_count = select_count.options[select_count.selectedIndex].value;
    var tmp="";
    for(i=0;i<flash_img_count;i++){
        if(count_img>file_json_obj.count-1){
            document.getElementById("more").style.display = "none";
            document.getElementById("img_count").style.display = "none";
            break;
        }
        var full_address = data_json[count_img]['file_address'];
        var file_time = data_json[count_img]['file_time'];
        var small_file_address = data_json[count_img]['small_file_address'];
        if(getCookie('hid')==1){
            $('#main_div').append('<div id="div"><a href='+full_address+'><img src='+full_address+'>'
                +'<br><a>'+file_time+'</a>'+'</div>');
        }else{
            $('#main_div').append('<div id="div"><a href='+full_address+'><img width="200px" height="200px" src='+full_address+'>'
                +'<br><a>'+file_time+'</a>'+'</div>');
        }
        count_img++;
    }
}
function more(){flash_img();}
function hid_sw(){
    if(getCookie('hid')==1){
        document.cookie="hid=0";
        document.getElementById("hid_a").innerHTML="当前为原图模式：";document.getElementById("hid_a").value="点击切换至缩略图模式";
    }else{
        document.cookie="hid=1";
        document.getElementById("hid_a").innerHTML="当前为缩略图模式：";document.getElementById("hid_a").value="点击切换至原图模式";
    }
    window.location.reload();
}
function del_all(){
    var pass = prompt("请输入密码");
    $.get("./del?pass="+pass,function(data,status){
        alert("数据: " + data + "\n状态: " + status);
        window.location.reload();
    });
}
function getCookie(Name) {
    var search = Name + "="//查询检索的值
    var returnvalue = "";//返回值
    if (document.cookie.length > 0) {
        sd = document.cookie.indexOf(search);
        if (sd!= -1) {
            sd += search.length;
            end = document.cookie.indexOf(";", sd);
            if (end == -1)
                end = document.cookie.length;
            //unescape() 函数可对通过 escape() 编码的字符串进行解码。
            returnvalue=unescape(document.cookie.substring(sd, end))
        }
    }
    return returnvalue;
}