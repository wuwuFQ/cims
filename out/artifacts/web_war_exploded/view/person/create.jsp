<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <title>人员添加</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/assets/bootstrap-datepicker/css/datepicker.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
  <body>
  <section id="container" class="">
     
    <div class="row">
    <div class="col-lg-12">
      <section class="panel">
          <header class="panel-heading">
             人员添加
          </header>
          <div class="panel-body">
              <form class="form-horizontal tasi-form" action="${pageContext.request.contextPath}/person.do" method="post">
                  <input type="hidden" name="kc" value="create"/>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">姓名</label>
                      <div class="col-sm-10">
                          <input type="text" class="form-control" name="name" placeholder="输入姓名">
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">身份证号</label>
                      <div class="col-sm-10">
                          <input type="text" class="form-control" name="card" placeholder="输入姓名证件编号">
                          <span class="help-block">请输入正确的证件编号, 并确认该编号是唯一的!</span>
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">状态</label>
                      <div class="col-sm-10">
                          <select class="form-control" name="state">
                            <option value="0">请选择</option>
                            <option value="1">离休</option>
                            <option value="2">退休</option>
                          </select>
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">职级</label>
                      <div class="col-sm-10">
                          <select class="form-control" name="grade">
                              <option value="0">请选择</option>
                              <c:forEach items="${applicationScope.grade}" var="grade">
                                  <option value="${grade.key}">${grade.value}</option>
                              </c:forEach>
                          </select>
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">起薪日期</label>
                      <div class="col-sm-10">
                          <input class="form-control"  name="start" type="text" placeholder="点击这里选择日期..." id="date" readonly>
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="control-label col-lg-2">补贴项目</label>
                      <div class="col-lg-10">
                          <label class="checkbox-inline">
                              <input type="checkbox" name="heating" value="1"> 供暖
                          </label>
                          <label class="checkbox-inline">
                              <input type="checkbox" name="property" value="1"> 物业
                          </label>
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">更改原因</label>
                      <div class="col-sm-10">
                          <input type="text" name="reason" class="form-control" placeholder="请输入更改原因">
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="col-lg-2 control-label"></label>
                      <div class="col-lg-10">
                         <button type="submit" class="btn btn-success" disabled>添加</button>
                         <button type="button" class="btn btn-warning" onclick="javascript:window.history.go(-1)">返回</button>
                      </div>
                  </div>
              </form>
          </div>
      </section>
  </section>

    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/layer/layer.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('[name=card]').on('blur', function(){
                let object = $(this);
                let card = $(object).val();
                if($.trim(card).length === 18)
                {
                    //通过ajax发送异步请求, 在无刷新页面的情况下完成与数据库交互
                    //1.创建ajax引擎对象
                    let request = new XMLHttpRequest();
                    //2.指定响应处理函数
                    request.onreadystatechange = function()
                    {
                        /**
                         * readyState 0-4
                         * 0: ajax引擎对象未初始化
                         * 1: 未配置请求参数
                         * 2: 已配置请求参数, 但未发出请求
                         * 3: 客户端发出请求, 服务器还未返回响应
                         * 4: 服务器已经返回响应
                         */
                        //2.1发出请求即弹出装载层
                        layer.load();
                        if( request.readyState === 4)
                        {
                            //2.2服务器返回响应后关闭装载...
                            layer.closeAll('loading');
                            //2.3接受服务器返回响应状态码
                            if(request.status === 200)
                            {
                                //2.4获取服务器返回的响应内容
                                /**
                                 * ajax只能接受服务器返回两种数据格式
                                 * 1. string字符串 request.responseText
                                 * 2. xml文档 request.responseXML
                                 */
                                if( '0' === request.responseText )
                                {
                                    $(object).next().html('<font color="green">恭喜...!</font>');
                                }
                                else
                                {
                                    $(object).next().html('<font color="#dc143c">该账号已经被占用, 请输入其他的证件编号!</font>');
                                }
                            }
                            else
                            {
                                layer.msg('很遗憾, 出现了问题!');
                            }
                        }
                    };
                    //3.配置请求相关参数
                    request.open('post', '${pageContext.request.contextPath}/person.do');
                    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    //4.发出请求并携带参数
                    request.send('kc=card&card='+card);
                }
                $(object).next().html('<font color="#dc143c">请输入正确的证件编号!</font>');
            });

            $('#date').datepicker({
                format: 'yyyy-mm-dd'
            });
        });
    </script>
  </body>
</html>
