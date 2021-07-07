<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Add new contract</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        small {
            float: left;
        }
    </style>
</head>
<body>
<div class="container">
    <form method="post" action="/contract" class="text-center">
        <input hidden name="action" value="add">
        <h2 class="m-3">Add New Contract</h2>
        <table class="table table-borderless">
            <c:if test="${messSQL != null}">
                <p class="form-text text-danger">${messSQL}</p>
            </c:if>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addId" class="d-inline">ID</label>
                    </td>
                    <td>
                        <input type="number" min="0" class="form-control d-inline" id="addId" name="contract-id"
                               value="${contract.id}" aria-describedby="id_stu" required>
                        
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addStartDate" class="d-inline">Start date</label>
                    </td>
                    <td>
                        <input type="date" class="form-control d-inline" id="addStartDate" name="contract-start-date"
                               value="${contract.startDate}" aria-describedby="start_date_stu" required>
                        <c:if test="${messTime != null}">
                        <small id="start_date_stu" class="form-text text-danger">${messTime}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addEndDate" class="d-inline">End date</label>
                    </td>
                    <td>
                        <input type="date" class="form-control d-inline" id="addEndDate" name="contract-end-date"
                               value="${contract.endDate}" aria-describedby="end_date_stu" required>
                        <c:if test="${messTime != null}">
                        <small id="end_date_stu" class="form-text text-danger">${messTime}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addDeposit" class="d-inline">Deposit (VND)</label>
                    </td>
                    <td>
                        <input type="number" min="0" class="form-control d-inline" id="addDeposit" name="contract-deposit"
                               aria-describedby="deposit_stu" value="${contract.deposit}" required>
                        <c:if test="${messMoney != null}">
                        <small id="deposit_stu" class="form-text text-danger">${messMoney}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addTotalMoney" class="d-inline">Total Money (VND)</label>
                    </td>
                    <td>
                        <input type="number" min="0" class="form-control d-inline" id="addTotalMoney" name="contract-total-money"
                               aria-describedby="deposit_stu" value="${contract.totalMoney}" required>
                        <c:if test="${messMoney != null}">
                        <small id="deposit_stu" class="form-text text-danger">${messMoney}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addEmployID" class="d-inline">Employee ID</label>
                    </td>
                    <td>
                        <input type="number" min="0" class="form-control d-inline" id="addEmployID" name="contract-employee"
                               aria-describedby="employee_stu" value="${contract.employeeId}" required>
                        <c:if test="${messEmployeeId != null}">
                        <small id="employee_stu" class="form-text text-danger">${messEmployeeId}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addCustomerID" class="d-inline">Customer ID</label>
                    </td>
                    <td>
                        <input type="text" class="form-control d-inline" id="addCustomerID" name="contract-customer"
                               aria-describedby="customer_stu" value="${contract.customerId}" required>
                        <c:if test="${messCustomerId != null}">
                        <small id="customer_stu" class="form-text text-danger">${messCustomerId}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addServiceID" class="d-inline">Service ID</label>
                    </td>
                    <td>
                        <input type="text" class="form-control d-inline" id="addServiceID" name="contract-service"
                               aria-describedby="service_stu" value="${contract.serviceId}" required>
                        <c:if test="${messServiceId != null}">
                        <small id="service_stu" class="form-text text-danger">${messServiceId}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
        </table>
        <a href="/contract" type="button" class="btn btn-secondary">Back</a>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>
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