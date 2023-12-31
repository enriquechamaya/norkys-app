<%@include file="../base/header.jsp" %>
<div class="text-center">
    <h1 class="display-4 text-white">Registrar pedido</h1>
</div>

<div class="row">
    <div class="col-md-4 offset-md-4 text-center">
        <button type="button" class="btn btn-success btn-lg">
            Agregar
        </button>
    </div>
</div>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="row">
            <div class="col-6">
                <div class="text-left">
                    <h1 class="display-4 text-white">Nro mesa: #5</h1>
                </div>
            </div>
            <div class="col-6">
                <div class="text-right">
                    <h1 class="display-4 text-white">Pedido: #0001</h1>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>

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
            <tfoot class="text-white">
                <tr>
                    <td></td>
                    <td></td>
                    <td>TOTAL</td>
                    <td>S/. 70.00</td>
                </tr>
            </tfoot>
        </table>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4 text-center">
                <button type="button" class="btn btn-success btn-lg">
                    Grabar
                </button>
            </div>
            <div class="col-md-4 text-right">
                <button type="button" class="btn btn-link text-success" onclick="location.href='../menu/menuPrincipal.jsp'">Cancelar</button>
            </div>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>


<%@include file="../base/footer.jsp" %>