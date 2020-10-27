<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>


<%--    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.1.1.min.js"></script>--%>
<%--    <script>--%>
<%--        function a1(){--%>
<%--            $.post({--%>
<%--                url:"${pageContext.request.contextPath}/a1",--%>
<%--                data:{'name':$("#txtName").val()},--%>
<%--                success:function (data,status) {--%>
<%--                    alert(data);--%>
<%--                    alert(status);--%>
<%--                }--%>
<%--            });--%>
<%--        }--%>
<%--    </script>--%>

</head>
<body>

<%--onblur：失去焦点触发事件--%>
<%--用户名:<input type="text" id="txtName" onblur="a1()"/>--%>
<input type="button" id="btn" value="获取数据"/>
<table width="80%" align="center">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
    </tbody>
</table>

<script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.1.1/jquery.min.js"></script>
<script>

    $(function () {
        $("#btn").click(function () {
            $.post("${pageContext.request.contextPath}/a2",function (data) {
                console.log(data)
                var html="";
                for (var i = 0; i <data.length ; i++) {
                    html+= "<tr>" +
                        "<td>" + data[i].name + "</td>" +
                        "<td>" + data[i].age + "</td>" +
                        "<td>" + data[i].sex + "</td>" +
                        "</tr>"
                }
                $("#content").html(html);
            });
        })
    })
</script>
</body>
</html>