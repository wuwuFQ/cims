<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <table>--%>
<%--        <thead>--%>
<%--            <tr>--%>
<%--                <th>序号</th>--%>
<%--                <th>票种</th>--%>
<%--                <th>席别</th>--%>
<%--                <th>姓名</th>--%>
<%--                <th>证件类型</th>--%>
<%--                <th>证件号码</th>--%>
<%--                <th>手机号码</th>--%>
<%--                <th></th>--%>
<%--            </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--            <tr>--%>
<%--                <td>1</td>--%>
<%--                <td>--%>
<%--                    <select>--%>
<%--                        <option value="">成人票</option>--%>
<%--                        <option value="">儿童票</option>--%>
<%--                        <option value="">学生票</option>--%>
<%--                        <option value="">残军票</option>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <select>--%>
<%--                        <option value="">商务座</option>--%>
<%--                        <option value="">一等座</option>--%>
<%--                        <option value="">二等座</option>--%>
<%--                        <option value="">站票</option>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--                <td><input type="text"/></td>--%>
<%--                <td>--%>
<%--                    <select>--%>
<%--                        <option value="">二代省份证</option>--%>
<%--                        <option value="">港澳通行证</option>--%>
<%--                        <option value="">护照</option>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--                <td><input type="text"/></td>--%>
<%--                <td><input type="text"/></td>--%>
<%--                <td><input type="button" id="add" value="＋"/></td>--%>
<%--            </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>

    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script type="application/javascript">
        $(document).ready(function()
        {
            $('#add').click(function () {
                //1.1克隆tr
                let newTr = $('tbody>tr:first').clone();
                let trLen = $('tbody>tr').length;
                //1.2修改tr
                $(newTr).find('[type=button]')
                    .val('－')
                    .removeAttr('id')
                    .attr('name', 'removes')
                    .click(function () {
                        $(this).parent().parent().remove();
                        //序号排序
                        $('#add').prop('disabled', false);
                    });
                $(newTr).find('td:first').text(++trLen);
                //2.追加tr
                $('tbody').append(newTr);
                //3.判断下一次是否继续添加
                if( trLen === 5 ){
                    $(this).prop('disabled', true);
                }

                // 无法使用
                // $('[name=removes]').click(function () {
                //     alert('ksksksks')
                // })
            });

            // $(document).delegate('[name=removes]', 'click', function()
            // {
            //     alert('delete');
            // });
        });
    </script>
</body>
</html>
