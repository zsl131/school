package com.zslin.tools;

import net.sf.json.JSONObject;

import java.util.Map;

/**
 * Created by zsl-pc on 2016/7/24.
 */
public class MyJsonTools {

    /**
     * 将参数map转换成JSON数据
     * @param map
     * @return
     */
    public static String map2Json(Map<String, Object> map) {
        JSONObject jsonObj = JSONObject.fromObject(map);
        return jsonObj.toString();
    }

    /**
     * 将特定的字符串参数转换成JSON数据
     * 键值以冒号隔开
     * @param params
     * @return
     */
    public static String params2Json(String ...params) {
        try {
            Map<String, Object> map = new java.util.HashMap<String, Object>();
            for(String p : params) {
                p = p.trim();
                String [] tmp = p.split(":");
                map.put(tmp[0].trim(), tmp[1].trim());
            }
            return map2Json(map);
        } catch (Exception e) {
            return params[0];
        }
    }

    public static Object json2Obj(String jsonStr, Class beanClass) {
        return JSONObject.toBean(JSONObject.fromObject(jsonStr), beanClass);
    }
}
