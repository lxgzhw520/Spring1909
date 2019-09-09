<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/9
  时间: 5:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义类型转换器</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form method="post" action="/param/date">
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                        <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
                </div>
                <div class="form-group">
                    <label for="date">日期</label>
                    <input type="text" class="form-control" id="date" name="birthday" placeholder="请输入生日">
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
