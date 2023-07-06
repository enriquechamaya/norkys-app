<%@include file="../base/header.jsp" %>

<div class="col-md-4 offset-md-4 text-center">
    <h1 class="display-4">Detalle Carrito</h1>
</div>


<div class="row">
    <div class="col-md-8 offset-md-2">
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Subtotal</th>
                    <th scope="col">Accion</th>
                </tr>
            </thead>
            <tbody id="tbl_productos_carrito"></tbody>
        </table>
    </div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/vistas-usuario/carrito/carrito.js" type="text/javascript"></script>