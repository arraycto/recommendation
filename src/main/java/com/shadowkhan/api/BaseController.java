package com.shadowkhan.api;

import com.shadowkhan.core.constants.Constants;
import com.shadowkhan.core.model.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller 基类
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
public class BaseController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;


    /**
     * The Global exception handler
     * @param e
     * @return
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        R response = R.failure(Constants.Response.FAILURE);
        return response;
    }

}