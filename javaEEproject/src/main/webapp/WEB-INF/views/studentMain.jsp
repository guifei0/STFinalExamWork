<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2019/5/30
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body{
            background-color:#EEEEEE;
        }
        .main{
            width: 40%;
            margin: 200px 30%;
        }
        #div1{
            margin:0px;
            padding:0px;
            width:100%;
            height:100%;
            font-size:14px;
            position:absolute;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="div1">
    <h1 align="center">
        在线考试系统
    </h1>
    <table class="main table table-striped"></table>
</div>
<input id="userid" type="hidden" value="${userid}">
</body>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script>
    var userid=$("#userid").val();
    $.ajax({
        url:"/Test/selectAllTest",
        dataType:"json",
        async:true,
        data:{

        },
        type:"POST",
        success: function (data) {
            console.log(data['list']);
            for(var j=0;j<data['list'].length;j++){
                var item="<tr><td>"+data['list'][j].test_name+"</td><td>"+data['list'][j].test_time+"分钟"+"</td><td><button class='action'><a href='/Test/startTest?testid="+data['list'][j].test_id+"&userid="+userid+"'"+">开始考试</a></button></td></tr>";
                $("table").append(item);
            }
        },
        error: function () {
            alert("异常！");
        }
    });
</script>
</html>