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
                                <label for="idCustomer" class="d-inline">ID</label>
                            </td>
                            <td>
                                <input type="text" min="0" class="form-control d-inline" id="idCustomer"
                                       name="customer-id"
                                       value="${customer.getCustomerId()}" aria-describedby="id_stu" required>
                                <input id="id_stu2" class="form-text text-danger border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
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
                                    <option value="1" ${customer.getCustomerType() == 1 ? 'selected' : ''}>Diamond
                                    </option>
                                    <option value="2" ${customer.getCustomerType() == 2 ? 'selected' : ''}>Platinium
                                    </option>
                                    <option value="3" ${customer.getCustomerType() == 3 ? 'selected' : ''}>Gold</option>
                                    <option value="4" ${customer.getCustomerType() == 4 ? 'selected' : ''}>Silver
                                    </option>
                                    <option value="5" ${customer.getCustomerType() == 5 ? 'selected' : ''}>Member
                                    </option>
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
                                <input id="name_stu" class="form-text text-danger border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addBirthday" class="d-inline">Birthday</label>
                            </td>
                            <td>
                                <input type="date" class="form-control d-inline" id="addBirthday"
                                       name="customer-birthday"
                                       value="${customer.getCustomerBirthday()}" required>
                                <input id="birthday_stu" class="form-text text-danger border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
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
                                           value="Male" ${customer.getCustomerGender() == 'Male' ? 'checked' : ''} checked="checked">
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
                                <input id="id_card_stu" class="form-text text-danger border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
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
                                <input id="phone_stu" class="form-text text-danger border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
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
                                <input id="email_stu" class="form-text text-danger border-0 bg-white d-block w-100"
                                       style="font-size: smaller" value="" hidden disabled>
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
                <button type="submit" class="btn btn-success" disabled="false" id="btn_submit">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../layoutt/footer.jsp"></jsp:include>


<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
<script>
    $(document).ready(function () {
        $('#idCustomer').change(function () {
            let id = $("#idCustomer").val();
            console.log(id);
            $.ajax({
                url: 'customer',
                data: {
                    action: "check_id",
                    id_check: id
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("id_stu2").value = responseText;
                        document.getElementById("id_stu2").hidden = false;
                        document.getElementById("id_stu2").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("id_stu2").value = "";
                        document.getElementById("id_stu2").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });
        $('#addName').change(function () {
            let name = $("#addName").val();
            console.log(name);
            $.ajax({
                url: 'customer',
                data: {
                    action: "check_name",
                    name_check: name
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("name_stu").value = responseText;
                        document.getElementById("name_stu").hidden = false;
                        document.getElementById("name_stu").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("name_stu").value = "";
                        document.getElementById("name_stu").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });

        $('#addBirthday').change(function () {
            let birthday = $("#addBirthday").val();
            console.log(birthday);
            $.ajax({
                url: 'customer',
                data: {
                    action: "check_birthday",
                    birthday_check: birthday
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("birthday_stu").value = responseText;
                        document.getElementById("birthday_stu").hidden = false;
                        document.getElementById("birthday_stu").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("birthday_stu").value = "";
                        document.getElementById("birthday_stu").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });

        $('#addIdCard').change(function () {
            let idCard = $("#addIdCard").val();
            console.log(idCard);
            $.ajax({
                url: 'customer',
                data: {
                    action: "check_id_card",
                    id_card_check: idCard
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("id_card_stu").value = responseText;
                        document.getElementById("id_card_stu").hidden = false;
                        document.getElementById("id_card_stu").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("id_card_stu").value = "";
                        document.getElementById("id_card_stu").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });

        $('#addPhone').change(function () {
            let phone = $("#addPhone").val();
            console.log(phone);
            $.ajax({
                url: 'customer',
                data: {
                    action: "check_phone",
                    phone_check: phone
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("phone_stu").value = responseText;
                        document.getElementById("phone_stu").hidden = false;
                        document.getElementById("phone_stu").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("phone_stu").value = "";
                        document.getElementById("phone_stu").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });

        $('#addEmail').change(function () {
            let email = $("#addEmail").val();
            console.log(email);
            $.ajax({
                url: 'customer',
                data: {
                    action: "check_email",
                    email_check: email
                },
                success: function (responseText) {
                    if (responseText != "") {
                        document.getElementById("email_stu").value = responseText;
                        document.getElementById("email_stu").hidden = false;
                        document.getElementById("email_stu").disabled = true;
                        document.getElementById("btn_submit").disabled = true;
                    }else {
                        document.getElementById("email_stu").value = "";
                        document.getElementById("email_stu").hidden = true;
                        document.getElementById("btn_submit").disabled = false;
                    }
                }
            });
        });
    });
</script>
</html>