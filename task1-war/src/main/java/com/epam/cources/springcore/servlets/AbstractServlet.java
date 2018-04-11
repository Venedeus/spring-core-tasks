package com.epam.cources.springcore.servlets;

import com.epam.cources.springcore.app.AppConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeniy_Shvetsov on 2/21/2018.
 */
public abstract class AbstractServlet extends HttpServlet {
    private AppConfig appConfig;

    public AbstractServlet() {
        appConfig = AppConfig.getInstance("spring.xml");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    protected abstract void process(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException;

    protected AppConfig getAppConfig(){
        return appConfig;
    }
}
