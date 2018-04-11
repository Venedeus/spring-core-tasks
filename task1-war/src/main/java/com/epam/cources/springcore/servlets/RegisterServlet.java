package com.epam.cources.springcore.servlets;

import com.epam.cources.springcore.beans.User;
import com.epam.cources.springcore.services.UserService;
import com.epam.cources.springcore.services.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Evgeniy on 31.03.2018.
 */
public class RegisterServlet extends AbstractServlet {
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD1 = "password1";
    private static final String PASSWORD2 = "password2";
    private static final String BIRTHDAY = "birthday";
    private static final String REGISTER_JSP = "signup.jsp";
    private static final String INDEX_JSP = "index.jsp";
    private static final String ROLE = "role";
    private static final String MESSAGE = "message";
    private static final String BLANK = "";

    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserService userService = getAppConfig().getUserService();
        Validator validator = getAppConfig().getValidator();

        if(!validateInputs(req)){
            session.setAttribute(MESSAGE, "Something went wrong...");
            req.getRequestDispatcher(REGISTER_JSP).forward(req, resp);
        }
        else{
            User user = new User();

            user.setName(req.getParameter(NAME));
            user.setRole(req.getParameter(ROLE));
            user.setEmail(req.getParameter(EMAIL));
            user.setBirthday(getBirthday(req.getParameter(BIRTHDAY)));
            user.setPassword(req.getParameter(PASSWORD1));

            userService.addItem(user);
            userService.save();

            session.setAttribute(MESSAGE, BLANK);
            req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
        }
    }

    private boolean validateInputs(HttpServletRequest req){
        boolean isCorrect = false;

        if(!"".equals(req.getParameter(NAME))){
            isCorrect = true;
        }
        else{
            isCorrect = false;
        }

        if(!"".equals(req.getParameter(EMAIL))) {
            isCorrect = true;
        }
        else{
            isCorrect = false;
        }

        if(!"".equals(req.getParameter(PASSWORD1)) &&
                !"".equals(req.getParameter(PASSWORD2)) &&
                req.getParameter(PASSWORD1).equals(req.getParameter(PASSWORD2))) {
            isCorrect = true;
        }
        else{
            isCorrect = false;
        }

        return isCorrect;
    }

    private LocalDate getBirthday(String birthday){
        LocalDate date = LocalDate.now();

        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

            date = LocalDateTime.ofInstant(formatter.parse(birthday).toInstant(), ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
