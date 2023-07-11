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
        success: function (data, textStatus, jqXHR) {
            let total = 0;
            if (data.length > 0) {
                $.each(data, function () {
                    $("#tbl_productos_carrito").append(`
                    <tr>
                        <th>${this.producto}</th>
                        <td>${this.cantidad}</td>
                        <td>${this.precio}</td>
                        <td>${this.subtotal}</td>
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
                            <h2 class="h2">${total}</h2>
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
    informacionPedido.subtotal = total;
    informacionPedido.igv = informacionPedido.subtotal * 0.18;
    informacionPedido.total = informacionPedido.subtotal + informacionPedido.igv;
    informacionPedido.detalle = data;
}

function realizarVenta() {
    localStorage.setItem("informacionPedido", JSON.stringify(informacionPedido));
    location.href = "../venta/venta.jsp";
}