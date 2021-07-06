<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Quản lý dịch vụ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="assert/datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
    <style>
    </style>
</head>
<body>
<div class="container">
    <div class="card mt-4">
        <div class="card-header">
            <h3 style="color: #c41f00">Danh sách dịch vụ</h3>
        </div>
        <div class="card-body">
            <c:if test="${empty listservice}">
            <div class="d-block">
                    <%--Hiển thị danh sách--%>
                <h5 class="card-title d-inline-block">Danh sách dịch vụ rỗng</h5>
                <a href="/service?action=add" type="button" class="btn btn-success card-title float-right">
                    Add new service
                </a></div>
        </div>
        </c:if>
        <c:if test="${not empty listservice}">
            <%--            toast--%>
        <c:if test="${not empty status}">
            <div class="toast" data-autohide="false"
                 style="position: fixed; bottom: 15px; right: 15px; z-index: 1">
                <div class="toast-header" style="background-color: ${requestScope['colorHeader']}">
                    <strong class="mr-auto">Trạng thái</strong>
                    <small>vừa xong</small>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="toast-body">
                    <span style="color: red">${requestScope['status']}</span>
                </div>
            </div>
        </c:if>
        <div class="d-inline">
                <%--Hiển thị danh sách--%>
            <h5 class="card-title d-inline-block">List of Services</h5>
            <a href="/service?action=add" type="button" class="btn btn-success card-title float-right">
                Add new service
            </a></div>
            <%--Bảng danh sách--%>
        <table class="table table-sm align-middle table-striped table-bordered mt-4" id="tableCustomer">
                <%--tiêu đề của bảng--%>
            <thead class="p-0 table-dark w-100">
            <tr class="">
                <th class=" text-center">ID</th>
                <th class=" text-center">Name</th>
                <th class=" text-center">Area</th>
                <th class=" text-center">Cost</th>
                <th class=" text-center">Max People</th>
                <th class=" text-center">Rent Type</th>
                <th class=" text-center">Service Type</th>
                <th class=" text-center">Standard Room</th>
                <th class=" text-center">Description Convenience</th>
                <th class=" text-center">Pool Area</th>
                <th class=" text-center">Number of Floors</th>
            </tr>
            </thead>
                <%--danh sách người dùng--%>
            <tbody>
            <c:forEach items='${listservice}' var="service">
                <tr class="">
                    <td class=" text-center">${service.getId()}</td>
                    <td class=" text-center">${service.getName()}</td>
                    <td class=" text-center">${service.getArea()}</td>
                    <td class=" text-center">${service.getCost()}</td>
                    <td class=" text-center">${service.getMaxPeople()}</td>
                    <td class=" text-center">${service.getRentTypeName()}</td>
                    <td class=" text-center">${service.getServiceTypeName()}</td>
                    <td class=" text-center">${service.getStandardRoom()}</td>
                    <td class=" text-center">${service.getDescriptionConvenience()}</td>
                    <td class=" text-center">${service.getPoolArea()}</td>
                    <td class=" text-center">${service.getFloor()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</c:if>
</div>


<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
<%--        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
<%--        crossorigin="anonymous"></script>--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 7
        });
    });
</script>
<script>
    $(document).ready(function () {
        $('.toast').toast('show');
        $('.toast').fadeOut(3500);
    });
</script>
<script>
    function activeBtnSearch() {
        document.getElementById("button-addon2").removeAttribute("disabled");
    }
</script>
</body>
</html>