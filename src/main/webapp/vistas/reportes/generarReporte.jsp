<%@include file="../base/header.jsp" %>
<link href="../../assets/css/datepicker/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css"/>

<div class="card">
    <h5 class="card-header">Generar reporte de ventas</h5>
    <div class="card-body">

        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h5 class="card-title">Seleccione un rango de fecha</h5>
                <form>
                    <div class="row">
                        <div class="col">
                            <label>FECHA INICIO:</label>
                            <div class="input-group date">
                                <input type="text" id="txt_fechaInicio" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                            </div>
                        </div>
                        <div class="col">
                            <label>FECHA FIN:</label>
                            <div class="input-group date">
                                <input type="text" id="txt_fechaFin" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-6 offset-md-3 text-center">
                <button type="button" class="btn btn-primary btn-block" onclick="javascript:listarReporte()">Buscar</button>
            </div>
        </div>
        <br/>
        <br/>


        <div class="row">
            <div class="col-md-2">
            </div>&nbsp;
            <div class="col-md-8">
                <button type="button" class="btn btn-success" onclick="javascript:generarExcel()">Exportar en Excel</button>
            </div>
            <div class="col-md-2">&nbsp;</div>
        </div>
        <div class="row">    
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <table class="table table-sm table-striped">
                    <thead class="bg-info text-white">
                        <tr>
                            <th scope="col">Nro venta</th>
                            <th scope="col">Fecha venta</th>
                            <th scope="col">Subtotal</th>
                            <th scope="col">IGV</th>
                            <th scope="col">Total</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Usuario</th>
                        </tr>
                    </thead>
                    <tbody id="tbl_reporte"></tbody>
                </table>

                <div class="text-center">
                    <button type="button" class="btn btn-secondary" onclick="location.href = '../menu/menuPrincipal.jsp'">Cancelar</button>
                </div>

            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</div>

<%@include file="../base/footer.jsp" %>
<script src="../../assets/js/datepicker/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="../../assets/js/datepicker/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
<script src="../../assets/js/reporte/reporte.js" type="text/javascript"></script>