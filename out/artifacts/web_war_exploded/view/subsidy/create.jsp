<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <link rel="shortcut icon" href="img/favicon.html">
    <title>补贴添加</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/assets/bootstrap-datepicker/css/datepicker.css"/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
<body>
<section id="container" class="">

    <div class="row">
        <div class="col-lg-12">
            <section class="panel">
                <header class="panel-heading">
                    ${param.type == 1?"供暖":"物业"}补贴
                </header>
                <div class="panel-body">
                    <form class="form-horizontal tasi-form" action="${pageContext.request.contextPath}/subsidy.do"
                          method="post">
                        <input type="hidden" name="type" value="${param.type}">
                        <input type="hidden" name="personId" id="personId" value="">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="输选择姓名" id="name" readonly required>
                                <span class="help-block">请选择人员!</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">身份证号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="请选择姓名证件编号" id="card" readonly required>
                                <span class="help-block">根据选择的人员自动显示该人员的证件编号!</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">补贴金额</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="请输入补贴金额">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">更改原因</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="请输入更改原因">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label"></label>
                            <div class="col-lg-10">
                                <button type="submit" class="btn btn-success">添加</button>
                                <button type="submit" class="btn btn-success">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
        </div>
    </div>
</section>

<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //为人员选择绑定点击事件
        $('#name').click(function()
        {
            //1.查询需要补贴的人员
            /**
             * 1.创建ajax引擎对象
             * 2.指定响应处理函数
             *  2.1:判断状态 请求状态
             *  2.2:判断状态 响应状态
             *  2.3:接受服务器返回内容 string/xml
             * 3.配置请求相关参数
             * 4.发送请求携带参数
             */

            let content = '';

            let request = new XMLHttpRequest();
            request.onreadystatechange = function()
            {
                if(request.readyState === 4 && request.status === 200)
                {
                    let result = request.responseText;
                    content = JSON.parse(result);
                }
            };
            request.open('get', '${pageContext.request.contextPath}/subsidy.do?kc=subsidyPerson&type=${param.type}', false);
            request.send();

            //2.手动拼页面
            let html = '';
            html += '<table class="table table-striped table-advance table-hover">';
            html += '   <thead>';
            html += '        <tr>';
            html += '               <th></th>';
            html += '               <th><i class="icon-bullhorn"></i>序号</th>';
            html += '               <th><i class="icon-male"></i>姓名</th>';
            html += '               <th><i class="icon-bookmark"></i>身份证号</th>';
            html += '               <th><i class="icon-edit"></i>状态</th>';
            html += '       </tr>';
            html += '   </thead>';
            html += '   <tbody>';
            $.each(content, function(i, o)
            {
                html += '   <tr>';
                html += '       <td><input type="radio" name="personIds" value="'+i+'"/></td>';
                html += '       <td>'+(i+1)+'</td>';
                html += '       <td>'+o.name+'</td>';
                html += '       <td>'+o.card+'</td>';
                html += '       <td>'+o.state+'</td>';
                html += '   </tr>';
            });
            html += '   </tbody>';
            html += '   <tfoot>';
            html += '       <tr>';
            html += '           <td colspan="5" style="text-align: center;"><button class="btn btn-primary" type="button" id="choose">确认</button></td>';
            html += '       </tr>';
            html += '   </tfoot>';
            html += '</table>';

            //3.弹窗并显示补贴人员
            let index = layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['520px', '440px'], //宽高
                content: html
            });

            $('#choose').click(function()
            {
                let radioArray = $('[name=personIds]:checked');
                if($(radioArray).length === 0)
                {
                    layer.alert('请选择补贴的人员!', {
                        skin: 'layui-layer-molv'
                        ,closeBtn: 0
                        ,anim: 4 //动画类型
                    });
                }
                let person = content[$(radioArray).first().val()];
                $('#personId').val(person.id);
                $('#name').val(person.name);
                $('#card').val(person.card);

                layer.close(index);
            });
        });



        $('#date').datepicker({
            format: 'yyyy-mm-dd'
        });
    });
</script>
</body>
</html>
