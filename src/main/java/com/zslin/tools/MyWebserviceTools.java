package com.zslin.tools;

import com.ztw.platform.ws.IPlatformOldWebService;
import com.ztw.platform.ws.PlatformOldWebService;

/**
 * Created by zsl-pc on 2016/7/25.
 */
public class MyWebserviceTools {

    private static String resourceCode = "A4YSHMPHV5GOCBANS7149332555936";

    /**
     * 获取数据
     * @param code 接口代码
     * @param json 参数
     * @return
     */
    private static String queryDatas(String code, String json) {
        IPlatformOldWebService service = new PlatformOldWebService().getPlatformOldWebServicePort();
        String result = service.uploadObject(resourceCode, code, json);
        return result;
    }

    /**
     * 获取Webservice数据
     * @param code 接口代码
     * @param params 参数组，以键值对存在，如： cityDivision:530600
     * @return
     */
    public static String queryDatasByParams(String code, String ...params) {
        String json = MyJsonTools.params2Json(params);
        return queryDatas(code, json);
    }
}
