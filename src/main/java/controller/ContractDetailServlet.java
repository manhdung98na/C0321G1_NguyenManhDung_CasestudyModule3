package controller;

import model.bean.ContractDetail;
import model.bean.Service;
import model.service.contract_detail.ContractDetailServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DetailContractServlet", urlPatterns = "/contract_detail")
public class ContractDetailServlet extends HttpServlet {
    private ContractDetailServiceImpl services;

    @Override
    public void init() throws ServletException {
        services = new ContractDetailServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addContractDetail(request, response);
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
        List<ContractDetail> list = services.selectAll();
        request.setAttribute("listcontract_detail", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract_detail/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract_detail/add.jsp");
        dispatcher.forward(request, response);
    }

    private void addContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("contract-detail-id"));
            int contractId = Integer.parseInt(request.getParameter("contract-id"));
            int serviceId = Integer.parseInt(request.getParameter("attach-service-id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            ContractDetail contractDetail = new ContractDetail(id, contractId, serviceId, quantity);
            Map<String, String> mapError = services.addContractDetail(contractDetail);
            if (mapError.isEmpty()) {
                request.setAttribute("status", id + " đã được tạo mới thành công");
                request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
                showList(request, response);
            } else {
                request.setAttribute("messName", mapError.get("nameError"));
                request.setAttribute("messId", mapError.get("idError"));
                request.setAttribute("messSQL", mapError.get("sqlError"));
                request.setAttribute("contract_detail", contractDetail);
                showAddForm(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("view/contract_detail/add.jsp");
            rd.forward(request, response);
        }
    }
}
