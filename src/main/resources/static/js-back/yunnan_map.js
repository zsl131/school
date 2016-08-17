$(function() {
    $.get('china.json', function (chinaJson) {
        echarts.registerMap('china', chinaJson);
        var chart = echarts.init(document.getElementById('show_map_div'));
        chart.setOption({
            series: [{
                type: 'map',
                map: 'china'
            }]
        });
    });
});