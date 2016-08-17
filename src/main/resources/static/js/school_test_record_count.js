$(function() {
    var normalParams = $("#normalParams");
    var cityDivision = $(normalParams).attr("cityDivision");
    var schId = $(normalParams).attr("schId");
    var schCode = $(normalParams).attr("schCode");
    var time = $(normalParams).attr("time");

    $(".show_test_record_count_area").each(function() {
        var objId = $(this).attr("id");
        var thisObj = $(this);
        //alert(cityDivision+"=="+schId+"=="+schCode+"=="+time);
        var name = "模拟考试统计";

        var title = $(this).attr("title");
        var type = $(thisObj).attr("dataType");

        ///alert(title+"==="+type);
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById(objId), "dark");
        myChart.showLoading();
        $.get("/queryTestRecordCountDatas?schoolId="+schId+"&steps="+type+"&cityDivision="+cityDivision).done(function(resData) {
            //alert(resData);
            myChart.hideLoading();
            var dataJson = eval('(' + resData + ')');
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
                        name: name,
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
            myChart.setOption(option);
        });
    });


});