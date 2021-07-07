<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Add new customer</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        small{
            float: left;
        }
    </style>
</head>
<body>
<div class="container">
    <form method="post" action="/customer" class="text-center">
        <input hidden name="action" value="add">
        <h2 class="m-3">Add New Customer</h2>
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
                        <input type="text" min="0" class="form-control d-inline" id="addId" name="customer-id"
                               value="${customer.getCustomerId()}" aria-describedby="id_stu" required>
                        <c:if test="${messId != null}">
                        <small id="id_stu" class="form-text text-danger">${messId}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addCustomerType" class="d-inline">Customer Type</label>
                    </td>
                    <td>
                        <select class="form-control" id="addCustomerType" name="customer-type">
                            <option value="1" ${customer.getCustomerType() == 1 ? 'selected' : ''}>Diamond</option>
                            <option value="2" ${customer.getCustomerType() == 2 ? 'selected' : ''}>Platinium</option>
                            <option value="3" ${customer.getCustomerType() == 3 ? 'selected' : ''}>Gold</option>
                            <option value="4" ${customer.getCustomerType() == 4 ? 'selected' : ''}>Silver</option>
                            <option value="5" ${customer.getCustomerType() == 5 ? 'selected' : ''}>Member</option>
                        </select>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addName" class="d-inline">Name</label>
                    </td>
                    <td>
                        <input type="text" class="form-control d-inline" id="addName" name="customer-name"
                               aria-describedby="name_stu" value="${customer.getCustomerName()}" required>
                        <c:if test="${messName != null}">
                        <small id="name_stu" class="form-text text-danger">${messName}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addBirthday" class="d-inline">Birthday</label>
                    </td>
                    <td>
                        <input type="date" class="form-control d-inline" id="addBirthday" name="customer-birthday"
                               value="${customer.getCustomerBirthday()}" required>
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
                                   value="Male" ${customer.getCustomerGender() == 'Male' ? 'checked' : ''}>
                            <label class="form-check-label" for="addGender1">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="customer-gender" id="addGender2"
                                   value="Female" ${customer.getCustomerGender() == 'Female' ? 'checked' : ''}>
                            <label class="form-check-label" for="addGender2">Female</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="customer-gender" id="addGender3"
                                   value="Unknown" ${customer.getCustomerGender() == 'Unknown' ? 'checked' : ''}>
                            <label class="form-check-label" for="addGender3">Unknown</label>
                        </div>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addIdCard" class="d-inline">ID Card</label>
                    </td>
                    <td>
                        <input type="text" class="form-control d-inline" id="addIdCard" name="customer-id-card"
                              value="${customer.getCustomerIdCard()}" aria-describedby="idCard_stu" required>
                        <c:if test="${messIdCard != null}">
                        <small id="idCard_stu" class="form-text text-danger">${messIdCard}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addPhone" class="d-inline">Phone</label>
                    </td>
                    <td>
                        <input type="text" class="form-control d-inline" id="addPhone" name="customer-phone"
                               aria-describedby="phone_stu" value="${customer.getCustomerPhone()}" required>
                        <c:if test="${messPhone != null}">
                        <small id="phone_stu" class="form-text text-danger">${messPhone}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addEmail" class="d-inline">Email</label>
                    </td>
                    <td>
                        <input type="email" class="form-control d-inline" id="addEmail" name="customer-email"
                               aria-describedby="email_stu" value="${customer.getCustomerEmail()}" required>
                        <c:if test="${messEmail != null}">
                        <small id="email_stu" class="form-text text-danger">${messEmail}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td>
                        <label for="addAddress" class="d-inline">Address</label>
                    </td>
                    <td>
                        <input type="text" class="form-control d-inline" id="addAddress" name="customer-address"
                              value="${customer.getCustomerAddress()}" required>
                    <td>
                </tr>
            </div>
        </table>
        <a href="/customer" type="button" class="btn btn-secondary">Back</a>
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