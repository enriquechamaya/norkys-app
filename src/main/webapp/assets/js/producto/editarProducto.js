$(document).ready(function () {

    listarCategorias();

    $("#btn_editar").on('click', function () {
        editarProducto();
    });

});

function listarCategorias() {
    $.ajax({
        type: 'GET',
        url: "../../CategoriaController",
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            var $dropdown = $("#cbx_categoria");
            $.each(data, function () {
                $dropdown.append($("<option />").val(this.id).text(this.nombre));
            });
            obtenerProducto();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarProductos', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            $.LoadingOverlay("hide");
        }
    });
}

function obtenerProducto() {
    $.ajax({
        type: 'GET',
        url: "../../ProductoController?accion=obtener",
        data: {
            productoId: $("#productoId").val()
        },
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            $("#txt_nombre").val(data.nombre);
            $("#txt_precioUnitario").val(data.precioUnitario);
            $("#cbx_unidadMedida").val(data.unidadMedida);
            $("#txt_stock").val(data.stock);
            $("#cbx_estado").val(data.estado);
            $("#cbx_categoria").val(data.categoriaId);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición obtenerProducto', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            $.LoadingOverlay("hide");
        }
    });
}

function editarProducto() {
    $.ajax({
        type: 'POST',
        url: "../../ProductoController?accion=editar",
        data: {
            id: $("#productoId").val(),
            nombre: $("#txt_nombre").val(),
            cantidadPorUnidad: 1,
            precioUnitario: $("#txt_precioUnitario").val(),
            unidadMedida: $("#cbx_unidadMedida").val(),
            stock: $("#txt_stock").val(),
            estado: $("#cbx_estado").val(),
            categoriaId: $("#cbx_categoria").val()
        },
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            if (data == "1") {
                toastr.success('Producto editado correctamente', 'Mensaje exitoso');
                location.href = 'consultarProducto.jsp';
            } else {
                toastr.error('No pudo editar el producto', 'Error');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición editarProducto', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            $.LoadingOverlay("hide");
        }
    });
}