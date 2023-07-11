$(document).ready(function () {
    $('#txt_fechaInicio, #txt_fechaFin').datepicker({
        language: "es"
    });
});

function listarReporte() {
    $.ajax({
        type: 'GET',
        url: "../../ReporteController",
        data: {
            accion: 'listar',
            fechaInicio: $("#txt_fechaInicio").val(),
            fechaFin: $("#txt_fechaFin").val()
        },
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            let datajson = JSON.parse(data);
            console.log(datajson)
            if (datajson.length > 0) {
                $.each(datajson, function () {
                    $("#tbl_reporte").append(`
                    <tr>
                        <th scope="row">${this.nroVenta}</th>
                        <td>${this.fechaVenta}</td>
                        <td>${parseFloat(this.subtotal).toFixed(2)}</td>
                        <td>${parseFloat(this.igv).toFixed(2)}</td>
                        <td>${parseFloat(this.total).toFixed(2)}</td>
                        <td>${this.cliente}</td>
                        <td>${this.usuario}</td>
                    </tr>                
                `);
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarReporte', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            $.LoadingOverlay("hide");
        }
    });
}

function generarExcel() {
    let fechaInicio = $("#txt_fechaInicio").val();
    let fechaFin = $("#txt_fechaFin").val();
    location.href = '../../ReporteController?accion=generarExcel&fechaInicio=' + fechaInicio + '&fechaFin=' + fechaFin;

}