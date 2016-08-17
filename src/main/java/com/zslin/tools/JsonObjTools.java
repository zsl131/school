package com.zslin.tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by zsl-pc on 2016/7/25.
 */
public class JsonObjTools124<T> {

    public List<T> buildDatas1(String jsonStr, Class clz) {
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        return (List<T>) JSONArray.toCollection(jsonArray, clz);
    }

    public T buildSingleDatas(String jsonStr, Class clz) {
        JSONObject jsonObj = JSONObject.fromObject(jsonStr);
        return (T) JSONObject.toBean(jsonObj, clz);
    }
}
