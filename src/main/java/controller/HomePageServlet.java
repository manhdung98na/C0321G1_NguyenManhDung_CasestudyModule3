package controller;

import model.bean.CustomerUsingService;
import model.service.HomepageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePageServlet", urlPatterns = {"/login", ""})
public class HomePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String user = request.getParameter("login_user");
//        String pass = request.getParameter("login_pass");
//        if (user == "admin" && pass == "123") {
            List<CustomerUsingService> list = HomepageService.seselectCustomerUsingService();
            request.setAttribute("listcustomer", list);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
//        }
    }
}
