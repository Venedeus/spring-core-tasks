package com.epam.cources.springcore.servlets;

import com.epam.cources.springcore.beans.Event;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy on 11.04.2018.
 */
public class EventServlet extends AbstractServlet {
    private static final String LIST_RATING = "listOfRating";
    private static final String EVENT_JSP = "event.jsp";

    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(LIST_RATING, Event.getListOfRating());
        System.out.println("Ratings: " + Event.getListOfRating());
        req.getRequestDispatcher(EVENT_JSP).forward(req, resp);
    }
}
