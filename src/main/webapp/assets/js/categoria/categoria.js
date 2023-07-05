$(document).ready(function () {
    listarCategorias();
});


function listarCategorias() {
    $.ajax({
        type: 'GET',
        url: "../../CategoriaController",
        success: function (data, textStatus, jqXHR) {
            var $dropdown = $("#cbx_categoria");
            $.each(data, function () {
                $dropdown.append($("<option />").val(this.id).text(this.nombre));
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarProductos', 'Error interno');
        }
    });
}