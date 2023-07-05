<%@include file="header.jsp" %>

<div class="text-center">
    <h1 class="display-4 text-white">Consultar productos</h1>
</div>

<div class="row">
    <div class="col-md-4 offset-md-4">
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text" id="btnGroupAddon"><i class="fa fa-search"></i></div>
                </div>
                <input type="text" class="form-control form-control-lg" placeholder="Digital el producto a buscar..." aria-label="Input group example" aria-describedby="btnGroupAddon">
            </div>

        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">

        <div class="row">
            <div class="col-2">
                <button type="button" class="btn btn-success btn-lg">
                    Agregar
                </button>
            </div>
            <div class="col-2">
                <button type="button" class="btn btn-success btn-lg">
                    Modificar
                </button>
            </div>
            <div class="col-8 text-right">
                <button type="button" class="btn btn-success btn-lg">
                    Pedir
                </button>
            </div>
        </div>

    </div>
    <div class="col-md-2"></div>
</div>

<br/>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <table class="table">
            <thead class="text-white">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
            </thead>
            <tbody class="text-white">
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                </tr>
            </tbody>
        </table>

        <div class="text-center">
            <button type="button" class="btn btn-link text-success" onclick="location.href='menuPrincipal.jsp'">Cancelar</button>
        </div>

    </div>
    <div class="col-md-2"></div>
</div>

<%@include file="footer.jsp" %>