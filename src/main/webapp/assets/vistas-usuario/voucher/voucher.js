let carrito = new Array();
let cliente = {};

$(document).ready(function () {
    inicializarCarrito();
    inicializarCliente();

    mostrarDatosCliente();
    mostrarCarrito();

});

function inicializarCarrito() {
    let carritoBD = localStorage.getItem("carritoBD");
    if (carritoBD !== null && typeof carritoBD !== "undefined") {
        let data = JSON.parse(carritoBD);
        if (data.length > 1) {
            carrito = data;
        } else {
            carrito.push(data[0]);
        }
    }
}

function inicializarCliente() {
    let clienteBD = localStorage.getItem("clienteBD");
    if (clienteBD !== null && typeof clienteBD !== "undefined") {
        cliente = JSON.parse(clienteBD);
    }
}

function mostrarDatosCliente() {
    $("#lbl_dni").append(cliente.dni);
    $("#lbl_nombres").append(cliente.nombres);
    $("#lbl_apellidos").append(cliente.apellidos);
    $("#lbl_correo").append(cliente.correo);
    $("#lbl_nro_pedido").append(cliente.nroPedido);
    $("#lbl_nro_mesa").append("00" + cliente.nroPersonas);
}

function mostrarCarrito() {
    let total = 0;

    $("#tbl_productos_carrito").empty();
    $.each(carrito, function () {
        $("#tbl_productos_carrito").append(`
            <tr>
                <td>${this.nombre}</td>
                <td>${this.cantidad}</td>
                <td>${this.precio.toFixed(2)}</td>
                <td><b>${(this.cantidad * this.precio).toFixed(2)}</b></td>
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
                <h2 class="h2">${total.toFixed(2)}</h2>
            </td>
        </tr>
    `);
}

function limpiarTodo() {
    localStorage.removeItem("carritoBD");
    localStorage.removeItem("clienteBD");
    location.href = '../menu/menu.jsp';
}