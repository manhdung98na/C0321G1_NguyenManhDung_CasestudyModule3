<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Chi tiết khách hàng</title>
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
            <h2 class="m-3">Chi tiết khách hàng</h2>
            <table class="table table-borderless">
                <div class="form-group">
                    <tr>
                        <td width="20%">
                            <label for="detailID" class="d-inline">ID</label>
                        </td>
                        <td>
                            <input type="text" readonly class="form-control d-inline" id="detailID" name="customer-id"
                                   value="${customer.getCustomerId()}" aria-describedby="id_stu">
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailType" class="d-inline">Customer type</label>
                        </td>
                        <td>
                            <select class="form-control d-inline" id="detailType" name="customer-type" disabled="true">
                                <option value="1" ${customer.getCustomerType() == 1 ? 'selected': ''}>Diamond
                                </option>
                                <option value="2" ${customer.getCustomerType() == 2 ? 'selected': ''}>Platinium
                                </option>
                                <option value="3" ${customer.getCustomerType() == 3 ? 'selected': ''}>Gold</option>
                                <option value="4" ${customer.getCustomerType() == 4 ? 'selected': ''}>Silver
                                </option>
                                <option value="5" ${customer.getCustomerType() == 5 ? 'selected': ''}>Member
                                </option>
                            </select>
                        <td>
                    </tr>
                </div>
                <%--Edit Name--%>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailName" class="d-inline">Customer Name</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailName" name="customer-name"
                                   value="${customer.getCustomerName()}" aria-describedby="name_stu" readonly>

                        <td>
                    </tr>
                </div>
                <%--Edit Email--%>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailBirthday" class="d-inline">Birthday</label>
                        </td>
                        <td>
                            <input type="date" class="form-control d-inline" id="detailBirthday"
                                   name="customer-birthday"
                                   value="${customer.getCustomerBirthday()}" readonly>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label class="d-inline">Gender</label>
                        </td>
                        <td style="float: left">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="customer-gender" id="addGender1"
                                       value="Male" ${customer.getCustomerGender() == 'Male' ? 'checked':''} disabled>
                                <label class="form-check-label" for="addGender1">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="customer-gender" id="addGender2"
                                       value="Female" ${customer.getCustomerGender() == 'Female' ? 'checked':''}
                                       disabled>
                                <label class="form-check-label" for="addGender2">Female</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="customer-gender" id="addGender3"
                                       value="Unknown" ${customer.getCustomerGender() == 'Unknown' ? 'checked':''}
                                       disabled>
                                <label class="form-check-label" for="addGender3">Unknown</label>
                            </div>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailIdCard" class="d-inline">ID Card</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailIdCard" name="customer-id-card"
                                   value="${customer.getCustomerIdCard()}" aria-describedby="idCard_stu" readonly>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailPhone" class="d-inline">Phone</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailPhone" name="customer-phone"
                                   value="${customer.getCustomerPhone()}" aria-describedby="phone_stu" readonly>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailEmail" class="d-inline">Email</label>
                        </td>
                        <td>
                            <input type="email" class="form-control d-inline" id="detailEmail" name="customer-email"
                                   value="${customer.getCustomerEmail()}" aria-describedby="email_stu" readonly>
                        <td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="detailAddress" class="d-inline">Address</label>
                        </td>
                        <td>
                            <input type="text" class="form-control d-inline" id="detailAddress"
                                   name="customer-address"
                                   value="${customer.getCustomerAddress()}" readonly>
                        <td>
                    </tr>
                </div>
            </table>
            <div class=" text-center">
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