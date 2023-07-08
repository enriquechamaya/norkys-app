$(document).ready(function () {
    listarPedido();
});

function listarPedido() {
    $.ajax({
        type: 'GET',
        url: "../../PedidoController?accion=listar",
        data: {
            nroPedido: $("#txt_nroPedido").val()
        },
        success: function (data, textStatus, jqXHR) {
            if (data.length > 0) {
                $.each(data, function () {
                    $("#tbl_productos").append(`
                    <tr>
                        <th scope="row">${this.nroPedido}</th>
                        <td>${this.cliente}</td>
                        <td>${this.fecha}</td>
                        <td>${this.estado}</td>
                        <td>
                            <button type="button" class="btn btn-success" onclick="javascript:verDetallePedido('${this.nroPedido}')">Realizar pago</button>
                        </td>
                    </tr>
                `);
                });
            } else {
                $("#tbl_productos").append(`
                <tr>
                    <td colspan="5" class="text-center text-danger">Sin registros</td>
                </tr>
                `);
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarPedido', 'Error interno');
        }
    });
}

function verDetallePedido(nroPedido) {
    location.href = "detallePedido.jsp?nroPedido=" + nroPedido;
}