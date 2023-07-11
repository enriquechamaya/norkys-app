$(document).ready(function () {

    $("#btn_registrar").on('click', function (e) {
        registrarProducto();
    });

});

async function registrarProducto() {
    let frm = new FormData(document.getElementById("frm_registrarProducto"));
    $.ajax({
        type: 'POST',
        url: "../../ProductoController?accion=registrar",
        contentType: false,
        cache: false,
        processData: false,
        data: frm,
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            if (data == "1") {
                toastr.success('Producto registrado correctamente', 'Mensaje exitoso');
                location.href = 'consultarProducto.jsp';
            } else {
                toastr.error('No pudo registrar el producto', 'Error');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición registrarProducto', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            $.LoadingOverlay("hide");
        }
    });
}