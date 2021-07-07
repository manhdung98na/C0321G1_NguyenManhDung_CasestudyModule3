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
    <link rel="stylesheet" href="../../assert/datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
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
            <div class="card mt-4">
                <div class="card-header">
                    <h3 style="color: #c41f00">Tìm kiếm khách hàng theo tên</h3>
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
                        <h5 class="card-title d-inline-block">Danh sách khách hàng</h5>
                    </div>
                    <table class="table table-sm align-middle table-striped table-bordered mt-4" id="tableCustomer">
                            <%--tiêu đề của bảng--%>
                        <thead class="p-0 table-dark w-100">
                        <tr class="">
                            <th class=" text-center">ID</th>
                            <th class=" text-center">Type</th>
                            <th class=" text-center">Name</th>
                            <th class=" text-center">Birthday</th>
                            <th class=" text-center">Gender</th>
                            <th class=" text-center">ID Card</th>
                            <th class=" text-center">Phone</th>
                            <th class=" text-center">Email</th>
                            <th class=" text-center">Address</th>
                            <th class=" text-center ">Action</th>
                        </tr>
                        </thead>
                            <%--danh sách người dùng--%>
                        <tbody>
                        <c:forEach items='${searchList}' var="customer">
                            <tr class="">
                                <td class=" text-center">${customer.getCustomerId()}</td>
                                <td class=" text-center">${customer.getCustomerTypeName()}</td>
                                <td class=" text-center">${customer.getCustomerName()}</td>
                                <td class=" text-center">${customer.getCustomerBirthday()}</td>
                                <td class=" text-center">${customer.getCustomerGender()}</td>
                                <td class=" text-center">${customer.getCustomerIdCard()}</td>
                                <td class=" text-center">${customer.getCustomerPhone()}</td>
                                <td class=" text-center">${customer.getCustomerEmail()}</td>
                                <td class=" text-center">${customer.getCustomerAddress()}</td>
                                <td class=" text-center">
                                    <a class="btn btn-info btn-sm"
                                       href="/customer?action=edit&id=${customer.getCustomerId()}"
                                       role="button">Edit</a>

                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                            data-target="#modalDel"
                                            onclick="sendInfoToDelete(${customer.getCustomerId()},'${customer.getCustomerName()}')">
                                        Delete
                                    </button>
                                    <!-- Modal -->
                                    <div class="modal fade" id="modalDel" tabindex="-1" role="dialog"
                                         aria-labelledby="modelTitleId" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title">Xác nhận xoá</h5>
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <form action="/customer" method="get">
                                                    <input hidden name="action" value="delete">
                                                    <input hidden name="id" value="" id="idDelete">
                                                    <div class="modal-body">
                                                        <div class="container-fluid">
                                                            Bạn muốn xoá
                                                            <input id="nameConfirm" value=""
                                                                   style="border: none; outline:none; color: red"
                                                                   readonly>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-dismiss="modal">
                                                            Close
                                                        </button>
                                                        <button type="submit" class="btn btn-danger">Delete</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <script>
                                        function sendInfoToDelete(id, name) {
                                            document.getElementById("idDelete").value = id;
                                            document.getElementById("nameConfirm").value = name + '?';

                                        }
                                    </script>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                </c:if>
                <div class="text-center w-100">
                    <a href="/customer" type="button" class="btn btn-dark w-15 ">
                        Back
                    </a>
                </div>
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
<script src="../../assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../assert/datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>