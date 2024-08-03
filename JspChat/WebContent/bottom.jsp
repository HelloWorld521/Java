<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My JSP 'bottom.jsp' starting page</title>
    <base href="${basePath}">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById("sendButton").addEventListener("click", function () {
                const message = document.forms['formms']['message'].value;
                const avatar = document.forms['formms']['touxiang'].value;
                if (!message && !avatar) {
                    alert("不能发送空消息！");
                    return false;
                }
                document.forms['formms']['mess'].value = message;
                document.forms['formms']['message'].value = "";
                return true;
            });

            document.querySelectorAll("input[name='touxiang']").forEach(radio => {
                radio.addEventListener("click", function () {
                    document.getElementById("small").style.zIndex = 1;
                });
            });

            document.getElementById("smallImg").addEventListener("click", function () {
                document.getElementById("small").style.zIndex = 3;
            });
        });

        function resetRadio() {
            document.querySelectorAll("input[name='radiobutton']").forEach(radio => radio.checked = false);
        }
    </script>
    <style>
        body {
            font-family: "Helvetica Neue", Helvetica, "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
            height: 100%;
            background-size: cover;
            color: #000;
            position: relative;
        }

        .login {
            padding: 2px 15px;
            font-size: 15px;
            color: rgb(0, 100, 233);
            transition: background 250ms ease-in, color 250ms ease-in;
            border-radius: 6px;
            text-decoration: none;
        }

        .login:hover {
            color: #fff;
            background: #BBD631;
        }

        .doc {
            display: inline-block;
        }

        .doc:hover {
            border: 1px;
        }

        #small {
            position: absolute;
            z-index: 1;
        }

        #send {
            position: absolute;
            z-index: 2;
        }
    </style>
</head>
<body>
    <form action="left.jsp" target="left" method="post" name="formms">
        字体颜色：
        <select name="textColor">
            <option value="black">黑色</option>
            <option value="red">红色</option>
            <option value="green">绿色</option>
            <option value="blue">蓝色</option>
        </select>
        &nbsp;&nbsp;文件管理:&nbsp;&nbsp;
        <a class="doc" href="document.jsp" target="_blank">
            <img alt="文件管理" title="文件上传下载" src="images/documentMessage.png">
        </a>
        &nbsp;&nbsp;选择表情：&nbsp;&nbsp;
        <img id="smallImg" alt="表情" title="发送表情" src="images/small1.png">
        <div id="small" name="small">
            <input type="radio" name="touxiang" value="images/f01.gif">
            <img src="images/f01.gif">
            <input type="radio" name="touxiang" value="images/f02.gif">
            <img src="images/f02.gif">
            <input type="radio" name="touxiang" value="images/f03.gif">
            <img src="images/f03.gif">
            <input type="radio" name="touxiang" value="images/f04.gif">
            <img src="images/f04.gif">
        </div>
        <div id="send">
            <input type="text" name="message" style="width: 300px; height: 30px;">
            <input type="submit" id="sendButton" value="发送" class="login">
            <input type="hidden" name="mess">
        </div>
    </form>
</body>
</html>
