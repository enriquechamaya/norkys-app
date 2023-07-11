<%@include file="../base/header.jsp" %>

<div class="row">
    <div class="col-md-6 offset-md-3">
        <div class="card" >
            <div class="card-body mx-4">
                <div class="container">
                    <p class="my-5 mx-5 text-center" style="font-size: 30px;">GRACIAS POR TU COMPRA</p>
                    <div class="row">
                        <div class="col-md-10 offset-md-1">
                            <table width="100%">
                                <tr>
                                    <td class="font-weight-bold"># PEDIDO:</td>
                                    <td class="text-right" id="lbl_nroPedido"></td>
                                </tr>
                                <tr>
                                    <td class="font-weight-bold">FECHA PEDIDO:</td>
                                    <td class="text-right" id="lbl_fecha"></td>
                                </tr>                                
                                <tr>
                                    <td class="font-weight-bold">CLIENTE:</td>
                                    <td class="text-right" id="lbl_cliente"></td>
                                </tr>
                                <tr>
                                    <td class="font-weight-bold">USUARIO:</td>
                                    <td class="text-right" id="lbl_usuario"></td>
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

                    <div class="row">
                        <div class="col-md-10 offset-md-1">
                            <table width="100%">
                                <tr>
                                    <td class="font-weight-bold">SUBTOTAL</td>
                                    <td class="text-right" id="lbl_subtotal"></td>
                                </tr>
                                <tr>
                                    <td class="font-weight-bold">IGV</td>
                                    <td class="text-right" id="lbl_igv"></td>
                                </tr>                                
                                <tr>
                                    <td class="font-weight-bold">TOTAL</td>
                                    <td class="text-right" id="lbl_total"></td>
                                </tr>
                            </table>
                        </div>
                    </div>                    

                </div>
            </div>
        </div>
    </div>
</div>
<br/>
<div class="row">
    <div class="col-md-6 offset-md-3">
        <button type="button" class="btn btn-success btn-lg btn-block" onclick="registrarVenta()">
            PAGAR
        </button>
    </div>
</div>
<%@include file="../base/footer.jsp" %>
<script src="../../assets/js/venta/venta.js" type="text/javascript"></script>