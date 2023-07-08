<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String usuario = request.getParameter("username");
    String url = "";
    if (usuario != null) {
        url = "/norkys-app-utp/LoginController?usuario=" + usuario;
    } else {
        url = "/norkys-app-utp/LoginController";
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Norkys-App</title>
        <link rel="icon" href="../../assets/img/norkys-logo.png">
        <link href="../../assets/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/css/toastr/js_latest_toastr.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body class="bg">
        <div class="container">
            <header>
                <div class="row">
                    <div class="col-md-2">
                        <br/>
                        <button type="button" class="btn btn-primary" onclick="javascript:location.href = '<%= url %>'">
                            Intranet
                        </button>
                    </div>
                    <div class="col-md-8 text-center">
                        <img src="../../assets/img/logo.png">
                    </div>
                    <div class="col-md-2">
                        &nbsp;
                    </div>                    


                    <!--<div class="col-md-4 offset-md-4">
                        <img src="../../assets/img/logo.png">
                    </div>-->
                </div> 
            </header>