<%@include file="../base/header.jsp" %>
<div class="text-center">
    <h1 class="display-4 text-white">Registar producto</h1>
</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form id="frm_registrarProducto" enctype="multipart/form-data">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Nombre" id="txt_nombre" name="nombre">
                </div>
                <div class="form-group col-md-6">
                    <input type="number" class="form-control form-control-lg" placeholder="Precio unitario" id="txt_precioUnitario" name="precioUnitario">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="cbx_unidadMedida" name="unidadMedida">
                        <option value="-1">--SELECCIONAR UNIDAD MEDIDA--</option>
                        <option value="NIU">UNIDAD</option>
                        <option value="LTR">LITRO</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <input type="number" class="form-control form-control-lg" placeholder="Stock" id="txt_stock" name="stock">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="cbx_estado" name="estado">
                        <option value="-1">--SELECCIONAR ESTADO--</option>
                        <option value="ACTIVO">ACTIVO</option>
                        <option value="INVACTIVO">INVACTIVO</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="cbx_categoria" name="categoriaId">
                        <option value="-1">--SELECCIONAR CATEGORIA--</option>
                    </select>
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="txt_img" class="form-label text-white">Selecciona una imagen</label>
                    <input class="form-control form-control-lg" name="img" type="file" accept="image/png, image/jpg, image/jpeg" />
                </div>
            </div>
            <br/>
            <div class="text-center">
                <button type="button" class="btn btn-success btn-lg" id="btn_registrar">
                    Grabar
                </button>
                <br/><br/>
                <button type="button" class="btn btn-secondary" onclick="location.href = '../menu/menuPrincipal.jsp'">Cancelar</button>
            </div>
        </form>
    </div>
    <div class="col-md-2"></div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/js/categoria/categoria.js" type="text/javascript"></script>
<script src="../../assets/js/producto/registrarProducto.js" type="text/javascript"></script>