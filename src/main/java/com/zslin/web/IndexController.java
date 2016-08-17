package com.zslin.web;

import com.zslin.dto.*;
import com.zslin.tools.JsonObjTools;
import com.zslin.tools.MySystemConfigTools;
import com.zslin.tools.MyWebserviceTools;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zsl-pc on 2016/7/20.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(ModelMap model, String cityDivision, String division, HttpServletRequest request) {
        cityDivision = cityDivision==null?"530000":cityDivision;
        division = division==null?"":division;
        model.addAttribute("cityDivision", cityDivision);
        model.addAttribute("division", division);

        //市级行政区划
        List<DivisionDto> divisionList = new JsonObjTools<DivisionDto>().buildDatas(MyWebserviceTools.queryDatasByParams("P01"), DivisionDto.class);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("cityName", queryCityName(cityDivision, divisionList)); //获取出地州名称

        List<DivisionDto> divisionList2 = null;
        if(!"530000".equals(cityDivision)) {
            divisionList2 = new JsonObjTools<DivisionDto>().buildDatas(MyWebserviceTools.queryDatasByParams("P04", cityDivision), DivisionDto.class);
            //System.out.println("======"+divisionList2.size());
            model.addAttribute("divisionList2", divisionList2);
        }

        //驾校统计数据
        List<SchoolCountDto> schoolCountList = new JsonObjTools<SchoolCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W06", "cityDivision:"+cityDivision), SchoolCountDto.class);
        ResultDto resDto = new ResultDto();
        for(SchoolCountDto dto : schoolCountList) {
            resDto.getCates().add(dto.getCarType());
            resDto.getValues().add(dto.getAmount());
        }
        //System.out.print(JSONObject.fromObject(resDto).toString());
        model.addAttribute("schoolCountJson", JSONObject.fromObject(resDto).toString());

        List<SchoolCountDto> schoolCountList2 = new JsonObjTools<SchoolCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W07", "cityDivision:"+cityDivision), SchoolCountDto.class);
        ExamPlaceCountResultDto schResDto = new ExamPlaceCountResultDto();
        for(SchoolCountDto dto : schoolCountList2) {
            String nameTmp = "";
            if(!"530000".equals(cityDivision)) {
                nameTmp = queryCityName(dto.getDivision(), divisionList2);
            } else {
                nameTmp = queryCityName(dto.getCityDivision(), divisionList);
            }
            schResDto.getCates().add(nameTmp);
            schResDto.getDatas().add(new ResultNormalDto(nameTmp, dto.getAmount2()));
        }
//        System.out.print(JSONObject.fromObject(schResDto).toString());
        model.addAttribute("schoolCountJson2", JSONObject.fromObject(schResDto).toString());

        //考场统计数据
        List<ExamPlaceCountDto> placeCountList = new JsonObjTools<ExamPlaceCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W05", "cityDivision:"+cityDivision), ExamPlaceCountDto.class);
        ExamPlaceCountResultDto epcrd = new ExamPlaceCountResultDto();
        for(ExamPlaceCountDto dto : placeCountList) {
            String type = buildPlaceType(dto.getType());
            epcrd.getCates().add(type);
            epcrd.getDatas().add(new ResultNormalDto(buildPlaceType(dto.getType()), dto.getAmount()));
        }
//        System.out.print(JSONObject.fromObject(epcrd).toString());
        model.addAttribute("placeCountJson", JSONObject.fromObject(epcrd).toString());

        if(division!=null && !"".equals(division)) {
            List<SchoolDto> schoolList = new JsonObjTools<SchoolDto>().buildDatas(MyWebserviceTools.queryDatasByParams("P05", division), SchoolDto.class);
//            System.out.println(schoolList.size());
            model.addAttribute("schoolList", schoolList);
        }

        return "index/index";
    }

    /** 获取地州名称 */
    private String queryCityName(String cityDivision, List<DivisionDto> divisionList) {
        for(DivisionDto dto : divisionList) {
            if(dto.getCode().equals(cityDivision)) {return dto.getName();}
        }
        return "其他";
    }

    private String buildPlaceType(String type) {
        if("1".equals(type)) {
            return "科目一";
        } else if("2".equals(type)) {
            return "科目二";
        } else if("3".equals(type)) {
            return "科目三";
        } else if("4".equals(type)) {
            return "安全文明";
        } else {
            return "未识别";
        }
    }
}
