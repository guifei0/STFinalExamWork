<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2018/12/24
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/css/admin.css">
    <link rel="stylesheet" type="text/css" href="/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/css/menu.css">
    <link rel="stylesheet" type="text/css" href="/css/govern.css">
    <script src="/js/jquery.js"></script>
    <script src="/js/pages.js"></script>

</head>
<body>
<div class="nav">
    <a href="JavaScript:history.go(-1)">
        <div id="home">
            <i class="iconfont icon-shouye" style="font-size: 40px;margin: 8px;"></i>
        </div>
    </a>
    <div id="adminBoard">
        管理控制
    </div>
    <div class="adminer">
        <ul>
            <li>adminer</li>
            <li><a href="/User/toLoginManager">EXIT</a></li>
        </ul>
    </div>
</div>
<div class="main">
    <div class="rightMain">
        <div class="containerHeader">
            <div class="containhead">
                管理信息
            </div>
        </div>
        <div class="containMain" style="height: 500px;">
            <table id="nms">
                <thead>
                <tr>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>邮箱</td>
                    <td>手机号</td>
                    <td>心愿</td>
                    <td>删除</td>
                </tr>
                </thead>
                <tbody id="tabBody"></tbody>
            </table>
            <ul class="theme_body">
                <div id="pagecount"class="pagecount"></div>
            </ul>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
</script>
</body>
</html>