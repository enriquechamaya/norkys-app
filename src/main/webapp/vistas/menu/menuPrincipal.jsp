<%@include file="../base/header.jsp" %>
<div class="text-center">
    <h1 class="display-4 text-white">Menú principal</h1>
</div>

<div class="text-center">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = './../../RegistroUsuarioController'">
                Registrar usuario
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = '../productos/registrarProducto.jsp'">
                Registrar producto
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = '../productos/consultarProducto.jsp'">
                Consultar productos
            </button>
        </div>
    </div>
    <br/>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = '../pedidos/consultarPedido.jsp'">
                Consultar pedidos
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = '../reportes/generarReporte.jsp'">
                Generar reporte de ventas
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <a href="../manual/manual.jsp" class="btn btn-success btn-lg btn-block text-white" target="_blank">
                Manuel de usuario
            </a>
        </div>
    </div>
</div>

<%@include file="../base/footer.jsp" %>