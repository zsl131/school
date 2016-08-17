package org.zslin.test;

import com.zslin.tools.MyPropertiesTools;
import com.zslin.tools.MyWebserviceTools;
import com.ztw.platform.ws.IPlatformOldWebService;
import com.ztw.platform.ws.PlatformOldWebService;

/**
 * Created by zsl-pc on 2016/7/21.
 */
public class WebserviceTest {
    private static String resourceCode = "A4YSHMPHV5GOCBANS7149332555936";
    public static void main(String [] args) {
        IPlatformOldWebService service = new PlatformOldWebService().getPlatformOldWebServicePort();

//        System.out.println(testAll(service, "W02", MyJsonTools.params2Json("schoolId:50")));

//        String divisionStr = testAll(service, "P01", "");

       /* List<DivisionDto> list = new JsonObjTools<DivisionDto>().buildDatas(divisionStr, DivisionDto.class);
        for(DivisionDto dto : list) {
            System.out.println(dto);
        }*/

       /*String jsonStr = MyWebserviceTools.queryDatasByParams("W06", "cityDivision:530000");
        System.out.println(jsonStr);
        List<SchoolCountDto> schoolCountList = new JsonObjTools<SchoolCountDto>().buildDatas(jsonStr, SchoolCountDto.class);
        ResultDto resDto = new ResultDto();
        for(SchoolCountDto dto : schoolCountList) {
            resDto.getCates().add(dto.getCarType());
            resDto.getValues().add(dto.getAmount());
        }
        System.out.println(resDto.getCates().size()+"===="+resDto.getValues().size());*/
//        System.out.println(testAll(service, "P04", "530600"));

//        List<DivisionDto> divisionList2 = new JsonObjTools<DivisionDto>().buildDatas(MyWebserviceTools.queryDatasByParams("P04", "530600"), DivisionDto.class);
//        System.out.println("======"+divisionList2.size());

//        String str = testAll(service, "Q01", "{'jxdm':'C009'}");
//        SchoolInfoDto infoDto = new JsonObjTools<SchoolInfoDto>().buildSingleDatas(str, SchoolInfoDto.class);
//        System.out.println(infoDto.getJxmc());

//        List<StudentCountDto> stuCountList = new JsonObjTools<StudentCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W08", "cityDivision:530600", "schoolCode:C009", "time:7", "type:1"), StudentCountDto.class);
//        for(StudentCountDto dto : stuCountList) {
//            System.out.println(dto.getType()+"==="+dto.getType());
//        }

        /*List<CarCountDto> carCountList = new JsonObjTools<CarCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W02", "schoolId:50"), CarCountDto.class);
        for(CarCountDto dto : carCountList) {
            System.out.println(dto);
        }*/

        /*List<AppraiseCountDto> appraiseCountList = new JsonObjTools<AppraiseCountDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W03", "schoolId:50", "type:COACH"), AppraiseCountDto.class);
        for(AppraiseCountDto dto : appraiseCountList) {
            System.out.println(dto);
        }*/

        /*List<TestRecordDto> testRecordCountList = new JsonObjTools<TestRecordDto>().buildDatas(MyWebserviceTools.queryDatasByParams("W04", "schoolId:50", "cityDivision:530600", "steps:1"), TestRecordDto.class);
        for(TestRecordDto dto : testRecordCountList) {
            System.out.println(dto);
        }*/

//        LegalCountDto legalDto = new JsonObjTools<LegalCountDto>().buildSingleDatas(MyWebserviceTools.queryDatasByParams("W09", "schoolId:50", "range:12"), LegalCountDto.class);
//        System.out.println(legalDto);

//        System.out.println(MyPropertiesTools.getInstance().getValue("wsdl"));

        String jsonStr = MyWebserviceTools.queryDatasByParams("S01", "{}");
        System.out.println(jsonStr);
    }

    private static String testAll(IPlatformOldWebService service, String code, String json) {
        String result = service.uploadObject(resourceCode, code, json);
        return result;
    }
}
