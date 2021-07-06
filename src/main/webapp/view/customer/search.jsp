<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Quản lý sản phẩm</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="assert/datatables/css/dataTables.bootstrap4.min.css"/>
    <style>

    </style>
</head>
<body>
<div class="container">
    <div class="card mt-4">
        <div class="card-header">
            <h3 style="color: #c41f00">Người dùng tìm kiếm theo Country</h3>
        </div>
        <div class="card-body">
            <c:if test="${empty searchList}">
                <div class="d-inline">
                        <%--Hiển thị danh sách--%>
                    <h5 class="card-title d-inline-block">Danh sách rỗng</h5>
                </div>
            </c:if>
            <c:if test="${not empty searchList}">
            <div class="d-inline">
                <h5 class="card-title d-inline-block">Danh sách người dùng</h5>
            </div>
            <table class="table align-middle table-striped table-bordered mt-4" id="">
                <thead class="p-0 table-dark w-100">
                <tr class="">
                    <th class=" text-center">ID</th>
                    <th class=" text-center">Name</th>
                    <th class=" text-center">Email</th>
                    <th class=" text-center">Country</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items='${requestScope["searchList"]}' var="user">
                    <tr class="">
                        <td class=" text-center">${user.getId()}</td>
                        <td class=" text-center">${user.getName()}</td>
                        <td class=" text-center">${user.getEmail()}</td>
                        <td class=" text-center">${user.getCountry()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </c:if>
        <div class="text-center w-100">
            <a href="/users" type="button" class="btn btn-dark w-15 ">
                Back
            </a>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="assert/datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
<script>
    $(document).ready(function () {
        $('#tableUser').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
            "aoColumns": [
                {"bSortable": false},
                {"bSortable": false},
                {"bSortable": false},
                {"bSortable": false},
            ]
        });
    });
</script>
</html>