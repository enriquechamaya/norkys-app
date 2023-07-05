$(document).ready(function () {
    listarProductos();

    $("#txt_buscarProducto").keyup(function (e) {
        if (e.keyCode == 13) {
            if ($("#txt_buscarProducto").val().length > 3) {
                $("#tbl_productos").empty();
                listarProductos();
            }
            if ($("#txt_buscarProducto").val().length === 0) {
                $("#tbl_productos").empty();
                listarProductos();
            }
        }
    });

});

function listarProductos() {
    $.ajax({
        type: 'GET',
        url: "../../ProductoController?accion=listar",
        data: {
            nombre: $("#txt_buscarProducto").val()
        },
        success: function (data, textStatus, jqXHR) {
            if (data.length > 0) {
                $.each(data, function () {
                    $("#tbl_productos").append(`
                    <tr>
                        <th scope="row">${this.id}</th>
                        <td>${this.nombre}</td>
                        <td>${this.precioUnitario}</td>
                        <td>${this.stock}</td>
                        <td>${this.estado}</td>
                        <td>
                            <button type="button" class="btn btn-success" onclick="location.href='../productos/editarProducto.jsp?id=${this.id}'">Editar</button>
                            <button type="button" class="btn btn-info" onclick="javascript:pedir('${this.id}')">Pedir</button>
                        </td>
                    </tr>                
                `);
                });
            } else {
                $("#tbl_productos").append(`
                <tr>
                    <td colspan="6" class="text-center text-danger">Sin registros</td>
                </tr>
                `);
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarProductos', 'Error interno');
        }
    });
}

function pedir(id) {
    alert("pedir: " + id);
}