<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>StartTest</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
        }
        #div1{
            margin:0px;
            padding:0px;
            width:100%;
            height:99%;
            font-size:14px;

            position:absolute;
            text-align: center;
        }
        .head{
            height: 8%;
            font-size: 30px;
            font-weight: bold;
            /*            color: #ffffff;*/
            /*            background-color: #0099FF;*/
            padding-top: 10px;
            box-shadow: 0px 3px 2px #dddddd;
        }
        /*.headp{
            margin-top: 20px;
        }*/
        #div1_2{
            /*margin: 0 0 0 120px;*/
            /*padding:0;*/
            width:1014px;
            position: absolute;
            top: 15%;
            left:30%;
            margin: -46px 0 0 -175px;

        }
        #div2{
            margin:0;
            padding:0px;
            width:100%;
            float: left;
            border:1px solid #F0F0F0;
            /*            background-color:#eeeeee;*/

        }
        #div3{
            margin:0;
            padding:0 0 0 30px;
            height: 500px;
            width:100%;
            text-align:left;
            border:0.8px solid #F0F0F0;
            float: left;
            overflow-y:scroll;
        }
        .foot{
            margin:0;
            padding:20px 0;
            width:100%;
            float: left;

        }
    </style>
    <script type="text/javascript">
        history.go(1);
        var i;
        var t;
        function check1(x){
            t = x*60;
            i = self.setInterval("jishi()",1000);
        }
        function jishi(){
            h = parseInt(t/3600);
            m = parseInt((t-h*60*60)/60);
            mm = t-h*60*60-m*60;
            document.getElementById("span1").innerHTML = h+"时"+m+"分"+mm+"秒";
            t--;
            if(t == 600){
                alert("距离考试结束还有10分钟，请抓紧时间！");
            }
            if(t<0){
                i = window.clearInterval(i);
                var tnid = document.getElementById("span2").lang;
                alert("考试结束");
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "/Test/calculateGrades",
                    data: {
                        "ansArr":JSON.stringify(arr2),
                        "qidArr":JSON.stringify(arr1)
                    },
                    success: function (data) {
                        if (data['score']==${score}) {
                            alert("恭喜你，满分通过！")
                        }else if(data['score']==0){
                            alert("一道题都没答对？？！！")
                        }else{
                            alert("你的分数是："+data['score']+"分");
                        }
                        $(function(){
                            var c = confirm('是否查看正确答案？');
                            if(c){
                                Layer_HideOrShow('ans1');
                            }else{
                                location.href="/User/toMain?userid="+${user.user_id};
                            }
                        });
                    },
                    error: function () {
                        alert("提交失败");
                    }
                });
            }
        }
        var arr1 = new Array();
        var arr2 = new Array();
        function check(){
            var arrayInput=document.getElementsByTagName("input");
            for (var i=0;i<$('input:radio:checked').length;i++){
                if(arrayInput[i].value!= ""){
                    arr1[i]=$('input:radio:checked')[i].name;
                    arr2[i]=$('input:radio:checked')[i].value;
                    // console.log(arr2[i]+arr1[i]);
                }else{
                    return null;
                }
            }
            for (var i=0;i<$('input:text').length;i++) {
                if(arrayInput[i].value!=""){
                    arr1[i+$('input:radio:checked').length]=$('input:text')[i].name;
                    arr2[i+$('input:radio:checked').length]=$('input:text')[i].value;
                    //console.log(arr2[i]+arr1[i]);
                }
            }
            // console.log(JSON.stringify(arr1));
            if(confirm("您确定要交卷吗?")){
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "/Test/calculateGrades",
                    data: {
                        "ansArr":JSON.stringify(arr2),
                        "qidArr":JSON.stringify(arr1)
                    },
                    success: function (data) {
                        if (data['score']==${score}) {
                            alert("恭喜你，满分通过！")
                        }else if(data['score']==0){
                            alert("一道题都没答对？？！！")
                        }else{
                            alert("你的分数是："+data['score']+"分");
                        }
                        $(function(){
                            var c = confirm('是否查看正确答案？');
                            if(c){
                                Layer_HideOrShow('ans1');
                            }else{
                                location.href="/User/toMain?userid="+${user.user_id};
                            }
                        });
                    },
                    error: function () {
                        alert("提交失败");
                    }
                });
            }
        }
        function Layer_HideOrShow(cur_div){
            var current=document.getElementsByClassName(cur_div);
            console.log(current.length);
            for (var i=0;i<current.length;i++){
                if(current[i].style.display =="block"){
                    current[i].style.display ="none";
                }else {
                    current[i].style.display ="block";
                }
            }
        }
    </script>
</head>
<body onload="check1(${test.test_time});">
<div id="div1">
    <div class="head">
        <p class="headp">逢考必会，逢考必过</p>
    </div>
    <div id="div1_2">
        <div id="div2">
            <table class="table .table-condensed" >
                <tr>
                    <td style="text-align: center;" colspan="2"><span id="span2">${test.test_name}</span></td>
                </tr>
                <tr>
                    <td style="text-align: center;" colspan="2">满分：${score}</td>
                </tr>
                <tr>
                    <td style="text-align: center;" colspan="2" >考生信息</td>
                </tr>
                <tr>
                    <td style="text-align: center;" >学号：${user.user_id}</td>
                </tr>
                <tr>
                    <td style="text-align: center;">姓名：${user.user_name}</td>
                </tr>
                <tr>
                    <td style="text-align: center;" colspan="2" ><div class="ans1" style="display: block;">距离考试结束还有:</div></td>
                </tr>
                <tr>
                    <td style="text-align: center;" colspan="2" ><span id="span1" class="ans1" style="display: block";></span></td>
                </tr>
                <tr>
                    <span class="ans1" style="display: none;"><a href="/User/toMain?userid=${user.user_id}">返回主页</a></span>
                </tr>
            </table>
        </div>
        <div id="div3">
            <c:if test="${qxzlist.size()>0}">
                <span>一、单选题</span><br/>
                <c:forEach var="question" items="${qxzlist}" varStatus="st">
                    ${st.count}、${question.question_content}<br/>
                    <input name="${question.question_id}" type="radio" value="${question.question_Aans}">A.&nbsp;&nbsp;${question.question_Aans}<br/>
                    <input name="${question.question_id}" type="radio" value="${question.question_Bans}">B.&nbsp;&nbsp;${question.question_Bans}<br/>
                    <input name="${question.question_id}" type="radio" value="${question.question_Cans}">C.&nbsp;&nbsp;${question.question_Cans}<br/>
                    <input name="${question.question_id}" type="radio" value="${question.question_Dans}">D.&nbsp;&nbsp;${question.question_Dans}<br/>
                    <div class="ans1" style="display: none;">正确答案：${question.question_rightans}</div>
                    <br/>
                </c:forEach>
            </c:if>
            <c:if test="${qpdlist.size()>0}">
                <span>二、判断题</span><br/>
                <c:forEach var="question" items="${qpdlist}" varStatus="st">
                    ${st.count}、${question.question_content}<br/>
                    <input name="${question.question_id}" type="radio" value="对">对<br/>
                    <input name="${question.question_id}" type="radio" value="错" >错<br/>
                    <div class="ans1" style="display: none;">正确答案：${question.question_rightans}</div>
                    <br/>
                </c:forEach>
            </c:if>
            <c:if test="${qcxlist.size()>0}">
                <span>三、读程序题</span><br/>
                <c:forEach var="question" items="${qcxlist}" varStatus="st">
                    ${st.count}、<br/>
                    <textarea readonly="readonly" style="resize:none; overflow-y:auto" cols="90" rows="8">${question.question_content}</textarea><br/>
                    请输入结果:<input name="${question.question_id}" type="text"><br/>
                    <div class="ans1" style="display: none;">正确答案：${question.question_rightans}</div>
                    <br/>
                </c:forEach>
            </c:if>
        </div>
        <div class="foot">
            <input type="button" size="100px;" class="btn" value="交&nbsp;&nbsp;&nbsp;&nbsp;卷" onclick="check()"/>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
</body>
</html>