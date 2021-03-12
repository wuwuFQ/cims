<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="javakc-zhg">
    <title>物业补贴管理</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/assets/bootstrap-datepicker/css/datepicker.css" />
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
  </head>
  <body>
  <section id="container" class="">
      <div class="row">
          <div class="col-lg-12">
              <section class="panel">
                  <header class="panel-heading">
                      ${type == 1?"供暖":"物业"}补贴
                  </header>
                  <div class="row">
	                  <div class="col-lg-12">
	                      <section class="panel">
	                          <div class="panel-body">
	                              <form class="form-inline" role="form">
	                                  <div class="form-group">
	                                      <label class="">姓名</label>
	                                      <input type="text" class="form-control" placeholder="输入姓名">
	                                  </div>
	                                  <div class="form-group">
	                                      <label class="">身份证号</label>
	                                      <input type="text" class="form-control" placeholder="请输入身份证号">
	                                  </div>
	                                  <div class="form-group">
	                                      <label class="">月份</label>
	                                      <input type="text" id="sdate" class="form-control" placeholder="请输入开始日期" readonly>
	                                  </div>
	                                  <button type="submit" class="btn btn-success">搜索</button>
	                                  <button type="button" id="create" class="btn btn-info">添加</button>
	                                  <button type="submit" class="btn btn-danger">批量删除</button>
	                              </form>
	                          </div>
	                      </section>
	                  </div>
	              </div>
                  <table class="table table-striped table-advance table-hover">
                      <thead>
	                      	<tr>
								<th><input type="checkbox"/></th>
	                          	<th><i class="icon-bullhorn"></i>序号</th>
	                          	<th><i class="icon-male"></i>月份</th>
	                          	<th><i class="icon-bookmark"></i>姓名</th>
	                          	<th><i class="icon-edit"></i>身份证</th>
	                          	<th><i class="icon-tags"></i>职级</th>
	                          	<th><i class="icon-jpy"></i>金额</th>
	                          	<th><i class="icon-home"></i>操作</th>
	                      	</tr>
                      </thead>
                      <tbody>
					  	<c:forEach items="${list}" var="e" varStatus="n">
	                      	<tr>
	                      		<th><input type="checkbox"/></th>
	                          	<td>${n.count}</td>
	                          	<td>
									<f:formatDate value="${e.month}" pattern="yyyy年MM月"/>
								</td>
	                          	<td>
									${e.person.name}
								</td>
	                          	<td>${e.person.card} </td>
	                          	<td>${e.person.grade}</td>
	                          	<td>${e.money}￥</td>
	                          	<td>
	                              	<button class="btn btn-primary btn-xs"><i class="icon-pencil"></i></button>
	                              	<button class="btn btn-danger btn-xs"><i class="icon-trash "></i></button>
	                          	</td>
	                      	</tr>
						</c:forEach>
                      </tbody>
                  </table>
                  <div class="btn-row">
                      <div class="btn-toolbar">
                          <div class="btn-group">
                              <button class="btn btn-primary" type="button">首页</button>
                              <button class="btn btn-primary" type="button">上页</button>
                              <button class="btn btn-primary" type="button">下页</button>
                              <button class="btn btn-primary" type="button">末页</button>
                          </div>
                      </div>
                  </div>
              </section>
          </div>
      </div>
  	</section>
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script>
		$(document).ready(function() 
		{
			$('#create').bind('click', function()
			{
				window.location.href='${pageContext.request.contextPath}/view/subsidy/create.jsp?type=${type}';
			});

			$('#sdate').datepicker({
	            format: 'yyyy-mm'
	        });
		});
    </script>
  </body>
</html>