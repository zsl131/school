<#include "/header.ftl">

<div class="row">
    <div class="col-md-12" style="padding-bottom:12px">
        <div>
            <button class="btn btn-primary">统计时间段：</button>
            <a href="/all?days=1" class="btn btn-info <#if days==1>btn-warning</#if>">昨天</a>
            <a href="/all?days=30" class="btn btn-info <#if days==30>btn-warning</#if>">一月内</a>
            <a href="/all?days=90" class="btn btn-info <#if days==90>btn-warning</#if>">三月内</a>
            <a href="/all?days=180" class="btn btn-info <#if days==180>btn-warning</#if>">半年内</a>
            <a href="/all?days=365" class="btn btn-info <#if days==365>btn-warning</#if>">一年内</a>
            <a href="/all?days=730" class="btn btn-info <#if days==730>btn-warning</#if>">两年内</a>
        </div>
        <p class="days-remind">注：此时间段只对“预约考试统计”起作用</p>
    </div>

    <div class="col-md-12">
        <table class="show_datas_table" cellspacing="0" cellpadding="0">
            <tr>
                <th>-</th>
                <#list divisionList as division>
                <th>${division.name}</th>
                </#list>
            </tr>

            <tr class="school_count" code="S01">
                <td>驾校统计</td>
                <#list divisionList as division>
                <td divisionCode="${division.code}">-</td>
                </#list>
            </tr>

        </table>
    </div>
</div>

<script type="text/javascript" src="js/all/all_normal.js"></script>
<#include "/footer.ftl">