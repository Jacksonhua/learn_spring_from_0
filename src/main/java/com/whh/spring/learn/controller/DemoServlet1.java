package com.whh.spring.learn.controller;

import com.whh.spring.learn.service.DemoService;
import com.whh.spring.learn.service.impl.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Artermus wang on 2021-04-14 17:29
 */
@Slf4j
@WebServlet(urlPatterns = "/demo1")
public class DemoServlet1 extends HttpServlet {
    private DemoService service = new DemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().println(service.findAll().toString());
    }

}
