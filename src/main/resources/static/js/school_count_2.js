$(function() {
    //alert($("#temp").val());
    var examPlaceObj = $("#school_count_p");
    var title = $(examPlaceObj).attr("title");
    var dataJson = eval('(' + $(examPlaceObj).html() + ')');

    // 基于准备好的dom，初始化echarts图表
    var schoolCountDiv2 = echarts.init(document.getElementById('schoolCountDiv2'), "dark");

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
                name: '驾校分布',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:dataJson.datas,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    },
                    normal : {
                        label : {
                            formatter : function (params) {
                              return params.name+"-"+params.value+"("+(params.percent - 0).toFixed(1) + '%)'
                            }
                        },
                        labelLine : {
                            show : true
                        }
                    }
                }
            }
        ]
    };

    // 为echarts对象加载数据
    schoolCountDiv2.setOption(option);
});