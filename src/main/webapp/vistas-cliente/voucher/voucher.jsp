<%@include file="../base/header.jsp" %>

<div class="row">
    <div class="col-md-6 offset-md-3">
        <div class="card" >
            <div class="card-body mx-4">
                <div class="container">
                    <p class="my-5 mx-5" style="font-size: 30px;">Gracias por tu compra</p>
                    <div class="row">
                        <div class="col-md-10 offset-md-1">
                            <table width="100%">
                                <tr>
                                    <td class="font-weight-bold">DNI:</td>
                                    <td class="text-right" id="lbl_dni"></td>
                                </tr>
                                <tr>
                                    <td class="font-weight-bold">NOMBRES:</td>
                                    <td class="text-right" id="lbl_nombres"></td>
                                </tr>
                                <tr>
                                    <td class="font-weight-bold">APELLIDOS</td>
                                    <td class="text-right" id="lbl_apellidos"></td>
                                </tr>
                                <tr>
                                    <td class="font-weight-bold">CORREO:</td>
                                    <td class="text-right" id="lbl_correo"></td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <hr/>

                    <div class="row">
                        <div class="col-md-10 offset-md-1">
                            <table width="100%">
                                <tr>
                                    <td class="font-weight-bold">FECHA DE COMPRA:</td>
                                    <td class="text-right" id="lbl_dni">07/07/2023 14:30:05</td>
                                </tr>
                                <tr>
                                    <td class="font-weight-bold"># DE PEDIDO:</td>
                                    <td class="text-right" id="lbl_nro_pedido"></td>
                                </tr>
                                <tr>
                                    <td class="font-weight-bold"># DE MESA</td>
                                    <td class="text-right" id="lbl_nro_mesa"></td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <hr/>

                    <div class="row">
                        <table class="table table-striped table-sm">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Cant</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Subtotal</th>
                                </tr>
                            </thead>
                            <tbody id="tbl_productos_carrito"></tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<br/>
<div class="row">
    <div class="col-md-6 offset-md-3">
        <button type="button" class="btn btn-success btn-lg btn-block" onclick="limpiarTodo()">
            Finalizar
        </button>
    </div>
</div>
<%@include file="../base/footer.jsp" %>
<script src="../../assets/vistas-usuario/voucher/voucher.js" type="text/javascript"></script>