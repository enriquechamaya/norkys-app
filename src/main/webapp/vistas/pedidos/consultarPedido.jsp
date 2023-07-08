<%@include file="../base/header.jsp" %>

<div class="text-center">
    <h1 class="display-4 text-white">Consultar pedidos</h1>
</div>

<div class="row">
    <div class="col-md-4 offset-md-4">
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text" id="btnGroupAddon"><i class="fa fa-search"></i></div>
                </div>
                <input type="text" class="form-control form-control-lg" id="txt_nroPedido" placeholder="Digital el número de pedido..." aria-label="Input group example" aria-describedby="btnGroupAddon">
            </div>

        </div>
    </div>
</div>

<br/>

<div class="row">    
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <table class="table table-dark">
            <thead class="text-white">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Fecha Pedido</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody class="text-white" id="tbl_productos"></tbody>
        </table>

        <div class="text-center">
            <button type="button" class="btn btn-link text-success" onclick="location.href = '../menu/menuPrincipal.jsp'">Cancelar</button>
        </div>

    </div>
    <div class="col-md-2"></div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/js/pedido/consultarPedido.js" type="text/javascript"></script>