<%@include file="header.jsp" %>
<div class="text-center">
    <h1 class="display-4 text-white">Registar usuario</h1>
</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Apellidos">
                </div>
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Nombres">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="DNI">
                </div>
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Usuario">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Contraseña">
                </div>
                <div class="form-group col-md-6">
                    <input type="text" class="form-control form-control-lg" placeholder="Repetir contraseña">
                </div>
            </div>
            <br/>
            <div class="text-center">
                <button type="button" class="btn btn-success btn-lg">
                    Grabar
                </button>
                <br/>
                <button type="button" class="btn btn-link text-success" onclick="location.href = 'login.jsp'">Cancelar</button>
            </div>
        </form>
    </div>
    <div class="col-md-2"></div>
</div>

<%@include file="footer.jsp" %>