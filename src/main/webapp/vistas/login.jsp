<%@include file="header.jsp" %>
<link href="../assets/css/login.css" rel="stylesheet" type="text/css"/>

<div class="text-center">
    <h1 class="display-4 text-white">Iniciar sesión</h1>
</div>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Login Form -->
        <form method="POST">
            <input type="text" placeholder="Usuario" class="form-control form-control-lg" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
            <input type="text" placeholder="Contraseña" class="form-control form-control-lg" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
            <button type="button" class="btn btn-success btn-lg">
                Ingresar
            </button>
        </form>

        <br/>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <p class="text-white">¿No tienes una cuenta?</p>
            <a class="underlineHover" href="#" onclick="location.href = 'registrarUsuario.jsp'">Regístrate</a>
        </div>

    </div>
</div>

<%@include file="footer.jsp" %>