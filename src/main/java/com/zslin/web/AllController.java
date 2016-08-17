package com.zslin.web;

import com.zslin.dto.DivisionDto;
import com.zslin.tools.JsonObjTools;
import com.zslin.tools.MyWebserviceTools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zsl-pc on 2016/8/7.
 */
@Controller
public class AllController {

    /** 数据统计总页面 */
    @RequestMapping(value="all", method= RequestMethod.GET)
    public String all(ModelMap model, Integer days, HttpServletRequest request) {
        days = days==null?1:days;
        model.addAttribute("days", days);

        //市级行政区划
        List<DivisionDto> divisionList = new JsonObjTools<DivisionDto>().buildDatas(MyWebserviceTools.queryDatasByParams("P01"), DivisionDto.class);
        model.addAttribute("divisionList", divisionList);

        return "index/all";
    }
}
