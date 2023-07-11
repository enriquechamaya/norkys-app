<%@ page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String username = (String) session.getAttribute("username");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Norkys-App</title>
        <link rel="icon" href="../../assets/img/logo.png">
        <link href="../../assets/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/css/main.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/css/toastr/js_latest_toastr.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">        
    </head>
    <body class="bg">

        <div class="container-fluid">
            <header>
                <div class="row">
                    <div class="col-4">
                        <% if (username != null) {%>
                        <div>
                            <h3 class="text-white">
                                <strong>Usuario:</strong> <span><%= username %></span>
                            </h3>
                            <button type="button" class="btn btn-success btn-lg" onclick="location.href = '../../LoginController?accion=logout'">
                                Salir
                            </button>
                        </div>
                        <%}%>
                    </div>
                    <div class="col-4 text-center">
                        <img src="../../assets/img/logo.png">                    
                    </div>
                    <div class="col-4 text-right">
                        <br/>
                        <% if (username != null) {%>
                        <button type="button" class="btn btn-info btn-lg" onclick="location.href = '../../vistas-cliente/menu/menu.jsp'">
                            Ir a la vista cliente
                        </button>
                        <%}%>
                    </div>
                </div> 
            </header>