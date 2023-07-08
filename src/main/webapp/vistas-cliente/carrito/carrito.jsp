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
        <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#exampleModal">
            Proceder con la compra
        </button>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Regístrate</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="txt_dni" class="col-form-label">DNI:</label>
                                <input type="number" class="form-control" id="txt_dni">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="col-xs-4 form-group">
                                <label for="txt_nro_personas" class="col-form-label">NRO DE PERSONAS:</label>
                                <input type="number" class="form-control" id="txt_nro_personas">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txt_nombres" class="col-form-label">Nombres:</label>
                        <input type="text" class="form-control" id="txt_nombres">
                    </div>
                    <div class="form-group">
                        <label for="txt_apellidos" class="col-form-label">Apellidos:</label>
                        <input type="text" class="form-control" id="txt_apellidos">
                    </div>
                    <div class="form-group">
                        <label for="txt_correo" class="col-form-label">Correo:</label>
                        <input type="email" class="form-control" id="txt_correo">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                <!--<button type="button" class="btn btn-success" onclick="procederCompra()">Realizar pedido</button>-->
                <button type="button" class="btn btn-success" onclick="registrarPedido()">Realizar pedido</button>
            </div>
        </div>
    </div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/vistas-usuario/carrito/carrito.js" type="text/javascript"></script>