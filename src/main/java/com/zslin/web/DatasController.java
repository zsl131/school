package com.zslin.web;

import com.zslin.dto.*;
import com.zslin.tools.JsonObjTools;
import com.zslin.tools.MyWebserviceTools;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zsl-pc on 2016/8/2.
 */
@Controller
public class DatasController {

    @RequestMapping(value="queryStudentCount")
    public @ResponseBody String queryStudentCount(String cityDivision, String schCode, Integer time, String type, HttpServletRequest request) {
        //获取通过性别分组的数据
        List<StudentCountDto> stuCountList = new JsonObjTools<StudentCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W08", "cityDivision:"+cityDivision, "schoolCode:"+schCode, "time:"+time, "type:"+type), StudentCountDto.class);
        ExamPlaceCountResultDto resDto = new ExamPlaceCountResultDto();
        for(StudentCountDto dto : stuCountList) {
            String typeTmp = buildType(type, dto.getType());
            resDto.getCates().add(typeTmp);
            resDto.getDatas().add(new ResultNormalDto(typeTmp, dto.getAmount()));
        }
        //System.out.println(resDto.getCates()+"==="+resDto.getDatas());

        String res = JSONObject.fromObject(resDto).toString();
        //System.out.println(res);
        return res;
    }

    @RequestMapping(value="queryCarCountDatas")
    public @ResponseBody String queryCarCountDatas(Integer schoolId, HttpServletRequest request) {
        List<CarCountDto> carCountList = new JsonObjTools<CarCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W02", "schoolId:"+schoolId), CarCountDto.class);
        ExamPlaceCountResultDto resDto = new ExamPlaceCountResultDto();
        for(CarCountDto dto : carCountList) {
            resDto.getCates().add(dto.getCarType());
            resDto.getDatas().add(new ResultNormalDto(dto.getCarType(), dto.getAmount()));
        }
        String res = JSONObject.fromObject(resDto).toString();
        return res;
    }

    @RequestMapping(value="queryAppraiseCountDatas")
    public @ResponseBody String queryAppraiseCountDatas(Integer schoolId, String type, HttpServletRequest request) {
        List<AppraiseCountDto> appraiseCountList = new JsonObjTools<AppraiseCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W03", "schoolId:"+schoolId, "type:"+type), AppraiseCountDto.class);
        ExamPlaceCountResultDto resDto = new ExamPlaceCountResultDto();
        for(AppraiseCountDto dto : appraiseCountList) {
            String typeTmp = buildAppraiseLevel(dto.getLevel());
            resDto.getCates().add(typeTmp);
            resDto.getDatas().add(new ResultNormalDto(typeTmp, dto.getAmount()));
        }
        String res = JSONObject.fromObject(resDto).toString();
        return res;
    }

    @RequestMapping(value="queryTestRecordCountDatas")
    public @ResponseBody String queryTestRecordCountDatas(Integer schoolId, String steps, String cityDivision, HttpServletRequest request) {
        List<TestRecordDto> countList = new JsonObjTools<TestRecordDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W04", "schoolId:"+schoolId, "steps:"+steps, "cityDivision:"+cityDivision), TestRecordDto.class);
        ExamPlaceCountResultDto resDto = new ExamPlaceCountResultDto();
        for(TestRecordDto dto : countList) {
            String typeTmp = buildTestRecordFlag(dto.getFlag());
            resDto.getCates().add(typeTmp);
            resDto.getDatas().add(new ResultNormalDto(typeTmp, dto.getAmount()));
        }
        String res = JSONObject.fromObject(resDto).toString();
        return res;
    }

    @RequestMapping(value="queryLegalCountData")
    public @ResponseBody LegalCountDto queryLegalCountDatas(Integer schoolId, String range, HttpServletRequest request) {
        LegalCountDto legalDto = new JsonObjTools<LegalCountDto>().buildSingleDatas(MyWebserviceTools.queryDatasByParams("W09", "schoolId:"+schoolId, "range:"+range), LegalCountDto.class);
        return legalDto;
    }

    @RequestMapping(value="queryNormalDatas")
    public @ResponseBody String queryNormalDatas(HttpServletRequest request, String code, @RequestParam(value="params[]") String [] params) {
        System.out.println("==============="+code);
        for(String param : params) {
            System.out.println(param);
        }
        String resJson = MyWebserviceTools.queryDatasByParams(code, params);
        return resJson;
    }

    private String buildTestRecordFlag(Integer flag) {
        if(flag==0) {return "不及格";}
        else if(flag==1) {return "及格";}
        return "其他";
    }

    private String buildAppraiseLevel(Integer level) {
        if(level == 1) { return "好评"; }
        else if(level == 2) {return "中评";}
        else if(level == 3) {return "差评";}
        return "其他";
    }

    private String buildType(String type, String valType) {
        if("1".equals(type)) {
            if("1".equals(valType)) {return "男";}
            else if("2".equals(valType)) {return "女";}
        } else if("2".equals(type)) {
            if("0".equals(valType)) {return "未考";}
            else if("1".equals(valType)) {return "及格";}
            else if("2".equals(valType)) {return "挂科";}
        }
        return "";
    }
}
