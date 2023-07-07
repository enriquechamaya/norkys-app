<%@include file="../base/header.jsp" %>

<div class="col-md-4 offset-md-4 text-center">
    <h1 class="display-4">Detalle Carrito</h1>
</div>


<div class="row">
    <div class="col-md-12">
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Subtotal</th>
                </tr>
            </thead>
            <tbody id="tbl_productos_carrito"></tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="col-md-4">
        <button type="button" class="btn btn-info btn-lg" onclick="history.back()">
            Seguir comprando
        </button>
    </div>
    <div class="col-md-4">&nbsp;</div>
    <div class="col-md-4 text-right">
        <button type="button" class="btn btn-success btn-lg" onclick="location.href = '../productos/registrarProducto.jsp'">
            Proceder con la compra
        </button>
    </div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/vistas-usuario/carrito/carrito.js" type="text/javascript"></script>