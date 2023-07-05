<%@include file="header.jsp" %>
<link href="../assets/css/login.css" rel="stylesheet" type="text/css"/>

<div class="text-center">
    <h1 class="display-4 text-white">Iniciar sesi�n</h1>
</div>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Login Form -->
        <form method="POST">
            <input type="text" placeholder="Usuario" class="form-control form-control-lg" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
            <input type="text" placeholder="Contrase�a" class="form-control form-control-lg" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
            <button type="button" class="btn btn-success btn-lg">
                Ingresar
            </button>
        </form>

        <br/>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <p class="text-white">�No tienes una cuenta?</p>
            <a class="underlineHover" href="#" onclick="location.href = 'registrarUsuario.jsp'">Reg�strate</a>
        </div>

    </div>
</div>

<%@include file="footer.jsp" %>