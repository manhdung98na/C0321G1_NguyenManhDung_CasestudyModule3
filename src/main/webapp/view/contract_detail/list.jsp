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
                    <h3 style="color: #c41f00">Danh sách hợp đồng chi tiết</h3>
                </div>
                <div class="card-body">
                    <c:if test="${empty listcontract_detail}">
                    <div class="d-block">
                            <%--Hiển thị danh sách--%>
                        <h5 class="card-title d-inline-block">Danh sách rỗng</h5>
                    </div>
                    <a href="/contract_detail?action=add" type="button" class="btn btn-success card-title float-right text-wrap">
                        Add new contract detail
                    </a></div>
                </c:if>
                <c:if test="${not empty listcontract_detail}">
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

                    <%--Ô tìm kiếm--%>
<%--                    <div>--%>
<%--                        <div class="search-box">--%>
<%--                            <form class="search-form  d-flex" action="/contract_detail" method="post">--%>
<%--                                <div class="input-group mb-3">--%>
<%--                                    <input type="text" class="form-control" name="nameSearch"--%>
<%--                                           placeholder="Tìm kiếm theo tên"--%>
<%--                                           aria-label="Tìm kiếm theo tên" aria-describedby="button-addon2"--%>
<%--                                           onkeypress="activeBtnSearch()">--%>
<%--                                    <div class="input-group-prepend">--%>
<%--                                        <input hidden name="action" value="search">--%>
<%--                                        <button type="submit" class="btn btn-secondary" id="button-addon2" disabled>--%>
<%--                                            <i class="fas fa-search"></i>--%>
<%--                                        </button>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </form>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <hr>
                    <div class="d-inline">
                            <%--Hiển thị danh sách--%>
                        <h5 class="card-title d-inline-block">List of Customers</h5>
                        <a href="/contract_detail?action=add" type="button" class="btn btn-success card-title float-right">
                            Add new contract_detail
                        </a></div>
                    <%--Bảng danh sách--%>
                    <table class="table table-sm align-middle table-striped table-bordered mt-4" id="tableContractDetail">
                            <%--tiêu đề của bảng--%>
                        <thead class="p-0 table-dark w-100">
                        <tr class="">
                            <th class="text-wrap text-center">Contract detail ID</th>
                            <th class="text-wrap text-center">Contract ID</th>
                            <th class="text-wrap text-center">Attach service name</th>
                            <th class="text-wrap text-center">Quantity</th>
                        </tr>
                        </thead>
                            <%--danh sách người dùng--%>
                        <tbody>
                        <c:forEach items='${listcontract_detail}' var="contract_detail">
                            <tr class="">
                                <td class=" text-center">${contract_detail.idContractDetail}</td>
                                <td class=" text-center">${contract_detail.idContract}</td>
                                <td class=" text-center">${contract_detail.nameAttachService}</td>
                                <td class=" text-center">${contract_detail.quantity}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
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
        $('#tableContractDetail').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
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
</html>