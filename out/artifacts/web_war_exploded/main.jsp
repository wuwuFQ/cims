<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">

    <title>干部收入管理系统-主页</title>

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
          rel="stylesheet" type="text/css" media="screen"/>
    <link href="${pageContext.request.contextPath}/static/css/owl.carousel.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style-responsive.css" rel="stylesheet"/>
</head>

<body>

<section id="container" class="">

    <!--main content start-->
    <section id="">
        <section class="wrapper">

            <!--state overview start-->
            <div class="row state-overview">
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol terques">
                            <i class="icon-user"></i>
                        </div>
                        <div class="value">
                            <h1 id="user">0</h1>
                            <p>当月新用户</p>
                        </div>
                    </section>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol red">
                            <i class="icon-tags"></i>
                        </div>
                        <div class="value">
                            <h1 id="heating">0</h1>
                            <p>本周供暖补贴</p>
                        </div>
                    </section>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol yellow">
                            <i class="icon-shopping-cart"></i>
                        </div>
                        <div class="value">
                            <h1 id="property">0</h1>
                            <p>本周物业补贴</p>
                        </div>
                    </section>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol blue">
                            <i class="icon-bar-chart"></i>
                        </div>
                        <div class="value">
                            <h1 id="total">0</h1>
                            <p>本总补贴金额</p>
                        </div>
                    </section>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <!--本月补贴 start-->
                    <div class="panel terques-chart">
                        <div class="panel-body chart-texture">
                            <div class="chart">
                                <div class="heading">
                                    <span>当前月补贴</span>
                                    <strong>￥ 4,880,457,00 | 35%</strong>
                                </div>
                                <div class="sparkline" data-type="line" data-resize="true" data-height="75"
                                     data-width="90%" data-line-width="1" data-line-color="#fff" data-spot-color="#fff"
                                     data-fill-color="" data-highlight-line-color="#fff" data-spot-radius="4"
                                     data-data="[200,135,667,333,526,996,564,123,890,564,455,200,135,667,333,526,996,564,123,890,564,455]"></div>
                            </div>
                        </div>
                        <div class="chart-tittle">
                            <span class="title">最新记录。。。</span>
                        </div>
                    </div>
                    <!--本月补贴 end-->

                    <div class="panel green-chart">
                        <div class="panel-body">
                            <div class="chart">
                                <div class="heading">
                                    <span>前一月补贴</span>
                                    <strong>30 天 | 99%</strong>
                                </div>
                                <div id="main" style="width: 100%;height: 300px;"></div>
                            </div>
                        </div>
                        <div class="chart-tittle">
                            <span class="title">总补贴额</span>
                            <span class="value">￥ 76,524,678</span>
                        </div>
                    </div>
                </div>
            </div>

        </section>
    </section>
    <!--main content end-->
</section>

<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/echarts/echarts.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        let mainCharts = echarts.init(document.getElementById('main'));

        let option = {
            xAxis: {
                type: 'category',
                data: ['11-01', '11-02', '11-03', '11-04', '11-05', '11--06']
            },
            yAxis: {
                type: 'value',
                min:200,
                max: 1000
            },
            series: [{
                data: [335, 782, 991, 923, 351, 531],
                type: 'bar'
            }]
        };

        mainCharts.setOption(option);

        //页面初始化数据方法
        function init()
        {
            // $.get('url', function(result)
            // {
            //
            // }, 'json');
            $('#user').text(10);
            $('#heating').text(10);
            $('#property').text(10);
            $('#total').text(10);

            /**
             * java -> Image w h
             * highcharts -> jquery charts
             * echarts -> baidu charts apache.org   echart.apache.org  tomcat.apache.org
             *
             */
        }
        //每个一分钟调用一次服务器刷新数据
        setInterval(init, 60000);
    });
</script>
</body>
</html>
