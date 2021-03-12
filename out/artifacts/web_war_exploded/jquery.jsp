<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <input type="text" name="card" id="card">

    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script type="application/javascript">
        $(document).ready(function()
        {
            $('#card').blur(function(){
                <%--$.ajax({--%>
                <%--    url: '${pageContext.request.contextPath}/person.do',--%>
                <%--    type: 'post',--%>
                <%--    async: true,--%>
                <%--    // data: 'card='+$(this).val()+'&kc=card',--%>
                <%--    data: {card: $(this).val(), kc: 'card'},--%>
                <%--    dataType: 'json',--%>
                <%--    beforeSend: function()--%>
                <%--    {--%>
                <%--        console.log('请求发出之前...')--%>
                <%--    },--%>
                <%--    success: function(result)--%>
                <%--    {--%>
                <%--        if(result.success)--%>
                <%--        {--%>
                <%--            alert('恭喜, 账号可以用!')--%>
                <%--        }--%>
                <%--    },--%>
                <%--    error: function(a, b, c)--%>
                <%--    {--%>
                <%--        console.log('服务器返回响应但出现异常')--%>
                <%--    },--%>
                <%--    complete: function()--%>
                <%--    {--%>
                <%--        console.log('本次请求执行结束')--%>
                <%--    }--%>
                <%--});--%>

                <%--$.ajax({--%>
                <%--    url: '${pageContext.request.contextPath}/person.do',--%>
                <%--    type: 'post',--%>
                <%--    data: {card: $(this).val(), kc: 'card'},--%>
                <%--    dataType: 'json',--%>
                <%--    success: function(result)--%>
                <%--    {--%>
                <%--        if(result.success)--%>
                <%--        {--%>
                <%--            alert('恭喜, 账号可以用!')--%>
                <%--        }--%>
                <%--    }--%>
                <%--});--%>

                // $.post(url, params, callback, dataType);
                $.get('${pageContext.request.contextPath}/person.do', {card: $(this).val(), kc: 'card'}, function(result){
                    alert( result.success );
                }, 'json');

            });
        });
    </script>
</body>
</html>
