<%@include file="header.jsp" %>
<div class="text-center">
    <h1 class="display-4 text-white">Registar producto</h1>
</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Nombre">
                </div>
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Precio">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="exampleFormControlSelect1">
                        <option>--Unidad de medida--</option>
                        <option>UNIDAD</option>
                        <option>LITRO</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Stock">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="exampleFormControlSelect1">
                        <option>--Estado--</option>
                        <option>ACTIVO</option>
                        <option>INVACTIVO</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <select class="form-control form-control-lg" id="exampleFormControlSelect1">
                        <option>--Categoría--</option>
                        <option>BEBIDAS</option>
                        <option>POSTRES</option>
                    </select>
                </div>
            </div>
            <br/>
            <div class="text-center">
                <button type="button" class="btn btn-success btn-lg">
                    Grabar
                </button>
                <br/>
                <button type="button" class="btn btn-link text-success" onclick="location.href='menuPrincipal.jsp'">Cancelar</button>
            </div>
        </form>
    </div>
    <div class="col-md-2"></div>
</div>

<%@include file="footer.jsp" %>