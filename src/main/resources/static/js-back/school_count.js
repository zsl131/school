$(function() {
    //alert($("#temp").val());
    var title = $("#school_count_title").val();
    var dataJson = eval('(' + $("#school_count_json").html() + ')');
    // 路径配置
    require.config({
        paths: {
            echarts: 'echarts-2.2.7'
        }
    });

    // 使用
    require(
        [
            'echarts',
            'echarts/theme/dark', //主题
            'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec, theme) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('schoolCountDiv'), theme);

            var option = {
                title : {
                    text: title,
                    //subtext: '纯属虚构',
                    x:'center'
                },
                tooltip: {
                    show: true
                },
                /*legend: {
                    data:[title]
                },*/
                xAxis : [
                    {
                        type : 'category',
                        //data : ["衬衫1","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                        data : dataJson.cates
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":title,
                        "type":"bar",
                        //"data":[5, 20, 40, 10, 10, 20]
                        "data": dataJson.values
                    }
                ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);
        }
    );
});