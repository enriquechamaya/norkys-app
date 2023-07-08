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
            console.log(data);
            $("#lbl_nroPedido").append(data[0].nroPedido);
            $("#lbl_fechaPedido").append(data[0].fecha);
            $("#lbl_cliente").append(data[0].cliente);
            $("#lbl_estado").append(data[0].estado);

            listarDetallePedido();
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
            console.log("data -->>>" + data);
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

        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr.error('No pudo realizar la petición listarDetallePedido', 'Error interno');
        }
    });
}