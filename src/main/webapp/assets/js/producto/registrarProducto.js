$(document).ready(function () {

    $("#btn_registrar").on('click', function (e) {
        registrarProducto(e);
    });

});

async function registrarProducto(e) {
    e.preventDefault();
    let frm = new FormData(document.getElementById("frm_registrarProducto"));
    console.log(frm);
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
            console.log(data);
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