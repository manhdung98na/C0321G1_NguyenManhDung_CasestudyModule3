<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Trang chủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>

    </style>
</head>
<body>
<jsp:include page="../layoutt/header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 p-0 m-0" style="height: 100vh">
            <jsp:include page="../layoutt/left_content.jsp"></jsp:include>
        </div>
        <div class="col-10">
            <h2 class="m-3">Thông tin hợp đồng</h2>
            <table class="table table-borderless">
                <div class="form-group">
                    <tr>
                        <td width="30%">
                            <label for="detailId" class="d-inline">ID</label>
                        </td>
                        <td>
                            <input type="number" class="form-control d-inline" id="detailId" name="contract-id"
                                   value="${contract.id}" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailStartDate" class="d-inline">Start date</label>
                        </td>
                        <td>
                            <input type="date" class="form-control d-inline" id="detailStartDate"
                                   name="contract-start-date" value="${contract.startDate}" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailEndDate" class="d-inline">End date</label>
                        </td>
                        <td>
                            <input type="date" class="form-control d-inline" id="detailEndDate"
                                   name="contract-end-date" value="${contract.endDate}" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailDeposit" class="d-inline">Deposit (VND)</label>
                        </td>
                        <td>
                            <input type="number" class="form-control d-inline" id="detailDeposit"
                                   name="contract-deposit" value="${contract.deposit}" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailTotalMoney" class="d-inline">Total Money (VND)</label>
                        </td>
                        <td>
                            <input type="number" class="form-control d-inline" id="detailTotalMoney"
                                   name="contract-total-money" value="${contract.totalMoney}" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailEmploy" class="d-inline">Employee</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailEmploy"
                                   name="contract-employee" value="${contract.employeeName}" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailCustomer" class="d-inline">Customer</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailCustomer"
                                   name="contract-customer" value="${contract.customerName}" disabled>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailService" class="d-inline">Service</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailService"
                                   name="contract-service" value="${contract.serviceName}" disabled>
                        <td>
                    </tr>
                </div>
            </table>
            <div class="text-center">
                <a href="/" type="button" class="btn btn-secondary">Back to Home</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layoutt/footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>