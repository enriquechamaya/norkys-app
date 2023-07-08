<%@include file="../base/header.jsp" %>
<%
    String nroPedido = request.getParameter("nroPedido");
%>

<div class="col-md-4 offset-md-4 text-center">
    <h1 class="display-4 text-white">Detalle Pedido</h1>
</div>

<input type="hidden" id="txt_nroPedido" value="<%= nroPedido %>" />


<div class="row">
    <div class="col-md-6 offset-md-3 text-center">
        <table class="table table-sm table-dark">
            <thead>
                <tr>
                    <th scope="col" class="text-left"># PEDIDO:</th>
                    <th scope="col" id="lbl_nroPedido" class="text-right"></th>
                </tr>
                <tr>
                    <th scope="col" class="text-left">FECHA DE PEDIDO</th>
                    <th scope="col" id="lbl_fechaPedido" class="text-right"></th>
                </tr>
                <tr>
                    <th scope="col" class="text-left">CLIENTE</th>
                    <th scope="col" id="lbl_cliente" class="text-right"></th>
                </tr>
                <tr>
                    <th scope="col" class="text-left">ESTADO</th>
                    <th scope="col" id="lbl_estado" class="text-right"></th>
                </tr>
            </thead>
        </table>
    </div>
</div>

<br/>

<div class="row">
    <div class="col-md-12">
        <table class="table table-striped table-dark">
            <thead class="text-white">
                <tr>
                    <th scope="col">Producto</th>
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
            Volver
        </button>
    </div>
    <div class="col-md-4">&nbsp;</div>
    <div class="col-md-4 text-right">
        <button type="button" class="btn btn-success btn-lg">
            Proceder con la venta
        </button>
    </div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/js/pedido/detallePedido.js" type="text/javascript"></script>