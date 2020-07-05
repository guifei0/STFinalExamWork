<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2018/12/19
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="/css/homepage.css">
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/data.js"></script>
    <title>Document</title>
</head>
<body>
<div class="nav">
    <div class="navHeader">
        <h1>New Year's Wall of Wishes</h1>
        <h4><a href="/User/toAdmin?userid=${user.userId}&usertype=${user.userType}">I</a> want to say：</h4>
    </div>
</div>
<div class="container">
    <div id="mySaying">
        <form>
            <input type="text" placeholder="输入心愿" id="wishInput">
            <button id="wishOut" type="button" onclick="pop()">发送</button>
        </form>
    </div>
    <div id="sayings">
        <ul>
            <li>99999</li>
        </ul>
    </div>
</div>
<div class="bg">
    <img id="back" border='0' src='/image/back2.jpg' width='100%' height='100%' style='position: absolute;left:0px;top:0px;z-index: -1'>
</div>
<script>
    function getQueryString(name) {
        var result = window.location.search.match(new RegExp("[\?\&]" + userid + "=([^\&]+)", "i"));
        if (result == null || result.length < 1) {
            return "";
        }
        return result[1];
    }
    var userId =${user.userId};
    var sum=$(".barYe").size();
    var height=($("li").height()+11)*7;
    $("#sayings").css("height",height);
    function pop() {
        var str = $("#wishInput").val();
        if (str == "") {
            alert("请输入心愿");
        }
        else {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/User/addWish",
                data: {
                    "str": $("#wishInput").val(),
                    "id": userId
                },
                async: false,
                success: function (st) {
                    console.log(st);
                    if (st['json'] == 1) {
                        alert("已发表过！");
                    }
                    else if(st==0){
                        console.log(st);
                        alert("敏感词")
                    }else{
                        console.log(st);
                        alert("成功")
                    }
                },
                error: function (st) {
                    alert("error")
                }
            });
        }
    }
    setTimeout(function(){
        $("ul li:eq(6)").slideUp(10);
    },1000);
    setInterval(function(){
        come();
    },2000);
    function come(){
        $("ul li:eq(6)").slideDown(1000);
        $("ul li:eq(0)").animate({ "margin-top": "-65px"},"slow");
        setTimeout(function() {
                $("ul li:eq(0)").remove();
                $("ul li:eq(6)").slideUp(10);
            },
            1000);
        if($("li").size()<=6){
            add();
        }
        var height=($("li").height()+10)*$("li").size();
    };
</script>
</body>
</html>