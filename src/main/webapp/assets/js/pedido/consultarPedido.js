$(document).ready(function () {
    listarPedido();

    $("#txt_nroPedido").keyup(function (e) {
        if (e.keyCode == 13) {
            $("#tbl_productos").empty();
            listarPedido();
        }
    });
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
                    let estado = '', botonEntregado = '', botonPagado = '';
                    if (this.estado === 'PENDIENTE') {
                        estado = '<span class="badge badge-danger">PENDIENTE</span>';
                        botonEntregado = `<button type="button" class="btn btn-info" onclick="javascript:cambiarEstadoPedido('${this.nroPedido}', 'ENTREGADO')">Pedido Entregado</button>`;
                        botonPagado = '';
                    }
                    if (this.estado === 'ENTREGADO') {
                        estado = '<span class="badge badge-info">ENTREGADO</span>';
                        botonPagado = `<button type="button" class="btn btn-success" onclick="javascript:verDetallePedido('${this.nroPedido}')">Realizar pago</button>`;
                        botonEntregado = '';
                    }
                    if (this.estado === 'PAGADO') {
                        estado = '<span class="badge badge-success">PAGADO</span>';
                        botonEntregado = '';
                        botonPagado = '';
                    }
                    $("#tbl_productos").append(`
                    <tr>
                        <th scope="row">${this.nroPedido}</th>
                        <td>${this.cliente}</td>
                        <td>${this.fecha}</td>
                        <td>${estado}</td>
                        <td>
                            ${botonEntregado}
                            ${botonPagado}
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

function cambiarEstadoPedido(nroPedido, estado) {
    $.ajax({
        type: 'POST',
        url: "../../PedidoController?accion=editar",
        data: {
            nroPedido: nroPedido,
            estado: estado
        },
        success: function (data, textStatus, jqXHR) {
            if (data == "1") {
                toastr.success(`El pedido ${nroPedido} ha sido cambiado a ${estado} con éxito`, 'Mensaje exitoso');
                $("#tbl_productos").empty();
                listarPedido();
            } else {
                toastr.error('No pudo editar el pedido', 'Error');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición cambiarEstadoEntregado', 'Error interno');
        }
    });
}