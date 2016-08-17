$(function() {
    //alert($("#temp").val());
    var title = $("#school_count_title").val();
    var dataJson = eval('(' + $("#school_count_json").html() + ')');

    // 基于准备好的dom，初始化echarts图表
    var schoolCountDiv = echarts.init(document.getElementById('schoolCountDiv'), "dark");

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
                "data": dataJson.values,
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                }
            }
        ]
    };

    // 为echarts对象加载数据
    schoolCountDiv.setOption(option);
});