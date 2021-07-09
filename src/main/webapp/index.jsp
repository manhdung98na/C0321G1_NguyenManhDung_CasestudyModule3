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
    <link rel="stylesheet" href="assert/datatables/css/dataTables.bootstrap4.min.css"/>
    <style>
    </style>
</head>
<body>
<jsp:include page="view/layoutt/header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 p-0 m-0" style="height: 100vh">
            <jsp:include page="view/layoutt/left_content.jsp"></jsp:include>
        </div>
        <div class="col-10">
<%--            BODY--%>
            <div class="card mt-4">
                <div class="card-header">
                    <h3 style="color: #c41f00">Danh sách khách hàng đang sử dụng dịch vụ tại Resort</h3>
                </div>
                <div class="card-body">
                    <c:if test="${empty listcustomer}">
                    <div class="d-block">
                            <%--Hiển thị danh sách--%>
                        <h5 class="card-title d-inline-block">Không có khách hàng nào đang sử dụng dịch vụ</h5>
                    </div>
                </c:if>
                <c:if test="${not empty listcustomer}">
                    <table class="table table-sm align-middle table-striped table-bordered mt-4" id="tableCustomer">
                            <%--tiêu đề của bảng--%>
                        <thead class="p-0 table-dark w-100">
                        <tr class="">
                            <th class=" text-center">ID Customer</th>
                            <th class=" text-center">Customer name</th>
                            <th class=" text-center">ID Contract</th>
                            <th class=" text-center">Start Date</th>
                            <th class=" text-center">End Date</th>
                            <th class=" text-center">Service Name</th>
                            <th class=" text-center">Attach Service</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items='${listcustomer}' var="customer">
                            <tr class="">
                                <td class=" text-center"><a href="/customer?action=detail&id=${customer.idCustomer}">${customer.idCustomer}</a></td>
                                <td class=" text-center">${customer.nameCustomer}</td>
                                <td class=" text-center"><a href="/contract?action=detail&id=${customer.idContract}">${customer.idContract}</a></td>
                                <td class=" text-center">${customer.startDate}</td>
                                <td class=" text-center">${customer.endDate}</td>
                                <td class=" text-center"><a href="/service?action=detail&id=${customer.idService}">${customer.nameService}</a></td>
                                <td class=" text-center">${customer.getStringAttachService()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</div>
<jsp:include page="view/layoutt/footer.jsp"></jsp:include>

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
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>