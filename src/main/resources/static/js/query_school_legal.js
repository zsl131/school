$(function() {
    var normalParams = $("#normalParams");
    var schoolId = $(normalParams).attr("schId");
    var pObj = $(".query_school_legal");
    $.post("/queryLegalCountData?schoolId="+schoolId+"&range=12", function(datas) {
        $(pObj).find(".carAmount").html(datas.carAmount);
        $(pObj).find(".legalCarAmount").html(datas.legalCarAmount);
        $(pObj).find(".legalAmount").html(datas.legalAmount);
        $(pObj).find(".totalMoney").html(datas.moneyAmount);
        $(pObj).find(".totalScore").html(datas.scoreAmount);
    });
});