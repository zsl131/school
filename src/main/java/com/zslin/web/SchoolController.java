package com.zslin.web;

import com.zslin.dto.*;
import com.zslin.tools.JsonObjTools;
import com.zslin.tools.MyWebserviceTools;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zsl-pc on 2016/7/28.
 */
@Controller
public class SchoolController {

    @RequestMapping(value="/sch")
    public String sch(ModelMap model, Integer schId, String cityDivision, String schCode, Integer time, HttpServletRequest request) {

        time = time==null?30:time;
        model.addAttribute("cityDivision", cityDivision);
        model.addAttribute("schoolId", schId);
        model.addAttribute("schoolCode", schCode);
        model.addAttribute("time", time);
//        System.out.println(schId+"==="+cityDivision+"===="+schCode);
        SchoolInfoDto schInfoDto = new JsonObjTools<SchoolInfoDto>().buildSingleDatas(MyWebserviceTools.queryDatasByParams("Q01", "jxdm:"+schCode), SchoolInfoDto.class);
        model.addAttribute("schInfoDto", schInfoDto);

       /* //获取通过考试结果分组的数据
        List<StudentCountDto> stuCountList2 = new JsonObjTools<StudentCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W08", "cityDivision:"+cityDivision, "schoolCode:"+schCode, "time:"+time, "type:2"), StudentCountDto.class);
        ExamPlaceCountResultDto resDto2 = new ExamPlaceCountResultDto();
        for(StudentCountDto dto : stuCountList2) {
            String type = buildType("2", dto.getType());
            resDto2.getCates().add(type);
            resDto2.getDatas().add(new ResultNormalDto(type, dto.getAmount()));
        }
//        System.out.println(resDto.getCates()+"==="+resDto.getValues());

        model.addAttribute("stuCountResult", JSONObject.fromObject(resDto2).toString());*/

        return "index/school";
    }
}
