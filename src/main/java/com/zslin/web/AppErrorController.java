package com.zslin.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;

/**
 * Created by zsl-pc on 2016/7/20.
 */
@Controller
public class AppErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";


    @Override
    public String getErrorPath() {
        return null;
    }
}
