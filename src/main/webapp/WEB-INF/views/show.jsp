<%--
  Created by IntelliJ IDEA.
  User: JR
  Date: 2018/12/16
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
﻿<html>
<head>
    <title>物联网项目</title>
    <meta http-equiv=”Content-Type” content=text/html; charset=utf-8>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="./js/face_load.js"></script>
    <link rel="stylesheet" href="./css/face_load_css.css" type="text/css" />
</head>
<body>
<a id="count_all" class="a" style="font-size:60px;"></a>
<input type=button class="button button1" id="button" onclick="del_all()" style="font-size:50px;" value="删除所有图片"/><br>
<a id="speed" class="a" style="font-size:40px"><a id="hid_a" class="a" style="font-size:40px"></a>
    <input type=button class="button button1" onclick="hid_sw()" id="hid_sw" style="font-size:50px;" value=""/></a>
<div id="main_div"></div>
<div>
    <select id="img_count" style="font-size:50px;margin-bottom:40px;">
        <option value ="30">读取30张识别结果</option><option value ="70">读取70张识别结果</option>
        <option value="100">读取100张识别结果</option><option value="150">读取150张识别结果</option>
        <option value="250">读取250张识别结果</option><option value="370">读取370张识别结果</option>
        <option value="400">读取400张识别结果</option>
    </select>
    <input type=button id="more" onclick="more()" class="button button1" style="font-size:50px;margin-bottom:40px;" value="获取更多"/><br>
</div>
<div class="footer">此页面仅作学习用途</div>
</body>
</html>
