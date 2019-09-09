<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/9
  时间: 10:27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务器响应测试</title>
</head>
<body>
<a href="/user/string">返回string类型的数据</a> <br>
<a href="/user/mv">返回ModelAndView类型的数据</a> <br>
<a href="/user/redirect">转发和重定向</a> <br>
<button>ajax一步请求</button>
<br>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script>
    $(function () {
        $("button").click(function () {
            $.get("/user/ajax",
                {username: '楚枫', password: 'cufeng', age: 23},
                function (data) {
                    console.log(data);
                }, "json")
        })
    })
</script>
</body>
</html>
