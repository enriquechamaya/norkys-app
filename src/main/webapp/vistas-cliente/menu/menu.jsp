<%@include file="../base/header.jsp" %>
<link href="../../assets/vistas-usuario/menu/menu.css" rel="stylesheet" type="text/css"/>

<div class="row">
    <div class="col-md-10"> 
        <div class="btn-group btn-group-lg" role="group" aria-label="Basic example">
            <button type="button" id="btn_pollos" class="btn btn-outline-success active" onclick="botones_dinamicos(1)">POLLOS</button>
            <button type="button" id="btn_bebidas" class="btn btn-outline-success" onclick="botones_dinamicos(2)">BEBIDAS</button>
            <button type="button" id="btn_ensaladas" class="btn btn-outline-success" onclick="botones_dinamicos(3)">ENSALDAS</button>
            <button type="button" id="btn_postres" class="btn btn-outline-success" onclick="botones_dinamicos(4)">POSTRES</button>
        </div>
    </div>
    <div class="col-md-2">
        <button type="button" class="btn btn-warning btn-lg" id="btn_carrito" onclick="location.href = '../carrito/carrito.jsp'">
            Carrito <span class="badge badge-light">0</span>
        </button>
    </div>
</div>

<br/>

<div id="container_productos">

</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/vistas-usuario/menu/menu.js" type="text/javascript"></script>