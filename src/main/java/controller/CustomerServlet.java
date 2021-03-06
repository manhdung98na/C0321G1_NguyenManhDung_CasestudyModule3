package controller;

import model.bean.Customer;
import model.service.customer.CustomerServiceImpl;

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
import java.util.Map;

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
                break;
            case "search":
                searchByName(request, response);
                break;
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
            case "detail":
                showDetail(request, response);
                break;
            case "check_id":
                checkId(request, response);
                break;
            case "check_name":
                checkName(request, response);
                break;
            case "check_birthday":
                checkBirthday(request, response);
                break;
            case "check_id_card":
                checkIdCard(request, response);
                break;
            case "check_phone":
                checkPhone(request, response);
                break;
            case "check_email":
                checkEmail(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = customerService.selectAll();
        request.setAttribute("listcustomer", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/add.jsp");
        dispatcher.forward(request, response);
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customer-id");
        int customerType = Integer.parseInt(request.getParameter("customer-type"));
        String customerName = request.getParameter("customer-name");
        Date customerBirthday = Date.valueOf(request.getParameter("customer-birthday"));
        String customerGender = request.getParameter("customer-gender");
        String customerIdCard = request.getParameter("customer-id-card");
        String customerPhone = request.getParameter("customer-phone");
        String customerEmail = request.getParameter("customer-email");
        String customerAddress = request.getParameter("customer-address");
        Customer newCustomer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        try {
            customerService.addCustomer(newCustomer);
            request.setAttribute("status", customerName + " ???? ???????c t???o m???i th??nh c??ng");
            request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
            showListCustomer(request, response);
        } catch (Exception e) {
            request.setAttribute("customer", newCustomer);
            request.setAttribute("mesSQL", "L???i SQL!");
            RequestDispatcher rd = request.getRequestDispatcher("view/customer/add.jsp");
            rd.forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customerEdit = customerService.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("customer", customerEdit);
        dispatcher.forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String customerId = request.getParameter("customer-id");
            int customerType = Integer.parseInt(request.getParameter("customer-type"));
            String customerName = request.getParameter("customer-name");
            Date customerBirthday = Date.valueOf(request.getParameter("customer-birthday"));
            String customerGender = request.getParameter("customer-gender");
            String customerIdCard = request.getParameter("customer-id-card");
            String customerPhone = request.getParameter("customer-phone");
            String customerEmail = request.getParameter("customer-email");
            String customerAddress = request.getParameter("customer-address");
            Customer customerEdit = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            Map<String, String> mapError = customerService.updateCustomer(customerEdit);
            if (mapError.isEmpty()) {
                request.setAttribute("status", customerName + " ???? ???????c c???p nh???t th??nh c??ng");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
                showListCustomer(request, response);
            } else {
                request.setAttribute("messName", mapError.get("nameError"));
                request.setAttribute("messPhone", mapError.get("phoneError"));
                request.setAttribute("messEmail", mapError.get("emailError"));
                request.setAttribute("messId", mapError.get("idError"));
                request.setAttribute("messIdCard", mapError.get("idCardError"));
                request.setAttribute("messSQL", mapError.get("sqlError"));
                request.setAttribute("customer", customerEdit);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("messSQL", "D??? li???u nh???p v??o kh??ng h???p l???! Kh??ng ????ng ?????nh d???ng");
            RequestDispatcher rd = request.getRequestDispatcher("view/customer/edit.jsp");
            rd.forward(request, response);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            if (customerService.deleteCustomer(id)) {
                request.setAttribute("status", "Xo?? kh??ch h??ng th??nh c??ng");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
            } else {
                request.setAttribute("status", "Xo?? kh??ch h??ng th???t b???i");
                request.setAttribute("colorHeader", "#d50005");
            }
            showListCustomer(request, response);
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        List<Customer> searchList = null;
        try {
            searchList = customerService.selectByName(nameSearch);
        } catch (SQLException e) {
            request.setAttribute("messSQL", "Error");
            System.out.println(e.getMessage());
        } finally {
            request.setAttribute("searchList", searchList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/search.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer = customerService.selectById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/detail.jsp");
        dispatcher.forward(request, response);
    }

    private void checkId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id_check");
        response.setContentType("text/plain");
        response.getWriter().write(customerService.validateId(id));
    }

    private void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_check");
        response.setContentType("text/plain");
        response.getWriter().write(customerService.validateName(name));
    }

    private void checkBirthday(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String birthday = (request.getParameter("birthday_check"));
        response.setContentType("text/plain");
        response.getWriter().write(customerService.validateBirthday(birthday));
    }

    private void checkIdCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCard = request.getParameter("id_card_check");
        response.setContentType("text/plain");
        response.getWriter().write(customerService.validateIdCard(idCard));
    }

    private void checkPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone_check");
        response.setContentType("text/plain");
        response.getWriter().write(customerService.validatePhone(phone));
    }

    private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email_check");
        response.setContentType("text/plain");
        response.getWriter().write(customerService.validateEmail(email));
    }
}
