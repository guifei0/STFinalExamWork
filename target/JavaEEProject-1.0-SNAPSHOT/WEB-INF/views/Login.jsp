<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2018/12/19
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.slideunlock.js"></script>
</head>
<body>
<div class="container">
    <div class="loginAll">
        <div class="loginCover">
            <input type="radio" id="tabOne" name="tab" class="loginFlag">
            <label for="tabOne" class="tab" id="loginF">登录</label>
            <input type="radio" id="tabTwo" name="tab" class="registerFlag">
            <label for="tabTwo" class="tab" id="registerF">注册</label>
            <div class="loginFormAll">
                <div class="loginForm">
                    <div class="group">
                        <div class="groupTltle">USERNAME</div>
                        <input type="text" id="name" class="groupInput">
                    </div>
                    <div class="group">
                        <div class="groupTltle">PASSWORD</div>
                        <input type="password" id="password" class="groupInput">
                    </div>
                    <div class="group">
                        <div class="groupTltle" >UNLOCK</div>
                        <div id=""></div>
                        <div id="slider">
                            <div id="slider_bg"></div>
                            <span id="label"></span> <span id="labelTip">拖动滑块验证</span>
                        </div>
                    </div>
                    <div class="group">
                        <div class="groupTltle">
                            <%--<input type="checkbox" name="remember">Keep me Signed in--%>
                        </div>
                        <a id="loginA">
                            <button class="groupInputB" style="background: rgba(255,255,255,.96);" id="loginButton">登录</button>
                        </a>
                    </div>
                    <div class="group" style="border-bottom: solid 1px #ffffff57;height: 25px;"></div>
                    <div class="group" id="governLogin">
                        <a href="/User/toLoginManager">管理员登录注册</a>
                    </div>
                </div>

                <div class="registerForm">
                    <div class="group">
                        <div class="groupTltle">USERNAME</div>
                        <input type="text" id="registerUser"  class="groupInput" placeholder="输入名称，不少于两个字符">
                    </div>
                    <div class="group">
                        <div class="groupTltle">PASSWORD</div>
                        <input type="password" id="registerPassword"  class="groupInput" placeholder="长度为6-16个字符">
                    </div>
                    <div class="group">
                        <div class="groupTltle">REAPEAT PASSWORD</div>
                        <input type="password" id="registerPasswordR" class="groupInput" placeholder="确认密码">
                    </div>
                    <div class="group">
                        <div class="groupTltle">EAIML</div>
                        <input type="email" id="EMAIL" class="groupInput"  placeholder="请输入正确邮箱">
                    </div>
                    <div class="group">
                        <button class="groupInputB" style="background: rgba(255,255,255,.96);" id="registerButton">注册</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var flag=0;//0表示未被解锁
    $(function () {
        var slider = new SliderUnlock("#slider",{
            successLabelTip : "验证成功"
        },function(){
            alert("验证成功!");
            flag=1;
            console.log(flag);
        });
        slider.init();
        $("#loginA").click(function(event) {
            if (flag == 0) {
                event.preventDefault();
            }
        })
    })


    $("#loginButton").click(function () {
        if(flag==1){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/User/Login",
                data: {
                    "name": $("#name").val(),
                    "password": $("#password").val()
                },
                success: function (data) {
                    console.log(data['woord']);
                    if (data['woord'] == "12306") {
                        location.href = "/User/Main?userid="+data['userid'];
                    } else {
                        alert(data['woord']);
                    }
                },
                error: function () {
                    alert("异常！");
                }
            });
        }
        else {
            alert("请先进行验证");
        }
    })
    $("#registerButton").click(function () {
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/User/Register",
            data: {
                "name": $("#registerUser").val(),
                "password": $("#registerPassword").val(),
                "email":$("#EMAIL").val()
            },
            success: function (data) {
                alert(data['woord']);
                location.href="/User/toLogin";
            },
            error: function () {
                alert("注册失败");
            }
        });
    })


    $(function () {
        $("#loginF").click(function () {
            $(".registerForm").hide(500);
            $(".loginForm").show(500);
            $(this).css("color", "#f8342673");
            $("#registerF").css("color", "white");
        });
        $("#registerF").click(function () {
            $(".registerForm").show(500);
            $(".loginForm").hide(500);
            $(this).css("color", "#f8342673");
            $("#loginF").css("color", "white");
        })
    })
    $("#registerUser").focus(function () {
        $(this).css("border", "solid 2px #2196f3c2");
    })
    $("#registerUser").blur(function () {
        var Str = /^[a-zA-z0-9]\w{1,255}$/;
        if (Str.test(this.value)) {
            $(this).css("border", "solid 2px #03a9f487");
        }
        else {
            $(this).css("border", "solid 2px #f443369e");
        }
    })

    $("#registerPassword").focus(function () {
        $(this).css("border", "solid 2px #2196f3c2");
    })
    $("#registerPassword").blur(function () {
        var Str = /^[a-zA-z0-9]\w{5,15}$/;
        if (Str.test(this.value)) {
            $(this).css("border", "solid 2px #03a9f487");
        }
        else {
            $(this).css("border", "solid 2px #f443369e");
        }
    })

    $("#registerPasswordR").focus(function () {
        $(this).css("border", "solid 2px #2196f3c2");
    })
    $("#registerPasswordR").blur(function () {
        var Str = /^[a-zA-z0-9]\w{5,15}$/;
        console.log($("#registerPassword").val());
        if (this.value == $("#registerPassword").val()) {
            $(this).css("border", "solid 2px #03a9f487");
        }
        else {
            $(this).css("border", "solid 2px #f443369e");
        }
    })
    $("#EMAIL").focus(function () {
        $(this).css("border", "solid 2px #2196f3c2");
    })
    $("#EMAIL").blur(function () {
        var Str = /^(\w-*\.*)+@(\w-?)+(\.\w{2,3})+$/;
        if (Str.test(this.value)) {
            $(this).css("border", "solid 2px #03a9f487");
        }
        else {
            $(this).css("border", "solid 2px #f443369e");
        }
    })
    history.pushState(null, null,document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
    });

</script>
</body>
</html>
