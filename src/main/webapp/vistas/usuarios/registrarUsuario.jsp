<%@include file="../base/header.jsp" %>

<input type="hidden" id="txt_username" value="<%= session.getAttribute("username") %>"/>
    

<div class="text-center">
    <h1 class="display-4 text-white">Registar usuario</h1>
</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" id="in-apellidos" class="form-control form-control-lg" placeholder="Apellidos">
                </div>
                <div class="form-group col-md-6">
                    <input type="text" id="in-nombre" class="form-control form-control-lg" placeholder="Nombres">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" id="in-dni" class="form-control form-control-lg" placeholder="DNI">
                </div>
                <div class="form-group col-md-6">
                    <input type="text" id="in-usuario" class="form-control form-control-lg" placeholder="Usuario">
                </div>
            </div>
            <br/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="password" id="in-password" class="form-control form-control-lg" placeholder="Contraseņa">
                </div>
                <div class="form-group col-md-6">
                    <input type="password" id="in-repeat-password" class="form-control form-control-lg" placeholder="Repetir contraseņa">
                </div>
            </div>
            <br/>
            <div class="text-center">
                <button type="button" id="btn-grabar" class="btn btn-success btn-lg">
                    Grabar
                </button>
                <br/>
                <br/>
                <button type="button" class="btn btn-secondary" onclick="location.href = '../../LoginController'">Cancelar</button>
            </div>
        </form>
    </div>
    <div class="col-md-2"></div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/js/registroUsuario/registroUsuario.js" type="text/javascript"></script>