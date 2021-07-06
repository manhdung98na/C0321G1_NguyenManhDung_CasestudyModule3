package controller;

import model.bean.Customer;
import model.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerServiceImpl customerService;

    public void init() {
        customerService = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
            default:
                showListCustomer(request, response);
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
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = customerService.selectAll();
        request.setAttribute("list-customer", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/add.jsp");
        dispatcher.forward(request, response);
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int customerId = Integer.parseInt(request.getParameter("customer-id"));
            int customerType = Integer.parseInt(request.getParameter("customer-type"));
            String customerName = request.getParameter("customer-name");
            Date customerBirthday = Date.valueOf(request.getParameter("customer-birthday"));
            String customerGender = request.getParameter("customer-gender");
            String customerIdCard = request.getParameter("customer-id-card");
            String customerPhone = request.getParameter("customer-phone");
            String customerEmail = request.getParameter("customer-email");
            String customerAddress = request.getParameter("customer-address");
            Customer newCustomer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            boolean isAddedSuccess = customerService.addCustomer(newCustomer);
            if (isAddedSuccess) {
                request.setAttribute("status", customerName + " đã được tạo mới thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
                showListCustomer(request, response);
            } else {
                request.setAttribute("error", "Kiểm tra lại định dạng và ID/ID Card/Phone/Email không được trùng lặp");
                RequestDispatcher rd = request.getRequestDispatcher("view/customer/add.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("view/customer/add.jsp");
            rd.forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerEdit = customerService.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("customer", customerEdit);
        dispatcher.forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int customerId = Integer.parseInt(request.getParameter("customer-id"));
            int customerType = Integer.parseInt(request.getParameter("customer-type"));
            String customerName = request.getParameter("customer-name");
            Date customerBirthday = Date.valueOf(request.getParameter("customer-birthday"));
            String customerGender = request.getParameter("customer-gender");
            String customerIdCard = request.getParameter("customer-id-card");
            String customerPhone = request.getParameter("customer-phone");
            String customerEmail = request.getParameter("customer-email");
            String customerAddress = request.getParameter("customer-address");
            Customer customerEdit = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            boolean isEditedSuccess = customerService.updateCustomer(customerEdit);
            if (isEditedSuccess) {
                request.setAttribute("status", customerName + " được cập nhật thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
            } else {
                request.setAttribute("status", "Cập nhật khách hàng thất bại");
                request.setAttribute("colorHeader", "#d50005");
            }
//            showListCustomer(request,response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("view/customer/edit.jsp");
            rd.forward(request, response);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (customerService.deleteCustomer(id)) {
                request.setAttribute("status", "Xoá khách hàng thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
            }else {
                request.setAttribute("status", "Xoá khách hàng thất bại");
                request.setAttribute("colorHeader", "#d50005");
            }
            showListCustomer(request,response);
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
