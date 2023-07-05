<%@include file="header.jsp" %>
<div class="text-center">
    <h1 class="display-4 text-white">Menú principal</h1>
</div>

<div class="text-center">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = 'registrarUsuario.jsp'">
                Registrar usuario
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = 'registrarProducto.jsp'">
                Registrar producto
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = 'consultarProducto.jsp'">
                Consulta productos
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = 'registrarPedido.jsp'">
                Registrar pedido
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = 'consultarPedido.jsp'">
                Consulta pedidos
            </button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <button type="button" class="btn btn-success btn-lg btn-block" onclick="location.href = 'generarReporte.jsp'">
                Generar reporte de ventas
            </button>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>