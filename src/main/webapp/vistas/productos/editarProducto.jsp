<%@include file="../base/header.jsp" %>

<div class="text-center">
    <h1 class="display-4 text-white">Editar producto</h1>
</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form>
            <input type="hidden" id="productoId" value="<%= request.getParameter("id") %>"/>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Nombre" id="txt_nombre">
                </div>
                <div class="form-group col-md-6">
                    <input type="number" class="form-control form-control-lg" placeholder="Precio unitario" id="txt_precioUnitario">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="cbx_unidadMedida">
                        <option value="-1">--SELECCIONAR UNIDAD MEDIDA--</option>
                        <option value="NIU">UNIDAD</option>
                        <option value="LTR">LITRO</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <input type="number" class="form-control form-control-lg" placeholder="Stock" id="txt_stock">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="cbx_estado">
                        <option value="-1">--SELECCIONAR ESTADO--</option>
                        <option value="ACTIVO">ACTIVO</option>
                        <option value="INVACTIVO">INVACTIVO</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="cbx_categoria">
                        <option value="-1">--SELECCIONAR CATEGORIA--</option>
                    </select>
                </div>
            </div>
            <br/>
            <div class="text-center">
                <button type="button" class="btn btn-success btn-lg" id="btn_editar">
                    Grabar
                </button>
                <br/> <br/>
                <button type="button" class="btn btn-secondary" onclick="history.back()">Cancelar</button>
            </div>
        </form>
    </div>
    <div class="col-md-2"></div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/js/producto/editarProducto.js" type="text/javascript"></script>