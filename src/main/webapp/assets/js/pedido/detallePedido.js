let informacionPedido = {};

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
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            $("#lbl_nroPedido").append(data[0].nroPedido);
            $("#lbl_fechaPedido").append(data[0].fecha);
            $("#lbl_cliente").append(data[0].cliente);
            $("#lbl_estado").append(data[0].estado);

            listarDetallePedido();

            llenarInfoPedido(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarPedido', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            $.LoadingOverlay("hide");
        }
    });
}

function listarDetallePedido() {
    $.ajax({
        type: 'GET',
        url: "../../PedidoController?accion=listar_detalle",
        data: {
            nroPedido: $("#txt_nroPedido").val()
        },
        beforeSend: function (xhr) {
            $.LoadingOverlay("show");
        },
        success: function (data, textStatus, jqXHR) {
            let total = 0;
            if (data.length > 0) {
                $.each(data, function () {
                    $("#tbl_productos_carrito").append(`
                    <tr>
                        <th>${this.producto}</th>
                        <td>${this.cantidad}</td>
                        <td>${parseFloat(this.precio).toFixed(2)}</td>
                        <td>${parseFloat(this.subtotal).toFixed(2)}</td>
                    </tr>
                `);
                    total += this.cantidad * this.precio;
                });

                $("#tbl_productos_carrito").append(`
                    <tr>
                        <td colspan="3" class="text-right font-weight-bold">
                            <h2 class="h2">TOTAL S/.</h2>
                        </td>
                        <td colspan="1" class="text-left">
                            <h2 class="h2">${parseFloat(total).toFixed(2)}</h2>
                        </td>
                    </tr>
                `);
            } else {
                $("#tbl_productos").append(`
                <tr>
                    <td colspan="4" class="text-center text-danger">Sin registros</td>
                </tr>
                `);
            }
            llenarInfoDetallePedido(data, total);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarDetallePedido', 'Error interno');
        },
        complete: function (jqXHR, textStatus) {
            $.LoadingOverlay("hide");
        }
    });
}

function llenarInfoPedido(data) {
    informacionPedido.nroPedido = data[0].nroPedido;
    informacionPedido.fecha = data[0].fecha;
    informacionPedido.cliente = data[0].cliente;
    informacionPedido.estado = data[0].estado;
    informacionPedido.clienteId = data[0].clienteId;
    informacionPedido.username = $("#txt_username").val();
    informacionPedido.usernameId = $("#txt_usernameId").val();
}

function llenarInfoDetallePedido(data, total) {
    let subtotal = parseFloat(total);
    let igv = parseFloat(subtotal * 0.18).toFixed(2);
    let neto = parseFloat(parseFloat(subtotal) + parseFloat(igv)).toFixed(2);

    informacionPedido.subtotal = subtotal;
    informacionPedido.igv = igv;
    informacionPedido.total = neto;
    informacionPedido.detalle = data;
}

function realizarVenta() {
    localStorage.setItem("informacionPedido", JSON.stringify(informacionPedido));
    location.href = "../venta/venta.jsp";
}