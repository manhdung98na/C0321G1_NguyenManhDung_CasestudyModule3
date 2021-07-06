package controller;

import model.bean.Customer;
import model.bean.Service;
import model.service.service.ResortService;
import model.service.service.ResortServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private ResortServiceImpl resortService;

    @Override
    public void init() throws ServletException {
        resortService = new ResortServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addService(request,response);
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(request,response);
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> list = resortService.selectAll();
//        if (list.size() != 0) {
            request.setAttribute("listservice", list);
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/add.jsp");
        dispatcher.forward(request, response);
    }

    private void addService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("service-id"));
            String name = request.getParameter("service-name");
            int area = Integer.parseInt(request.getParameter("service-area"));
            double cost = Double.parseDouble(request.getParameter("service-cost"));
            int maxPeople = Integer.parseInt(request.getParameter("service-max-people"));
            int rentType = Integer.parseInt(request.getParameter("service-rent-type"));
            int serviceType = Integer.parseInt(request.getParameter("service-type"));
            String standardRoom = request.getParameter("service-standard-room");
            String description = request.getParameter("service-description");
            int poolArea = Integer.parseInt(request.getParameter("service-pool-area"));
            int floors = Integer.parseInt(request.getParameter("service-floors"));
            Service newService = new Service(id,name,area,cost,maxPeople,rentType,serviceType,standardRoom,description,poolArea,floors);
            boolean isAddedSuccess = resortService.addService(newService);
            if (isAddedSuccess) {
                request.setAttribute("status", name + " đã được tạo mới thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
                showListService(request, response);
            } else {
                request.setAttribute("error", "Kiểm tra lại dữ liệu nhập vào");
                RequestDispatcher rd = request.getRequestDispatcher("view/service/add.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("view/service/add.jsp");
            rd.forward(request, response);
        }
    }
}