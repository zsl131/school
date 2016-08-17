<#include "/header.ftl">
    <!-- ECharts单文件引入 -->
    <script src="echarts-3.2.2/echarts.min.js"></script>
    <script src="echarts-3.2.2/dark.js"></script>

    <input id="normalParams" cityDivision="${cityDivision}" schId="${schoolId?c}" schCode="${schoolCode}" time="${time}" type="hidden"/>

    <div class="row">
        <div class="col-md-3">
            <div class="panel panel-success">
                <div class="panel-heading"><i class="glyphicon glyphicon-credit-card"></i> 驾校名片</div>
                <div class="panel-body">
                    <p>驾校名称：${schInfoDto.jxmc}</p>
                    <p>可教车型：${schInfoDto.kpxcx}</p>
                    <#if (schInfoDto.lxr)??>
                        <p>联系人：${schInfoDto.lxr}</p>
                    </#if>
                    <p>驾校地址：${schInfoDto.jxdz}</p>

                    <div class="query_school_legal">
                        <h4>教练车违章统计（一年内）：</h4>
                        <p>统计车辆：<b class="carAmount"><img src="loading.gif"/></b>辆</p>
                        <p>违章车辆：<b class="legalCarAmount"><img src="loading.gif"/></b>辆</p>
                        <p>违章次数：<b class="legalAmount"><img src="loading.gif"/></b>起</p>
                        <p>共处罚金：<b class="totalMoney"><img src="loading.gif"/></b>元</p>
                        <p>共计扣分：<b class="totalScore"><img src="loading.gif"/></b>分</p>
                    </div>
                </div>
            </div>

            <!-- 显示车辆统计 -->
            <div class="alert">
                <div id="schoolCarCount" style="height:380px;" class="show_student_car_count_area" title="${schInfoDto.jxjc}车型分布图"></div>
                <script type="text/javascript" src="js/school_car_count.js"></script>
            </div>
        </div>

        <div class="col-md-6">
            <!-- 评价统计 -->
            <div class="row">
                <div class="col-md-6">
                    <!-- 性别分类的学员统计 -->
                    <div class="alert">
                        <div id="appraiseCountSchool" style="height:360px;" class="show_appraise_count_area" title="${schInfoDto.jxjc}-驾校评价统计" dataType="SCHOOL"></div>
                        <script type="text/javascript" src="js/school_appraise_count.js"></script>
                    </div>
                </div>

                <div class="col-md-6">
                    <!-- 结果分类的学员统计 -->
                    <div class="alert">
                        <div id="appraiseCountCoach" style="height:360px;" class="show_appraise_count_area" title="${schInfoDto.jxjc}-教练评价统计" dataType="COACH"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <!-- 模拟考试统计，科目一 -->
                    <div class="alert">
                        <div id="testRecordCount1" style="height:360px;" class="show_test_record_count_area" title="${schInfoDto.jxjc}-科一模拟统计" dataType="1"></div>
                        <script type="text/javascript" src="js/school_test_record_count.js"></script>
                    </div>
                </div>

                <div class="col-md-6">
                    <!-- 模拟考试统计，安全文明 -->
                    <div class="alert">
                        <div id="testRecordCount4" style="height:360px;" class="show_test_record_count_area" title="${schInfoDto.jxjc}-科四模拟统计" dataType="4"></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="row">
                <div class="col-md-12" style="padding-bottom:12px">
                    <div>
                        <button class="btn btn-primary">统计时间段：</button>
                        <a href="/sch?schId=${schoolId}&cityDivision=${cityDivision}&schCode=${schoolCode}&time=1" class="btn btn-info <#if time==1>btn-warning</#if>">昨天</a>
                        <a href="/sch?schId=${schoolId}&cityDivision=${cityDivision}&schCode=${schoolCode}&time=30" class="btn btn-info <#if time==30>btn-warning</#if>">一月内</a>
                        <a href="/sch?schId=${schoolId}&cityDivision=${cityDivision}&schCode=${schoolCode}&time=90" class="btn btn-info <#if time==90>btn-warning</#if>">三月内</a>
                        <a href="/sch?schId=${schoolId}&cityDivision=${cityDivision}&schCode=${schoolCode}&time=365" class="btn btn-info <#if time==365>btn-warning</#if>">一年内</a>
                    </div>
                </div>
            </div>

            <!-- 性别分类的学员统计 -->
            <div class="alert">
                <div id="schoolStuCount" style="height:320px;" class="show_student_count_area" title="${schInfoDto.jxjc}学员性别分布图" dataType="1"></div>
                <script type="text/javascript" src="js/school_stu_count.js"></script>
            </div>

            <!-- 结果分类的学员统计 -->
            <div class="alert">
                <div id="schoolStuCount2" style="height:320px;" class="show_student_count_area" title="${schInfoDto.jxjc}考试结果分布图" dataType="2"></div>
            </div>
        </div>
    </div>

    <!-- 查询驾校车辆违章数据 -->
    <script type="text/javascript" src="js/query_school_legal.js"></script>
<#include "/footer.ftl">