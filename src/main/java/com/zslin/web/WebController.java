package com.zslin.web;

import com.zslin.dto.DivisionDto;
import com.zslin.tools.JsonObjTools;
import com.zslin.tools.MyWebserviceTools;
import com.ztw.platform.ws.IPlatformOldWebService;
import com.ztw.platform.ws.PlatformOldWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by zsl-pc on 2016/7/20.
 */

@Controller
public class WebController {

    @RequestMapping(value="page")
    public String page() {

        return "page";
    }

    @RequestMapping(value="/welcome")
    public String welcome(ModelMap map) {
        //市级行政区划
        List<DivisionDto> divisionList = new JsonObjTools<DivisionDto>().buildDatas(MyWebserviceTools.queryDatasByParams("P01"), DivisionDto.class);
        System.out.println("===="+divisionList.size());
        map.addAttribute("divisionList", divisionList);

        return "welcome";
    }
}
