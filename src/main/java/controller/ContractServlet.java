package controller;

import model.bean.Contract;
import model.bean.Customer;
import model.service.contract.ContractServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private ContractServiceImpl service;

    @Override
    public void init() throws ServletException {
        service = new ContractServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addContract(request, response);
                break;
            default:
                showList(request, response);
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
            default:
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> list = service.selectAll();
        request.setAttribute("listcontract", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/add.jsp");
        dispatcher.forward(request, response);
    }

    private void addContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("contract-id"));
            Date startDate = Date.valueOf(request.getParameter("contract-start-date"));
            Date endDate = Date.valueOf(request.getParameter("contract-end-date"));
            double deposit = Double.parseDouble(request.getParameter("contract-deposit"));
            double totalMoney = Double.parseDouble(request.getParameter("contract-total-money"));
            int employeeId = Integer.parseInt(request.getParameter("contract-employee"));
            String customerId = request.getParameter("contract-customer");
            String serviceId = request.getParameter("contract-service");
            Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
            System.out.println(contract);
            Map<String, String> mapError = service.addContract(contract);
            if (mapError.isEmpty()) {
                request.setAttribute("status", "Hợp đồng số " + id + " đã được tạo mới thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
                showList(request, response);
            } else {
                request.setAttribute("messCustomerId", mapError.get("customerIdError"));
                request.setAttribute("messServiceId", mapError.get("serviceIdError"));
                request.setAttribute("messMoney", mapError.get("moneyError"));
                request.setAttribute("messTime", mapError.get("timeError"));
                request.setAttribute("messSQL", mapError.get("sqlError"));
                request.setAttribute("contract", contract);
                showAddForm(request,response);
            }
        } catch (Exception e) {
            request.setAttribute("messSQL", "Dữ liệu nhập vào không hợp lệ! Không đúng định dạng");
            RequestDispatcher rd = request.getRequestDispatcher("view/contract/add.jsp");
            rd.forward(request, response);
        }
    }
}
