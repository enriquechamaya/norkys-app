let informacionPedido = {};

$(document).ready(function () {
    inicializarBD();
    inicializarInformacionPedido();
    inicializarInformacionDetallePedido();
});

function inicializarBD() {
    let infoPedidoBD = localStorage.getItem("informacionPedido");
    if (infoPedidoBD !== null && typeof infoPedidoBD !== "undefined") {
        informacionPedido = JSON.parse(infoPedidoBD);
    }
}

function inicializarInformacionPedido() {
    $("#lbl_nroPedido").append(informacionPedido.nroPedido);
    $("#lbl_fecha").append(informacionPedido.fecha);
    $("#lbl_cliente").append(informacionPedido.cliente);
    $("#lbl_usuario").append(informacionPedido.username);

    $("#lbl_subtotal").append(`<b>${ parseFloat(informacionPedido.subtotal).toFixed(2)}</b>`);
    $("#lbl_igv").append(`<b>${ parseFloat(informacionPedido.igv).toFixed(2)}</b>`);
    $("#lbl_total").append(`<b>${ parseFloat(informacionPedido.total).toFixed(2)}</b>`);
}

function inicializarInformacionDetallePedido() {
    $.each(informacionPedido.detalle, function () {
        $("#tbl_productos_carrito").append(`
            <tr>
                <td>${this.producto}</td>
                <td>${this.cantidad}</td>
                <td>${parseFloat(this.precio).toFixed(2)}</td>
                <td><b>${parseFloat(this.subtotal).toFixed(2)}</b></td>
            </tr>
        `);
    });
}

function registrarVenta() {
    $.ajax({
        type: 'POST',
        url: "../../VentaController?accion=registrar",
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        data: {
            subtotal: parseFloat(informacionPedido.subtotal).toFixed(2),
            igv: parseFloat(informacionPedido.igv).toFixed(2),
            total: parseFloat(informacionPedido.total).toFixed(2),

            pedidoId: informacionPedido.nroPedido,
            clienteId: parseInt(informacionPedido.clienteId),
            usuarioId: parseInt(informacionPedido.usernameId),

            productos: JSON.stringify(informacionPedido.detalle)
        },
        success: function (data, textStatus, jqXHR) {
            if (data > 0) {
                toastr.success('Venta registrada correctamente', 'Mensaje exitoso');
                localStorage.removeItem("informacionPedido");
                location.href = '../pedidos/consultarPedido.jsp';
            } else {
                toastr.error('No pudo registrar la venta', 'Error');
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