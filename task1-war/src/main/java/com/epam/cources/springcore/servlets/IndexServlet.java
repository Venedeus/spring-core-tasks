package com.epam.cources.springcore.servlets;

import com.epam.cources.springcore.beans.Auditorium;
import com.epam.cources.springcore.beans.Event;
import com.epam.cources.springcore.beans.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy on 01.04.2018.
 */
public class IndexServlet extends AbstractServlet {
    private static final String MAIN_JSP = "main.jsp";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";
    private static final String INDEX_JSP = "index.jsp";
    private static final String LIST_OF_EVENTS = "listOfEvents";

    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(!getAppConfig().getValidator().checkUser(req.getParameter(NAME),
                req.getParameter(PASSWORD))){
            session.setAttribute(MESSAGE, "Something went wrong...");

            req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
        }

        req.setAttribute(LIST_OF_EVENTS, getListOfEvents());
        req.getRequestDispatcher(MAIN_JSP).forward(req, resp);
    }

    private List<String[]> getListOfEvents(){
        List<String[]> listOfEvents = new ArrayList<>();

        for(Item item: getAppConfig().getEventService().getAll()){
            Event event = (Event) item;
            String[] eventString = new String[2];
            eventString[0] = ((Event) item).getName();
            eventString[1] = ((Auditorium)getAppConfig()
                    .getAuditoriumService()
                    .getById(event.getAuditoriumId()))
                    .getName();

            listOfEvents.add(eventString);
        }

        return listOfEvents;
    }
}
