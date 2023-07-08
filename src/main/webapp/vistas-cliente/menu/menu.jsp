<%@include file="../base/header.jsp" %>
<link href="../../assets/vistas-usuario/menu/menu.css" rel="stylesheet" type="text/css"/>

<div class="row">
    <div class="col-md-10"> 
        <div class="btn-group btn-group-lg" role="group" aria-label="Basic example" id="btn_categorias">
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