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
<div class="container-fluid">
    <%--    Logo--%>
    <div class="row" style="background-color: #f8f9fa; height: 50px">
        <div class="col-2">
            <img src="img/logo/logo_codegym.jpg" width="50px" height="50px">
        </div>
        <div class="col-10">
            <span class="" style="font-size: large; float: right; line-height: 50px">C0321G1-Nguyễn Mạnh Dũng</span>
        </div>
    </div>
    <%--        navbar--%>
    <div class="row" style="background-color: #f8f9fa">
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <%--                <button class="navbar-toggler" type="button" data-toggle="collapse"--%>
                <%--                        data-target="#navbarSupportedContent"--%>
                <%--                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
                <%--                    <span class="navbar-toggler-icon"></span>--%>
                <%--                </button>--%>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contract</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <div class="row" style="height: 100vh">
        <div class="col-3">

        </div>
        <div class="col-9">

        </div>
    </div>
    <div class="row" style="background-color: #f8f9fa">
        Footer
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
</body>
</html>