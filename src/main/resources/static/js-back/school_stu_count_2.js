$(function() {
    //alert($("#temp").val());
    var dataObj = $("#school_stu_count_p_2");
    var title = $(dataObj).attr("title");
    var dataJson = eval('(' + $(dataObj).html() + ')');
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
            'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec, theme) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('schoolStuCount2'), theme);

            var option = {
                title : {
                    text: title,
                    //subtext: '纯属虚构',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                series : [
                    {
                        //name: '访问来源',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:dataJson.datas
                    }
                ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);
        }
    );
});