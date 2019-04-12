<%--
  Created by IntelliJ IDEA.
  User: lyd20
  Date: 2019/3/31
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/textView">测试view</a>
    <hr/>
    <a href="${pageContext.request.contextPath}/update/1">更新</a>
    <hr/>
    <input type="button" id="btn" value="请求JSON"/>

    <form id="myform">
        user:<input type="text" name="username"><br>
        age:<input type="text" name="age"><br>
        爱好:<input type="checkbox" name="hobby" value="篮球"> 篮球
        <input type="checkbox" name="hobby" value="乒乓球"> 乒乓球
        <input type="checkbox" name="hobby" value="足球"> 足球
    </form>
    <input type="button" id="formbtn" value="发送form">


<script>
    /*序列化转Json*/
    (function($){
        $.fn.serializeJson=function(){
            var serializeObj={};
            var array=this.serializeArray();
            var str=this.serialize();
            $(array).each(function(){
                if(serializeObj[this.name]){
                    if($.isArray(serializeObj[this.name])){
                        serializeObj[this.name].push(this.value);
                    }else{
                        serializeObj[this.name]=[serializeObj[this.name],this.value];
                    }
                }else{
                    serializeObj[this.name]=this.value;
                }
            });
            return serializeObj;
        };
    })(jQuery);

    $(function () {
        $("#formbtn").click(function () {
            //获取表单中所有的参数，发送给服务器
            var serialize = $("#myform").serializeJson();
            console.log(serialize);
            console.log(JSON.stringify(serialize))

            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/formJson",
                data:JSON.stringify(serialize),
                dataType:'json',
                contentType:'application/json',
                success:function (data) {
                    alert(data.responseText)
                }
            });


            /**
            $.post("${pageContext.request.contextPath}/formJson",serializa,function (data) {
                console.log(data);
            });*/
        });



        $("#btn").click(function () {
            //发送Ajax请求
            $.post("${pageContext.request.contextPath}/getJson", function (data) {
                console.log(data);
            });
        });

    });
</script>


</body>
</html>
