<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Add new service</title>
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
    <form method="post" action="/service" class="text-center">
        <input hidden name="action" value="add">
        <h2 class="m-3">Add New Service</h2>
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
                        <input type="text" class="form-control d-inline" id="addId" name="service-id"
                               value="${service.id}" aria-describedby="id_stu" required>
                        <c:if test="${messId != null}">
                        <small id="id_stu" class="form-text text-danger">${messId}</small>
                        </c:if>
                    <td>
                </tr>
            </div>

            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addName" class="d-inline">Name</label>
                    </td>
                    <td>
                        <input type="text" class="form-control d-inline" id="addName" name="service-name"
                               value="${service.name}" required>
                        <c:if test="${messName != null}">
                        <small id="name_stu" class="form-text text-danger">${messName}</small>
                        </c:if>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addServiceArea" class="d-inline">Service Area (m2)</label>
                    </td>
                    <td>
                        <input type="number" min="1" class="form-control d-inline" id="addServiceArea"
                               name="service-area" value="${service.area}" required>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addServiceCost" class="d-inline">Service Cost (VND)</label>
                    </td>
                    <td>
                        <input type="number" min="0" class="form-control d-inline" id="addServiceCost"
                               name="service-cost" value="${service.cost}" required>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addServiceMaxPeople" class="d-inline">Max People</label>
                    </td>
                    <td>
                        <input type="number" min="1" class="form-control d-inline" id="addServiceMaxPeople"
                               name="service-max-people" value="${service.maxPeople}" required>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addServiceRentType" class="d-inline">Rent Type</label>
                    </td>
                    <td>
                        <select class="form-control" id="addServiceRentType" name="service-rent-type">
                            <option value="1" ${service.rentTypeId == 1 ? 'selected' : ''}>Năm</option>
                            <option value="2" ${service.rentTypeId == 2 ? 'selected' : ''}>Tháng</option>
                            <option value="3" ${service.rentTypeId == 3 ? 'selected' : ''}>Ngày</option>
                            <option value="4" ${service.rentTypeId == 4 ? 'selected' : ''}>Giờ</option>
                        </select>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addServiceType" class="d-inline">Service Type</label>
                    </td>
                    <td>
                        <select class="form-control" id="addServiceType" name="service-type">
                            <option value="1" ${service.serviceTypeId == 1 ? 'selected' : ''}>Villa</option>
                            <option value="2" ${service.serviceTypeId == 2 ? 'selected' : ''}>House</option>
                            <option value="3" ${service.serviceTypeId == 3 ? 'selected' : ''}>Room</option>
                        </select>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addServiceStandardRoom" class="d-inline">Standard Room</label>
                    </td>
                    <td>
                        <input type="text" min="0" class="form-control d-inline" id="addServiceStandardRoom"
                               name="service-standard-room" value="${service.standardRoom}" required>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addDescription" class="d-inline">Description other convenience</label>
                    </td>
                    <td>
                        <input type="text" min="0" class="form-control d-inline" id="addDescription"
                               name="service-description" value="${service.descriptionConvenience}" required>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addPoolArea" class="d-inline">Pool Area (m2)</label>
                    </td>
                    <td>
                        <input type="number" min="0" class="form-control d-inline" id="addPoolArea"
                               name="service-pool-area" value="${service.poolArea}" required>
                    <td>
                </tr>
            </div>
            <div class="form-group">
                <tr>
                    <td width="30%">
                        <label for="addFloor" class="d-inline">Number of Floors</label>
                    </td>
                    <td>
                        <input type="number" min="1" class="form-control d-inline" id="addFloor"
                               name="service-floors" value="${service.floor}" required>
                    <td>
                </tr>
            </div>
        </table>
        <a href="/service" type="button" class="btn btn-secondary">Back</a>
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