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
            <form method="post" action="/employee" class="text-center">
                <input hidden name="action" value="add">
                <h2 class="m-3">Add New Employee</h2>
                <table class="table table-borderless">
                    <div class="form-group">
                        <c:if test="${messSQL != null}">
                            <p class="form-text text-danger">${messSQL}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td width="30%">
                                <label for="addId" class="d-inline">ID</label>
                            </td>
                            <td>
                                <input type="number" min="0" class="form-control d-inline" id="addId" name="employee-id"
                                       required value="${employee.id}">
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addName" class="d-inline">Name</label>
                            </td>
                            <td>
                                <input type="text" class="form-control d-inline" id="addName" name="employee-name"
                                       required value="${employee.name}">
                                <c:if test="${messName != null}">
                                <small id="id_stu" class="form-text text-danger">${messName}</small>
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
                                <input type="date" class="form-control d-inline" id="addBirthday"
                                       name="employee-birthday"
                                       required value="${employee.birthday}">
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addIdCard" class="d-inline">ID Card</label>
                            </td>
                            <td>
                                <input type="text" class="form-control d-inline" id="addIdCard" name="employee-id-card"
                                       required value="${employee.idCard}">
                                <c:if test="${messIdCard != null}">
                                <small id="id_stu" class="form-text text-danger">${messIdCard}</small>
                                </c:if>
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addSalary" class="d-inline">Salary (triệu VND/tháng)</label>
                            </td>
                            <td>
                                <input type="number" min="1" class="form-control d-inline" id="addSalary"
                                       name="employee-salary"
                                       required value="${employee.salary}">
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addPhone" class="d-inline">Phone</label>
                            </td>
                            <td>
                                <input type="text" class="form-control d-inline" id="addPhone" name="employee-phone"
                                       required value="${employee.phone}">
                                <c:if test="${messPhone != null}">
                                <small id="id_stu" class="form-text text-danger">${messPhone}</small>
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
                                <input type="email" class="form-control d-inline" id="addEmail" name="employee-email"
                                       required value="${employee.email}">
                                <c:if test="${messEmail != null}">
                                <small id="id_stu" class="form-text text-danger">${messEmail}</small>
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
                                <input type="text" class="form-control d-inline" id="addAddress" name="employee-address"
                                       required value="${employee.address}">
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addPosition" class="d-inline">Position</label>
                            </td>
                            <td>
                                <select class="form-control" id="addPosition" name="employee-position">
                                    <option value="1" ${employee.positionId == 1 ? 'selected' : ''}>Lễ tân</option>
                                    <option value="2" ${employee.positionId == 2 ? 'selected' : ''}>Phục vụ</option>
                                    <option value="3" ${employee.positionId == 3 ? 'selected' : ''}>Chuyên viên</option>
                                    <option value="4" ${employee.positionId == 4 ? 'selected' : ''}>Giám sát</option>
                                    <option value="5" ${employee.positionId == 5 ? 'selected' : ''}>Quản lý</option>
                                    <option value="6" ${employee.positionId == 6 ? 'selected' : ''}>Giám đốc</option>
                                </select>
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addEducation" class="d-inline">Education Degree</label>
                            </td>
                            <td>
                                <select class="form-control" id="addEducation" name="employee-education">
                                    <option value="1" ${employee.educationDegreeId == 1 ? 'selected' : ''}>Trung cấp
                                    </option>
                                    <option value="2" ${employee.educationDegreeId == 2 ? 'selected' : ''}>Cao đẳng
                                    </option>
                                    <option value="3" ${employee.educationDegreeId == 3 ? 'selected' : ''}>Đại học
                                    </option>
                                    <option value="4" ${employee.educationDegreeId == 4 ? 'selected' : ''}>Sau đại học
                                    </option>
                                </select>
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addDivision" class="d-inline">Division</label>
                            </td>
                            <td>
                                <select class="form-control" id="addDivision" name="employee-division">
                                    <option value="1" ${employee.divisionId == 1 ? 'selected' : ''}>Sale - Marketing
                                    </option>
                                    <option value="2" ${employee.divisionId == 2 ? 'selected' : ''}>Hành chính</option>
                                    <option value="3" ${employee.divisionId == 3 ? 'selected' : ''}>Phục vụ</option>
                                    <option value="4" ${employee.divisionId == 4 ? 'selected' : ''}>Quản lý</option>
                                </select>
                            <td>
                        </tr>
                    </div>
                </table>
                <a href="/employee" type="button" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-success">Submit</button>
            </form>
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