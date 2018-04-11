package com.epam.cources.springcore.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Evgeniy on 31.03.2018.
 */
public class SignupServlet extends AbstractServlet {
    private static final String USER = "user";
    private static final String LIST_OF_ROLES = "listOfRoles";
    private static final String SIGNUP_JSP = "signup.jsp";
    private static final String MESSAGE = "message";
    private static final String BLANK = "";

    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setAttribute(LIST_OF_ROLES, getAppConfig().getUserService().getListOfRoles());
        session.setAttribute(MESSAGE, BLANK);

        req.getRequestDispatcher(SIGNUP_JSP).forward(req, resp);
    }
}
