$(document).ready(function () {

    $("#btn_registrar").on('click', function () {
        registrarProducto();
    });

});

function registrarProducto() {
    $.ajax({
        type: 'POST',
        url: "../../ProductoController?accion=registrar",
        data: {
            nombre: $("#txt_nombre").val(),
            cantidadPorUnidad: 1,
            precioUnitario: $("#txt_precioUnitario").val(),
            unidadMedida: $("#cbx_unidadMedida").val(),
            stock: $("#txt_stock").val(),
            estado: $("#cbx_estado").val(),
            categoriaId: $("#cbx_categoria").val()
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
        }
    });
}