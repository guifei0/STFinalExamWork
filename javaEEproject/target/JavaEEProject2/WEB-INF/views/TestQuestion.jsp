<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2019/6/1
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TeacherManager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        tr{
            width: 50%;
            margin-left: 25%;
            margin-top: 30px;
            /*border-style: solid;*/
            /*border-width: 0.8px;*/
            /*border-color: #4cae4c;*/
        }
        h2{
            width: 100%;
            text-align: center;
        }
        h3{
            width: 100%;
            text-align: center;
        }
        #div2{
            width: 50%;
            margin-left: 25%;
            margin-top: 10px;
            padding-left: 30px;
            border-style: solid;
            border-width: 0.8px;
            border-color: #4cae4c;
        }
        .foot{
            width: 35%;
            margin: 10px 32.5%;
        }

    </style>
</head>
<body>
<div id="div1">
    <table class="table table-condensed">
        <tr>
            <td><span id="span2"><h2>${test.test_name}</h2></span></td>
        </tr>
        <tr>
            <td><h3>时间：${test.test_time}分钟</h3></td>
        </tr>
        <tr>
            <span class="ans1" ><a href="/User/toMain?userid=${userid}">返回主页</a></span>
        </tr>
    </table>

</div>
<div id="div2">
    <c:if test="${qxzlist.size()>0}">
        <span>一、单选题</span><br/>
        <c:forEach var="question" items="${qxzlist}" varStatus="st">
            题目编号：${question.question_id}<br/>${st.count}、${question.question_content}<br/>
            <input name="${question.question_id}" type="radio" value="${question.question_Aans}">A.&nbsp;&nbsp;${question.question_Aans}<br/>
            <input name="${question.question_id}" type="radio" value="${question.question_Bans}">B.&nbsp;&nbsp;${question.question_Bans}<br/>
            <input name="${question.question_id}" type="radio" value="${question.question_Cans}">C.&nbsp;&nbsp;${question.question_Cans}<br/>
            <input name="${question.question_id}" type="radio" value="${question.question_Dans}">D.&nbsp;&nbsp;${question.question_Dans}<br/>
            <div class="ans1">正确答案：${question.question_rightans}</div>
            <br/>
        </c:forEach>
    </c:if>
    <c:if test="${qpdlist.size()>0}">
        <span>二、判断题</span><br/>
        <c:forEach var="question" items="${qpdlist}" varStatus="st">
            题目编号：${question.question_id}<br/>${st.count}、${question.question_content}<br/>
            <input name="${question.question_id}" type="radio" value="对">对<br/>
            <input name="${question.question_id}" type="radio" value="错">错<br/>
            <div class="ans1" >正确答案：${question.question_rightans}</div>
            <br/>
        </c:forEach>
    </c:if>
    <c:if test="${qcxlist.size()>0}">
        <span>三、读程序题</span><br/>
        <c:forEach var="question" items="${qcxlist}" varStatus="st">
            题目编号：${question.question_id}<br/>${st.count}、
            <textarea readonly="readonly" style="resize:none; overflow-y:auto" cols="90" rows="8">${question.question_content}</textarea><br/>
            请输入结果:<input name="${question.question_id}" type="text"><br/>
            <div class="ans1">正确答案：${question.question_rightans}</div>
            <br/>
        </c:forEach>
    </c:if>

</div>
<div class="foot">
    <button type="button" id="changeTestName" class="btn">修改名称</button>
    <button type="button" id="changeTestTime" class="btn">修改时间</button>
    <span>满分：${score}分</span>
    <button type="button" id="changeQuestionAns" class="btn" >修改试题答案</button>
    <button type="button" id="deleteQuestion" class="btn">&nbsp;删除试题&nbsp;</button>
</div>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script>
    $("#deleteQuestion").click( function diag() {
        var str=prompt("您正在删除试题","输入题目编号");
        if(str){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/Test/deleteQuestion",
                data: {
                    "questionid":str,
                },
                success: function (data) {
                    if (data['isSuccess']==1)
                        alert("删除成功");
                },
                error: function () {
                    alert("删除失败");
                }
            });
        }
    })
    $("#changeQuestionAns").click( function diag() {
        var str=prompt("您正在修改试题答案","输入题目编号");
        if(str){
            var str1=prompt("您正在修改试题答案","输入题目答案");
            if(str1){
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "/Test/changeQuestionAns",
                    data: {
                        "questionid":str,
                        "str":str1
                    },
                    success: function (data) {
                        if (data['isSuccess']==1)
                            alert("修改成功");
                    },
                    error: function () {
                        alert("修改失败");
                    }
                });
            }
        }
    })
    $("#changeTestName").click( function diag() {
        var str=prompt("您正在修改试卷名称","${test.test_name}");
        if(str){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/Test/changeTestName",
                data: {
                    "testid":${test.test_id},
                    "str":str
                },
                success: function (data) {
                    if (data['isSuccess']==1)
                        alert("修改成功");
                },
                error: function () {
                    alert("修改失败");
                }
            });
        }
    })
    $("#changeTestTime").click( function diag() {
        var str=prompt("您正在修改试卷时间：(单位：min)","${test.test_time}");
        if(str){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/Test/changeTestTime",
                data: {
                    "testid":${test.test_id},
                    "str":str
                },
                success: function (data) {
                    if (data['isSuccess']==1)
                        alert("修改成功");
                },
                error: function () {
                    alert("修改失败");
                }
            });
        }
    })
</script>
</body>
</html>
