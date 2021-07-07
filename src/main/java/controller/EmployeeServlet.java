package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.service.employee.EmployeeServiceImpl;

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

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeServiceImpl service;

    @Override
    public void init() throws ServletException {
        service = new EmployeeServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "search":
                searchEmployeeByName(request,response);
                break;
            default:
                showListEmployee(request, response);
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
                deleteEmployee(request,response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> list = service.selectAll();
        request.setAttribute("listemployee", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/add.jsp");
        dispatcher.forward(request, response);
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("employee-id"));
            String name = request.getParameter("employee-name");
            Date birthday = Date.valueOf(request.getParameter("employee-birthday"));
            String idCard = request.getParameter("employee-id-card");
            double salary = Double.parseDouble(request.getParameter("employee-salary"));
            String phone = request.getParameter("employee-phone");
            String email = request.getParameter("employee-email");
            String address = request.getParameter("employee-address");
            int position = Integer.parseInt(request.getParameter("employee-position"));
            int education = Integer.parseInt(request.getParameter("employee-education"));
            int division = Integer.parseInt(request.getParameter("employee-division"));
            Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division);
            Map<String, String> mapError = service.addEmployee(employee);
            if (mapError.isEmpty()) {
                request.setAttribute("status", name + " đã được tạo mới thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
                showListEmployee(request, response);
            } else {
                request.setAttribute("messName", mapError.get("nameError"));
                request.setAttribute("messIdCard", mapError.get("idCardError"));
                request.setAttribute("messPhone", mapError.get("phoneError"));
                request.setAttribute("messEmail", mapError.get("emailError"));
                request.setAttribute("messSQL", mapError.get("sqlError"));
                request.setAttribute("employee", employee);
                showAddForm(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("view/customer/add.jsp");
            rd.forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = service.selectById(id);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("employee-id"));
            String name = request.getParameter("employee-name");
            Date birthday = Date.valueOf(request.getParameter("employee-birthday"));
            String idCard = request.getParameter("employee-id-card");
            double salary = Double.parseDouble(request.getParameter("employee-salary"));
            String phone = request.getParameter("employee-phone");
            String email = request.getParameter("employee-email");
            String address = request.getParameter("employee-address");
            int position = Integer.parseInt(request.getParameter("employee-position"));
            int education = Integer.parseInt(request.getParameter("employee-education"));
            int division = Integer.parseInt(request.getParameter("employee-division"));
            Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division);
            Map<String, String> mapError = service.updateEmployee(employee);
            if (mapError.isEmpty()) {
                request.setAttribute("status", name + " đã được cập nhật thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
                showListEmployee(request, response);
            } else {
                request.setAttribute("messName", mapError.get("nameError"));
                request.setAttribute("messIdCard", mapError.get("idCardError"));
                request.setAttribute("messPhone", mapError.get("phoneError"));
                request.setAttribute("messEmail", mapError.get("emailError"));
                request.setAttribute("messSQL", mapError.get("sqlError"));
                request.setAttribute("employee", employee);
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("view/customer/edit.jsp");
            rd.forward(request, response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (service.deleteEmployee(id)) {
                request.setAttribute("status", "Xoá khách hàng thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
            } else {
                request.setAttribute("status", "Xoá khách hàng thất bại");
                request.setAttribute("colorHeader", "#d50005");
            }
            showListEmployee(request, response);
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        List<Employee> searchList = null;
        try {
            searchList = service.selectByName(nameSearch);
        } finally {
            request.setAttribute("searchList", searchList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/search.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
