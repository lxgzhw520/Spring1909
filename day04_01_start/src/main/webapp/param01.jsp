<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/9
  时间: 4:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实体类参数绑定</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="/param/saveAccount" method="post">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                </div>
                <div class="form-group">
                    <label for="money">余额</label>
                    <input type="text" class="form-control" id="money" name="money" placeholder="请输入余额">
                </div>
                <div class="form-group">
                    <label for="name">用户姓名</label>
                    <%--注意,这里要传给User引用类型,用user.字段名的特殊写法--%>
                    <input type="text" class="form-control" id="name" name="user.name" placeholder="请输入用户姓名">
                </div>
                <div class="form-group">
                    <label for="age">用户年龄</label>
                    <input type="text" class="form-control" id="age" name="user.age" placeholder="请输入用户年龄">
                </div>

                <%--这组User对象封装为List--%>
                <div class="form-group">
                    <label for="lname">用户姓名</label>
                    <input type="text" class="form-control" id="lname" name="list[0].name" placeholder="请输入用户姓名">
                </div>
                <div class="form-group">
                    <label for="lage">用户年龄</label>
                    <input type="text" class="form-control" id="lage" name="list[0].age" placeholder="请输入用户年龄">
                </div>
                <%--这组User对象封装为Map--%>
                <div class="form-group">
                    <label for="mname">用户姓名</label>
                    <input type="text" class="form-control" id="mname" name="map['one'].name" placeholder="请输入用户姓名">
                </div>
                <div class="form-group">
                    <label for="mage">用户年龄</label>
                    <input type="text" class="form-control" id="mage" name="map['one']..age" placeholder="请输入用户年龄">
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
