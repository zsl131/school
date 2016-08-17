<#include "/header.ftl">
    <!-- ECharts单文件引入 -->
    <!-- <script src="echarts-2.2.7/echarts.js"></script> -->
    <script src="echarts-3.2.2/echarts.min.js"></script>
    <script src="echarts-3.2.2/dark.js"></script>
    <div class="row">
        <div class="col-md-3">
            <div class="alert">
                <div id="show_map_div" style="height:480px;" cityDivision="${cityDivision}"></div>
                <script type="text/javascript" src="js/yunnan_map.js"></script>
            </div>

            <!-- 地州显示 -->
            <div class="alert">
                <div class="need_change_margin">
                    <#if divisionList??>
                    <#list divisionList as division>
                    <#if division?? && division.code?? && division.name??>
                        <#if cityDivision==division.code>
                            <a href="javascript:void(0)" class="btn btn-warning" title="${division.name}"}>${division.name}</a>
                        <#else>
                            <a href="/index?cityDivision=${division.code}" class="btn btn-success" title="${division.name}"}>${division.name}</a>
                        </#if>
                    </#if>
                    </#list>
                    </#if>
                </div>
            </div>


        </div>

        <div class="col-md-6">
             <!-- 显示驾校 -->
            <div class="alert">
                <div id="schoolCountDiv" style="height:400px"></div>
                <input id="school_count_title" type="hidden" value="${cityName}驾校类型分布图"/>
                <p id="school_count_json" style="display:none;">${schoolCountJson}</p>

                <script type="text/javascript" src="js/school_count.js"></script>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <!-- 驾校数量统计 -->
                    <div id="schoolCountDiv2" style="height:280px;"></div>
                    <p id="school_count_p" title="${cityName}驾校分布图" style="display:none">${schoolCountJson2}</p>
                    <script type="text/javascript" src="js/school_count_2.js"></script>
                </div>

                <div class="col-md-6">
                    <!-- 考场数量统计 -->
                    <div class="alert">
                        <div id="examPlaceCountDiv" style="height:280px;"></div>
                        <p id="exam_place_count_p" title="${cityName}各考场分布图" style="display:none">${placeCountJson}</p>
                        <script type="text/javascript" src="js/exam_place_count.js"></script>
                    </div>
                </div>
            </div>

        </div>

        <div class="col-md-3">
            <!-- 县级区划 -->
            <#if divisionList2 ??>
                <div class="alert need_change_margin">
                <#list divisionList2 as divObj>
                     <#if division==divObj.code>
                        <a href="javascript:void(0)" class="btn btn-warning" title="${divObj.name}"}>${divObj.name}</a>
                     <#else>
                        <a href="/index?division=${divObj.code}&cityDivision=${cityDivision}" class="btn btn-success" title="${divObj.name}"}>${divObj.name}</a>
                     </#if>
                </#list>
                </div>
            </#if>

            <!-- 显示驾校列表 -->
            <#if schoolList ??>
                <div class="alert need_change_margin">
                <#list schoolList as sch>
                    <a href="/sch?schId=${(sch.id)?c}&cityDivision=${sch.cityDivision}&schCode=${sch.schoolCode}" class="btn btn-success">${sch.schoolName}<!--[${sch.carType}]--></a>
                </#list>
                </div>
            </#if>
        </div>
    </div>


<#include "/footer.ftl">