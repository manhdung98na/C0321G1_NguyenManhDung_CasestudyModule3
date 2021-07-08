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
            <form method="post" action="/contract_detail" class="text-center">
                <input hidden name="action" value="add">
                <h2 class="m-3">Add New Contract Detail</h2>
                <table class="table table-borderless">
                    <c:if test="${messSQL != null}">
                        <p class="form-text text-danger">${messSQL}</p>
                    </c:if>
                    <div class="form-group">
                        <tr>
                            <td width="30%">
                                <label for="addId" class="d-inline">Contract Detail ID</label>
                            </td>
                            <td>
                                <input type="number" min="1" class="form-control d-inline" id="addId" name="contract-detail-id"
                                       value="${contract_detail.idContractDetail}" aria-describedby="id_stu" required>
                                <c:if test="${messId != null}">
                                <small id="id_stu" class="form-text text-danger">${messId}</small>
                                </c:if>
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addContractID" class="d-inline">Contract ID</label>
                            </td>
                            <td>
                                <input type="number" min="1" class="form-control d-inline" id="addContractID" name="contract-id"
                                       value="${contract_detail.idContract}" aria-describedby="id_contract_stu" required>
                                <c:if test="${messId != null}">
                                <small id="id_contract_stu" class="form-text text-danger">${messId}</small>
                                </c:if>
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addAttachService" class="d-inline">Attach service name</label>
                            </td>
                            <td>
                                <select class="form-control" id="addAttachService" name="attach-service-id">
                                    <option value="1" ${contract_detail.idAttachService == 1 ? 'selected' : ''}>Massage
                                    </option>
                                    <option value="2" ${customer.idAttachService == 2 ? 'selected' : ''}>Karaoke
                                    </option>
                                    <option value="3" ${customer.idAttachService == 3 ? 'selected' : ''}>Thức ăn</option>
                                    <option value="4" ${customer.idAttachService == 4 ? 'selected' : ''}>Nước uống
                                    </option>
                                    <option value="5" ${customer.idAttachService == 5 ? 'selected' : ''}>Thuê xe di chuyển tham quan resort
                                    </option>
                                </select>
                            <td>
                        </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                            <td>
                                <label for="addQuantity" class="d-inline">Quantity</label>
                            </td>
                            <td>
                                <input type="number" min="1" class="form-control d-inline" id="addQuantity"
                                       name="quantity"
                                       value="${contract_detail.quantity}" required>
                            <td>
                        </tr>
                    </div>
                </table>
                <a href="/contract_detail" type="button" class="btn btn-secondary">Back</a>
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