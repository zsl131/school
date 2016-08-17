$(function() {
    var curCityDivision = $("#show_map_div").attr("cityDivision");
    $.get('yunnan.json', function (chinaJson) {
        echarts.registerMap('yunnan', chinaJson);
        var chart = echarts.init(document.getElementById('show_map_div'), "dark");
        chart.setOption({
            series: [{
                type: 'map',
                map: 'yunnan',
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[
                    {name:getCityName(curCityDivision), selected:true}
                ]
            }]
        });

        chart.on('click', function (params) {
            //alert(JSON.stringify(params.dataType));

            var cityName = params.name;
            var cityDivision = getCityDivision(cityName);

            //alert(index+"======"+cityDivision);
            window.location.href = "/index?cityDivision="+cityDivision;
        });
    });


});

function getCityName(cityDivision) {
    var res = "云南省";
    if(cityDivision=='530100') { res = "昆明市";}
    else if(cityDivision=='530300') {res = "曲靖市";}
    else if(cityDivision=='530600') {res = "昭通市";}
    else if(cityDivision=='530700') {res = "丽江市";}
    else if(cityDivision=='530400') {res = "玉溪市";}
    else if(cityDivision=='530900') {res = "临沧市";}
    else if(cityDivision=='530800') {res = "普洱市";}
    else if(cityDivision=='532300') {res = "楚雄州";}
    else if(cityDivision=='532800') {res = "西双版纳";}
    else if(cityDivision=='532600') {res = "文山州";}
    else if(cityDivision=='532500') {res = "红河州";}
    else if(cityDivision=='533100') {res = "德宏州";}
    else if(cityDivision=='532900') {res = "大理州";}
    else if(cityDivision=='533300') {res = "怒江州";}
    else if(cityDivision=='533400') {res = "迪庆州";}
    else if(cityDivision=='530500') {res = "保山市";}
    return res;
}

function getCityDivision(cityName) {
    var res = "云南省";
    if(cityName=='昆明市') { res = "530100";}
    else if(cityName=='曲靖市') {res = "530300";}
    else if(cityName=='昭通市') {res = "530600";}
    else if(cityName=='丽江市') {res = "530700";}
    else if(cityName=='玉溪市') {res = "530400";}
    else if(cityName=='临沧市') {res = "530900";}
    else if(cityName=='普洱市') {res = "530800";}
    else if(cityName=='楚雄州') {res = "532300";}
    else if(cityName=='西双版纳') {res = "532800";}
    else if(cityName=='文山州') {res = "532600";}
    else if(cityName=='红河州') {res = "532500";}
    else if(cityName=='德宏州') {res = "533100";}
    else if(cityName=='大理州') {res = "532900";}
    else if(cityName=='怒江州') {res = "533300";}
    else if(cityName=='迪庆州') {res = "533400";}
    else if(cityName=='保山市') {res = "530500";}
    return res;
}