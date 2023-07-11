<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
%>
<%@include file="../base/header.jsp" %>
<link href="../../assets/css/login.css" rel="stylesheet" type="text/css"/>

<div class="text-center">
    <h1 class="display-4 text-white">Iniciar sesión</h1>
</div>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Login Form -->
        <form method="POST" action="../../LoginController">
            <input type="text" placeholder="Usuario" name="usuario" class="form-control form-control-lg" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
            <input type="password" placeholder="Contraseña" name="password" class="form-control form-control-lg" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
            <button type="submit" class="btn btn-success btn-lg">
                Ingresar
            </button>
        </form>

        <br/>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <p class="text-white">¿No tienes una cuenta?</p>
            <a class="underlineHover" href="#" onclick="location.href = '../../RegistroUsuarioController'">Regístrate</a>
        </div>

    </div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/js/login/login.js" type="text/javascript"></script>