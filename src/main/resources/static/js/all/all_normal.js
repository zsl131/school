$(function() {
    $("tr.school_count").each(function() {
        var thisObj = $(this);
        var code = $(thisObj).attr("code");
        var params = ["cityDivision:530000"];
        $.ajax({
            url: "/queryNormalDatas",
            data: {"code":code, "params[]": params},
            success: function(datas) {
                var jsonObj = eval('(' + datas + ')');
                //alert(jsonObj);
//                alert(JSON.stringify(jsonObj.datas['530100']));
                $(thisObj).find("td").each(function() {
                    var divisionCode = $(this).attr("divisionCode");
                    //alert(divisionCode+"===");
                    if(divisionCode && divisionCode!='530000') {
                        var tmpObj = jsonObj.datas[""+divisionCode];
                        //alert(JSON.stringify(tmpObj));
                        var html = '';

                        for(var i=0; i<tmpObj.length; i++) {
                            html += '<p>'+tmpObj[i].carType+'：'+tmpObj[i].amount+'</p>';
                        }
                        $(this).html(html);
                    }
                });
            }
        });
    });

});