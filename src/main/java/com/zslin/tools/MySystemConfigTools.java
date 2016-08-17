package com.zslin.tools;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by zsl-pc on 2016/8/7.
 */
public class MySystemConfigTools {

    private String wsdl;

    private static MySystemConfigTools instance;

    public static MySystemConfigTools getInstance() {
        if(instance==null) {
            instance = new MySystemConfigTools();
        }
        return instance;
    }

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }
}
