package com.zslin.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zsl-pc on 2016/8/7.
 */
public class MyPropertiesTools {
    private static MyPropertiesTools util = null;
    private static Map<String,Properties> props = null;
    private MyPropertiesTools(){
    }

    public static MyPropertiesTools getInstance() {
        if(util==null) {
            props = new HashMap<String, Properties>();
            util = new MyPropertiesTools();
        }
        return util;
    }

    /** 获取系统基本的配置文件 */
    public static Properties getBaseProperties() {
        return MyPropertiesTools.getInstance().load("basic");
    }

    public Properties load(String name) {
        if(props.get(name)!=null) {
            return props.get(name);
        } else {
            Properties prop = new Properties();
            try {
                prop.load(MyPropertiesTools.class.getResourceAsStream("/"+name+".properties"));
                props.put(name, prop);
                return prop;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Object getValue(String fileName, String key) {
        Properties pro = MyPropertiesTools.getInstance().load(fileName);
        return pro.getProperty(key);
    }

    public Object getValue(String key) {
        Properties pro = MyPropertiesTools.getInstance().load("basic");
        return pro.getProperty(key);
    }
}
