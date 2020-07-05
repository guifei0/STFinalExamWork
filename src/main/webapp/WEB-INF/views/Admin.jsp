<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2018/12/22
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/css/admin.css">
    <link rel="stylesheet" type="text/css" href="/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/css/menu.css">
    <script src="/js/jquery.js"></script>

</head>
<body>
<div class="nav">
    <a href="/User/Main?userid=${user.userId}">
        <div id="home">
            <i class="iconfont icon-shouye" style="font-size: 40px;margin: 8px;"></i>
        </div>
    </a>
    <div id="adminBoard">
        我的信息
    </div>
    <div class="adminer">
        <ul>
            <li>欢迎您！${user.userName}</li>
            <li><a href="/User/toLogin">EXIT</a></li>
        </ul>
    </div>
</div>
<div class="main">
    <!-- <div class="leftMain">
        <dl class="list_dl">
            <dt class="list_dt">
                <span class="_after"></span>
                <p>选择器</p>
                <i class="list_dt_icon"></i>
            </dt>
            <dd class="list_dd">
                <ul>
                    <li class="list_li">#id</li>
                    <li class="list_li">element</li>
                    <li class="list_li">.class</li>
                    <li class="list_li">*</li>
                </ul>
            </dd>
            <dt class="list_dt">
                <span class="_after"></span>
                <p>属性</p>
                <i class="list_dt_icon"></i>
            </dt>
            <dd class="list_dd">
                <ul>
                    <li class="list_li">attr</li>
                    <li class="list_li">removeAttr</li>
                    <li class="list_li">prop</li>
                    <li class="list_li">removeProp</li>
                    <li class="list_li">addClass</li>
                    <li class="list_li">removeClass</li>
                </ul>
            </dd>
            <dt class="list_dt">
                <span class="_after"></span>
                <p>文档处理</p>
                <i class="list_dt_icon"></i>
            </dt>
            <dd class="list_dd">
                <ul>
                    <li class="list_li">append</li>
                    <li class="list_li">appendTo</li>
                    <li class="list_li">prepend</li>
                    <li class="list_li">prependTo</li>
                    <li class="list_li">after</li>
                    <li class="list_li">before</li>
                </ul>
            </dd>
            <dt class="list_dt">
                <span class="_after"></span>
                <p>事件</p>
                <i class="list_dt_icon"></i>
            </dt>
            <dd class="list_dd">
                <ul>
                    <li class="list_li">ready</li>
                    <li class="list_li">on</li>
                    <li class="list_li">off</li>
                    <li class="list_li">bind</li>
                    <li class="list_li">one</li>
                    <li class="list_li">trigger</li>
                    <li class="list_li">hover</li>
                    <li class="list_li">click</li>
                    <li class="list_li">focus</li>
                </ul>
            </dd>
            <dt class="list_dt">
                <span class="_after"></span>
                <p>AJAX</p>
                <i class="list_dt_icon"></i>
            </dt>
            <dd class="list_dd">
                <ul>
                    <li class="list_li">$.ajax</li>
                    <li class="list_li">$.get</li>
                    <li class="list_li">$.getJSON</li>
                    <li class="list_li">$.getScript</li>
                    <li class="list_li">$.post</li>
                </ul>
            </dd>
            <dt class="list_dt">
                <span class="_after"></span>
                <p>效果</p>
                <i class="list_dt_icon"></i>
            </dt>
            <dd class="list_dd">
                <ul>
                    <li class="list_li">show</li>
                    <li class="list_li">hide</li>
                    <li class="list_li">toggle</li>
                    <li class="list_li">slideDown</li>
                    <li class="list_li">slideUp</li>
                    <li class="list_li">slideToggle</li>
                    <li class="list_li">fadeIn</li>
                    <li class="list_li">fadeOut</li>
                    <li class="list_li">fadeTo</li>
                    <li class="list_li">fadeToggle</li>
                    <li class="list_li">stop</li>
                </ul>
            </dd>
        </dl>
    </div> -->
    <div class="rightMain">
        <div class="containerHeader">
            <div class="containhead">
                用户中心
            </div>
        </div>
        <div class="containMain">
            <div class="containMainUser">
                <div class="containUserPic">
                    <img src="/image/human.png">
                </div>
                <div class="containUserFrom">
                    <span>会员账号：<i style="font-style: normal;font-size: 18px;">${user.userName}</i></span>
                    <span>会员邮箱：<i style="font-style: normal;font-size: 18px;">${user.userPostbox}</i></span>
                    <span>手机号码：<i style="font-style: normal;font-size: 18px;">${user.userPhone}</i></span>
                    <span>新年心愿：<i style="font-style: normal;font-size: 18px;">${user.userWish}</i></span>

                </div>
            </div>
            <div class="containMainGroup">
                <div class="groupHeader">
                    <span>手机号码</span>
                </div>
                <div class="groupMain">
                    <span>绑定手机号码，便于找回</span>
                </div>
                <div class="groupChange">
                    <a id="rePhone">修改</a>
                </div>
            </div>

            <div class="containMainGroup">
                <div class="groupHeader">
                    <span>邮箱绑定</span>
                </div>
                <div class="groupMain">
                    <span>绑定邮箱可以用于安全验证、找回密码等重要操作</span>
                </div>
                <div class="groupChange">
                    <a id="reEmail">修改</a>
                </div>
            </div>
            <div class="containMainGroup">
                <div class="groupHeader">
                    <span>登录密码</span>
                </div>
                <div class="groupMain">
                    <span>安全性高的密码可以使账号更安全，建议您定期更换密码，设置一个包含字母，符号或数字中至少两项且长度超过6位的密码。</span>
                </div>
                <div class="groupChange">
                    <a id="rePassword">修改</a>
                </div>
            </div>
            <div class="containMainGroup">
                <div class="groupHeader">
                    <span>心愿修改</span>
                </div>
                <div class="groupMain">
                    <span>点击修改愿望</span>
                </div>
                <div class="groupChange">
                    <a id="reWish">修改</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function getQueryString(name) {
        var result = window.location.search.match(new RegExp("[\?\&]" + userid + "=([^\&]+)", "i"));
        if (result == null || result.length < 1) {
            return "";
        }
        return result[1];
    }
    var userId =${user.userId};

    $(".list_dt").on("click",function () {
        $('.list_dd').stop();
        $(this).siblings("dt").removeAttr("id");
        if($(this).attr("id")=="open"){
            $(this).removeAttr("id").siblings("dd").slideUp();
        }else{
            $(this).attr("id","open").next().slideDown().siblings("dd").slideUp();
        }
    });

    $("#reEmail").click(function(){
        var E=prompt("请修改你的邮箱");
        if(E!=null){
            var Str = /^(\w-*\.*)+@(\w-?)+(\.\w{2,3})+$/;
            if(Str.test(E)){
                $.ajax({
                    type:"POST",
                    dataType:"json",
                    url:"/User/changeUser",
                    data:{
                        "str":E,
                        "id":userId,
                        "flag":2
                    },
                    async: false,
                    success: function(st) {
                        alert(st['word']);
                        location.href="/User/toAdmin?userid="+userId;
                    },
                    error:function (st) {
                        alert("error")
                    },
                });
            }
            else{
                // console.log(E);
                alert("不符合规范，请重新输入");
                // console.log(false);
            }
        }


    });
    $("#rePassword").click(function(){
        var E=prompt("请修改你的密码");
        if(E!=null){
            var Str = /^[a-zA-z0-9]\w{5,15}$/;
            if(Str.test(E)){
                $.ajax({
                    type:"POST",
                    dataType:"json",
                    url:"/User/changeUser",
                    data:{
                        "str":E,
                        "id":userId,
                        "flag":3
                    },
                    async: false,
                    success: function(st) {
                        alert(st['word']);
                    },
                    error:function (st) {
                        alert("error")
                    },
                });
            }
            else{
                alert("不符合规范，请重新输入");
                console.log(false);
            }
        }
    });
    $("#rePhone").click(function(){
        var E=prompt("请绑定你的手机");
        if(E!=null){
            var Str = /^1\d{10}$/;
            if(Str.test(E)){
                $.ajax({
                    type:"POST",
                    dataType:"json",
                    url:"/User/changeUser",
                    data:{
                        "str":E,
                        "id":userId,
                        "flag":1
                    },
                    async: false,
                    success: function(st) {
                        alert(st['word']);
                        location.href="/User/toAdmin?userid="+userId;
                    },
                    error:function (st) {
                        alert("error")
                    },
                });
            }
            else{
                alert("不符合规范，请重新输入");
                console.log(false);
            }
        }
    });
    $("#reWish").click(function(){
        var E=prompt("请修改你的心愿");
        if(E!=null){
            var str=/^\s*$/;
            if(str.test(E)) {
                alert("心愿不能为空");
            }else{
                $.ajax({
                    type:"POST",
                    dataType:"json",
                    url:"/User/changeUser",
                    data:{
                        "str":E,
                        "id":userId,
                        "flag":4
                    },
                    async: false,
                    success: function(st) {
                        alert(st['word']);
                        location.href="/User/toAdmin?userid="+userId;
                    },
                    error:function (st) {
                        alert("error")
                    },
                });
            }
        }
    });
</script>
</body>
</html>