<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/9
  时间: 16:06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <link rel="stylesheet" href="css/index.css">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="box"></div>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="/user/upload" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                </div>
                <div class="form-group">
                    <label for="file">选择文件</label>
                    <input type="file" id="file" name="upload">
                    <p class="help-block">请选择要上传的文件</p>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 同意注册协议
                    </label>
                </div>
                <input type="submit" class="btn btn-default" value="提交">
            </form>
        </div>
    </div>
</div>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
