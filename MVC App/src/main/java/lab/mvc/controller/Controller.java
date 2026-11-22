package lab.mvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab.mvc.model.PersonBean;

import java.io.IOException;

@WebServlet("/Controller")
public class Controller  extends HttpServlet {

     @Override
    public void doPost(HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException {
         String firstName = req.getParameter("firstName");
         String lastName = req.getParameter("lastName");
         String birthDay = req.getParameter("birthDay");
         String sex = req.getParameter("sex");


     PersonBean personBean = new PersonBean();
     personBean.setFirstName(firstName);
     personBean.setLastName(lastName);
     personBean.setBirthDay(birthDay);
     personBean.setSex(sex);


     req.setAttribute("person", personBean);
     RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/old.jsp");
     dispatcher.include(req, resp);
     }
}
