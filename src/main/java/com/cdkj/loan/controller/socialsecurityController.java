package com.cdkj.loan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 社保
 * @author: CYL 
 * @since: 2018年9月19日 下午4:30:08 
 * @history:
 */
@Controller
public class socialsecurityController {
    private static Logger logger = Logger.getLogger(MobileReportDemo.class);

    @RequestMapping(value = "/socialsecurity", method = RequestMethod.POST)
    public void doClockIn(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String json = request.getParameter("json").toString();
        String str = URLDecoder.decode(json, "UTF-8");
        logger.info("-----------------");
        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.append(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
