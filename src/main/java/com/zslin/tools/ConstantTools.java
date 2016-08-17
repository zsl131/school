package com.zslin.tools;

/**
 * Created by zsl-pc on 2016/8/7.
 */
public class ConstantTools {
//    public static final String WSDL_LOCATION = "http://192.168.1.106:8888/platform/sws?wsdl";
    public static final String WSDL_LOCATION = MyPropertiesTools.getInstance().getValue("wsdl").toString();
//    public static final String WSDL_LOCATION = "http://192.168.31.247:8888/platform/sws?wsdl";
}
